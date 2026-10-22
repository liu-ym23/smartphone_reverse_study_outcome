package com.obric.cae.userAware;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.os.RemoteCallbackList;
import com.obric.cae.libs.bluetooth.SmartBluetoothEvent;
import com.obric.cae.libs.bluetooth.a;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareListener;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.UShort;

/* JADX INFO: loaded from: classes3.dex */
public class BtAwareInfoManager {
    private static final long SCAN_HIGH_MODE_REFRESH_INTERVAL_MS = 600000;
    private static final int SCAN_MODE_SCREEN_OFF_BALANCED = 5;
    private static final String STR_SMART_BT_FILE_NAME = "smart_bt.txt";
    private static final String TAG = "BtAwareInfoManager";
    private static volatile BtAwareInfoManager sInstance;
    private final BluetoothAdapter mBluetoothAdapter;
    private final PluginBroadcastReceiver mBluetoothEventsReceiver;
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
    private final RemoteCallbackList<a> mSmartBluetoothEventCallbackList;
    private final ConcurrentHashMap<BluetoothDevice, SmartBluetoothEvent> mSmartBluetoothEventMap;

    private BtAwareInfoManager(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.mBtInfoMap = new ConcurrentHashMap();
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.mIsBluetoothEnabled = r0;
        this.mCurScanMode = new AtomicInteger(-1);
        this.mScanRefreshExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mRequestedScanMode = new AtomicInteger(-1);
        this.mBtScanFileKey = "";
        this.mSmartBluetoothEventCallbackList = new RemoteCallbackList();
        this.mSmartBluetoothEventMap = new ConcurrentHashMap();
        this.mLeScanCallback = new AnonymousClass1(this);
        this.mBluetoothEventsReceiver = new AnonymousClass2(this);
        this.mSmartBluetoothAwareListener = new AnonymousClass3(this);
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        initSmartBtLogFile();
        BluetoothManager r1 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("bluetooth"), BluetoothManager.class, "com.obric.memorydata.plugin");
        SmartBluetoothAwareManager r9 = SmartBluetoothAwareManager.getInstance(r8);
        this.mSmartBluetoothAwareManager = r9;
        r9.init();
        BluetoothAdapter r10 = r1.getAdapter();
        this.mBluetoothAdapter = r10;
        this.mBluetoothLeScanner = r10.getBluetoothLeScanner();
        r0.set(r10.isEnabled());
        if (r0.get() == false) goto L5;
        startBleScan(-1);
    L5:
        registerEventReceiver();
    }

    public static /* synthetic */ Context access$000(BtAwareInfoManager r0) {
        return r0.mContext;
    }

    public static /* synthetic */ SmartBluetoothAwareManager access$100(BtAwareInfoManager r0) {
        return r0.mSmartBluetoothAwareManager;
    }

    public static /* synthetic */ void access$200(BtAwareInfoManager r0, BtAwareInfo r1) {
        r0.notifyBtInfoChanged(r1);
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }

    public static /* synthetic */ void access$400(BtAwareInfoManager r0, BluetoothDevice r1, int r2, int r3) {
        r0.processSmartBluetoothEvent(r1, r2, r3);
    }

    public static /* synthetic */ void access$500(BtAwareInfoManager r0, Intent r1, boolean r2) {
        r0.processBleConnectedEvent(r1, r2);
    }

    public static /* synthetic */ void access$600(BtAwareInfoManager r0, boolean r1) {
        r0.notifyBluetoothEnabled(r1);
    }

    public static /* synthetic */ void access$700(BtAwareInfoManager r0, int r1) {
        r0.processSmartBluetoothEBikeAware(r1);
    }

    private String bytesToHexString(byte[] r6) {
        if (r6 != null) goto L5;
        return "null";
    L5:
        StringBuilder r5 = new StringBuilder();
        int r0 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L9;
        r5.append(String.format("%02x ", new Object[]{Byte.valueOf(r6[r2])}));
        r2 = r2 + 1;
        goto L6
    L9:
        return r5.toString().trim();
    }

    private File getBtDir() {
        File r0 = new File(this.mContext.getFilesDir(), "bt");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public static synchronized BtAwareInfoManager getInstance(Context r3) {
        monitor-enter(BtAwareInfoManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new BtAwareInfoManager(r4);     // Catch: Throwable -> L10
    L7:
        BtAwareInfoManager r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(BtAwareInfoManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private void initSmartBtLogFile() {
        File r0 = new File(getBtDir(), STR_SMART_BT_FILE_NAME);
        r0.delete();
        r0.createNewFile();     // Catch: IOException -> L5
    L6:
        com.obric.cae.log.a.c(TAG, "initSmartBtLogFile, file: " + r0);
        com.obric.cae.log.a.a("smart_bt", r0);
        return;
    L5:
        com.obric.cae.log.a.i(TAG, "IO error occurred!");
        goto L6
    }

    private boolean isBleScannerDown() {
        BluetoothAdapter r0 = this.mBluetoothAdapter;
        if (r0 != null) goto L8;
        String r2 = TAG;
        String r1 = "bluetoothAdapter is null";
    L5:
        com.obric.cae.log.a.i(r2, r1);
        return true;
    L8:
        if (r0.isEnabled() == true) goto L11;
        r2 = TAG;
        r1 = "bluetoothAdapter is disabled";
        goto L5
    L11:
        if (this.mBluetoothLeScanner != null) goto L13;
        r2 = TAG;
        r1 = "bluetoothLeScanner is null";
        goto L5
    L13:
        return false;
    }

    public static /* synthetic */ void lambda$tgVlCoOdiEIZLiI53pCLAvvmSnA(BtAwareInfoManager r0) {
        r0.refreshScanIfNeeded();
    }

    private void notifyBluetoothEnabled(boolean r2) {
        if (r2 == this.mIsBluetoothEnabled.get()) goto L20;
        this.mIsBluetoothEnabled.set(r2);
        if (r2 == true) goto L7;
        BluetoothAdapter r3 = this.mBluetoothAdapter;
        if (r3 != null) goto L17;
        return;
    L17:
        if (r3.isLeEnabled() == false) goto L23;
        stopBleScan();
        return;
    L23:
        return;
    L7:
        if (this.mBluetoothLeScanner != null) goto L9;
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
    L9:
        com.obric.cae.log.a.e(TAG, "bluetooth is enabled, restart ble scan");
        if (UserAwareManager.getInstance().isHarLevel2DataRecording() == false) goto L12;
        AtomicInteger r4 = this.mCurScanMode;
        int r0 = 5;
    L13:
        r4.set(r0);
        startBleScan(this.mCurScanMode.get());
        return;
    L12:
        r4 = this.mCurScanMode;
        r0 = -1;
        goto L13
    }

    private synchronized void notifyBtInfoChanged(BtAwareInfo r4) {
        monitor-enter(this);
        UserAwareManager r0 = UserAwareManager.getInstance();     // Catch: Throwable -> L20
        if (r0 != null) goto L9;
        com.obric.cae.log.a.i(TAG, "notifyBtInfoChanged: userAwareManager is null");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        if (r0.isRecording() == false) goto L11;
    L16:
        com.obric.cae.log.a.b(r4.toString(), com.obric.cae.log.a.b(this.mBtScanFileKey));     // Catch: Throwable -> L20
    L17:
        r0.postHarLevel2Data(r4);     // Catch: Throwable -> L20
        this.mBtInfoMap.put(r4.getAddress(), r4);     // Catch: Throwable -> L20
        r0.notifyInnerCallbacks($$Lambda$Ci_NN1DvkXEkItQHoPnAiP03RCQ.INSTANCE, r4);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L11:
        if (r0.isRecordingByCallback() == true) goto L16;
        if (r0.isHarLevel2DataRecording() == false) goto L17;
        if (AwareStateListener.isHarCollectLocal() == false) goto L17;
    L20:
        th = move-exception;
        throw th;
    }

    private List<ParcelUuid> parseParcelUuids(byte[] r12, int r13) {
        ArrayList r11 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r12.length) goto L16;
        ByteBuffer r2 = ByteBuffer.wrap(r12, r1, r13).order(ByteOrder.LITTLE_ENDIAN);
        if (r13 != 2) goto L9;
        UUID r6 = new UUID((((long) (r2.getShort() & UShort.MAX_VALUE)) << 32) | 4096, -9223371485494954757L);
    L15:
        r11.add(new ParcelUuid(r6));
        r1 = r1 + r13;
        goto L4
    L9:
        if (r13 != 4) goto L11;
        r6 = new UUID(((((long) r2.getInt()) & 4294967295L) << 32) | 4096, -9223371485494954757L);
        goto L15
    L11:
        byte[] r3 = new byte[16];
        int r4 = 0;
    L12:
        if (r4 >= 16) goto L14;
        r3[r4] = r12[(r1 + 15) - r4];
        r4 = r4 + 1;
        goto L12
    L14:
        ByteBuffer r5 = ByteBuffer.wrap(r3);
        r6 = new UUID(r5.getLong(), r5.getLong());
        goto L15
    L16:
        return r11;
    }

    private void parseScanRecord(byte[] r10) {
        int r1 = 0;
    L4:
        if (r1 >= r10.length) goto L36;
        int r2 = r1 + 1;
        int r3 = r10[r1] & 255;
        if (r3 == 0) goto L37;
        if (((r2 + r3) - 1) >= r10.length) goto L10;
        int r4 = r2 + 1;
        int r5 = r10[r2] & 255;
        int r6 = r3 - 1;
        byte[] r7 = new byte[r6];
        System.arraycopy(r10, r4, r7, 0, r6);
        if (r5 != 1) goto L14;
        r5 = r7[0] & 255;
        String r8 = TAG;
        StringBuilder r9 = new StringBuilder("Flags: 0x");
    L27:
        StringBuilder r11 = r9.append(Integer.toHexString(r5));
    L28:
        String r12 = r11.toString();
    L29:
        com.obric.cae.log.a.c(r8, r12);
        r1 = r6 + r4;
        goto L4
    L14:
        if (r5 != 3) goto L16;
        List<ParcelUuid> r13 = parseParcelUuids(r7, 2);
        r8 = TAG;
        StringBuilder r14 = new StringBuilder("Complete 16-bit Service UUIDs: ");
    L25:
        r11 = r14.append(r13);
        goto L28
    L16:
        if (r5 != 7) goto L18;
        r13 = parseParcelUuids(r7, 16);
        r8 = TAG;
        r14 = new StringBuilder("Complete 128-bit Service UUIDs: ");
        goto L25
    L18:
        if (r5 == 9) goto L22;
        if (r5 == 255) goto L21;
        r8 = TAG;
        r9 = new StringBuilder("Unknown AD Type: 0x");
        goto L27
    L21:
        int r15 = ((r7[1] & 255) << 8) | (255 & r7[0]);
        int r16 = r6 - 2;
        byte[] r17 = new byte[r16];
        System.arraycopy(r7, 2, r17, 0, r16);
        r8 = TAG;
        r11 = d.a("Manufacturer ID: ", r15, ", Data: ").append(bytesToHexString(r17));
        goto L28
    L22:
        String r18 = new String(r7, StandardCharsets.UTF_8);
        r8 = TAG;
        r12 = "Device Name: ".concat(r18);
        goto L29
    L10:
        com.obric.cae.log.a.i(TAG, "Error: Invalid AD structure length.");
        return;
    L37:
        return;
    }

    private void processBleConnectedEvent(Intent r4, boolean r5) {
        BluetoothDevice r0 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), BluetoothDevice.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r4.getIntExtra("android.bluetooth.device.extra.TRANSPORT", 0) == 2) goto L9;
        return;
    L9:
        if (r5 == false) goto L11;
        r2 = 2;
    L11:
        processSmartBluetoothEvent(r0, 7, r2);
    }

    private void processSmartBluetoothEBikeAware(int r8) {
        com.obric.cae.log.a.c(TAG, "onEBikeAware: " + r8);
        RemoteCallbackList<a> r0 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r0);
        int r1 = this.mSmartBluetoothEventCallbackList.beginBroadcast();     // Catch: Throwable -> L15
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        com.obric.cae.log.a.c(TAG, "onEBikeAware callback: " + r8);     // Catch: Throwable -> L9 Throwable -> L15
        ((a) ZeusTransformUtils.preCheckCast(this.mSmartBluetoothEventCallbackList.getBroadcastItem(r2), a.class, "com.obric.memorydata.plugin")).a(r8);     // Catch: Throwable -> L9 Throwable -> L15
    L11:
        r2 = r2 + 1;     // Catch: Throwable -> L15
    L9:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "onEBikeAware, callback error: " + e.getMessage());     // Catch: Throwable -> L15
        goto L11
    L12:
        this.mSmartBluetoothEventCallbackList.finishBroadcast();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void processSmartBluetoothEvent(BluetoothDevice r6, int r7, int r8) {
        RemoteCallbackList<a> r0 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r0);
        SmartBluetoothEvent r1 = new SmartBluetoothEvent(r6, r7, r8);     // Catch: Throwable -> L23
        if (this.mSmartBluetoothEventMap.containsKey(r6) == false) goto L12;
        SmartBluetoothEvent r9 = (SmartBluetoothEvent) ZeusTransformUtils.preCheckCast(this.mSmartBluetoothEventMap.get(r6), SmartBluetoothEvent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r9 == null) goto L12;
        if (r9.equals(r1) == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L12:
        this.mSmartBluetoothEventMap.put(r6, r1);     // Catch: Throwable -> L23
        com.obric.cae.log.a.b(r1.toString(), com.obric.cae.log.a.b("smart_bt"));     // Catch: Throwable -> L23
        int r10 = this.mSmartBluetoothEventCallbackList.beginBroadcast();     // Catch: Throwable -> L23
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L20;
        com.obric.cae.log.a.c(TAG, "onEventReported: " + r1);     // Catch: Throwable -> L17 Throwable -> L23
        ((a) ZeusTransformUtils.preCheckCast(this.mSmartBluetoothEventCallbackList.getBroadcastItem(r11), a.class, "com.obric.memorydata.plugin")).a(r1);     // Catch: Throwable -> L17 Throwable -> L23
    L19:
        r11 = r11 + 1;     // Catch: Throwable -> L23
    L17:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "BluetoothHeadset, onEventReported: " + e.getMessage());     // Catch: Throwable -> L23
        goto L19
    L20:
        this.mSmartBluetoothEventCallbackList.finishBroadcast();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void refreshScanIfNeeded() {
        int r0 = this.mRequestedScanMode.get();
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (isBleScannerDown() == false) goto L9;
        com.obric.cae.log.a.i(TAG, "refreshScanIfNeeded, bleScanner is not ready");
        return;
    L9:
        int r1 = this.mCurScanMode.get();
        if (r1 == r0) goto L13;
        com.obric.cae.log.a.e(TAG, "refreshScanIfNeeded, current mode changed from " + r0 + " to " + r1);
        return;
    L13:
        com.obric.cae.log.a.e(TAG, "refreshScanIfNeeded, restarting BLE scan with mode: " + r0);
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L16
    L18:
        startBleScan(r0);
        return;
    L16:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "refreshScanIfNeeded: stopScan error", e);
        goto L18
    }

    private void registerEventReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        r0.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        r0.addAction("android.bluetooth.pbap.profile.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ZeusTransformUtils.registerReceiver(this.mContext, this.mBluetoothEventsReceiver, r0, "com.obric.memorydata.plugin");
        this.mSmartBluetoothAwareManager.addSmartBluetoothAwareListener(this.mSmartBluetoothAwareListener);
    }

    private synchronized void scheduleScanRefreshIfNeeded(int r5) {
        monitor-enter(this);
        ScheduledFuture<?> r0 = this.mScanRefreshFuture;     // Catch: Throwable -> L14
        if (r0 == null) goto L7;
        r0.cancel(false);     // Catch: Throwable -> L14
        this.mScanRefreshFuture = null;     // Catch: Throwable -> L14
    L7:
        if (r5 != (-1)) goto L11;
        this.mRequestedScanMode.set(-1);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        this.mRequestedScanMode.set(r5);     // Catch: Throwable -> L14
        this.mScanRefreshFuture = this.mScanRefreshExecutor.schedule(new $$Lambda$BtAwareInfoManager$tgVlCoOdiEIZLiI53pCLAvvmSnA(this), 600000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14
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

    public void recordBtFile(String r1, File r2) {
        this.mBtScanFileKey = r1;
        com.obric.cae.log.a.a(r1, r2);
    }

    public void registerSmartBluetoothEventCallback(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        RemoteCallbackList<a> r1 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r1);
        if (r6 != null) goto L11;
    L6:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        com.obric.cae.log.a.c(TAG, "registerSmartBluetoothEventCallback: " + r6);     // Catch: Throwable -> L8
        this.mSmartBluetoothEventCallbackList.register(r6);     // Catch: Throwable -> L8
        goto L6
    }

    public void startBleScan(int r7) {
        if (isBleScannerDown() == false) goto L6;
        com.obric.cae.log.a.i(TAG, "bleScanner is not ready");
        return;
    L6:
        String r0 = TAG;
        com.obric.cae.log.a.c(r0, "startBleScan, mode: " + r7);
        ScanSettings r1 = new ScanSettings.Builder().setScanMode(r7).build();
        boolean r3 = false;
    L12:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "startBleScan error", e);
    L14:
        if (r3 == false) goto L19;
        scheduleScanRefreshIfNeeded(r7);
        return;
    L19:
        return;
    L8:
        if (r7 <= this.mCurScanMode.get()) goto L10;
        com.obric.cae.log.a.e(r0, "startBleScan, mode: " + r7 + " is higher than cur mode: " + this.mCurScanMode.get());     // Catch: Throwable -> L12
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L12
        this.mCurScanMode.set(r7);     // Catch: Throwable -> L12
    L10:
        this.mBluetoothLeScanner.startScan(null, r1, this.mLeScanCallback);     // Catch: Throwable -> L12
        r3 = true;
        com.obric.cae.log.a.c(r0, "startBleScan");     // Catch: Throwable -> L12
        goto L14
    }

    public void stopBleScan() {
        if (this.mBluetoothLeScanner != null) goto L6;
        com.obric.cae.log.a.i(TAG, "BluetoothLeScanner is not ready");
        return;
    L6:
        BluetoothAdapter r0 = this.mBluetoothAdapter;
        if (r0 != null) goto L9;
    L25:
        com.obric.cae.log.a.i(TAG, "bluetoothAdapter is not ready");
        return;
    L9:
        if (r0.isLeEnabled() == true) goto L14;
        if (this.mBluetoothAdapter.isEnabled() == false) goto L25;
    L14:
        if (this.mCurScanMode.get() != (-1)) goto L17;
        com.obric.cae.log.a.e(TAG, "do not stop ble scan in opportunistic mode");
        return;
    L17:
        this.mCurScanMode.set(-1);
        com.obric.cae.log.a.c(TAG, "stopBleScan");     // Catch: Throwable -> L22
        this.mBluetoothLeScanner.stopScan(this.mLeScanCallback);     // Catch: Throwable -> L22
        Thread.sleep(100);     // Catch: Throwable -> L22
        if (isBleScannerDown() == true) goto L29;
        startBleScan(-1);     // Catch: Throwable -> L22
        return;
    L29:
        return;
    L22:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "stopBleScan exception: ", e);
    }

    public void unregisterSmartBluetoothEventCallback(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        RemoteCallbackList<a> r1 = this.mSmartBluetoothEventCallbackList;
        monitor-enter(r1);
        if (r6 != null) goto L11;
    L6:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        com.obric.cae.log.a.c(TAG, "unregisterSmartBluetoothEventCallback: " + r6);     // Catch: Throwable -> L8
        this.mSmartBluetoothEventCallbackList.unregister(r6);     // Catch: Throwable -> L8
        goto L6
    }
}
