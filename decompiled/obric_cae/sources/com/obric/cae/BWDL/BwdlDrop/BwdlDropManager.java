package com.obric.cae.BWDL.BwdlDrop;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.BWDL.BwdlDrop.activity.BwdlDevicePickerActivity;
import com.obric.cae.BWDL.BwdlDrop.activity.BwdlDropIncomingFileConfirmActivity;
import com.obric.cae.BWDL.BwdlDrop.activity.BwdlDropTransferFailedActivity;
import com.obric.cae.BWDL.BwdlDrop.activity.BwdlDropTransferringActivity;
import com.obric.cae.BWDL.BwdlDrop.activity.BwdlDropWaitingActivity;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropDatabase;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.DataLink;
import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.ExternalAPI.BWDLCallback;
import com.sdk.bwdl.ExternalAPI.BWDLConfigs;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import com.sdk.bwdl.ExternalAPI.BWDLManager;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropManager {
    private static final String TAG = "BwdlDropManager";
    private static volatile BwdlDropManager sInstance;
    private final String DROP_SWITCH_TIMEOUT;
    private final String feature;
    public volatile boolean isReadyForFileSharing;
    private boolean isReceiverRegistered;
    private BluetoothAdapter mAdapter;
    private BWDLAdvertisingData mAdvertisingData;
    private BWDLCallback mBWDLCallback;
    private BWDLManager mBWDLManager;
    private boolean mBwdlDropSwitch;
    private final ContentObserver mBwdlDropSwitchObserver;
    private Context mContext;
    private ControlLink mControlLink;
    private DataLink mDataLink;
    private BwdlDropDatabase mDatabase;
    private final ConcurrentMap<Integer, BwdlDropDeviceManager> mDeviceManagerMap;
    private BwdlDropDiscoveryEngine mDiscoveryEngine;
    private final ContentObserver mDropObserver;
    private BwdlDropEventHandler mEventHandler;
    private List<IDiscoveryListener> mListenerList;
    public volatile boolean mSendingFlag;
    public BwdlDropSession mSession;
    private PendingIntent mTimeoutPendingIntent;
    private TimeoutReceiver mTimeoutReceiver;
    private Timer mTimer;
    private WifiManager mWifiManager;

    public interface IDiscoveryListener {
        void onDiscoveryDataChanged(BWDLDiscoveryData r8);
    }

    public class TimeoutReceiver extends BroadcastReceiver {
        final /* synthetic */ BwdlDropManager this$0;

        public TimeoutReceiver(BwdlDropManager r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            CaeLog.d(BwdlDropManager.TAG, "stopTimeoutTask");
            if ("DROP_SWITCH_TIMEOUT".equals(r10.getAction()) == false) goto L6;
            BwdlDropManager.access$1200(this.this$0, false);
            return;
        }
    }

    private BwdlDropManager(Context r8) {
        this.isReadyForFileSharing = true;
        this.feature = BWDLInnerConstant.FEATURE_BWDL_DROP;
        this.DROP_SWITCH_TIMEOUT = "DROP_SWITCH_TIMEOUT";
        this.mListenerList = new CopyOnWriteArrayList();
        this.mDeviceManagerMap = new ConcurrentHashMap();
        final Handler r10 = null;
        this.mTimer = null;
        this.isReceiverRegistered = false;
        this.mBWDLCallback = new AnonymousClass1(this);
        this.mBwdlDropSwitchObserver = new AnonymousClass3(this, r10);
        this.mDropObserver = new AnonymousClass4(this, r10);
        this.mContext = r8.getApplicationContext();
        init();
    }

    public static /* synthetic */ ControlLink access$000(BwdlDropManager r8) {
        return r8.mControlLink;
    }

    public static /* synthetic */ ControlLink access$002(BwdlDropManager r8, ControlLink r10) {
        r8.mControlLink = r10;
        return r10;
    }

    public static /* synthetic */ BwdlDropEventHandler access$100(BwdlDropManager r8) {
        return r8.mEventHandler;
    }

    public static /* synthetic */ Context access$1000(BwdlDropManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ BWDLManager access$1100(BwdlDropManager r8) {
        return r8.mBWDLManager;
    }

    public static /* synthetic */ void access$1200(BwdlDropManager r8, boolean r10) {
        r8.setBwdlDropSwitchStatus(r10);
    }

    public static /* synthetic */ void access$200(BwdlDropManager r8, int r10) {
        r8.removeDeviceManager(r10);
    }

    public static /* synthetic */ ConcurrentMap access$300(BwdlDropManager r8) {
        return r8.mDeviceManagerMap;
    }

    public static /* synthetic */ DataLink access$400(BwdlDropManager r8) {
        return r8.mDataLink;
    }

    public static /* synthetic */ DataLink access$402(BwdlDropManager r8, DataLink r10) {
        r8.mDataLink = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(BwdlDropManager r8) {
        r8.updateBwdlDropSwitchStatus();
    }

    public static /* synthetic */ boolean access$600(BwdlDropManager r8) {
        return r8.mBwdlDropSwitch;
    }

    public static /* synthetic */ void access$700(BwdlDropManager r8, long r10) {
        r8.startDropSwitchTimeoutTask(r10);
    }

    public static /* synthetic */ void access$800(BwdlDropManager r8) {
        r8.startAdvertising();
    }

    public static /* synthetic */ void access$900(BwdlDropManager r8) {
        r8.stopTimeoutTask();
    }

    public static BwdlDropManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BwdlDropManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BwdlDropManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BwdlDropManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void init() {
        CaeLog.d(TAG, "init");
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mDatabase = new BwdlDropDatabase(this.mContext);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        BWDLManager r8 = BWDLManager.getInstance(this.mContext);
        this.mBWDLManager = r8;
        BwdlDropDiscoveryEngine r10 = new BwdlDropDiscoveryEngine(this.mContext, r8);
        this.mDiscoveryEngine = r10;
        this.mEventHandler = new BwdlDropEventHandler(this.mContext, r10);
        this.mAdvertisingData = this.mDiscoveryEngine.buildAdvertisingData();
        BWDLConfigs r11 = new BWDLConfigs.Builder(this.mContext).setCallback(this.mBWDLCallback).setFeatureName(BWDLInnerConstant.FEATURE_BWDL_DROP).setAdvertisingData(this.mAdvertisingData).setAdvertisingInterval(BWDLConstant.ADV_INTERVAL_LEVEL.ADV_INTERVAL_HIGH).setDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL.DISCOVERY_MODE_LOW_LATENCY).build();
        this.mBWDLManager.init(r11);
        registerObserver();
        registerTimeoutReceiver();
        startAdvertising();
    }

    private void postDelayTransferTask(final BwdlDropSession r8) {
        new Handler().postDelayed(new AnonymousClass2(this, r8), 200);
    }

    private void registerObserver() {
        ContentResolver r8 = this.mContext.getContentResolver();
        r8.registerContentObserver(Settings.Global.getUriFor(BwdlDropConstant.FAST_TRANSFER), false, this.mBwdlDropSwitchObserver);
        r8.registerContentObserver(Settings.Global.getUriFor("device_name"), false, this.mDropObserver);
        updateBwdlDropSwitchStatus();
    }

    private void registerTimeoutReceiver() {
        if (this.isReceiverRegistered == true) goto L6;
        this.mTimeoutReceiver = new TimeoutReceiver(this);
        IntentFilter r8 = new IntentFilter("DROP_SWITCH_TIMEOUT");
        this.mContext.registerReceiver(this.mTimeoutReceiver, r8, 4);
        this.isReceiverRegistered = true;
        CaeLog.d(TAG, "TimeoutReceiver registered");
        return;
    }

    private void removeDeviceManager(int r8) {
        if (r8 != 0) goto L5;
        return;
    L5:
        ConcurrentMap<Integer, BwdlDropDeviceManager> r10 = this.mDeviceManagerMap;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mDeviceManagerMap.get(Integer.valueOf(r8)) != null) goto L12;
        CaeLog.d(TAG, "removeDeviceManager: " + r8 + " have none deviceManager");     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L12:
        CaeLog.d(TAG, "removeDeviceManager for deviceId: " + r8);     // Catch: Throwable -> L15
        this.mDeviceManagerMap.remove(Integer.valueOf(r8));     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
    }

    private void setBwdlDropSwitchStatus(boolean r8) {
        ContentResolver r10 = this.mContext.getContentResolver();
        if (r8 == false) goto L5;
        int r11 = 1;
    L6:
        Settings.Global.putInt(r10, BwdlDropConstant.FAST_TRANSFER, r11);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    private void startAdvertising() {
        boolean r8 = this.mBwdlDropSwitch;
        BwdlDropEventHandler r10 = this.mEventHandler;
        if (r8 == false) goto L5;
        int r11 = 4;
    L6:
        r10.sendMessageWithParam(r11, 0, 0, null);
        return;
    L5:
        r11 = 5;
        goto L6
    }

    private void startDropSwitchTimeoutTask(long r8) {
        CaeLog.d(TAG, "start Switch timeout task: " + r8);
    L8:
        e = move-exception;
        android.aimedia.a.q("start Switch timeout task failed:", e, TAG);
        return;
    L4:
        if (this.isReceiverRegistered == true) goto L6;
        registerTimeoutReceiver();     // Catch: Exception -> L8
    L6:
        AlarmManager r10 = (AlarmManager) this.mContext.getSystemService("alarm");     // Catch: Exception -> L8
        this.mTimeoutPendingIntent = PendingIntent.getBroadcast(this.mContext, (int) System.currentTimeMillis(), new Intent("DROP_SWITCH_TIMEOUT"), 201326592);     // Catch: Exception -> L8
        r10.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + r8, this.mTimeoutPendingIntent);     // Catch: Exception -> L8
        CaeLog.d(TAG, "Alarm scheduled successfully");     // Catch: Exception -> L8
    }

    private void stopTimeoutTask() {
    L7:
        e = move-exception;
        android.aimedia.a.q("Cancel timeout task failed:", e, TAG);
        return;
    L4:
        if (this.mTimeoutPendingIntent == null) goto L12;
        ((AlarmManager) this.mContext.getSystemService("alarm")).cancel(this.mTimeoutPendingIntent);     // Catch: Exception -> L7
        this.mTimeoutPendingIntent = null;     // Catch: Exception -> L7
        CaeLog.d(TAG, "Timeout task cancelled");     // Catch: Exception -> L7
        return;
    }

    private void unregisterObserver() {
        ContentResolver r8 = this.mContext.getContentResolver();
        r8.unregisterContentObserver(this.mBwdlDropSwitchObserver);
        r8.unregisterContentObserver(this.mDropObserver);
    }

    private void unregisterTimeoutReceiver() {
        if (this.isReceiverRegistered == false) goto L8;
        TimeoutReceiver r8 = this.mTimeoutReceiver;
        if (r8 == null) goto L9;
        this.mContext.unregisterReceiver(r8);
        this.isReceiverRegistered = false;
        CaeLog.d(TAG, "TimeoutReceiver unregistered");
        return;
    L9:
        return;
    }

    private void updateBwdlDropSwitchStatus() {
        boolean r8 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), BwdlDropConstant.FAST_TRANSFER, 0) != 1) goto L5;
        r8 = true;
    L5:
        this.mBwdlDropSwitch = r8;
    }

    public boolean connectControlLink(BWDLDevice r8) {
        CaeLog.d(TAG, "connectControlLink");
        return this.mBWDLManager.connect(r8);
    }

    public boolean connectDataLink(BWDLConstant.LinkType[] r8) {
        CaeLog.d(TAG, "connectDataLink");
        ControlLink r10 = this.mControlLink;
        if (r10 == null) goto L6;
        this.mDataLink = r10.createDataLink(r8);
    L6:
        if (this.mDataLink == null) goto L13;
        boolean r11 = this.mSendingFlag;
        DataLink r12 = this.mDataLink;
        if (r11 == false) goto L10;
        r12.listen();
        return true;
    L10:
        r12.connect();
        return true;
    L13:
        CaeLog.d(TAG, "DataLink is null");
        return false;
    }

    public boolean controlLinkWriteData(byte[] r8) {
        defpackage.a.j(new StringBuilder("controlLinkWriteData,len:"), r8.length, TAG);
        ControlLink r10 = this.mControlLink;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.write(r8);
    }

    @SuppressLint({"MissingPermission"})
    public void disableBluetooth() {
        BluetoothAdapter r8 = this.mAdapter;
        if (r8 == null) goto L6;
        r8.disable();
        return;
    }

    public void disconnectControlLink(ControlLink r8) {
        CaeLog.d(TAG, "disconnectControlLink:" + r8);
        this.mSendingFlag = false;
        if (r8 == null) goto L6;
        r8.disconnect();
        return;
    }

    public void disconnectDataLink(DataLink r8) {
        CaeLog.d(TAG, "disconnectDataLink:" + r8);
        if (r8 == null) goto L8;
        r8.disconnect();
        this.isReadyForFileSharing = true;
        ControlLink r10 = this.mControlLink;
        if (r10 == null) goto L9;
        r10.removeDataLink(this.mDataLink);
        return;
    L9:
        return;
    }

    public boolean enableBluetoothNoAutoConnect() {
        BluetoothAdapter r8 = this.mAdapter;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.enable();
    }

    public boolean enableWifi() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.setWifiEnabled(true);
    }

    public void exit() {
        unregisterObserver();
        BwdlDropEventHandler r8 = this.mEventHandler;
        if (r8 == null) goto L5;
        r8.cleanup();
    L5:
        ControlLink r10 = this.mControlLink;
        if (r10 == null) goto L8;
        r10.disconnect();
    L8:
        DataLink r11 = this.mDataLink;
        if (r11 == null) goto L11;
        r11.disconnect();
    L11:
        unregisterTimeoutReceiver();
        CaeLog.d(TAG, "BwdlDropManager exited, all resources released");
    }

    public BwdlDropDeviceManager getDeviceManagerByControlLink(ControlLink r8) {
        ConcurrentMap<Integer, BwdlDropDeviceManager> r10 = this.mDeviceManagerMap;
        monitor-enter(r10);
        Iterator<Integer> r11 = this.mDeviceManagerMap.keySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r11.hasNext() == false) goto L12;
        int r12 = r11.next().intValue();     // Catch: Throwable -> L15
        if (this.mDeviceManagerMap.get(Integer.valueOf(r12)).getControlLink() != r8) goto L6;
        BwdlDropDeviceManager r13 = this.mDeviceManagerMap.get(Integer.valueOf(r12));     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r13;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public BwdlDropDiscoveryEngine getDiscoveryEngine() {
        return this.mDiscoveryEngine;
    }

    public BwdlDropEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public BwdlDropDeviceManager getOrCreateDeviceManager(int r8) {
        if (r8 != 0) goto L6;
        return null;
    L6:
        ConcurrentMap<Integer, BwdlDropDeviceManager> r10 = this.mDeviceManagerMap;
        monitor-enter(r10);
        BwdlDropDeviceManager r11 = this.mDeviceManagerMap.get(Integer.valueOf(r8));     // Catch: Throwable -> L15
        if (r11 == null) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r11;
    L12:
        CaeLog.d(TAG, "Create a new BwdlDropDeviceManager for " + r8);     // Catch: Throwable -> L15
        BwdlDropDeviceManager r12 = new BwdlDropDeviceManager(r8);     // Catch: Throwable -> L15
        this.mDeviceManagerMap.put(Integer.valueOf(r8), r12);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r12;
    L15:
        th = move-exception;
        throw th;
    }

    public BwdlDropSession getSession() {
        return this.mSession;
    }

    public boolean isBTEnabled() {
        BluetoothAdapter r8 = this.mAdapter;
        if (r8 != null) goto L5;
        CaeLog.v(TAG, "BLUETOOTH_SERVICE is not available! ");
        return false;
    L5:
        return r8.isEnabled();
    }

    public boolean isLocationEnabled(Context r8) {
        return ((LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION)).isLocationEnabled();
    }

    public boolean isWifiEnabled() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L5;
        CaeLog.v(TAG, "WIFI_SERVICE is not available! ");
        return false;
    L5:
        return r8.isWifiEnabled();
    }

    public void launchBwdlDevicePicker(BwdlDropSession r8) {
        CaeLog.d(TAG, "launchBwdlDevicePicker");
        Intent r10 = new Intent(this.mContext, BwdlDevicePickerActivity.class);
        r10.setFlags(335544320);
        r10.putExtra(BwdlDropConstant.BWLD_DROP_SESSION, r8);
        this.mContext.startActivity(r10);
    }

    public void launchBwdlDropWaitingActivity(int r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "launchBwdlDropWaitingActivity,deviceId:" + r8);
        Intent r11 = new Intent(this.mContext, BwdlDropWaitingActivity.class);
        Bundle r12 = new Bundle();
        r12.putParcelable(BwdlDropConstant.BWLD_DROP_SESSION, r10);
        r12.putInt("device_id", r8);
        r11.putExtras(r12);
        r11.setFlags(335544320);
        this.mContext.startActivity(r11);
    }

    public void launchIncomingFileConfirmActivity(int r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "launchIncomingFileConfirmActivity,deviceId:" + r8);
        Intent r11 = new Intent(this.mContext, BwdlDropIncomingFileConfirmActivity.class);
        Bundle r12 = new Bundle();
        r12.putParcelable(BwdlDropConstant.BWLD_DROP_SESSION, r10);
        r12.putInt("device_id", r8);
        r11.putExtras(r12);
        r11.setFlags(335544320);
        this.mContext.startActivity(r11);
    }

    public void launchTransferFailedActivity() {
        CaeLog.d(TAG, "launchTransferFailedActivity");
        Intent r8 = new Intent(this.mContext, BwdlDropTransferFailedActivity.class);
        r8.setFlags(335544320);
        this.mContext.startActivity(r8);
    }

    public void launchTransferringActivity(int r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "launchTransferringActivity,deviceId:" + r8);
        Intent r11 = new Intent(this.mContext, BwdlDropTransferringActivity.class);
        Bundle r12 = new Bundle();
        r12.putParcelable(BwdlDropConstant.BWLD_DROP_SESSION, r10);
        r12.putInt("device_id", r8);
        r11.putExtras(r12);
        r11.setFlags(335544320);
        this.mContext.startActivity(r11);
    }

    public void removeDiscoveryListener(IDiscoveryListener r8) {
        List<IDiscoveryListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void sendDiscoveryDataToListener(BWDLDiscoveryData r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        List<IDiscoveryListener> r10 = this.mListenerList;
        monitor-enter(r10);
        Iterator<IDiscoveryListener> r11 = this.mListenerList.iterator();     // Catch: Throwable -> L12
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onDiscoveryDataChanged(r8);     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void sendFileTransferNotify() {
        CaeLog.d(TAG, "sendFileTransferNotify");
        this.mEventHandler.sendMessageWithParam(12, 0, 0, null);
    }

    public void sendFileTransferReq(BwdlDropSession r8) {
        CaeLog.d(TAG, "sendFileTransferReq");
        this.mEventHandler.sendMessageWithParam(6, 0, 0, r8);
        r8.notifyObserversStatusChange(1);
        this.mDatabase.updateSessionInfoFieldToDB(r8, BwdlDropProvider.BwdlDropEntry.STATUS, 1);
    }

    public void sendFileTransferResp(String r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "sendFileTransferResp");
        this.mEventHandler.sendMessageWithParam(7, 0, 0, r8);
        updateTransferStatus(r8, r10);
    }

    public void sendTransferFailForExternal(String r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "sendTransferFailForExternal");
        this.mEventHandler.sendMessageWithParam(8, 0, 2, r8);
        updateTransferStatus(r8, r10);
    }

    public void sendTransferFailForUser(String r8, BwdlDropSession r10) {
        CaeLog.d(TAG, "sendTransferFailForUser");
        this.mEventHandler.sendMessageWithParam(8, 0, 3, r8);
        updateTransferStatus(r8, r10);
    }

    public void setDiscoveryListener(IDiscoveryListener r8) {
        List<IDiscoveryListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLocationEnabled(Context r8, boolean r10, int r11) {
        CaeLog.d(TAG, "setLocationEnabled: " + r10);
        Settings.Secure.putIntForUser(r8.getContentResolver(), "location_changer", 1, r11);     // Catch: SecurityException -> L5
        ((LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION)).setLocationEnabledForUser(r10, UserHandle.of(r11));     // Catch: SecurityException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, " ", e);
    }

    public void setSession(BwdlDropSession r8) {
        CaeLog.d(TAG, "setBwdlDropSession");
        this.mSession = r8;
    }

    public void updateTransferStatus(String r8, BwdlDropSession r10) {
        b.o("updateTransferStatus:", r8, TAG);
        if (r10 != null) goto L11;
        CaeLog.d(TAG, "session is illegal");
        if (r8.equals(BwdlDropConstant.REASON_USER_INTERRUPT) == false) goto L7;
    L8:
        disconnectDataLink(this.mDataLink);
        this.mSendingFlag = false;
        return;
    L7:
        if (r8.equals(BwdlDropConstant.REASON_USER_REFUSE) == true) goto L8;
        return;
    L11:
        if (r8.equals(BwdlDropConstant.REASON_USER_INTERRUPT) == false) goto L16;
        r10.notifyObserversStatusChange(4);
        this.mDatabase.updateSessionInfoFieldToDB(r10, BwdlDropProvider.BwdlDropEntry.STATUS, 4);
        r10.cancel();
        this.mSendingFlag = false;
        if (r10.getDirection() != 0) goto L30;
        disconnectDataLink(r10.getDeviceManager().getDataLink());
        return;
    L30:
        return;
    L16:
        if (r8.equals(BwdlDropConstant.ACCEPT) == false) goto L19;
        r10.notifyObserversStatusChange(3);
        this.mDatabase.updateSessionInfoFieldToDB(r10, BwdlDropProvider.BwdlDropEntry.STATUS, 3);
        postDelayTransferTask(r10);
        return;
    L19:
        if (r8.equals(BwdlDropConstant.REASON_USER_REFUSE) == false) goto L22;
        r10.notifyObserversStatusChange(2);
        this.mDatabase.updateSessionInfoFieldToDB(r10, BwdlDropProvider.BwdlDropEntry.STATUS, 2);
        r10.cancel();
    L27:
        this.mSendingFlag = false;
        return;
    L22:
        if (r8.equals(BwdlDropConstant.REASON_TRANSFER_COMPLETE) == false) goto L25;
        this.mDatabase.updateSessionInfoFieldToDB(r10, BwdlDropProvider.BwdlDropEntry.STATUS, 5);
        return;
    L25:
        if (r8.equals(BwdlDropConstant.REASON_TRANSFER_INTERRUPT) == false) goto L34;
        this.mDatabase.updateSessionInfoFieldToDB(r10, BwdlDropProvider.BwdlDropEntry.STATUS, 4);
        disconnectDataLink(this.mDataLink);
        goto L27
    }
}
