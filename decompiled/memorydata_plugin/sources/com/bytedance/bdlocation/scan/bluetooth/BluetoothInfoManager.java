package com.bytedance.bdlocation.scan.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothInfoManager {
    private final String TAG;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothScanCallback mBluetoothCallback;
    private volatile BluetoothLeScanner mBluetoothLeScanner;
    private List<BDBleInfo> mBluetoothList;
    private PluginBroadcastReceiver mBluetoothReceiver;
    private Object mBpeaCert;
    private Context mContext;
    private Handler mHandler;
    private volatile boolean mIsRegisterReceiver;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private ScanCallback mScanCallback;
    private int mScanMode;
    private Handler mTimerHandler;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$1, reason: invalid class name */
    class AnonymousClass1 extends ScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass1(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ void lambda$onScanResult$0$BluetoothInfoManager$1(ScanResult r5) {
            BluetoothDevice r0 = r5.getDevice();     // Catch: Exception -> L15
            String r1 = BDLocationExtrasService.getBPEAManager().getAddress(r0, BluetoothInfoManager.access$100(this.this$0));     // Catch: Exception -> L15
            BDBleInfo r2 = new BDBleInfo();     // Catch: Exception -> L15
            r2.rssi = r5.getRssi();     // Catch: Exception -> L15
            if (BDLocationConfig.enableBlePassiveName() == false) goto L8;
            ScanRecord r3 = r5.getScanRecord();     // Catch: Exception -> L15
            if (r3 == null) goto L7;
            String r4 = r3.getDeviceName();     // Catch: Exception -> L15
        L9:
            if (r4 == null) goto L11;
            r2.bleName = r4;     // Catch: Exception -> L15
        L11:
            r2.bleMac = r1;     // Catch: Exception -> L15
            r2.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L15
            BluetoothInfoManager.optimizeBeaconData(r2, r5);     // Catch: Exception -> L15
            BluetoothInfoManager.access$200(this.this$0, r2);     // Catch: Exception -> L15
            if (BluetoothInfoManager.access$300(this.this$0) == null) goto L20;
            BluetoothInfoManager.access$300(this.this$0).onScan(r2);     // Catch: Exception -> L15
            return;
        L20:
            return;
        L7:
            r4 = null;
            goto L9
        L8:
            r4 = r0.getName();     // Catch: Exception -> L15
        L15:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onScanResult error:" + e.getMessage());
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> r3) {
            super.onBatchScanResults((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r2) {
            super.onScanFailed(r2);
            Logger.i("BDShakeCollectManager", "startLeScan onScanFailed errorCode:" + r2);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r2, final ScanResult r3) {
            super.onScanResult(r2, r3);
            BluetoothInfoManager.access$000(this.this$0).post(new $$Lambda$BluetoothInfoManager$1$NQeW97KScbV3LqNsLVbAW1nXEHk(this, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$2, reason: invalid class name */
    class AnonymousClass2 implements BluetoothAdapter.LeScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass2(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ void lambda$onLeScan$0$BluetoothInfoManager$2(BluetoothDevice r3, int r4) {
            Logger.d("BDShakeCollectManager", "onLeScan onScanResult");     // Catch: Exception -> L5
            BluetoothInfoManager.access$400(this.this$0, r3, r4);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onLeScan error:" + e.getMessage());
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice r2, final int r3, byte[] r4) {
            BluetoothInfoManager.access$000(this.this$0).post(new $$Lambda$BluetoothInfoManager$2$7EeedFDRjkmcnZORTC4uRZErDkI(this, r2, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$3, reason: invalid class name */
    class AnonymousClass3 extends PluginBroadcastReceiver {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass3(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ void lambda$onReceive$0$BluetoothInfoManager$3(Intent r4) {
            BluetoothDevice r0 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), BluetoothDevice.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
            short r5 = r4.getShortExtra("android.bluetooth.device.extra.RSSI", ShortCompanionObject.MIN_VALUE);     // Catch: Exception -> L4
            BluetoothInfoManager.access$400(this.this$0, r0, r5);     // Catch: Exception -> L4
            return;
        }

        public void onReceive(Context r3, final Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            String r6 = r4.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(r6) == false) goto L6;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_FOUND");
            BluetoothInfoManager.access$000(this.this$0).post(new $$Lambda$BluetoothInfoManager$3$IPs7IsnhhQ6zM02ojQcPw40hU(this, r4));
            return;
        L6:
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(r6) == false) goto L10;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_DISCOVERY_FINISHED");
            return;
        }
    }

    public interface BluetoothScanCallback {
        void onError();

        void onScan(BDBleInfo r1);

        void onSuccess(List<BDBleInfo> r1);
    }

    public BluetoothInfoManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.TAG = "BDShakeCollectManager";
        this.mScanMode = 2;
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mBluetoothReceiver = new AnonymousClass3(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothList = new ArrayList();
        this.mHandler = new Handler(ThreadLooperManager.getBleScanWorker());
        this.mTimerHandler = new Handler(ThreadLooperManager.getBleTimerWorker());
        initScanCallback();
    }

    static /* synthetic */ Handler access$000(BluetoothInfoManager r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Object access$100(BluetoothInfoManager r0) {
        return r0.mBpeaCert;
    }

    static /* synthetic */ void access$200(BluetoothInfoManager r0, BDBleInfo r1) {
        r0.addList(r1);
    }

    static /* synthetic */ BluetoothScanCallback access$300(BluetoothInfoManager r0) {
        return r0.mBluetoothCallback;
    }

    static /* synthetic */ void access$400(BluetoothInfoManager r0, BluetoothDevice r1, int r2) {
        r0.setDeviceData(r1, r2);
    }

    private void addList(BDBleInfo r2) {
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r0.contains(r2) == true) goto L17;
        this.mBluetoothList.add(r2);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L10:
        return;
    L11:
        e = move-exception;
        Logger.i("addList error" + e.getMessage());
    }

    private void initScanCallback() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mScanCallback = new AnonymousClass1(this);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L10;
        this.mLeScanCallback = new AnonymousClass2(this);
        return;
    }

    public static void optimizeBeaconData(BDBleInfo r6, ScanResult r7) {
        if (r7 != null) goto L4;
    L16:
        Logger.i("optimizeBeaconData error");
        return;
    L4:
        if (r7.getScanRecord() == null) goto L16;
        r6.rawData = BluetoothUtil.Bytes2HexString(r7.getScanRecord().getBytes());
        byte[] r8 = r7.getScanRecord().getManufacturerSpecificData(76);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.length >= 23) goto L11;
        return;
    L11:
        if (r8[0] != 2) goto L20;
        String r2 = BluetoothUtil.Bytes2HexString(Arrays.copyOfRange(r8, 2, 18));
        if (TextUtils.isEmpty(r2) == true) goto L21;
        String r0 = (((((((r2.substring(0, 8) + "-") + r2.substring(8, 12)) + "-") + r2.substring(12, 16)) + "-") + r2.substring(16, 20)) + "-") + r2.substring(20, 32);
        int r1 = BluetoothUtil.byteToInt(r8[18], r8[19]);
        int r9 = BluetoothUtil.byteToInt(r8[20], r8[21]);
        r6.isBeacon = true;
        r6.major = r1;
        r6.minor = r9;
        r6.beaconUuid = r0;
        return;
    L21:
        return;
    }

    private void registerScanReceiver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mBluetoothReceiver != null) goto L7;
        return;
    L7:
        if (this.mIsRegisterReceiver == true) goto L13;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.device.action.FOUND");
        r0.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        ZeusTransformUtils.registerReceiver(r5, this.mBluetoothReceiver, r0, "com.obric.memorydata.plugin");
        this.mIsRegisterReceiver = true;
        return;
    }

    private void setDeviceData(BluetoothDevice r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        BDBleInfo r0 = new BDBleInfo();
        String r1 = BDLocationExtrasService.getBPEAManager().getAddress(r4, this.mBpeaCert);
        if (BDLocationConfig.enableBlePassiveName() == true) goto L9;
        String r6 = r4.getName();
        if (r6 == null) goto L9;
        r0.bleName = r6;
    L9:
        r0.bleMac = r1;
        r0.rssi = r5;
        r0.timeStamp = System.currentTimeMillis();
        addList(r0);
        BluetoothScanCallback r3 = this.mBluetoothCallback;
        if (r3 == null) goto L13;
        r3.onScan(r0);
        return;
    }

    private void startBleScan(Object r9) {
        if (this.mBluetoothAdapter.isEnabled() == true) goto L24;
        Logger.i("未开启蓝牙");
        return;
    L24:
    L20:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "startBleCollect error" + e.getMessage());
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        ScanSettings r5 = new ScanSettings.Builder().setScanMode(this.mScanMode).build();     // Catch: Exception -> L20
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();     // Catch: Exception -> L20
        if (this.mScanCallback == null) goto L23;
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);     // Catch: Exception -> L20
        Logger.i("BDShakeCollectManager", "startLeScan bluetoothStartScan:");     // Catch: Exception -> L20
        BDLocationExtrasService.getBPEAManager().bluetoothStartScan(this.mBluetoothLeScanner, null, r5, this.mScanCallback, r9);     // Catch: Exception -> L20
    L23:
        return;
    L15:
        if (Build.VERSION.SDK_INT < 18) goto L23;
        BluetoothAdapter.LeScanCallback r1 = this.mLeScanCallback;     // Catch: Exception -> L20
        if (r1 == null) goto L23;
        this.mBluetoothAdapter.stopLeScan(r1);     // Catch: Exception -> L20
        BDLocationExtrasService.getBPEAManager().startLeScan(this.mBluetoothAdapter, this.mLeScanCallback, r9);     // Catch: Exception -> L20
        goto L23
    }

    private void startBlueScan(Object r2) {
    L14:
        Logger.i("startBlueCollect error");
        return;
    L3:
        if (LocationUtil.checkBackground() == false) goto L6;
        return;
    L6:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.i("未开启蓝牙");     // Catch: Exception -> L14
        return;
    L10:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L12;
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L14
    L12:
        BDLocationExtrasService.getBPEAManager().startDiscovery(this.mBluetoothAdapter, r2);     // Catch: Exception -> L14
        Logger.i("BluetoothAdapterstartNormalBlueCollect");     // Catch: Exception -> L14
    }

    private void stopBleScan() {
        Logger.i("stopBleScan BLE扫描结束------------------");     // Catch: Exception -> L15
        if (this.mBluetoothLeScanner == null) goto L10;
        if (Build.VERSION.SDK_INT < 21) goto L10;
        if (this.mScanCallback == null) goto L10;
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);     // Catch: Exception -> L15
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L20;
        BluetoothAdapter.LeScanCallback r0 = this.mLeScanCallback;     // Catch: Exception -> L15
        if (r0 == null) goto L21;
        this.mBluetoothAdapter.stopLeScan(r0);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L20:
        return;
    L15:
        e = move-exception;
        Logger.i("stopBleScan error:" + e.getMessage());
    }

    private void stopBlueScan() {
    L6:
        e = move-exception;
        Logger.i("stopBlueScan error:" + e.getMessage());
        return;
    L3:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L11;
        Logger.i("stopBlueScan Blue扫描结束------------------");     // Catch: Exception -> L6
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L6
        return;
    }

    private void unRegisterScanReceiver(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mIsRegisterReceiver == false) goto L10;
        if (r4 == null) goto L8;
        PluginBroadcastReceiver r0 = this.mBluetoothReceiver;
        if (r0 == null) goto L8;
        ZeusTransformUtils.unregisterReceiver(r4, r0, "com.obric.memorydata.plugin");
    L8:
        this.mIsRegisterReceiver = false;
        return;
    }

    public boolean blueToothIsEnabled() {
        return this.mBluetoothAdapter.isEnabled();
    L4:
        e = move-exception;
        Logger.i("blueToothIsEnabled error" + e.getMessage());
        return false;
    }

    public List<BDBleInfo> getBlueToothList() {
        return this.mBluetoothList;
    }

    public /* synthetic */ void lambda$null$0$BluetoothInfoManager(long r3, Object r5) {
        stopBleScan();
        if (r3 <= 0) goto L6;
        registerScanReceiver(this.mContext);
        this.mIsRegisterReceiver = true;
        startBlueScan(r5);
        return;
    }

    public /* synthetic */ void lambda$null$1$BluetoothInfoManager() {
        BluetoothScanCallback r0 = this.mBluetoothCallback;
        if (r0 == null) goto L6;
        r0.onSuccess(this.mBluetoothList);
        return;
    }

    public /* synthetic */ void lambda$null$2$BluetoothInfoManager() {
        stopBlueScan();
        if (BDLocationConfig.enableBleTruncateOnTimeout() == false) goto L5;
        this.mHandler.removeCallbacksAndMessages(null);
    L5:
        this.mHandler.post(new $$Lambda$BluetoothInfoManager$XJGkz7nM4EHueXP8XepLJZdygs(this));
    }

    public /* synthetic */ void lambda$startScan$3$BluetoothInfoManager(final Object r3, BluetoothScanCallback r4, long r5, final long r7) {
        BluetoothScanCallback r6 = (BluetoothScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, BluetoothScanCallback.class, "com.obric.memorydata.plugin");
        this.mBpeaCert = r3;     // Catch: Exception -> L21
        if (LocationUtil.checkBackground() == false) goto L8;
        r6.onError();     // Catch: Exception -> L21
        return;
    L8:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L11;
        Logger.i("未开启蓝牙");     // Catch: Exception -> L21
        r6.onError();     // Catch: Exception -> L21
        return;
    L11:
        this.mBluetoothCallback = r6;     // Catch: Exception -> L21
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L21
        if (r0 == null) goto L17;
        if (r0.size() <= 0) goto L17;
        this.mBluetoothList.clear();     // Catch: Exception -> L21
    L17:
        if (r5 <= 0) goto L19;
        startBleScan(r3);     // Catch: Exception -> L21
    L19:
        this.mTimerHandler.postDelayed(new $$Lambda$BluetoothInfoManager$bd2GmCToFDmKBaVhYq5HrRKD5s(this, r7, r3), r5);     // Catch: Exception -> L21
        this.mTimerHandler.postDelayed(new $$Lambda$BluetoothInfoManager$TSxSDJNVOnVaOYVTtTmEJY7Plpc(this), r7 + r5);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Logger.i("startScan error" + e.getMessage());
        stopScan();
        r6.onError();
    }

    public void setScanMode(int r1) {
        this.mScanMode = r1;
    }

    public synchronized void startScan(BluetoothScanCallback r10, final long r11, final long r13, final Object r15) {
        monitor-enter(this);
        final BluetoothScanCallback r3 = (BluetoothScanCallback) ZeusTransformUtils.wrapperContextForParams(r10, BluetoothScanCallback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L6
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L6
        this.mHandler.post(new $$Lambda$BluetoothInfoManager$odjyJVW86bloOL_IhC4kTAzZBiU(this, r15, r3, r13, r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void stopScan() {
        monitor-enter(this);
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7 Exception -> L9
        stopBlueScan();     // Catch: Throwable -> L7 Exception -> L9
        stopBleScan();     // Catch: Throwable -> L7 Exception -> L9
        this.mBluetoothCallback = null;     // Catch: Throwable -> L7 Exception -> L9
        if (this.mIsRegisterReceiver == false) goto L11;
        unRegisterScanReceiver(this.mContext);     // Catch: Throwable -> L7 Exception -> L9
        this.mIsRegisterReceiver = false;     // Catch: Throwable -> L7 Exception -> L9
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "stopBlueScan error" + e.getMessage());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
