package com.obric.cae.smartBluetooth.btaware;

import android.R;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.k;
import androidx.appcompat.app.r;
import androidx.core.app.j;
import androidx.room.l;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfo;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfoDao;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyRoomDatabase;
import defpackage.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class SmartBluetoothInCarAware {
    public static final String ACTION_USER_IN_CAR = "com.obric.cae.smartBluetooth.action.USER_IN_CAR";
    private static final long CAR_DISTANCE_NOTIFY_INTERVAL_MS = 3000;
    public static final String EXTRA_USER_IN_CAR = "extra_user_in_car";
    private static final long IN_CAR_SKIP_OUT_CHECK_BEFORE_MS = 5000;
    private static final long IN_CAR_WALKING_START_RSSI_DELAY_MS = 3000;
    private static final int MAX_RSSI_READ_COUNT = 1000;
    private static final double MEASUREMENT_NOISE = 2.0d;
    private static final String NOTIFICATION_CHANNEL_ID = "smart_bluetooth_incar";
    private static final String NOTIFICATION_CHANNEL_NAME = "SmartBluetooth";
    private static final int NOTIFICATION_ID_CAR_DISTANCE = 10003;
    private static final int NOTIFICATION_ID_IN_CAR = 10002;
    private static final int NOTIFICATION_ID_WALKING = 10001;
    private static final double PROCESS_NOISE = 0.1d;
    private static final long RSSI_READ_INTERVAL_MS = 100;
    private static final int RSSI_THRESHOLD = -50;
    private static final String TAG = "SmartBluetoothInCarAware";
    private static final Map<BluetoothDevice, GattCarInfo> sDeviceCarInfoMap = null;
    private static volatile SmartBluetoothInCarAware sInstance;
    private static boolean sLastWalking;
    private static boolean sWalking;
    private volatile List<CarkeyAppInfo> mAllCarkeyAppInfos;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private boolean mCarDistanceTrendReady;
    private final Context mContext;
    private GattCarInfo mCurrentCarInfo;
    private final ExecutorService mDbExecutor;
    private double mErrorCovariance;
    private double mEstimatedRssi;
    private final BluetoothGattCallback mGattCallback;
    private Handler mHandler;
    private long mInCarStartUptimeMs;
    private final Runnable mInCarWalkingStartRssiRunnable;
    private boolean mIsConnected;
    private double mKalmanGain;
    private int mLastCarDistanceCheckedAvg10Count;
    private int mLastCarDistanceMajorStateDirection;
    private int mLastCarDistanceNotifiedTrendDirection;
    private long mLastCarDistanceNotifyUptimeMs;
    private int mLastCarDistanceObservedTrendDirection;
    private volatile long mLastCharacteristicChangedUptimeMs;
    private long mRssiBelowMinus50Duration;
    private long mRssiBelowMinus50StartTime;
    private int mRssiReadCount;
    private long mStationaryStartUptimeMs;
    private boolean mcharacteristicChanged;

    static {
        sDeviceCarInfoMap = new HashMap();
        sLastWalking = false;
        sWalking = false;
    }

    private SmartBluetoothInCarAware(Context r8) {
        this.mIsConnected = false;
        this.mAllCarkeyAppInfos = new ArrayList();
        this.mRssiBelowMinus50StartTime = 0;
        this.mRssiBelowMinus50Duration = 0;
        this.mLastCharacteristicChangedUptimeMs = 0;
        this.mRssiReadCount = 0;
        this.mLastCarDistanceCheckedAvg10Count = 0;
        this.mLastCarDistanceNotifyUptimeMs = 0;
        this.mCarDistanceTrendReady = false;
        this.mLastCarDistanceObservedTrendDirection = 0;
        this.mLastCarDistanceNotifiedTrendDirection = 0;
        this.mKalmanGain = 0.0d;
        this.mEstimatedRssi = 0.0d;
        this.mErrorCovariance = 1.0d;
        this.mcharacteristicChanged = false;
        this.mStationaryStartUptimeMs = 0;
        this.mInCarStartUptimeMs = 0;
        this.mLastCarDistanceMajorStateDirection = 0;
        this.mInCarWalkingStartRssiRunnable = new AnonymousClass1(this);
        this.mGattCallback = new AnonymousClass2(this);
        CaeLog.w(TAG, TAG);
        this.mContext = r8.getApplicationContext();
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDbExecutor = Executors.newSingleThreadExecutor();
    }

    public static /* synthetic */ void a(SmartBluetoothInCarAware r8, String r10) {
        r8.lambda$showToastSafely$2(r10);
    }

    public static /* synthetic */ boolean access$000() {
        return sWalking;
    }

    public static /* synthetic */ GattCarInfo access$100(SmartBluetoothInCarAware r8) {
        return r8.mCurrentCarInfo;
    }

    public static /* synthetic */ boolean access$1000(SmartBluetoothInCarAware r8) {
        return r8.mcharacteristicChanged;
    }

    public static /* synthetic */ boolean access$1002(SmartBluetoothInCarAware r8, boolean r10) {
        r8.mcharacteristicChanged = r10;
        return r10;
    }

    public static /* synthetic */ GattCarInfo access$102(SmartBluetoothInCarAware r8, GattCarInfo r10) {
        r8.mCurrentCarInfo = r10;
        return r10;
    }

    public static /* synthetic */ double access$1100(SmartBluetoothInCarAware r8, int r10) {
        return r8.applyKalmanFilter(r10);
    }

    public static /* synthetic */ void access$1200(SmartBluetoothInCarAware r8) {
        r8.maybeNotifyCarDistanceByAvg10List();
    }

    public static /* synthetic */ void access$1300(SmartBluetoothInCarAware r8) {
        r8.resetCarDistanceTrendState();
    }

    public static /* synthetic */ void access$1400(SmartBluetoothInCarAware r8, int r10, String r11, String r12) {
        r8.postStatusNotification(r10, r11, r12);
    }

    public static /* synthetic */ long access$1500(SmartBluetoothInCarAware r8) {
        return r8.mStationaryStartUptimeMs;
    }

    public static /* synthetic */ void access$1600(SmartBluetoothInCarAware r8, BluetoothGatt r10) {
        r8.scheduleNextRssiRead(r10);
    }

    public static /* synthetic */ int access$200(SmartBluetoothInCarAware r8) {
        return r8.mRssiReadCount;
    }

    public static /* synthetic */ int access$202(SmartBluetoothInCarAware r8, int r10) {
        r8.mRssiReadCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$208(SmartBluetoothInCarAware r8) {
        int r10 = r8.mRssiReadCount;
        r8.mRssiReadCount = r10 + 1;
        return r10;
    }

    public static /* synthetic */ void access$300(SmartBluetoothInCarAware r8, String r10) {
        r8.showToastSafely(r10);
    }

    public static /* synthetic */ void access$400(SmartBluetoothInCarAware r8, BluetoothGatt r10) {
        r8.readRemoteRssi(r10);
    }

    public static /* synthetic */ boolean access$502(SmartBluetoothInCarAware r8, boolean r10) {
        r8.mIsConnected = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(SmartBluetoothInCarAware r8, long r10) {
        r8.mInCarStartUptimeMs = r10;
        return r10;
    }

    public static /* synthetic */ long access$700(SmartBluetoothInCarAware r8) {
        return r8.mRssiBelowMinus50StartTime;
    }

    public static /* synthetic */ long access$702(SmartBluetoothInCarAware r8, long r10) {
        r8.mRssiBelowMinus50StartTime = r10;
        return r10;
    }

    public static /* synthetic */ long access$800(SmartBluetoothInCarAware r8) {
        return r8.mRssiBelowMinus50Duration;
    }

    public static /* synthetic */ long access$802(SmartBluetoothInCarAware r8, long r10) {
        r8.mRssiBelowMinus50Duration = r10;
        return r10;
    }

    public static /* synthetic */ long access$814(SmartBluetoothInCarAware r8, long r10) {
        long r11 = r8.mRssiBelowMinus50Duration + r10;
        r8.mRssiBelowMinus50Duration = r11;
        return r11;
    }

    public static /* synthetic */ Map access$900() {
        return sDeviceCarInfoMap;
    }

    private double applyKalmanFilter(int r10) {
        double r8 = this.mErrorCovariance + PROCESS_NOISE;
        double r11 = r8 / (MEASUREMENT_NOISE + r8);
        this.mKalmanGain = r11;
        double r12 = this.mEstimatedRssi;
        double r13 = ((((double) r10) - r12) * r11) + r12;
        this.mEstimatedRssi = r13;
        this.mErrorCovariance = (1.0d - r11) * r8;
        return r13;
    }

    public static /* synthetic */ void b(SmartBluetoothInCarAware r8, String r10, String r11) {
        r8.lambda$onCarKeyAppGattConnected$0(r10, r11);
    }

    public static /* synthetic */ void c(SmartBluetoothInCarAware r8) {
        r8.lambda$loadAllCarkeyAppInfos$1();
    }

    private CarkeyAppInfo findCarkeyAppInfoInCache(String r8) {
        Iterator<CarkeyAppInfo> r10 = this.mAllCarkeyAppInfos.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        CarkeyAppInfo r11 = r10.next();
        if (r11 == null) goto L4;
        String r12 = r11.appName;
        if (r12 == null) goto L4;
        if (r12.equals(r8) == false) goto L4;
        return r11;
    L12:
        return null;
    }

    public static GattCarInfo getGattCarInfoByDevice(BluetoothDevice r8) {
        return sDeviceCarInfoMap.get(r8);
    }

    public static SmartBluetoothInCarAware getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothInCarAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothInCarAware(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothInCarAware.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ void lambda$loadAllCarkeyAppInfos$1() {
        this.mAllCarkeyAppInfos = CarkeyRoomDatabase.getInstance(this.mContext).carkeyAppInfoDao().getAll();
    }

    private /* synthetic */ void lambda$onCarKeyAppGattConnected$0(String r8, String r10) {
        CarkeyAppInfoDao r11 = CarkeyRoomDatabase.getInstance(this.mContext).carkeyAppInfoDao();
        CarkeyAppInfo r12 = findCarkeyAppInfoInCache(r8);
        if (r12 != null) goto L5;
        r12 = r11.getByAppName(r8);
    L5:
        ArrayList r13 = new ArrayList();
        if (r12 == null) goto L10;
        List<String> r14 = r12.addressList;
        if (r14 == null) goto L10;
        r13.addAll(r14);
    L10:
        if (r10 != null) goto L12;
    L18:
        CarkeyAppInfo r15 = new CarkeyAppInfo(r8, r13);
        r11.upsert(r15);
        updateCarkeyCaches(r15);
        return;
    L12:
        if (r10.isEmpty() == true) goto L18;
        r13.remove(r10);
    L15:
        if (r13.size() <= 2) goto L17;
        r13.remove(0);
        goto L15
    L17:
        r13.add(r10);
        goto L18
    }

    private /* synthetic */ void lambda$showToastSafely$2(String r8) {
        Toast.makeText(this.mContext, r8, 500).show();     // Catch: Throwable -> L4
        return;
    }

    private void loadAllCarkeyAppInfos() {
        this.mDbExecutor.execute(new k(this, 18));
    }

    private void maybeNotifyCarDistanceByAvg10List() {
        long r8 = SystemClock.uptimeMillis();
        GattCarInfo r10 = this.mCurrentCarInfo;
        if (r10 != null) goto L5;
        return;
    L5:
        List<Integer> r11 = r10.getRssiAvg10List();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.isEmpty() == true) goto L68;
        CaeLog.d(TAG, "maybeNotifyCarDistanceByAvg10List: avg10List size=" + r11.size());
        int r12 = r11.size();
        if (r12 != this.mLastCarDistanceCheckedAvg10Count) goto L13;
        return;
    L13:
        this.mLastCarDistanceCheckedAvg10Count = r12;
        if (r12 >= 3) goto L16;
        return;
    L16:
        int r13 = (r12 - Math.min(10, r12)) + 1;
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r13 >= r12) goto L24;
        int r16 = r11.get(r13).intValue() - r11.get(r13 - 1).intValue();
        if (r16 <= 0) goto L21;
        r14 = r14 + 1;
    L23:
        r13 = r13 + 1;
        goto L17
    L21:
        if (r16 >= 0) goto L23;
        r15 = r15 + 1;
        goto L23
    L24:
        CaeLog.d(TAG, "maybeNotifyCarDistanceByAvg10List: incSteps=" + r14 + ", decSteps=" + r15);
        int r17 = r14 + r15;
        if (r17 != 0) goto L27;
        return;
    L27:
        CaeLog.d(TAG, "maybeNotifyCarDistanceByAvg10List: moveSteps=" + r17);
        String r18 = "Approaching vehicle";
        if ((Math.max(r14, r15) * 10) >= (r17 * 7)) goto L41;
        CaeLog.d(TAG, "maybeNotifyCarDistanceByAvg10List: not enough trend");
        if (sWalking == false) goto L64;
        int r19 = this.mLastCarDistanceMajorStateDirection;
        if (r19 != 0) goto L34;
        return;
    L34:
        if ((r8 - this.mLastCarDistanceNotifyUptimeMs) < 3000) goto L66;
        this.mLastCarDistanceNotifyUptimeMs = r8;
        if (r19 > 0) goto L39;
        r18 = "Moving away from vehicle";
    L39:
        Log.d(TAG, "maybeNotifyCarDistanceByAvg10List: fallback msg=".concat(r18));
        return;
    L66:
        return;
    L64:
        return;
    L41:
        if (r14 <= r15) goto L43;
        int r20 = 1;
    L45:
        if (this.mCarDistanceTrendReady == true) goto L48;
        this.mCarDistanceTrendReady = true;
        this.mLastCarDistanceObservedTrendDirection = r20;
        this.mLastCarDistanceNotifiedTrendDirection = r20;
        return;
    L48:
        this.mLastCarDistanceObservedTrendDirection = r20;
        if ((r8 - this.mLastCarDistanceNotifyUptimeMs) >= 3000) goto L52;
        return;
    L52:
        if (sWalking == true) goto L54;
        return;
    L54:
        this.mLastCarDistanceNotifyUptimeMs = r8;
        this.mLastCarDistanceNotifiedTrendDirection = r20;
        if (r20 > 0) goto L58;
        r18 = "Moving away from vehicle";
    L58:
        StringBuilder r21 = b.h("maybeNotifyCarDistanceByAvg10List: msg=", r18, ", inCar=");
        r21.append(this.mCurrentCarInfo.isInCar());
        r21.append(", directionNow=");
        r21.append(r20);
        Log.d(TAG, r21.toString());
        return;
    L43:
        r20 = -1;
        goto L45
    }

    private void onCarKeyAppGattConnected(BluetoothDevice r8, String r10) {
        CaeLog.d(TAG, "onCarKeyAppGattConnected: device=" + r8 + ", appName=" + r10);
        if (r8 != null) goto L6;
        CaeLog.w(TAG, "onCarKeyAppGattConnected: device is null");
        return;
    L6:
        connect(r8);
        GattCarInfo r11 = new GattCarInfo(r8);
        this.mCurrentCarInfo = r11;
        r11.setPackageName(r10);
        this.mDbExecutor.execute(new l(this, r10, r8.getAddress(), 5));
    }

    private void onCharacteristicChanged(BluetoothDevice r10, String r11) {
        CaeLog.d(TAG, "onCharacteristicChanged: device=" + r10 + ", appName=" + r11);
        GattCarInfo r12 = sDeviceCarInfoMap.get(r10);
        this.mLastCharacteristicChangedUptimeMs = SystemClock.uptimeMillis();
        if (this.mCurrentCarInfo.isInCar() == false) goto L22;
        if (this.mcharacteristicChanged == true) goto L22;
        if (sWalking == false) goto L22;
        Log.d(TAG, "onCharacteristicChanged: start out-of-car check");
        showToastSafely("Start exit check");
        long r8 = SystemClock.uptimeMillis();
        long r13 = this.mInCarStartUptimeMs;
        if (r13 > 0) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L34;
        if (r12 == null) goto L34;
        if (r12.getBluetoothGatt() == null) goto L34;
        if (this.mRssiReadCount != 0) goto L34;
    L33:
        readRemoteRssi(r12.getBluetoothGatt());
    L34:
        this.mcharacteristicChanged = true;
        return;
    L11:
        if ((r8 - r13) > 5000) goto L13;
        r14 = true;
    L22:
        if (this.mCurrentCarInfo.isInCar() == true) goto L34;
        if (this.mcharacteristicChanged == true) goto L34;
        if (sWalking == false) goto L34;
        Log.d(TAG, "onCharacteristicChanged: start in-car check");
        showToastSafely("Start entry check");
        if (r12 == null) goto L34;
        if (r12.getBluetoothGatt() == null) goto L34;
        if (this.mRssiReadCount != 0) goto L34;
        goto L33
    }

    private void onCharacteristicWriteComplete(BluetoothDevice r8, String r10) {
        CaeLog.d(TAG, "onCharacteristicWriteComplete: device=" + r8 + ", appName=" + r10);
        GattCarInfo r11 = sDeviceCarInfoMap.get(r8);
        if (this.mRssiReadCount <= 0) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.getBluetoothGatt() == null) goto L11;
        readRemoteRssi(r11.getBluetoothGatt());
        return;
    }

    private void postStatusNotification(int r8, String r10, String r11) {
        Log.d(TAG, "postStatusNotification: notificationId=" + r8 + ", title=" + r10 + ", text=" + r11);
        NotificationManager r12 = (NotificationManager) this.mContext.getSystemService("notification");     // Catch: Throwable -> L11
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.getNotificationChannel(NOTIFICATION_CHANNEL_ID) != null) goto L9;
        r12.createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, 2));     // Catch: Throwable -> L11
    L9:
        j r13 = new j(this.mContext, NOTIFICATION_CHANNEL_ID);     // Catch: Throwable -> L11
        r13.f1627s.icon = R.drawable.stat_sys_data_bluetooth;     // Catch: Throwable -> L11
        r13.e(r10);     // Catch: Throwable -> L11
        r13.d(r11);     // Catch: Throwable -> L11
        r13.f(8, true);     // Catch: Throwable -> L11
        r13.f(16, true);     // Catch: Throwable -> L11
        r13.f1615g = -1;     // Catch: Throwable -> L11
        r12.notify(r8, r13.b());     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        CaeLog.e(TAG, "postStatusNotification: failed: " + th.getMessage());
    }

    private void readRemoteRssi(BluetoothGatt r8) {
        if (r8 == null) goto L5;
        Log.d(TAG, "readRemoteRssi: Reading RSSI: " + r8.readRemoteRssi());
        return;
    }

    private void resetCarDistanceTrendState() {
        this.mLastCarDistanceCheckedAvg10Count = 0;
        this.mLastCarDistanceNotifyUptimeMs = 0;
        this.mCarDistanceTrendReady = false;
        this.mLastCarDistanceObservedTrendDirection = 0;
        this.mLastCarDistanceNotifiedTrendDirection = 0;
        this.mRssiBelowMinus50Duration = 0;
        this.mRssiBelowMinus50StartTime = 0;
    }

    private void scheduleNextRssiRead(final BluetoothGatt r8) {
        this.mHandler.postDelayed(new AnonymousClass3(this, r8), RSSI_READ_INTERVAL_MS);
    }

    private void showToastSafely(String r8) {
        if (r8 == null) goto L17;
    L12:
        th = move-exception;
        CaeLog.e(TAG, "showToastSafely: failed: " + th.getMessage());
        return;
    L4:
        if (r8.isEmpty() == true) goto L18;
        Handler r10 = this.mHandler;     // Catch: Throwable -> L12
        if (r10 != null) goto L10;
        r10 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L12
    L10:
        r10.post(new r(14, this, r8));     // Catch: Throwable -> L12
        return;
    L18:
        return;
    }

    private void updateCarkeyCaches(CarkeyAppInfo r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.appName == null) goto L24;
        ArrayList r10 = new ArrayList(this.mAllCarkeyAppInfos);
        boolean r11 = false;
        int r12 = 0;
    L8:
        if (r12 >= r10.size()) goto L15;
        CarkeyAppInfo r13 = (CarkeyAppInfo) r10.get(r12);
        if (r13 == null) goto L14;
        if (r8.appName.equals(r13.appName) == false) goto L14;
        r10.set(r12, r8);
        r11 = true;
    L14:
        r12 = r12 + 1;
    L15:
        if (r11 == true) goto L17;
        r10.add(r8);
    L17:
        this.mAllCarkeyAppInfos = r10;
        return;
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        disconnect();
        close();
        sDeviceCarInfoMap.clear();
        this.mCurrentCarInfo = null;
        this.mRssiReadCount = 0;
        this.mDbExecutor.shutdown();
        sInstance = null;
    }

    public void close() {
        BluetoothGatt r8 = this.mBluetoothGatt;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.close();
        this.mBluetoothGatt = null;
        this.mIsConnected = false;
    }

    public boolean connect(BluetoothDevice r13) {
        if (this.mBluetoothAdapter == null) goto L16;
        if (r13 == null) goto L16;
        BluetoothGatt r8 = this.mBluetoothGatt;
        if (r8 != null) goto L9;
    L14:
        this.mBluetoothGatt = r13.connectGatt(this.mContext, false, this.mGattCallback, 2, true, 1, null);
        CaeLog.d(TAG, "Trying to create a new connection to " + r13.getAddress() + " with advanced parameters");
        return true;
    L9:
        if (r8.getDevice().equals(r13) == false) goto L14;
        CaeLog.d(TAG, "Trying to use existing mBluetoothGatt for connection");
        if (this.mBluetoothGatt.connect() == false) goto L13;
        return true;
    L13:
        return false;
    L16:
        CaeLog.w(TAG, "BluetoothAdapter not initialized or invalid device");
        return false;
    }

    public void disconnect() {
        if (this.mBluetoothAdapter == null) goto L9;
        BluetoothGatt r8 = this.mBluetoothGatt;
        if (r8 == null) goto L9;
        r8.disconnect();
        this.mIsConnected = false;
        return;
    L9:
        CaeLog.w(TAG, "BluetoothAdapter not initialized or mBluetoothGatt is null");
    }

    public void init() {
        CaeLog.d(TAG, "init");
        this.mIsConnected = false;
        loadAllCarkeyAppInfos();
    }

    public void onEventReported(Bundle r8) {
        CaeLog.d(TAG, "onEventReported, data is " + r8);
        if (r8 == null) goto L19;
        int r10 = r8.getInt("event");
        String r11 = r8.getString("appName");
        BluetoothDevice r12 = (BluetoothDevice) r8.getParcelable("device");
        if (r11 == null) goto L17;
        if (r12 == null) goto L17;
        if (r10 != 1) goto L12;
        onCarKeyAppGattConnected(r12, r11);
        return;
    L12:
        if (r10 != 2) goto L15;
        onCharacteristicChanged(r12, r11);
        return;
    L15:
        if (r10 != 3) goto L22;
        onCharacteristicWriteComplete(r12, r11);
        return;
    L22:
        return;
    L17:
        CaeLog.w(TAG, "appName or device is null");
        return;
    }

    public void onWalkingState(boolean r8) {
        long r10 = 0;
        if (r8 == false) goto L6;
    L4:
        this.mStationaryStartUptimeMs = r10;
    L8:
        boolean r11 = sWalking;
        if (r8 == r11) goto L11;
        sLastWalking = r11;
    L11:
        sWalking = r8;
        if (r8 == false) goto L14;
        String r12 = "Walking";
    L15:
        CaeLog.d(TAG, "onWalkingState, walking is " + r8);
        showToastSafely(r12);
        Handler r13 = this.mHandler;
        if (r13 != null) goto L19;
        r13 = new Handler(Looper.getMainLooper());
    L19:
        r13.removeCallbacks(this.mInCarWalkingStartRssiRunnable);
        if (r8 == false) goto L23;
        r13.postDelayed(this.mInCarWalkingStartRssiRunnable, 3000);
        return;
    L23:
        return;
    L14:
        r12 = "Stationary";
        goto L15
    L6:
        if (this.mStationaryStartUptimeMs != 0) goto L8;
        r10 = SystemClock.uptimeMillis();
        goto L4
    }
}
