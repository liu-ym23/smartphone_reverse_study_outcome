package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import com.obric.cae.commonsense.R;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.HarLevel2DataReq;
import com.obric.cae.libs.useraware.HarLevel2DataResp;
import com.obric.cae.libs.useraware.HarShmPacketsReader;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.SensorEventInfo;
import com.obric.cae.libs.useraware.UnifiedDataPacket;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.mediaaware.AudioAwareInfoManger;
import com.obric.cae.userAware.ui.a1;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class UserAwareManager {
    private static final int BUFFER_CAPACITY = 0;
    private static final String HAR_LEVEL2_DATA_SHM = "HarLevel2DataShm";
    private static final int HIGH_POWER_MASK = 27;
    private static final int SHM_BUFFER_SIZE_THRESHOLD = 0;
    private static final String TAG = "UserAwareManager";
    private static final int TIMEOUT_SHM_BUFFER_SEND_MS = 500;
    private static UserAwareManager sInstance;
    private final AtomicBoolean isCaeActiveRecording;
    private final AtomicBoolean isHarRecordLocal;
    private final AtomicBoolean isThirdPartyRom;
    private AudioAwareInfoManger mAudioAwareInfoManager;
    private BtAwareInfoManager mBtAwareInfoManager;
    private CellAwareInfoManger mCellAwareInfoManager;
    private int mCurrentShmBufferIndex;
    private int mCurrentShmBufferOffset;
    private final ExecutorService mHarDataExecutor;
    private Thread mHarDataThread;
    private int mHarLevel2BtDataCount;
    private int mHarLevel2CellDataCount;
    private SharedMemory mHarLevel2DaraShm;
    private final List<HarLevel2DataResp> mHarLevel2DataRespList;
    private int mHarLevel2GnssDataCount;
    private int mHarLevel2LocationDataCount;
    private final Map<Integer, Integer> mHarLevel2SensorDataCountMap;
    private int mHarLevel2WifiDataCount;
    private ByteBuffer mHarShmMappedBuffer;
    private final ConcurrentMap<Integer, ScheduledExecutorService> mHarTaskMap;
    private final List<InnerAwareInfoCallback> mInnerAwareInfoCallbacks;
    private final AtomicBoolean mIsHarLevel2DataRecording;
    private final AtomicBoolean mIsRecording;
    private final AtomicBoolean mIsRecordingByCallback;
    private String mLastDesc;
    private long mLastHarCollectEndTime;
    private long mLastHarCollectStartTime;
    private int mLastHarCollectTimeout;
    private long mLastNotifyTime;
    private LocationAwareInfoManager mLocationAwareInfoManager;
    private String mNearbyLogPath;
    private OemHarInfoManager mOemHarInfoManager;
    private Thread mRecordThread;
    private final AtomicInteger mRecordingAwakeCount;
    private int mRecordingMask;
    private SensorCollectManager mSensorCollectManager;
    private final Object mShmBufferLock;
    private final RemoteCallbackList<ICaeUserAwareCallback> mUserAwareCallbacks;
    private PowerManager.WakeLock mWakeLock;
    private WifiAwareInfoManager mWifiAwareInfoManager;

    @FunctionalInterface
    public interface CallbackAction<T> {
        void execute(ICaeUserAwareCallback r8, T r10);
    }

    public interface InnerCallbackAction<T> {
        void execute(InnerAwareInfoCallback r8, T r10);
    }

    public interface InnerCallbackAction2<T1, T2> {
        void execute(InnerAwareInfoCallback r8, T1 r10, T2 r11);
    }

    public interface InnerCallbackActionNoArg {
        void execute(InnerAwareInfoCallback r8);
    }

    public interface InnerCallbackActionSubway {
        void execute(InnerAwareInfoCallback r8, boolean r10, float r11, String r12, long r13, int r14, int r15, float r16, float r17, int r18, boolean r19, String r110);
    }

    static {
        int r8 = HarShmPacketsReader.getSingleBufferSize();
        SHM_BUFFER_SIZE_THRESHOLD = r8;
        BUFFER_CAPACITY = r8 * 2;
    }

    private UserAwareManager() {
        this.mIsRecording = new AtomicBoolean(false);
        this.mRecordingAwakeCount = new AtomicInteger(0);
        this.mIsRecordingByCallback = new AtomicBoolean(false);
        this.mIsHarLevel2DataRecording = new AtomicBoolean(false);
        this.mUserAwareCallbacks = new RemoteCallbackList();
        this.mHarLevel2DataRespList = new CopyOnWriteArrayList();
        this.mHarDataExecutor = Executors.newCachedThreadPool();
        this.mHarTaskMap = new ConcurrentHashMap();
        this.isHarRecordLocal = new AtomicBoolean(false);
        this.isCaeActiveRecording = new AtomicBoolean(false);
        this.isThirdPartyRom = new AtomicBoolean(false);
        this.mInnerAwareInfoCallbacks = new ArrayList();
        this.mRecordingMask = 0;
        this.mHarLevel2DaraShm = null;
        this.mHarShmMappedBuffer = null;
        this.mCurrentShmBufferIndex = 0;
        this.mCurrentShmBufferOffset = 0;
        this.mLastNotifyTime = 0;
        this.mLastHarCollectStartTime = 0;
        this.mLastHarCollectEndTime = 0;
        this.mLastHarCollectTimeout = 0;
        this.mHarLevel2WifiDataCount = 0;
        this.mHarLevel2BtDataCount = 0;
        this.mHarLevel2CellDataCount = 0;
        this.mHarLevel2LocationDataCount = 0;
        this.mHarLevel2GnssDataCount = 0;
        this.mHarLevel2SensorDataCountMap = new HashMap();
        this.mShmBufferLock = new Object();
        this.mLastDesc = "";
        this.mNearbyLogPath = "";
    }

    public static /* synthetic */ void a(UserAwareManager r8, int r10, int r11, int r12) {
        r8.lambda$scheduleNextWifiRecord$5(r10, r11, r12);
    }

    public static /* synthetic */ void b(UserAwareManager r8, int r10) {
        r8.lambda$recordNearbyInfo$0(r10);
    }

    public static /* synthetic */ void c(UserAwareManager r8, int r10) {
        r8.lambda$startLocationScan$1(r10);
    }

    public static /* synthetic */ void d(UserAwareManager r8, int r10, int r11, int r12) {
        r8.lambda$scheduleNextLocationRecord$9(r10, r11, r12);
    }

    public static /* synthetic */ void e(UserAwareManager r8) {
        r8.lambda$scheduleNextBtRecord$6();
    }

    public static /* synthetic */ void f(UserAwareManager r8, int r10, HarLevel2DataResp r11) {
        r8.lambda$startHarLevel2DataCollection$4(r10, r11);
    }

    private String formatHarLevel2SensorDataCountLocked() {
        if (this.mHarLevel2SensorDataCountMap.isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringJoiner r8 = new StringJoiner(", ", "{", "}");
        Iterator r10 = new TreeMap(this.mHarLevel2SensorDataCountMap).entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        Map.Entry r11 = (Map.Entry) r10.next();
        int r12 = ((Integer) r11.getKey()).intValue();
        r8.add(getSensorTypeName(r12) + "(type=" + r12 + ")=" + r11.getValue());
        goto L8
    L11:
        return r8.toString();
    }

    public static /* synthetic */ void g(UserAwareManager r8) {
        r8.lambda$stopHarLevel2DataCollection$10();
    }

    public static synchronized UserAwareManager getInstance() {
        monitor-enter(UserAwareManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new UserAwareManager();     // Catch: Throwable -> L10
    L7:
        UserAwareManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(UserAwareManager.class);
        return r8;
    }

    private String getSensorTypeName(int r8) {
        if (r8 != 8) goto L5;
        return "proximity";
    L5:
        if (r8 != 19) goto L7;
        return "step_counter";
    L7:
        if (r8 != 10) goto L9;
        return "linear_acceleration";
    L9:
        if (r8 == 11) goto L25;
        switch(r8) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            default: goto L12;
        };
    L13:
        return "pressure";
    L15:
        return "light";
    L17:
        return "gyroscope";
    L19:
        return "orientation";
    L21:
        return "magnetic_field";
    L23:
        return "accelerometer";
    L12:
        return defpackage.a.d("sensorType_", r8);
    L25:
        return "rotation_vector";
    }

    public static /* synthetic */ void h(UserAwareManager r8, int r10) {
        r8.lambda$zppCollectLocation$3(r10);
    }

    public static /* synthetic */ void i(UserAwareManager r8) {
        r8.lambda$scheduleNextLocationRecord$8();
    }

    public static /* synthetic */ void j(Location[] r8, CountDownLatch r10, Location r11) {
        lambda$zppCollectLocation$2(r8, r10, r11);
    }

    public static /* synthetic */ void k(UserAwareManager r8, Parcelable r10) {
        r8.lambda$postHarLevel2Data$11(r10);
    }

    public static /* synthetic */ void l(UserAwareManager r8, int r10, int r11, int r12) {
        r8.lambda$scheduleNextBtRecord$7(r10, r11, r12);
    }

    private /* synthetic */ void lambda$postHarLevel2Data$11(Parcelable r8) {
        postHarLevel2DataInternal(r8);
    }

    private /* synthetic */ void lambda$recordNearbyInfo$0(int r8) {
        Thread.sleep(r8);     // Catch: InterruptedException -> L7
        if (this.mIsRecording.get() == false) goto L11;
        CommSenseLog.d(TAG, "recordNearbyInfo timeout arrived");     // Catch: InterruptedException -> L7
        this.mIsRecording.set(false);     // Catch: InterruptedException -> L7
        cancelRecord(true);     // Catch: InterruptedException -> L7
        return;
    L11:
        return;
    L7:
        CommSenseLog.i(TAG, "recordNearbyInfo: Interrupted");
    }

    private /* synthetic */ void lambda$scheduleNextBtRecord$6() {
        this.mBtAwareInfoManager.stopBleScan();
    }

    private /* synthetic */ void lambda$scheduleNextBtRecord$7(int r8, int r10, int r11) {
        scheduleNextBtRecord(r8, r10, r11);
    }

    private /* synthetic */ void lambda$scheduleNextLocationRecord$8() {
        this.mLocationAwareInfoManager.stopLocationScan();
    }

    private /* synthetic */ void lambda$scheduleNextLocationRecord$9(int r8, int r10, int r11) {
        scheduleNextLocationRecord(r8, r10, r11);
    }

    private /* synthetic */ void lambda$scheduleNextWifiRecord$5(int r8, int r10, int r11) {
        scheduleNextWifiRecord(r8, r10, r11);
    }

    private /* synthetic */ void lambda$startHarLevel2DataCollection$4(int r8, HarLevel2DataResp r10) {
        Thread.sleep(r8);     // Catch: InterruptedException -> L7
        CommSenseLog.d(TAG, "startHarLevel2DataCollection timeout arrived");     // Catch: InterruptedException -> L7
        if (this.mIsHarLevel2DataRecording.get() == false) goto L11;
        this.mIsHarLevel2DataRecording.set(false);     // Catch: InterruptedException -> L7
        notifyAndSwitchBuffer();     // Catch: InterruptedException -> L7
        stopHarLevel2DataCollection(r10);     // Catch: InterruptedException -> L7
        return;
    L11:
        return;
    L7:
        CommSenseLog.i(TAG, "startHarLevel2DataCollection: Timer cancelled");
    }

    private /* synthetic */ void lambda$startLocationScan$1(int r8) {
        Thread.sleep(r8);     // Catch: InterruptedException -> L5
        this.mLocationAwareInfoManager.stopLocationScan();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "startSingleLocationScan: InterruptedException -- ", e);
    }

    private /* synthetic */ void lambda$stopHarLevel2DataCollection$10() {
        Thread.sleep(500);     // Catch: InterruptedException -> L6
        CommSenseLog.i(TAG, "stopHarLevel2DataCollection, restart recording, mask:0x" + String.format("%02X", new Object[]{Integer.valueOf(this.mRecordingMask)}));
        processRecordingTask(this.mRecordingMask);
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static /* synthetic */ Integer lambda$updateHarLevel2DataCountLocked$12(Integer r8, Integer r10) {
        int r11 = 1;
        if (r10 == null) goto L7;
        r11 = 1 + r10.intValue();
    L7:
        return Integer.valueOf(r11);
    }

    private static /* synthetic */ void lambda$zppCollectLocation$2(Location[] r8, CountDownLatch r10, Location r11) {
        CommSenseLog.d(TAG, "zppCollectLocation: " + r11);
        if (r11 == r8[0]) goto L6;
        r8[0] = r11;
        r10.countDown();
        return;
    }

    private /* synthetic */ void lambda$zppCollectLocation$3(int r8) {
        final CountDownLatch r10 = new CountDownLatch(r8);
        final Location[] r11 = {null};
        LocationListener r12 = new n(r11, r10);
        this.mLocationAwareInfoManager.resetLastLocationInfo();
        LocationUtil.getInstance().startLocationRequest("fused", r12);
        r10.await(r8, TimeUnit.SECONDS);     // Catch: InterruptedException -> L5
    L7:
        LocationUtil.getInstance().stopLocationRequest(r12);
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "zppCollectLocation: InterruptedException -- ", e);
        goto L7
    }

    private void logHarLevel2DataCount() {
        Object r8 = this.mShmBufferLock;
        monitor-enter(r8);
        CommSenseLog.encryptedI(TAG, LocationUtil.getEncryptedModule(), "stopHarLevel2DataCollection: dataCount, wifi=" + this.mHarLevel2WifiDataCount + ", bt=" + this.mHarLevel2BtDataCount + ", cell=" + this.mHarLevel2CellDataCount + ", location=" + this.mHarLevel2LocationDataCount + ", gnss=" + this.mHarLevel2GnssDataCount + ", sensor=" + formatHarLevel2SensorDataCountLocked(), LocationUtil.getEncryptedKey());     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Integer m(Integer r8, Integer r10) {
        return lambda$updateHarLevel2DataCountLocked$12(r8, r10);
    }

    private void notifyAndSwitchBuffer() {
        Object r8 = this.mShmBufferLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.isHarRecordLocal.get() == false) goto L7;
    L20:
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mCurrentShmBufferOffset == 0) goto L20;
        Iterator<HarLevel2DataResp> r10 = this.mHarLevel2DataRespList.iterator();     // Catch: Throwable -> L22
    L11:
        if (r10.hasNext() == false) goto L17;
        HarLevel2DataResp r11 = r10.next();     // Catch: Throwable -> L22
        r11.onDataReady(this.mCurrentShmBufferIndex, this.mCurrentShmBufferOffset);     // Catch: RemoteException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        this.mHarLevel2DataRespList.remove(r11);     // Catch: Throwable -> L22
        CommSenseLog.e(TAG, "Error notifying client", e);     // Catch: Throwable -> L22
        goto L11
    L17:
        this.mCurrentShmBufferIndex = (this.mCurrentShmBufferIndex + 1) % 2;     // Catch: Throwable -> L22
        this.mCurrentShmBufferOffset = 0;     // Catch: Throwable -> L22
        this.mLastNotifyTime = System.currentTimeMillis();     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
    }

    private void postHarLevel2DataInternal(Parcelable r8) {
        Object r10 = this.mShmBufferLock;
        monitor-enter(r10);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L7;
    L26:
        monitor-exit(r10);     // Catch: Throwable -> L28
        return;
    L7:
        if (this.isHarRecordLocal.get() == true) goto L26;
        if (this.mHarShmMappedBuffer == null) goto L26;
        byte[] r11 = serializePacket(new UnifiedDataPacket(r8));     // Catch: Throwable -> L28
        updateHarLevel2DataCountLocked(r8);     // Catch: Throwable -> L28
        int r12 = r11.length + 4;     // Catch: Throwable -> L28
        int r13 = BUFFER_CAPACITY;     // Catch: Throwable -> L28
        if (r12 <= r13) goto L16;
        CommSenseLog.e(TAG, "postHarLevel2DataInternal, Dropping oversized packet. Size: " + r11.length + " is larger than buffer capacity " + r13);     // Catch: Throwable -> L28
        monitor-exit(r10);     // Catch: Throwable -> L28
        return;
    L16:
        int r14 = (this.mCurrentShmBufferOffset + 4) + r11.length;     // Catch: Throwable -> L28
        int r15 = SHM_BUFFER_SIZE_THRESHOLD;     // Catch: Throwable -> L28
        if (r14 <= r15) goto L19;
        notifyAndSwitchBuffer();     // Catch: Throwable -> L28
    L19:
        this.mHarShmMappedBuffer.position((this.mCurrentShmBufferIndex * r15) + this.mCurrentShmBufferOffset);     // Catch: Throwable -> L28
        this.mHarShmMappedBuffer.putInt(r11.length);     // Catch: Throwable -> L28
        this.mHarShmMappedBuffer.put(r11);     // Catch: Throwable -> L28
        int r16 = (r11.length + 4) + this.mCurrentShmBufferOffset;     // Catch: Throwable -> L28
        this.mCurrentShmBufferOffset = r16;     // Catch: Throwable -> L28
        if (r16 <= r15) goto L22;
    L23:
        notifyAndSwitchBuffer();     // Catch: Throwable -> L28
    L24:
        monitor-exit(r10);     // Catch: Throwable -> L28
        return;
    L22:
        if ((System.currentTimeMillis() - this.mLastNotifyTime) < 500) goto L24;
        goto L23
    }

    private void processHarLevel2DataReq(List<HarLevel2DataReq> r8) {
        Iterator<HarLevel2DataReq> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L41;
        HarLevel2DataReq r11 = r10.next();
        String r12 = TAG;
        CommSenseLog.i(r12, "processHarLevel2DataReq: " + r11.getRequestType() + ", count: " + r11.getCount() + ", interval: " + r11.getInterval() + ", timeout: " + r11.getTimeout());
        if (this.mIsHarLevel2DataRecording.get() == false) goto L65;
        if (r11.getCount() <= 0) goto L66;
        if (r11.getInterval() == 0) goto L17;
        if (r11.getTimeout() == 0) goto L17;
        if (r11.getInterval() >= r11.getTimeout()) goto L17;
    L40:
        throw new IllegalArgumentException("interval must be greater than timeout and non-negative");
    L17:
        if (r11.getInterval() < 0) goto L40;
        if (r11.getTimeout() < 0) goto L40;
        int r13 = r11.getRequestType();
        if (r13 != 1) goto L23;
        if (r11.getTimeout() > r11.getInterval()) goto L38;
        this.mHarTaskMap.put(Integer.valueOf(r11.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextWifiRecord(r11.getCount(), r11.getInterval(), r11.getTimeout());
        goto L4
    L38:
        throw new IllegalArgumentException("timeout must be less than interval");
    L23:
        if (r13 != 2) goto L25;
        this.mHarTaskMap.put(Integer.valueOf(r11.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextBtRecord(r11.getCount(), r11.getInterval(), r11.getTimeout());
        goto L4
    L25:
        if (r13 == 3) goto L4;
        if (r13 != 4) goto L29;
        this.mHarTaskMap.put(Integer.valueOf(r11.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextLocationRecord(r11.getCount(), r11.getInterval(), r11.getTimeout());
        goto L4
    L29:
        if (r13 != 5) goto L30;
        this.mSensorCollectManager.startSensorCollect(4064);
        goto L4
    L30:
        CommSenseLog.e(r12, "processHarLevel2DataReq: unknown request type");
        goto L4
    L66:
        return;
    L65:
        return;
    }

    private void processRecordingTask(int r8) {
        if ((r8 & 1) != 1) goto L6;
        this.mWifiAwareInfoManager.startWifiRecord(true);
    L6:
        if ((r8 & 2) != 2) goto L9;
        this.mBtAwareInfoManager.startBleScan(5);
    L9:
        if ((r8 & 8) != 8) goto L12;
        this.mLocationAwareInfoManager.startLocationScan(false);
    L12:
        if ((r8 & 16) != 16) goto L14;
        this.mAudioAwareInfoManager.startRecordingExternal();
    L14:
        this.mSensorCollectManager.startSensorCollect(r8);
    }

    private void resetHarLevel2DataCountLocked() {
        this.mHarLevel2WifiDataCount = 0;
        this.mHarLevel2BtDataCount = 0;
        this.mHarLevel2CellDataCount = 0;
        this.mHarLevel2LocationDataCount = 0;
        this.mHarLevel2GnssDataCount = 0;
        this.mHarLevel2SensorDataCountMap.clear();
    }

    private void scheduleNextBtRecord(int r13, int r14, int r15) {
        this.mBtAwareInfoManager.startBleScan(5);
        ScheduledExecutorService r8 = this.mHarTaskMap.get(2);
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = 1;
        if (r15 <= 0) goto L8;
        r8.schedule(new p(this, r10), r15, TimeUnit.MILLISECONDS);
    L8:
        int r11 = r13 - 1;
        if (r11 <= 0) goto L13;
        if (r14 <= 0) goto L14;
        r8.schedule(new q(this, r11, r14, r15, 1), r14, TimeUnit.MILLISECONDS);
        return;
    L14:
        return;
    }

    private void scheduleNextLocationRecord(int r12, int r13, int r14) {
        int r8 = 0;
        this.mLocationAwareInfoManager.startLocationScan(false);
        ScheduledExecutorService r10 = this.mHarTaskMap.get(4);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r14 <= 0) goto L7;
        r10.schedule(new p(this, r8), r14, TimeUnit.MILLISECONDS);
    L7:
        int r11 = r12 - 1;
        if (r11 <= 0) goto L12;
        if (r13 <= 0) goto L13;
        r10.schedule(new q(this, r11, r13, r14, 0), r13, TimeUnit.MILLISECONDS);
        return;
    L13:
        return;
    }

    private void scheduleNextWifiRecord(int r8, final int r10, final int r11) {
        if (isRecording() == true) goto L5;
    L6:
        this.mWifiAwareInfoManager.startSingleHarDataCollection(r11 - 100, r11);
    L7:
        ScheduledExecutorService r12 = this.mHarTaskMap.get(1);
        if (r12 != null) goto L10;
        return;
    L10:
        final int r13 = r8 - 1;
        if (r13 <= 0) goto L15;
        if (r10 <= 0) goto L16;
        r12.schedule(new s(this, r13, r10, r11), r10, TimeUnit.MILLISECONDS);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((this.mRecordingMask & 1) == 0) goto L7;
        goto L6
    }

    private byte[] serializePacket(Parcelable r8) {
        Parcel r10 = Parcel.obtain();
        r8.writeToParcel(r10, 0);
        byte[] r11 = r10.marshall();
        r10.recycle();
        return r11;
    }

    @SuppressLint({"NewApi"})
    private void startHarLevel2DataCollection(Context r10, List<HarLevel2DataReq> r11, final int r12, final HarLevel2DataResp r13) {
        Object r8 = this.mShmBufferLock;
        monitor-enter(r8);
        String r14 = TAG;     // Catch: Throwable -> L40
        CommSenseLog.i(r14, "startHarLevel2DataCollection: isLocalCollect: " + this.isHarRecordLocal.get());     // Catch: Throwable -> L40
        if (this.isHarRecordLocal.get() == false) goto L7;
        createNearbyInfoFile(r10, r10.getString(R.string.user_aware_har_req_collection_local));     // Catch: Throwable -> L40
        CommSenseLog.i(r14, "onCollectStats: true, null");     // Catch: RemoteException -> L28 Throwable -> L40
        r13.onCollectStats(true, null);     // Catch: RemoteException -> L28 Throwable -> L40
    L30:
        monitor-exit(r8);     // Catch: Throwable -> L40
        acquireWakeLock(r10, r12 + 100);
        Thread r15 = new Thread(new m(this, r12, r13), "HarLevel2DataThread");
        this.mHarDataThread = r15;
        r15.start();
        Object r16 = this.mShmBufferLock;
        monitor-enter(r16);
        this.mLastNotifyTime = System.currentTimeMillis();     // Catch: Throwable -> L37
        monitor-exit(r16);     // Catch: Throwable -> L37
        processHarLevel2DataReq(r11);
        return;
    L37:
        th = move-exception;
        throw th;
    L28:
        e = move-exception;
        CommSenseLog.e(TAG, "startHarLevel2DataCollection: RemoteException1 -- ", e);     // Catch: Throwable -> L40
        goto L30
    L7:
        if (this.mHarLevel2DataRespList.isEmpty() == true) goto L52;
    L18:
        this.mHarLevel2DataRespList.add(r13);     // Catch: Throwable -> L40
        ParcelFileDescriptor r17 = this.mHarLevel2DaraShm.getFdDup();     // Catch: Throwable -> L21 Throwable -> L40
        CommSenseLog.i(r14, "onCollectStats: true, parcelFileDescriptor: " + r17);     // Catch: Throwable -> L21 Throwable -> L40
        r13.onCollectStats(true, r17);     // Catch: Throwable -> L21 Throwable -> L40
    L21:
        e = move-exception;
        CommSenseLog.e(TAG, "startHarLevel2DataCollection: Exception2 -- ", e);     // Catch: Throwable -> L40
        return;
    L52:
        CommSenseLog.i(r14, "Create SharedMemory");     // Catch: ErrnoException -> L10 Throwable -> L40
        int r18 = BUFFER_CAPACITY;     // Catch: ErrnoException -> L10 Throwable -> L40
        SharedMemory r19 = SharedMemory.create(HAR_LEVEL2_DATA_SHM, r18);     // Catch: ErrnoException -> L10 Throwable -> L40
        this.mHarLevel2DaraShm = r19;     // Catch: ErrnoException -> L10 Throwable -> L40
        this.mHarShmMappedBuffer = r19.map(OsConstants.PROT_READ | OsConstants.PROT_WRITE, 0, r18);     // Catch: ErrnoException -> L10 Throwable -> L40
    L10:
        e = move-exception;
        String r110 = TAG;     // Catch: Throwable -> L40
        CommSenseLog.e(r110, "startHarLevel2DataCollection: ErrnoException|IOException -- ", e);     // Catch: Throwable -> L40
        CommSenseLog.i(r110, "onCollectStats: true, null");     // Catch: RemoteException -> L14 Throwable -> L40
        r13.onCollectStats(true, null);     // Catch: RemoteException -> L14 Throwable -> L40
    L17:
        return;
    L14:
        e = move-exception;
        CommSenseLog.e(TAG, "startHarLevel2DataCollection: RemoteException1 -- ", e);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"NewApi"})
    private void stopHarLevel2DataCollection(HarLevel2DataResp r8) {
        Thread r10 = this.mHarDataThread;
        if (r10 == null) goto L38;
        r10.interrupt();
        this.mHarDataThread = null;
    L38:
        CommSenseLog.i(TAG, "onCollectStats: false, null");     // Catch: RemoteException -> L8
        r8.onCollectStats(false, null);     // Catch: RemoteException -> L8
    L9:
        String r11 = TAG;
        CommSenseLog.i(r11, "stopHarLevel2DataCollection");
        logHarLevel2DataCount();
        this.mHarLevel2DataRespList.remove(r8);
        Object r12 = this.mShmBufferLock;
        monitor-enter(r12);
    L33:
        th = move-exception;
        throw th;
    L12:
        if (this.mHarLevel2DataRespList.isEmpty() == true) goto L14;
    L26:
        this.mLastHarCollectEndTime = System.currentTimeMillis();     // Catch: Throwable -> L33
        monitor-exit(r12);     // Catch: Throwable -> L33
        if (this.mIsRecording.get() == false) goto L31;
        new Thread(new b(this, 2), "restartRecording").start();
    L31:
        releaseWakeLock();
        return;
    L14:
        if (this.isHarRecordLocal.get() == true) goto L19;
        CommSenseLog.i(r11, "No HarLevel2DataResp registered, cleanup Shm.");     // Catch: Throwable -> L33
        SharedMemory.unmap(this.mHarShmMappedBuffer);     // Catch: Throwable -> L33
        this.mHarShmMappedBuffer = null;     // Catch: Throwable -> L33
        SharedMemory r13 = this.mHarLevel2DaraShm;     // Catch: Throwable -> L33
        if (r13 == null) goto L18;
        r13.close();     // Catch: Throwable -> L33
        this.mHarLevel2DaraShm = null;     // Catch: Throwable -> L33
    L18:
        this.mCurrentShmBufferIndex = 0;     // Catch: Throwable -> L33
        this.mCurrentShmBufferOffset = 0;     // Catch: Throwable -> L33
        this.mLastNotifyTime = 0;     // Catch: Throwable -> L33
    L19:
        this.mWifiAwareInfoManager.startWifiRecord(false);     // Catch: Throwable -> L33
        this.mBtAwareInfoManager.stopBleScan();     // Catch: Throwable -> L33
        this.mLocationAwareInfoManager.stopLocationScan();     // Catch: Throwable -> L33
        this.mSensorCollectManager.stopSensorCollect();     // Catch: Throwable -> L33
        Iterator<Map.Entry<Integer, ScheduledExecutorService>> r14 = this.mHarTaskMap.entrySet().iterator();     // Catch: Throwable -> L33
    L21:
        if (r14.hasNext() == false) goto L23;
        r14.next().getValue().shutdownNow();     // Catch: Throwable -> L33
        goto L21
    L23:
        this.mHarTaskMap.clear();     // Catch: Throwable -> L33
        if (this.isHarRecordLocal.get() == false) goto L26;
        CommSenseLog.d(TAG, "Har record local, copy event logs");     // Catch: Throwable -> L33
        copyEventLogsToNearbyLogFile(true);     // Catch: Throwable -> L33
    L8:
        CommSenseLog.i(TAG, "Callback Server died, no need to notify");
        goto L9
    }

    private void updateHarLevel2DataCountLocked(Parcelable r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof WifiStandardData) == false) goto L8;
        this.mHarLevel2WifiDataCount++;
        return;
    L8:
        if ((r8 instanceof BtAwareInfo) == false) goto L11;
        this.mHarLevel2BtDataCount++;
        return;
    L11:
        if ((r8 instanceof CellAwareInfo) == false) goto L14;
        this.mHarLevel2CellDataCount++;
        return;
    L14:
        if ((r8 instanceof LocationAwareInfo) == false) goto L17;
        this.mHarLevel2LocationDataCount++;
        return;
    L17:
        if ((r8 instanceof GnssSvAwareInfo) == false) goto L20;
        this.mHarLevel2GnssDataCount++;
        return;
    L20:
        if ((r8 instanceof SensorEventInfo) == false) goto L22;
        this.mHarLevel2SensorDataCountMap.compute(Integer.valueOf(((SensorEventInfo) r8).getSensorType()), new r());
        return;
    L22:
        CommSenseLog.w(TAG, "updateHarLevel2DataCountLocked: unknown data type ".concat(r8.getClass().getSimpleName()));
    }

    public synchronized void acquireWakeLock(Context r8, int r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWakeLock != null) goto L12;
        PowerManager r11 = (PowerManager) r8.getSystemService("power");     // Catch: Throwable -> L15
        if (r11 != null) goto L11;
        CommSenseLog.e(TAG, "acquireWakeLock, powerManager is null");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        this.mWakeLock = r11.newWakeLock(1, TAG);     // Catch: Throwable -> L15
    L12:
        this.mWakeLock.acquire(r10);     // Catch: Throwable -> L15
        CommSenseLog.i(TAG, "acquireWakeLock, totalTimeout: " + r10);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public void cancelRecord(boolean r8) {
        CommSenseLog.i(TAG, "cancelRecord");
        Thread r10 = this.mRecordThread;
        if (r10 == null) goto L5;
        r10.interrupt();
        this.mRecordThread = null;
    L5:
        this.mWifiAwareInfoManager.startWifiRecord(false);
        this.mBtAwareInfoManager.stopBleScan();
        this.mLocationAwareInfoManager.stopLocationScan();
        this.mAudioAwareInfoManager.stopRecordingExternal();
        this.mSensorCollectManager.stopSensorCollect();
        OemHarInfoManager r11 = this.mOemHarInfoManager;
        if (r11 == null) goto L8;
        r11.stopRecordHarStatus();
    L8:
        copyEventLogsToNearbyLogFile(true);
        if (r8 == false) goto L11;
        notifyInnerCallbacks(new o5.o(8), Boolean.FALSE);
    L11:
        this.mIsRecordingByCallback.set(false);
        if (this.mRecordingAwakeCount.get() <= 0) goto L15;
        releaseWakeLock();
        this.mRecordingAwakeCount.decrementAndGet();
        return;
    }

    public void clearInnerCallbacks() {
        List<InnerAwareInfoCallback> r8 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r8);
        this.mInnerAwareInfoCallbacks.clear();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void copyEventLogsToNearbyLogFile(boolean r8) {
        File r10 = new File(this.mNearbyLogPath);
        if (r8 == false) goto L7;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("smart_bt"), r10);
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("geofence"), r10);
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("cell_events"), r10);
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("sensor_events"), r10);
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("har_state"), r10);
    L5:
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("user_aware"), r10);
        return;
    L7:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("smart_bt")) == true) goto L10;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("smart_bt"), r10);
    L10:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("geofence")) == true) goto L13;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("geofence"), r10);
    L13:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("cell_events")) == true) goto L16;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("cell_events"), r10);
    L16:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("sensor_events")) == true) goto L19;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("sensor_events"), r10);
    L19:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("har_state")) == true) goto L22;
        UserAwareUtil.copyFile(CommSenseLog.getRecordFile("har_state"), r10);
    L22:
        if (UserAwareUtil.isFileExist(r10, CommSenseLog.getRecordFile("user_aware")) == false) goto L5;
    }

    public void createNearbyInfoFile(Context r8) {
        CommSenseLog.i(TAG, "createNearbyInfoFile not desc, use last desc");
        String r10 = this.mLastDesc;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        createNearbyInfoFile(r8, this.mLastDesc);
        return;
    }

    public AudioAwareInfoManger getAudioAwareInfoManager() {
        return this.mAudioAwareInfoManager;
    }

    public BtAwareInfoManager getBtAwareInfoManager() {
        return this.mBtAwareInfoManager;
    }

    public CellAwareInfoManger getCellAwareInfoManager() {
        return this.mCellAwareInfoManager;
    }

    public LocationAwareInfoManager getLocationAwareInfoManager() {
        return this.mLocationAwareInfoManager;
    }

    public OemHarInfoManager getOemHarInfoManager() {
        return this.mOemHarInfoManager;
    }

    public SensorCollectManager getSensorCollectManager() {
        return this.mSensorCollectManager;
    }

    public String getSessionDir() {
        return this.mNearbyLogPath;
    }

    public WifiAwareInfoManager getWifiAwareInfoManager() {
        return this.mWifiAwareInfoManager;
    }

    public void initManager(WifiAwareInfoManager r8, BtAwareInfoManager r10, LocationAwareInfoManager r11, CellAwareInfoManger r12, AudioAwareInfoManger r13, SensorCollectManager r14, OemHarInfoManager r15) {
        CommSenseLog.d(TAG, "initManager");
        this.mWifiAwareInfoManager = r8;
        this.mBtAwareInfoManager = r10;
        this.mLocationAwareInfoManager = r11;
        this.mCellAwareInfoManager = r12;
        this.mAudioAwareInfoManager = r13;
        this.mSensorCollectManager = r14;
        this.mOemHarInfoManager = r15;
    }

    public boolean isActiveRecording() {
        if (this.mIsRecording.get() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mRecordingMask & 27) == 0) goto L7;
        return true;
    }

    public boolean isHarLevel2DataRecording() {
        return this.mIsHarLevel2DataRecording.get();
    }

    public boolean isMemDHarEnabled() {
        return UserAwareService.getService().mIsMemDHarEnabled.get();
    }

    public boolean isRecording() {
        return this.mIsRecording.get();
    }

    public boolean isRecordingByCallback() {
        return this.mIsRecordingByCallback.get();
    }

    public boolean isWifiRecordingMask() {
        if ((this.mRecordingMask & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void notifyActiveRecording(boolean r8) {
        this.isCaeActiveRecording.set(r8);
    }

    public <T> void notifyCallbacks(CallbackAction<T> r8, T r10) {
        RemoteCallbackList<ICaeUserAwareCallback> r11 = this.mUserAwareCallbacks;
        monitor-enter(r11);
        int r12 = this.mUserAwareCallbacks.beginBroadcast();     // Catch: Throwable -> L17
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        ICaeUserAwareCallback r14 = (ICaeUserAwareCallback) this.mUserAwareCallbacks.getBroadcastItem(r13);     // Catch: Throwable -> L17
        if (r14 == null) goto L13;
        if (r10 == null) goto L13;
        r8.execute(r14, r10);     // Catch: Exception -> L11 Throwable -> L17
    L11:
        e = move-exception;
        CommSenseLog.e(TAG, "notifyCallbacks exception" + e);     // Catch: Throwable -> L17
    L13:
        r13 = r13 + 1;     // Catch: Throwable -> L17
        goto L5
    L14:
        this.mUserAwareCallbacks.finishBroadcast();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public <T1, T2> void notifyInnerCallbacks(InnerCallbackAction2<T1, T2> r8, T1 r10, T2 r11) {
        List<InnerAwareInfoCallback> r12 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r12);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r12);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r13 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r12);     // Catch: Throwable -> L19
        Iterator r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        r8.execute((InnerAwareInfoCallback) r14.next(), r10, r11);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }

    public void notifySubwayEvaluationEvent(boolean r16, float r17, String r18, long r19, int r21, int r22, float r23, float r24, int r25, boolean r26, String r27) {
        List<InnerAwareInfoCallback> r8 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r10 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        ((InnerAwareInfoCallback) r11.next()).onSubwayEvaluationEvent(r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "notifySubwayEvaluationEvent exception" + e);
        goto L12
    }

    public void postHarLevel2Data(Parcelable r8) {
        Object r10 = this.mShmBufferLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L7;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.isHarRecordLocal.get() == true) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L14
        this.mHarDataExecutor.execute(new androidx.room.k(16, this, r8));
    }

    public boolean recordNearbyInfo(Context r8, boolean r10, String r11, int r12, int r13) {
        int r14 = 0;
        if (r10 != this.mIsRecording.get()) goto L10;
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder("recordNearbyInfo, already in ");
        if (r10 == false) goto L7;
        String r17 = "start";
    L8:
        r16.append(r17);
        r16.append(" state");
        CommSenseLog.d(r15, r16.toString());
        return false;
    L7:
        r17 = "stop";
        goto L8
    L10:
        String r18 = TAG;
        CommSenseLog.i(r18, "recordNearbyInfo: start: " + r10 + ", timeout: " + r12 + ", mask:0x" + String.format("%02X", new Object[]{Integer.valueOf(r13)}));
        this.mRecordingMask = r13;
        this.mIsRecording.set(r10);
        if (r10 == true) goto L13;
        cancelRecord(true);
    L27:
        return true;
    L13:
        if (this.mIsRecordingByCallback.get() == false) goto L16;
        CommSenseLog.e(r18, "recordNearbyInfo: already recording by callback, cancel it");
        cancelRecord(false);
    L16:
        if (this.mRecordingMask == 0) goto L19;
        acquireWakeLock(r8, r12 + 100);
        this.mRecordingAwakeCount.incrementAndGet();
    L19:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L25;
        CommSenseLog.e(r18, "recordNearbyInfo: already recording har level 2 data, stop it");
        Iterator<HarLevel2DataResp> r19 = this.mHarLevel2DataRespList.iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        stopHarLevel2DataCollection(r19.next());
        goto L22
    L24:
        this.mIsHarLevel2DataRecording.set(false);
    L25:
        createNearbyInfoFile(r8, r11);
        notifyInnerCallbacks(new r1.s(6), Boolean.TRUE);
        Thread r20 = new Thread(new o(this, r12, r14), "RecordNearbyThread");
        this.mRecordThread = r20;
        r20.start();
        processRecordingTask(r13);
        goto L27
    }

    public void recordNearbyInfoByCallback(Context r8, boolean r10, String r11) {
        if (r10 != this.mIsRecordingByCallback.get()) goto L11;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder("recordNearbyInfoByCallback, already in ");
        if (r10 == false) goto L7;
        String r14 = "start";
    L8:
        r13.append(r14);
        r13.append(" state");
        CommSenseLog.d(r12, r13.toString());
        return;
    L7:
        r14 = "stop";
        goto L8
    L11:
        if (this.mIsRecording.get() == false) goto L16;
        if (r10 == false) goto L16;
        CommSenseLog.e(TAG, "recordNearbyInfoByCallback: already recording");
        return;
    L16:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L20;
        if (r10 == false) goto L20;
        CommSenseLog.e(TAG, "recordNearbyInfoByCallback: already collecting level 2 data");
        return;
    L20:
        this.mIsRecordingByCallback.set(r10);
        CommSenseLog.i(TAG, "recordNearbyInfoByCallback: start: " + r10);
        createNearbyInfoFile(r8, r11);
        this.mSensorCollectManager.startSensorCollect(0);
        OemHarInfoManager r15 = this.mOemHarInfoManager;
        if (r15 == null) goto L24;
        r15.startRecordHarStatus();
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r8) {
        CommSenseLog.d(TAG, "registerCallback");
        RemoteCallbackList<ICaeUserAwareCallback> r10 = this.mUserAwareCallbacks;
        monitor-enter(r10);
        this.mUserAwareCallbacks.register(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerInnerCallback(InnerAwareInfoCallback r8) {
        CommSenseLog.d(TAG, "registerInnerCallback");
        List<InnerAwareInfoCallback> r10 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.contains(r8) == true) goto L7;
        this.mInnerAwareInfoCallbacks.add(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public synchronized void releaseWakeLock() {
        monitor-enter(this);
        PowerManager.WakeLock r8 = this.mWakeLock;     // Catch: Throwable -> L10
        if (r8 != null) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r8.isHeld() == false) goto L8;
        this.mWakeLock.release();     // Catch: Throwable -> L10
        CommSenseLog.i(TAG, "releaseWakeLock");     // Catch: Throwable -> L10
        this.mWakeLock = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"NewApi"})
    public void setLevel2DataCollection(Context r10, List<HarLevel2DataReq> r11, int r12, HarLevel2DataResp r13) {
        if (r11 == null) goto L32;
        if (r11.isEmpty() == true) goto L32;
        Object r8 = this.mShmBufferLock;
        monitor-enter(r8);
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L28
        long r15 = this.mLastHarCollectStartTime;     // Catch: Throwable -> L28
        if (r15 <= this.mLastHarCollectEndTime) goto L15;
        if ((r14 - r15) <= this.mLastHarCollectTimeout) goto L15;
        CommSenseLog.e(TAG, "workaround, for ap may sleep.");     // Catch: Throwable -> L28
        this.mIsHarLevel2DataRecording.set(false);     // Catch: Throwable -> L28
    L15:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L19;
        CommSenseLog.e(TAG, "setLevel2DataCollection: Collecting already started");     // Catch: Throwable -> L28
        monitor-exit(r8);     // Catch: Throwable -> L28
        return;
    L19:
        this.isHarRecordLocal.set(AwareStateListener.isHarCollectLocal());     // Catch: Throwable -> L28
        if (this.isHarRecordLocal.get() == false) goto L24;
        CommSenseLog.e(TAG, "setLevel2DataCollection: already recording Locally");     // Catch: Throwable -> L28
        monitor-exit(r8);     // Catch: Throwable -> L28
        return;
    L24:
        this.mIsHarLevel2DataRecording.set(true);     // Catch: Throwable -> L28
        this.mLastHarCollectStartTime = r14;     // Catch: Throwable -> L28
        this.mLastHarCollectTimeout = r12;     // Catch: Throwable -> L28
        resetHarLevel2DataCountLocked();     // Catch: Throwable -> L28
        monitor-exit(r8);     // Catch: Throwable -> L28
        CommSenseLog.i(TAG, "setLevel2DataCollection: true, totalTimeout: " + r12);
        startHarLevel2DataCollection(r10, r11, r12, r13);
        return;
    L28:
        th = move-exception;
        throw th;
    L32:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L35;
        CommSenseLog.i(TAG, "setLevel2DataCollection: Collecting already stopped");
        return;
    L35:
        this.mIsHarLevel2DataRecording.set(false);
        CommSenseLog.i(TAG, "setLevel2DataCollection: false");
        stopHarLevel2DataCollection(r13);
    }

    public void startLocationScan(boolean r8, int r10) {
        this.mLocationAwareInfoManager.startLocationScan(r8);
        new Thread(new a1(r10, 2, this), "StartLocationScanThread").start();
    }

    public void unregisterCallback(ICaeUserAwareCallback r8) {
        CommSenseLog.d(TAG, "unregisterCallback");
        RemoteCallbackList<ICaeUserAwareCallback> r10 = this.mUserAwareCallbacks;
        monitor-enter(r10);
        this.mUserAwareCallbacks.unregister(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterInnerCallback(InnerAwareInfoCallback r8) {
        CommSenseLog.d(TAG, "unregisterInnerCallback");
        List<InnerAwareInfoCallback> r10 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r10);
        this.mInnerAwareInfoCallbacks.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"InlinedApi"})
    public void zppCollectLocation(int r8) {
        new Thread(new o(this, r8, 1), "zppCollectLocationThread").start();
    }

    private void createNearbyInfoFile(Context r11, String r12) {
        this.mLastDesc = r12;
        long r8 = System.currentTimeMillis();
        Calendar r10 = Calendar.getInstance();
        r10.setTimeInMillis(r8);
        if (r12 != null) goto L5;
    L12:
        File r13 = new File(UserAwareUtil.getNearbyLogPathFile(r11), String.format(Locale.CHINA, defpackage.b.c("%ty%tm%td_%tH%tM%tS_", r12), new Object[]{r10, r10, r10, r10, r10, r10}));
        if (r13.exists() == false) goto L15;
    L17:
        this.mNearbyLogPath = r13.getAbsolutePath();
        if (new File(r13, r12 + ".txt").createNewFile() == true) goto L23;
        return;
    L23:
        String r14 = String.format(Locale.CHINA, "%tH.%tM.%tS", new Object[]{r10, r10, r10});
        this.mLocationAwareInfoManager.recordLocationFile(defpackage.b.c("nearby_location", r14), new File(r13, "location.log"));
        this.mBtAwareInfoManager.recordBtFile(defpackage.b.c("nearby_bt", r14), new File(r13, "bt_scan.log"));
        this.mWifiAwareInfoManager.recordWifiFile(defpackage.b.c("nearby_wifi", r14), new File(r13, "wifi_scan.log"));
        this.mAudioAwareInfoManager.recordAudioFile("nearby_audio" + r14, r13);
        this.mSensorCollectManager.recordSensorFile(defpackage.b.c("sensor_collect", r14), new File(r13, "sensor_collect.log"));
        return;
    L21:
        e = move-exception;
        CommSenseLog.e(TAG, "createNearbyInfoFile: IOException -- ", e);
        goto L23
    L15:
        if (r13.mkdirs() == true) goto L17;
        return;
    L5:
        if (r12.isEmpty() == true) goto L12;
        String r15 = UserAwareUtil.getStringValueFromXML(r11, R.string.user_aware_user_select_scene);
        if (r12.startsWith(r15) == false) goto L10;
        r12 = r12.substring(r15.length());
    L10:
        if (r12.contains("/") == false) goto L12;
        r12 = r12.replace("/", "_");
        goto L12
    }

    public <T> void notifyInnerCallbacks(InnerCallbackAction<T> r8, T r10) {
        List<InnerAwareInfoCallback> r11 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r12 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        r8.execute((InnerAwareInfoCallback) r13.next(), r10);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }

    public void notifyInnerCallbacks(InnerCallbackActionNoArg r8) {
        List<InnerAwareInfoCallback> r10 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r11 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        r8.execute((InnerAwareInfoCallback) r12.next());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }
}
