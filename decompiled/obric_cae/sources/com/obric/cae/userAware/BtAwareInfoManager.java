package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.os.RemoteCallbackList;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.bluetooth.SmartBluetoothEvent;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareListener;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class BtAwareInfoManager {
    private static final long SCAN_HIGH_MODE_REFRESH_INTERVAL_MS = 600000;
    private static final int SCAN_MODE_SCREEN_OFF_BALANCED = 5;
    private static final String STR_SMART_BT_FILE_NAME = "smart_bt.txt";
    private static final String TAG = "BtAwareInfoManager";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile BtAwareInfoManager sInstance;
    private final BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothEventsReceiver;
    private BluetoothLeScanner mBluetoothLeScanner;
    private final ConcurrentMap<String, BtAwareInfo> mBtInfoMap;
    private String mBtScanFileKey;
    private final Context mContext;
    private final AtomicInteger mCurScanMode;
    private final AtomicBoolean mIsBluetoothEnabled;
    private final ScanCallback mLeScanCallback;
    private final AtomicInteger mRequestedScanMode;
    private final ScheduledExecutorService mScanRefreshExecutor;
    private ScheduledFuture<?> mScanRefreshFuture;
    private final SmartBluetoothAwareListener mSmartBluetoothAwareListener;
    private final SmartBluetoothAwareManager mSmartBluetoothAwareManager;
    private final RemoteCallbackList<ISmartBluetoothEventCallback> mSmartBluetoothEventCallbackList;
    private final ConcurrentHashMap<BluetoothDevice, SmartBluetoothEvent> mSmartBluetoothEventMap;

    private BtAwareInfoManager(Context r8) {
        this.mBtInfoMap = new ConcurrentHashMap();
        AtomicBoolean r10 = new AtomicBoolean(false);
        this.mIsBluetoothEnabled = r10;
        this.mCurScanMode = new AtomicInteger(-1);
        this.mScanRefreshExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mRequestedScanMode = new AtomicInteger(-1);
        this.mBtScanFileKey = "";
        this.mSmartBluetoothEventCallbackList = new RemoteCallbackList();
        this.mSmartBluetoothEventMap = new ConcurrentHashMap();
        this.mLeScanCallback = new AnonymousClass1(this);
        this.mBluetoothEventsReceiver = new AnonymousClass2(this);
        this.mSmartBluetoothAwareListener = new AnonymousClass3(this);
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        initSmartBtLogFile();
        BluetoothManager r12 = (BluetoothManager) r11.getSystemService(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_BT);
        SmartBluetoothAwareManager r13 = SmartBluetoothAwareManager.getInstance(r11);
        this.mSmartBluetoothAwareManager = r13;
        r13.init();
        BluetoothAdapter r14 = r12.getAdapter();
        this.mBluetoothAdapter = r14;
        this.mBluetoothLeScanner = r14.getBluetoothLeScanner();
        r10.set(r14.isEnabled());
        if (r10.get() == false) goto L5;
        startBleScan(-1);
    L5:
        registerEventReceiver();
    }

    public static /* synthetic */ void a(BtAwareInfoManager r8) {
        r8.refreshScanIfNeeded();
    }

    public static /* synthetic */ Context access$000(BtAwareInfoManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ SmartBluetoothAwareManager access$100(BtAwareInfoManager r8) {
        return r8.mSmartBluetoothAwareManager;
    }

    public static /* synthetic */ void access$200(BtAwareInfoManager r8, BtAwareInfo r10) {
        r8.notifyBtInfoChanged(r10);
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }

    public static /* synthetic */ void access$400(BtAwareInfoManager r8, BluetoothDevice r10, int r11, int r12) {
        r8.processSmartBluetoothEvent(r10, r11, r12);
    }

    public static /* synthetic */ void access$500(BtAwareInfoManager r8, Intent r10, boolean r11) {
        r8.processBleConnectedEvent(r10, r11);
    }

    public static /* synthetic */ void access$600(BtAwareInfoManager r8, boolean r10) {
        r8.notifyBluetoothEnabled(r10);
    }

    public static /* synthetic */ void access$700(BtAwareInfoManager r8, int r10) {
        r8.processSmartBluetoothEBikeAware(r10);
    }

    private String bytesToHexString(byte[] r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder();
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L9;
        r10.append(String.format("%02x ", new Object[]{Byte.valueOf(r8[r12])}));
        r12 = r12 + 1;
        goto L6
    L9:
        return r10.toString().trim();
    }

    private File getBtDir() {
        File r8 = new File(this.mContext.getFilesDir(), "bt");
        if (r8.exists() == true) goto L5;
        r8.mkdirs();
    L5:
        return r8;
    }

    public static synchronized BtAwareInfoManager getInstance(Context r8) {
        monitor-enter(BtAwareInfoManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new BtAwareInfoManager(r8);     // Catch: Throwable -> L10
    L7:
        BtAwareInfoManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(BtAwareInfoManager.class);
        return r10;
    }

    private void initSmartBtLogFile() {
        File r8 = new File(getBtDir(), STR_SMART_BT_FILE_NAME);
        r8.delete();
        r8.createNewFile();     // Catch: IOException -> L5
    L6:
        CommSenseLog.d(TAG, "initSmartBtLogFile, file: " + r8);
        CommSenseLog.recordFileWithKey("smart_bt", r8);
        return;
    L5:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L6
    }

    private boolean isBleScannerDown() {
        BluetoothAdapter r8 = this.mBluetoothAdapter;
        if (r8 != null) goto L8;
        String r10 = TAG;
        String r11 = "bluetoothAdapter is null";
    L5:
        CommSenseLog.e(r10, r11);
        return true;
    L8:
        if (r8.isEnabled() == true) goto L11;
        r10 = TAG;
        r11 = "bluetoothAdapter is disabled";
        goto L5
    L11:
        if (this.mBluetoothLeScanner != null) goto L13;
        r10 = TAG;
        r11 = "bluetoothLeScanner is null";
        goto L5
    L13:
        return false;
    }

    private void notifyBluetoothEnabled(boolean r8) {
        if (r8 == this.mIsBluetoothEnabled.get()) goto L20;
        this.mIsBluetoothEnabled.set(r8);
        if (r8 == true) goto L7;
        BluetoothAdapter r10 = this.mBluetoothAdapter;
        if (r10 != null) goto L17;
        return;
    L17:
        if (r10.isLeEnabled() == false) goto L23;
        stopBleScan();
        return;
    L23:
        return;
    L7:
        if (this.mBluetoothLeScanner != null) goto L9;
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
    L9:
        CommSenseLog.i(TAG, "bluetooth is enabled, restart ble scan");
        if (UserAwareManager.getInstance().isHarLevel2DataRecording() == false) goto L12;
        AtomicInteger r11 = this.mCurScanMode;
        int r12 = 5;
    L13:
        r11.set(r12);
        startBleScan(this.mCurScanMode.get());
        return;
    L12:
        r11 = this.mCurScanMode;
        r12 = -1;
        goto L13
    }

    private synchronized void notifyBtInfoChanged(BtAwareInfo r8) {
        monitor-enter(this);
        UserAwareManager r10 = UserAwareManager.getInstance();     // Catch: Throwable -> L20
        if (r10 != null) goto L9;
        CommSenseLog.e(TAG, "notifyBtInfoChanged: userAwareManager is null");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        if (r10.isRecording() == false) goto L11;
    L16:
        CommSenseLog.addTimeLog(r8.toString(), CommSenseLog.getRecordFile(this.mBtScanFileKey));     // Catch: Throwable -> L20
    L17:
        r10.postHarLevel2Data(r8);     // Catch: Throwable -> L20
        this.mBtInfoMap.put(r8.getAddress(), r8);     // Catch: Throwable -> L20
        r10.notifyInnerCallbacks(new r1.s(5), r8);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L11:
        if (r10.isRecordingByCallback() == true) goto L16;
        if (r10.isHarLevel2DataRecording() == false) goto L17;
        if (AwareStateListener.isHarCollectLocal() == false) goto L17;
    L20:
        th = move-exception;
        throw th;
    }

    private List<ParcelUuid> parseParcelUuids(byte[] r12, int r13) {
        ArrayList r11 = new ArrayList();
        int r8 = 0;
    L4:
        if (r8 >= r12.length) goto L16;
        ByteBuffer r10 = ByteBuffer.wrap(r12, r8, r13).order(ByteOrder.LITTLE_ENDIAN);
        if (r13 != 2) goto L9;
        UUID r14 = new UUID((((long) (r10.getShort() & 65535)) << 32) | 4096, -9223371485494954757L);
    L15:
        r11.add(new ParcelUuid(r14));
        r8 = r8 + r13;
        goto L4
    L9:
        if (r13 != 4) goto L11;
        r14 = new UUID(((((long) r10.getInt()) & QesdkUtils.LIMITS.UINT_32_UPPER) << 32) | 4096, -9223371485494954757L);
        goto L15
    L11:
        byte[] r15 = new byte[16];
        int r16 = 0;
    L12:
        if (r16 >= 16) goto L14;
        r15[r16] = r12[(r8 + 15) - r16];
        r16 = r16 + 1;
        goto L12
    L14:
        ByteBuffer r17 = ByteBuffer.wrap(r15);
        r14 = new UUID(r17.getLong(), r17.getLong());
        goto L15
    L16:
        return r11;
    }

    private void parseScanRecord(byte[] r10) {
        int r8 = 0;
    L4:
        if (r8 >= r10.length) goto L37;
        int r11 = r8 + 1;
        int r12 = r10[r8] & 255;
        if (r12 == 0) goto L38;
        if (((r11 + r12) - 1) >= r10.length) goto L10;
        int r13 = r11 + 1;
        int r14 = r10[r11] & 255;
        int r15 = r12 - 1;
        byte[] r16 = new byte[r15];
        System.arraycopy(r10, r13, r16, 0, r15);
        if (r14 != 1) goto L14;
        r14 = r16[0] & 255;
        String r17 = TAG;
        StringBuilder r18 = new StringBuilder("Flags: 0x");
    L27:
        r18.append(Integer.toHexString(r14));
    L28:
        String r19 = r18.toString();
    L29:
        CommSenseLog.d(r17, r19);
        r8 = r15 + r13;
        goto L4
    L14:
        if (r14 != 3) goto L16;
        List<ParcelUuid> r20 = parseParcelUuids(r16, 2);
        r17 = TAG;
        r18 = new StringBuilder("Complete 16-bit Service UUIDs: ");
    L25:
        r18.append(r20);
        goto L28
    L16:
        if (r14 != 7) goto L18;
        r20 = parseParcelUuids(r16, 16);
        r17 = TAG;
        r18 = new StringBuilder("Complete 128-bit Service UUIDs: ");
        goto L25
    L18:
        if (r14 == 9) goto L22;
        if (r14 == 255) goto L21;
        r17 = TAG;
        r18 = new StringBuilder("Unknown AD Type: 0x");
        goto L27
    L21:
        int r21 = ((r16[1] & 255) << 8) | (255 & r16[0]);
        int r22 = r15 - 2;
        byte[] r23 = new byte[r22];
        System.arraycopy(r16, 2, r23, 0, r22);
        r17 = TAG;
        StringBuilder r24 = defpackage.b.f("Manufacturer ID: ", r21, ", Data: ");
        r24.append(bytesToHexString(r23));
        r19 = r24.toString();
        goto L29
    L22:
        String r25 = new String(r16, StandardCharsets.UTF_8);
        r17 = TAG;
        r19 = "Device Name: ".concat(r25);
        goto L29
    L10:
        CommSenseLog.e(TAG, "Error: Invalid AD structure length.");
        return;
    L38:
        return;
    }

    private void processBleConnectedEvent(Intent r8, boolean r10) {
        BluetoothDevice r11 = (BluetoothDevice) r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = 0;
        if (r8.getIntExtra("android.bluetooth.device.extra.TRANSPORT", 0) == 2) goto L8;
        return;
    L8:
        if (r10 == false) goto L10;
        r12 = 2;
    L10:
        processSmartBluetoothEvent(r11, 7, r12);
    }

    private void processSmartBluetoothEBikeAware(int r8) {
        CommSenseLog.d(TAG, "onEBikeAware: " + r8);
        RemoteCallbackList<ISmartBluetoothEventCallback> r10 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r10);
        int r11 = this.mSmartBluetoothEventCallbackList.beginBroadcast();     // Catch: Throwable -> L15
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L12;
        CommSenseLog.d(TAG, "onEBikeAware callback: " + r8);     // Catch: Throwable -> L9 Throwable -> L15
        ((ISmartBluetoothEventCallback) this.mSmartBluetoothEventCallbackList.getBroadcastItem(r12)).onEBikeAware(r8);     // Catch: Throwable -> L9 Throwable -> L15
    L11:
        r12 = r12 + 1;     // Catch: Throwable -> L15
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "onEBikeAware, callback error: " + e.getMessage());     // Catch: Throwable -> L15
        goto L11
    L12:
        this.mSmartBluetoothEventCallbackList.finishBroadcast();     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void processSmartBluetoothEvent(BluetoothDevice r8, int r10, int r11) {
        RemoteCallbackList<ISmartBluetoothEventCallback> r12 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r12);
        SmartBluetoothEvent r13 = new SmartBluetoothEvent(r8, r10, r11);     // Catch: Throwable -> L23
        if (this.mSmartBluetoothEventMap.containsKey(r8) == false) goto L12;
        SmartBluetoothEvent r14 = this.mSmartBluetoothEventMap.get(r8);     // Catch: Throwable -> L23
        if (r14 == null) goto L12;
        if (r14.equals(r13) == false) goto L12;
        monitor-exit(r12);     // Catch: Throwable -> L23
        return;
    L12:
        this.mSmartBluetoothEventMap.put(r8, r13);     // Catch: Throwable -> L23
        CommSenseLog.addTimeLog(r13.toString(), CommSenseLog.getRecordFile("smart_bt"));     // Catch: Throwable -> L23
        int r15 = this.mSmartBluetoothEventCallbackList.beginBroadcast();     // Catch: Throwable -> L23
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L20;
        CommSenseLog.d(TAG, "onEventReported: " + r13);     // Catch: Throwable -> L17 Throwable -> L23
        ((ISmartBluetoothEventCallback) this.mSmartBluetoothEventCallbackList.getBroadcastItem(r16)).onEventReported(r13);     // Catch: Throwable -> L17 Throwable -> L23
    L19:
        r16 = r16 + 1;     // Catch: Throwable -> L23
    L17:
        e = move-exception;
        CommSenseLog.e(TAG, "BluetoothHeadset, onEventReported: " + e.getMessage());     // Catch: Throwable -> L23
        goto L19
    L20:
        this.mSmartBluetoothEventCallbackList.finishBroadcast();     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void refreshScanIfNeeded() {
        int r8 = this.mRequestedScanMode.get();
        if (r8 != (-1)) goto L6;
        return;
    L6:
        if (isBleScannerDown() == false) goto L9;
        CommSenseLog.e(TAG, "refreshScanIfNeeded, bleScanner is not ready");
        return;
    L9:
        int r10 = this.mCurScanMode.get();
        if (r10 == r8) goto L13;
        CommSenseLog.i(TAG, "refreshScanIfNeeded, current mode changed from " + r8 + " to " + r10);
        return;
    L13:
        CommSenseLog.i(TAG, "refreshScanIfNeeded, restarting BLE scan with mode: " + r8);
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L16
    L18:
        startBleScan(r8);
        return;
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "refreshScanIfNeeded: stopScan error", e);
        goto L18
    }

    private void registerEventReceiver() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        r8.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        r8.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r8.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        r8.addAction("android.bluetooth.pbap.profile.action.CONNECTION_STATE_CHANGED");
        r8.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r8.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r8.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(this.mBluetoothEventsReceiver, r8);
        this.mSmartBluetoothAwareManager.addSmartBluetoothAwareListener(this.mSmartBluetoothAwareListener);
    }

    private synchronized void scheduleScanRefreshIfNeeded(int r8) {
        monitor-enter(this);
        ScheduledFuture<?> r10 = this.mScanRefreshFuture;     // Catch: Throwable -> L14
        if (r10 == null) goto L7;
        r10.cancel(false);     // Catch: Throwable -> L14
        this.mScanRefreshFuture = null;     // Catch: Throwable -> L14
    L7:
        if (r8 != (-1)) goto L11;
        this.mRequestedScanMode.set(-1);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        this.mRequestedScanMode.set(r8);     // Catch: Throwable -> L14
        this.mScanRefreshFuture = this.mScanRefreshExecutor.schedule(new g(this, 2), 600000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public List<BtAwareInfo> getBtScanInfo() {
        return new ArrayList(this.mBtInfoMap.values());
    }

    public boolean isBluetoothEnabled() {
        return this.mIsBluetoothEnabled.get();
    }

    public void recordBtFile(String r8, File r10) {
        this.mBtScanFileKey = r8;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void registerSmartBluetoothEventCallback(ISmartBluetoothEventCallback r8) {
        RemoteCallbackList<ISmartBluetoothEventCallback> r10 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r10);
        if (r8 != null) goto L11;
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        CommSenseLog.d(TAG, "registerSmartBluetoothEventCallback: " + r8);     // Catch: Throwable -> L8
        this.mSmartBluetoothEventCallbackList.register(r8);     // Catch: Throwable -> L8
        goto L6
    }

    public void startBleScan(int r8) {
        if (isBleScannerDown() == false) goto L6;
        CommSenseLog.e(TAG, "bleScanner is not ready");
        return;
    L6:
        String r10 = TAG;
        CommSenseLog.d(r10, "startBleScan, mode: " + r8);
        ScanSettings r11 = new ScanSettings.Builder().setScanMode(r8).build();
        boolean r12 = false;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "startBleScan error", e);
    L14:
        if (r12 == false) goto L19;
        scheduleScanRefreshIfNeeded(r8);
        return;
    L19:
        return;
    L8:
        if (r8 <= this.mCurScanMode.get()) goto L10;
        CommSenseLog.i(r10, "startBleScan, mode: " + r8 + " is higher than cur mode: " + this.mCurScanMode.get());     // Catch: Throwable -> L12
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L12
        this.mCurScanMode.set(r8);     // Catch: Throwable -> L12
    L10:
        this.mBluetoothLeScanner.startScan(null, r11, this.mLeScanCallback);     // Catch: Throwable -> L12
        r12 = true;
        CommSenseLog.d(r10, "startBleScan");     // Catch: Throwable -> L12
        goto L14
    }

    public void stopBleScan() {
        if (this.mBluetoothLeScanner != null) goto L6;
        CommSenseLog.e(TAG, "BluetoothLeScanner is not ready");
        return;
    L6:
        BluetoothAdapter r8 = this.mBluetoothAdapter;
        if (r8 != null) goto L9;
    L25:
        CommSenseLog.e(TAG, "bluetoothAdapter is not ready");
        return;
    L9:
        if (r8.isLeEnabled() == true) goto L14;
        if (this.mBluetoothAdapter.isEnabled() == false) goto L25;
    L14:
        if (this.mCurScanMode.get() != (-1)) goto L17;
        CommSenseLog.i(TAG, "do not stop ble scan in opportunistic mode");
        return;
    L17:
        this.mCurScanMode.set(-1);
        CommSenseLog.d(TAG, "stopBleScan");     // Catch: Throwable -> L22
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L22
        Thread.sleep(100);     // Catch: Throwable -> L22
        if (isBleScannerDown() == true) goto L29;
        startBleScan(-1);     // Catch: Throwable -> L22
        return;
    L29:
        return;
    L22:
        e = move-exception;
        CommSenseLog.e(TAG, "stopBleScan exception: ", e);
    }

    public void unregisterSmartBluetoothEventCallback(ISmartBluetoothEventCallback r8) {
        RemoteCallbackList<ISmartBluetoothEventCallback> r10 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r10);
        if (r8 != null) goto L11;
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        CommSenseLog.d(TAG, "unregisterSmartBluetoothEventCallback: " + r8);     // Catch: Throwable -> L8
        this.mSmartBluetoothEventCallbackList.unregister(r8);     // Catch: Throwable -> L8
        goto L6
    }
}
