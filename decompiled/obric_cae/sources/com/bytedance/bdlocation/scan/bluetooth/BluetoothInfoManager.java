package com.bytedance.bdlocation.scan.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothInfoManager {
    private final String TAG;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothScanCallback mBluetoothCallback;
    private volatile BluetoothLeScanner mBluetoothLeScanner;
    private List<BDBleInfo> mBluetoothList;
    private BroadcastReceiver mBluetoothReceiver;
    private Object mBpeaCert;
    private Context mContext;
    private Handler mHandler;
    private volatile boolean mIsRegisterReceiver;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private ScanCallback mScanCallback;
    private int mScanMode;
    private Handler mTimerHandler;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$1, reason: invalid class name */
    public class AnonymousClass1 extends ScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        public AnonymousClass1(BluetoothInfoManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8, ScanResult r10) {
            r8.lambda$onScanResult$0(r10);
        }

        private /* synthetic */ void lambda$onScanResult$0(ScanResult r8) {
            BluetoothDevice r10 = r8.getDevice();     // Catch: Exception -> L15
            String r11 = BDLocationExtrasService.getBPEAManager().getAddress(r10, BluetoothInfoManager.access$100(this.this$0));     // Catch: Exception -> L15
            BDBleInfo r12 = new BDBleInfo();     // Catch: Exception -> L15
            r12.rssi = r8.getRssi();     // Catch: Exception -> L15
            if (BDLocationConfig.enableBlePassiveName() == false) goto L8;
            ScanRecord r13 = r8.getScanRecord();     // Catch: Exception -> L15
            if (r13 == null) goto L7;
            String r14 = r13.getDeviceName();     // Catch: Exception -> L15
        L9:
            if (r14 == null) goto L11;
            r12.bleName = r14;     // Catch: Exception -> L15
        L11:
            r12.bleMac = r11;     // Catch: Exception -> L15
            r12.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L15
            BluetoothInfoManager.optimizeBeaconData(r12, r8);     // Catch: Exception -> L15
            BluetoothInfoManager.access$200(this.this$0, r12);     // Catch: Exception -> L15
            if (BluetoothInfoManager.access$300(this.this$0) == null) goto L20;
            BluetoothInfoManager.access$300(this.this$0).onScan(r12);     // Catch: Exception -> L15
            return;
        L20:
            return;
        L7:
            r14 = null;
            goto L9
        L8:
            r14 = r10.getName();     // Catch: Exception -> L15
        L15:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onScanResult error:" + e.getMessage());
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> r8) {
            super.onBatchScanResults(r8);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r8) {
            super.onScanFailed(r8);
            Logger.i("BDShakeCollectManager", "startLeScan onScanFailed errorCode:" + r8);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r8, final ScanResult r10) {
            super.onScanResult(r8, r10);
            BluetoothInfoManager.access$000(this.this$0).post(new d(this, r10));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$2, reason: invalid class name */
    public class AnonymousClass2 implements BluetoothAdapter.LeScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        public AnonymousClass2(BluetoothInfoManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass2 r8, BluetoothDevice r10, int r11) {
            r8.lambda$onLeScan$0(r10, r11);
        }

        private /* synthetic */ void lambda$onLeScan$0(BluetoothDevice r8, int r10) {
            Logger.d("BDShakeCollectManager", "onLeScan onScanResult");     // Catch: Exception -> L5
            BluetoothInfoManager.access$400(this.this$0, r8, r10);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Logger.i("BDShakeCollectManager", "startLeScan onLeScan error:" + e.getMessage());
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice r8, final int r10, byte[] r11) {
            BluetoothInfoManager.access$000(this.this$0).post(new e(this, r8, r10));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$3, reason: invalid class name */
    public class AnonymousClass3 extends BroadcastReceiver {
        final /* synthetic */ BluetoothInfoManager this$0;

        public AnonymousClass3(BluetoothInfoManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass3 r8, Intent r10) {
            r8.lambda$onReceive$0(r10);
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r8) {
            BluetoothDevice r10 = (BluetoothDevice) r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Exception -> L4
            short r11 = r8.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);     // Catch: Exception -> L4
            BluetoothInfoManager.access$400(this.this$0, r10, r11);     // Catch: Exception -> L4
            return;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, final Intent r10) {
            String r11 = r10.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(r11) == false) goto L6;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_FOUND");
            BluetoothInfoManager.access$000(this.this$0).post(new f(this, r10));
            return;
        L6:
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(r11) == false) goto L10;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_DISCOVERY_FINISHED");
            return;
        }
    }

    public interface BluetoothScanCallback {
        void onError();

        void onScan(BDBleInfo r8);

        void onSuccess(List<BDBleInfo> r8);
    }

    public BluetoothInfoManager(Context r8) {
        this.TAG = "BDShakeCollectManager";
        this.mScanMode = 2;
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mBluetoothReceiver = new AnonymousClass3(this);
        this.mContext = r8;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothList = new ArrayList();
        this.mHandler = new Handler(ThreadLooperManager.getBleScanWorker());
        this.mTimerHandler = new Handler(ThreadLooperManager.getBleTimerWorker());
        initScanCallback();
    }

    public static /* synthetic */ void a(BluetoothInfoManager r8) {
        r8.lambda$null$2();
    }

    public static /* synthetic */ Handler access$000(BluetoothInfoManager r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ Object access$100(BluetoothInfoManager r8) {
        return r8.mBpeaCert;
    }

    public static /* synthetic */ void access$200(BluetoothInfoManager r8, BDBleInfo r10) {
        r8.addList(r10);
    }

    public static /* synthetic */ BluetoothScanCallback access$300(BluetoothInfoManager r8) {
        return r8.mBluetoothCallback;
    }

    public static /* synthetic */ void access$400(BluetoothInfoManager r8, BluetoothDevice r10, int r11) {
        r8.setDeviceData(r10, r11);
    }

    private void addList(BDBleInfo r8) {
        List<BDBleInfo> r10 = this.mBluetoothList;     // Catch: Exception -> L11
        if (r10 == null) goto L10;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r10.contains(r8) == true) goto L17;
        this.mBluetoothList.add(r8);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L10:
        return;
    L11:
        e = move-exception;
        Logger.i("addList error" + e.getMessage());
    }

    public static /* synthetic */ void b(BluetoothInfoManager r8) {
        r8.lambda$null$1();
    }

    public static /* synthetic */ void c(BluetoothInfoManager r8, long r10, Object r11) {
        r8.lambda$null$0(r10, r11);
    }

    public static /* synthetic */ void d(BluetoothInfoManager r8, Object r10, BluetoothScanCallback r11, long r12, long r13) {
        r8.lambda$startScan$3(r10, r11, r12, r13);
    }

    private void initScanCallback() {
        this.mScanCallback = new AnonymousClass1(this);
    }

    private /* synthetic */ void lambda$null$0(long r8, Object r10) {
        stopBleScan();
        if (r8 <= 0) goto L6;
        registerScanReceiver(this.mContext);
        this.mIsRegisterReceiver = true;
        startBlueScan(r10);
        return;
    }

    private /* synthetic */ void lambda$null$1() {
        BluetoothScanCallback r8 = this.mBluetoothCallback;
        if (r8 == null) goto L6;
        r8.onSuccess(this.mBluetoothList);
        return;
    }

    private /* synthetic */ void lambda$null$2() {
        stopBlueScan();
        if (BDLocationConfig.enableBleTruncateOnTimeout() == false) goto L5;
        this.mHandler.removeCallbacksAndMessages(null);
    L5:
        this.mHandler.post(new a(this, 0));
    }

    private /* synthetic */ void lambda$startScan$3(Object r10, BluetoothScanCallback r11, long r12, long r13) {
        this.mBpeaCert = r10;     // Catch: Exception -> L20
        if (LocationUtil.checkBackground() == false) goto L7;
        r11.onError();     // Catch: Exception -> L20
        return;
    L7:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.i("未开启蓝牙");     // Catch: Exception -> L20
        r11.onError();     // Catch: Exception -> L20
        return;
    L10:
        this.mBluetoothCallback = r11;     // Catch: Exception -> L20
        List<BDBleInfo> r8 = this.mBluetoothList;     // Catch: Exception -> L20
        if (r8 == null) goto L16;
        if (r8.size() <= 0) goto L16;
        this.mBluetoothList.clear();     // Catch: Exception -> L20
    L16:
        if (r12 <= 0) goto L18;
        startBleScan(r10);     // Catch: Exception -> L20
    L18:
        this.mTimerHandler.postDelayed(new c(this, r13, r10, 0), r12);     // Catch: Exception -> L20
        this.mTimerHandler.postDelayed(new a(this, 1), r13 + r12);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Logger.i("startScan error" + e.getMessage());
        stopScan();
        r11.onError();
    }

    public static void optimizeBeaconData(BDBleInfo r8, ScanResult r10) {
        if (r10 != null) goto L4;
    L16:
        Logger.i("optimizeBeaconData error");
        return;
    L4:
        if (r10.getScanRecord() == null) goto L16;
        r8.rawData = BluetoothUtil.Bytes2HexString(r10.getScanRecord().getBytes());
        byte[] r11 = r10.getScanRecord().getManufacturerSpecificData(76);
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length >= 23) goto L11;
        return;
    L11:
        if (r11[0] != 2) goto L20;
        String r12 = BluetoothUtil.Bytes2HexString(Arrays.copyOfRange(r11, 2, 18));
        if (TextUtils.isEmpty(r12) == true) goto L21;
        StringBuilder r13 = android.aimedia.a.j(defpackage.a.e(r12.substring(0, 8), "-"));
        r13.append(r12.substring(8, 12));
        StringBuilder r14 = android.aimedia.a.j(defpackage.a.e(r13.toString(), "-"));
        r14.append(r12.substring(12, 16));
        StringBuilder r15 = android.aimedia.a.j(defpackage.a.e(r14.toString(), "-"));
        r15.append(r12.substring(16, 20));
        StringBuilder r16 = android.aimedia.a.j(defpackage.a.e(r15.toString(), "-"));
        r16.append(r12.substring(20, 32));
        String r17 = r16.toString();
        int r18 = BluetoothUtil.byteToInt(r11[18], r11[19]);
        int r19 = BluetoothUtil.byteToInt(r11[20], r11[21]);
        r8.isBeacon = true;
        r8.major = r18;
        r8.minor = r19;
        r8.beaconUuid = r17;
        return;
    L21:
        return;
    }

    private void registerScanReceiver(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mBluetoothReceiver != null) goto L6;
        return;
    L6:
        if (this.mIsRegisterReceiver == true) goto L12;
        IntentFilter r10 = defpackage.a.c("android.bluetooth.device.action.FOUND", "android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        r8.registerReceiver(this.mBluetoothReceiver, r10);
        this.mIsRegisterReceiver = true;
        return;
    }

    private void setDeviceData(BluetoothDevice r8, int r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        BDBleInfo r11 = new BDBleInfo();
        String r12 = BDLocationExtrasService.getBPEAManager().getAddress(r8, this.mBpeaCert);
        if (BDLocationConfig.enableBlePassiveName() == true) goto L9;
        String r13 = r8.getName();
        if (r13 == null) goto L9;
        r11.bleName = r13;
    L9:
        r11.bleMac = r12;
        r11.rssi = r10;
        r11.timeStamp = System.currentTimeMillis();
        addList(r11);
        BluetoothScanCallback r14 = this.mBluetoothCallback;
        if (r14 == null) goto L13;
        r14.onScan(r11);
        return;
    }

    private void startBleScan(Object r10) {
        if (this.mBluetoothAdapter.isEnabled() == true) goto L16;
        Logger.i("未开启蓝牙");
        return;
    L16:
    L13:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "startBleCollect error" + e.getMessage());
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L9;
        return;
    L9:
        ScanSettings r8 = new ScanSettings.Builder().setScanMode(this.mScanMode).build();     // Catch: Exception -> L13
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();     // Catch: Exception -> L13
        if (this.mScanCallback == null) goto L18;
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);     // Catch: Exception -> L13
        Logger.i("BDShakeCollectManager", "startLeScan bluetoothStartScan:");     // Catch: Exception -> L13
        BDLocationExtrasService.getBPEAManager().bluetoothStartScan(this.mBluetoothLeScanner, null, r8, this.mScanCallback, r10);     // Catch: Exception -> L13
        return;
    }

    private void startBlueScan(Object r8) {
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
        BDLocationExtrasService.getBPEAManager().startDiscovery(this.mBluetoothAdapter, r8);     // Catch: Exception -> L14
        Logger.i("BluetoothAdapterstartNormalBlueCollect");     // Catch: Exception -> L14
    }

    private void stopBleScan() {
        Logger.i("stopBleScan BLE扫描结束------------------");     // Catch: Exception -> L11
        if (this.mBluetoothLeScanner != null) goto L5;
    L7:
        BluetoothAdapter.LeScanCallback r8 = this.mLeScanCallback;     // Catch: Exception -> L11
        if (r8 == null) goto L16;
        this.mBluetoothAdapter.stopLeScan(r8);     // Catch: Exception -> L11
        return;
    L16:
        return;
    L5:
        if (this.mScanCallback == null) goto L7;
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);     // Catch: Exception -> L11
    L11:
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

    private void unRegisterScanReceiver(Context r8) {
        if (this.mIsRegisterReceiver == false) goto L10;
        if (r8 == null) goto L8;
        BroadcastReceiver r10 = this.mBluetoothReceiver;
        if (r10 == null) goto L8;
        r8.unregisterReceiver(r10);
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

    public void setScanMode(int r8) {
        this.mScanMode = r8;
    }

    public synchronized void startScan(final BluetoothScanCallback r12, final long r13, final long r15, final Object r17) {
        monitor-enter(this);
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        this.mHandler.post(new b(this, r17, r12, r15, r13));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void stopScan() {
        monitor-enter(this);
        this.mTimerHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8 Exception -> L10
        stopBlueScan();     // Catch: Throwable -> L8 Exception -> L10
        stopBleScan();     // Catch: Throwable -> L8 Exception -> L10
        this.mBluetoothCallback = null;     // Catch: Throwable -> L8 Exception -> L10
        if (this.mIsRegisterReceiver == false) goto L12;
        unRegisterScanReceiver(this.mContext);     // Catch: Throwable -> L8 Exception -> L10
        this.mIsRegisterReceiver = false;     // Catch: Throwable -> L8 Exception -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        Logger.i("BDShakeCollectManager", "stopBlueScan error" + e.getMessage());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
