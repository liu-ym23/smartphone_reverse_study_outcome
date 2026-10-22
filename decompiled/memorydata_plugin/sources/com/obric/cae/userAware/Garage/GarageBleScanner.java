package com.obric.cae.userAware.Garage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import android.os.PowerManager;
import com.obric.cae.log.a;
import com.obric.cae.userAware.Garage.proto.GarageApScanStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class GarageBleScanner {
    private static final int INVALID_RSSI = 127;
    private static final int STRONG_DEVICE_RSSI_THRESHOLD_DBM = -45;
    private static final String TAG = "GarageBleScanner";
    private static final long WAKE_LOCK_TIMEOUT_MS = 5000;
    private int mActiveScanId;
    private Callback mCompletionCallback;
    private final Context mContext;
    private final Map<String, DeviceSample> mDevices;
    private final ScheduledExecutorService mExecutor;
    private long mGeneration;
    private final Object mLock;
    private ScanCallback mScanCallback;
    private BluetoothLeScanner mScanner;
    private ScheduledFuture<?> mStopFuture;
    private final PowerManager.WakeLock mWakeLock;

    public interface Callback {
        void onComplete(Result r1);
    }

    public static final class DeviceSample {
        final int deviceClassMajor;
        final int deviceType;
        final boolean hasUuid;
        final int rssi;

        public DeviceSample(int r1, boolean r2, int r3, int r4) {
            this.rssi = r1;
            this.hasUuid = r2;
            this.deviceType = r3;
            this.deviceClassMajor = r4;
        }
    }

    public static final class Result {
        final float densityBucket;
        final float deviceClassMajor0Fraction;
        final float deviceClassMajor5Fraction;
        final float deviceType2Fraction;
        final float deviceType3Fraction;
        final float hasUuidFraction;
        final float rssiMean;
        final float rssiStd;
        final int scanId;
        final GarageApScanStatus status;
        final float strongM80Fraction;
        final int validUniqueCount;

        public Result(int r1, GarageApScanStatus r2, int r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12) {
            this.scanId = r1;
            this.status = r2;
            this.validUniqueCount = r3;
            this.densityBucket = r4;
            this.rssiMean = r5;
            this.rssiStd = r6;
            this.strongM80Fraction = r7;
            this.hasUuidFraction = r8;
            this.deviceType2Fraction = r9;
            this.deviceType3Fraction = r10;
            this.deviceClassMajor0Fraction = r11;
            this.deviceClassMajor5Fraction = r12;
        }
    }

    public GarageBleScanner(Context r4, ScheduledExecutorService r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ScheduledExecutorService r7 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mDevices = new HashMap();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mExecutor = r7;
        PowerManager r8 = (PowerManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(PowerManager.class), PowerManager.class, "com.obric.memorydata.plugin");
        PowerManager.WakeLock r9 = null;
        if (r8 != null) goto L14;
    L12:
        this.mWakeLock = r9;
        return;
    L14:
        r9 = r8.newWakeLock(1, "Cae:GarageBleScan");     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        a.a(TAG, "BLE wake lock creation failed", e);
        goto L12
    }

    public static /* synthetic */ void access$000(GarageBleScanner r0, int r1, long r2, ScanResult r4) {
        r0.record(r1, r2, r4);
    }

    public static /* synthetic */ void access$100(GarageBleScanner r0, int r1, long r2, GarageApScanStatus r4, boolean r5) {
        r0.finish(r1, r2, r4, r5);
    }

    private static Result buildResult(int r19, GarageApScanStatus r20, Map<String, DeviceSample> r21) {
        String r1 = "com.obric.memorydata.plugin";
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if (r20 != GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS) goto L5;
        Iterator r2 = r0.values().iterator();
        int r4 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        double r12 = 0.0d;
        double r14 = 0.0d;
    L8:
        if (r2.hasNext() == false) goto L31;
        DeviceSample r3 = (DeviceSample) ZeusTransformUtils.preCheckCast(r2.next(), DeviceSample.class, r1);
        int r5 = r3.rssi;
        r2 = r2;
        if (r5 >= STRONG_DEVICE_RSSI_THRESHOLD_DBM) goto L8;
        r11 = r11 + 1;
        String r18 = r1;
        double r13 = r5;
        r14 = r14 + r13;
        r12 = r12 + (r13 * r13);
        if (r5 < (-80)) goto L16;
        r10 = r10 + 1;
    L16:
        if (r3.hasUuid == false) goto L18;
        r9 = r9 + 1;
    L18:
        int r15 = r3.deviceType;
        if (r15 != 2) goto L22;
        r8 = r8 + 1;
    L22:
        if (r15 != 3) goto L24;
        r7 = r7 + 1;
    L24:
        int r16 = r3.deviceClassMajor;
        if (r16 != 0) goto L28;
        r6 = r6 + 1;
    L28:
        if (r16 != 5) goto L30;
        r4 = r4 + 1;
    L30:
        r1 = r18;
        goto L8
    L31:
        if (r11 == 0) goto L33;
        double r17 = r11;
        double r110 = r14 / r17;
        float r22 = r11;
        return new Result(r19, r20, r11, densityBucket(r11), (float) r110, (float) Math.sqrt(Math.max(0.0d, (r12 / r17) - (r110 * r110))), r10 / r22, r9 / r22, r8 / r22, r7 / r22, r6 / r22, r4 / r22);
    L33:
        return empty(r19, r20);
    L5:
        return empty(r19, r20);
    }

    private ScanCallback createCallback(final int r2, final long r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    private GarageApScanStatus currentBluetoothStatus() {
        BluetoothManager r2 = (BluetoothManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L12 SecurityException -> L15
        if (r2 != null) goto L5;
        BluetoothAdapter r3 = null;
    L6:
        if (r3 == null) goto L11;
        if (r3.isEnabled() == false) goto L11;
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
    L11:
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE;
    L5:
        r3 = r2.getAdapter();     // Catch: RuntimeException -> L12 SecurityException -> L15
    L12:
        e = move-exception;
        a.a(TAG, "BLE adapter state query failed", e);
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
    L16:
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    }

    private static float densityBucket(int r1) {
        if (r1 > 0) goto L6;
        return 0.0f;
    L6:
        if (r1 > 3) goto L10;
        return 1.0f;
    L10:
        if (r1 > 10) goto L14;
        return 2.0f;
    L14:
        if (r1 > 25) goto L17;
        return 3.0f;
    L17:
        return 4.0f;
    }

    private static Result empty(int r14, GarageApScanStatus r15) {
        return new Result(r14, r15, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void finish(int r6, long r7, GarageApScanStatus r9, boolean r10) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (r6 != 0) goto L36;
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return;
    L36:
    L31:
        th = move-exception;
        throw th;
    L6:
        if (r6 != this.mActiveScanId) goto L29;
        if (r7 != this.mGeneration) goto L29;
        if (r9 != GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS) goto L13;
        r9 = currentBluetoothStatus();     // Catch: Throwable -> L31
    L13:
        ScheduledFuture<?> r8 = this.mStopFuture;     // Catch: Throwable -> L31
        if (r8 == null) goto L16;
        r8.cancel(false);     // Catch: Throwable -> L31
        this.mStopFuture = null;     // Catch: Throwable -> L31
    L16:
        BluetoothLeScanner r11 = this.mScanner;     // Catch: Throwable -> L31
        ScanCallback r2 = this.mScanCallback;     // Catch: Throwable -> L31
        Callback r3 = this.mCompletionCallback;     // Catch: Throwable -> L31
        Result r12 = buildResult(r6, r9, this.mDevices);     // Catch: Throwable -> L31
        this.mScanner = null;     // Catch: Throwable -> L31
        this.mScanCallback = null;     // Catch: Throwable -> L31
        this.mCompletionCallback = null;     // Catch: Throwable -> L31
        this.mActiveScanId = 0;     // Catch: Throwable -> L31
        this.mDevices.clear();     // Catch: Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        if (r11 == null) goto L24;
        if (r2 == null) goto L24;
        r11.stopScan(r2);     // Catch: Throwable -> L22
    L22:
        e = move-exception;
        a.a(TAG, "BLE scan stop failed", e);
    L24:
        releaseWakeLock();
        if (r10 == false) goto L37;
        if (r3 == null) goto L38;
        r3.onComplete(r12);
        return;
    L38:
        return;
    }

    private boolean hasBluetoothPermissions() {
        if (this.mContext.checkSelfPermission("android.permission.BLUETOOTH_SCAN") == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L7;
        return true;
    }

    private void record(int r8, long r9, ScanResult r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.getDevice() != null) goto L6;
        return;
    L6:
        if (r11.getRssi() == 127) goto L57;
        BluetoothDevice r0 = r11.getDevice();     // Catch: RuntimeException -> L46 SecurityException -> L48
        String r1 = r0.getAddress();     // Catch: RuntimeException -> L46 SecurityException -> L48
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.isEmpty() == true) goto L52;
        ScanRecord r2 = r11.getScanRecord();     // Catch: RuntimeException -> L46 SecurityException -> L48
        if (r2 != null) goto L16;
        List<ParcelUuid> r3 = null;
    L17:
        String r4 = uuidSignature(r3);     // Catch: RuntimeException -> L46 SecurityException -> L48
        int r5 = r0.getType();     // Catch: RuntimeException -> L46 SecurityException -> L48
        BluetoothClass r6 = r0.getBluetoothClass();     // Catch: RuntimeException -> L46 SecurityException -> L48
        boolean r7 = false;
        if (r6 != null) goto L20;
        int r10 = 0;
    L21:
        int r12 = r11.getRssi();     // Catch: RuntimeException -> L46 SecurityException -> L48
        if (r3 != null) goto L24;
    L26:
        DeviceSample r13 = new DeviceSample(r12, r7, r5, r10);     // Catch: RuntimeException -> L46 SecurityException -> L48
        String r14 = r1 + "|" + r4;     // Catch: RuntimeException -> L46 SecurityException -> L48
        Object r15 = this.mLock;     // Catch: RuntimeException -> L46 SecurityException -> L48
        monitor-enter(r15);     // Catch: RuntimeException -> L46 SecurityException -> L48
    L42:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L46 SecurityException -> L48
    L29:
        if (r8 == this.mActiveScanId) goto L31;
    L40:
        monitor-exit(r15);     // Catch: Throwable -> L42
        return;
    L31:
        if (r9 != this.mGeneration) goto L40;
        DeviceSample r16 = (DeviceSample) ZeusTransformUtils.preCheckCast(this.mDevices.get(r14), DeviceSample.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r16 != null) goto L36;
    L37:
        this.mDevices.put(r14, r13);     // Catch: Throwable -> L42
    L38:
        monitor-exit(r15);     // Catch: Throwable -> L42
        return;
    L36:
        if (r13.rssi <= r16.rssi) goto L38;
    L24:
        if (r3.isEmpty() == true) goto L26;
        r7 = true;
        goto L26
    L20:
        r10 = (r6.getMajorDeviceClass() >> 8) & 255;     // Catch: RuntimeException -> L46 SecurityException -> L48
        goto L21
    L16:
        r3 = r2.getServiceUuids();     // Catch: RuntimeException -> L46 SecurityException -> L48
        goto L17
    L52:
        return;
    L48:
        finish(r8, r9, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED, true);
        return;
    L46:
        e = move-exception;
        a.a(TAG, "drop malformed BLE result", e);
        return;
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock r0 = this.mWakeLock;     // Catch: RuntimeException -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isHeld() == false) goto L14;
        this.mWakeLock.release();     // Catch: RuntimeException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        a.a(TAG, "BLE wake lock release failed", e);
    }

    private static String uuidSignature(List<ParcelUuid> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return "";
    L5:
        if (r5.isEmpty() == true) goto L25;
        StringBuilder r0 = new StringBuilder();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L17;
        ParcelUuid r2 = (ParcelUuid) ZeusTransformUtils.preCheckCast(r6.next(), ParcelUuid.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        if (r0.length() <= 0) goto L15;
        r0.append(',');
    L15:
        r0.append(r2);
        goto L9
    L17:
        return r0.toString();
    L25:
        return "";
    }

    public void cancel(int r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r3 = this.mGeneration;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        finish(r8, r3, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_CANCELLED, false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$start$0$GarageBleScanner(int r7, long r8) {
        finish(r7, r8, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS, true);
    }

    public boolean start(final int r15, long r16, Callback r18) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r18, Callback.class, "com.obric.memorydata.plugin");
        if (r15 != 0) goto L5;
    L60:
        return false;
    L5:
        if (r16 <= 0) goto L60;
        if (r5 == null) goto L60;
        if (hasBluetoothPermissions() == true) goto L67;
    L10:
        GarageApScanStatus r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    L11:
        r5.onComplete(empty(r15, r0));
        return true;
    L67:
        BluetoothManager r6 = (BluetoothManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L61 RuntimeException -> L58
        if (r6 != null) goto L16;
        BluetoothAdapter r7 = null;
    L17:
        if (r7 != null) goto L19;
    L23:
        BluetoothLeScanner r8 = null;
    L24:
        if (r8 != null) goto L26;
        r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE;
        goto L11
    L26:
        Object r9 = this.mLock;
        monitor-enter(r9);
    L55:
        th = move-exception;
        throw th;
    L29:
        if (this.mActiveScanId == 0) goto L32;
        monitor-exit(r9);     // Catch: Throwable -> L55
        return false;
    L32:
        final long r10 = this.mGeneration + 1;     // Catch: Throwable -> L55
        this.mGeneration = r10;     // Catch: Throwable -> L55
        ScanCallback r1 = createCallback(r15, r10);     // Catch: Throwable -> L55
        this.mScanner = r8;     // Catch: Throwable -> L55
        this.mScanCallback = r1;     // Catch: Throwable -> L55
        this.mCompletionCallback = r5;     // Catch: Throwable -> L55
        this.mActiveScanId = r15;     // Catch: Throwable -> L55
        this.mDevices.clear();     // Catch: Throwable -> L55
        monitor-exit(r9);     // Catch: Throwable -> L55
        PowerManager.WakeLock r11 = this.mWakeLock;     // Catch: RuntimeException -> L49 SecurityException -> L51
        if (r11 == null) goto L37;
        r11.acquire(5000);     // Catch: RuntimeException -> L49 SecurityException -> L51
    L37:
        r8.startScan(null, new ScanSettings.Builder().setScanMode(1).build(), r1);     // Catch: RuntimeException -> L49 SecurityException -> L51
        Object r12 = this.mLock;     // Catch: RuntimeException -> L49 SecurityException -> L51
        monitor-enter(r12);     // Catch: RuntimeException -> L49 SecurityException -> L51
    L46:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L49 SecurityException -> L51
    L40:
        if (this.mActiveScanId == r15) goto L42;
    L44:
        monitor-exit(r12);     // Catch: Throwable -> L46
    L54:
        return true;
    L42:
        if (this.mGeneration != r10) goto L44;
        this.mStopFuture = this.mExecutor.schedule(new $$Lambda$GarageBleScanner$XyxNNiHq4sc9FqMEBLhcDwCLgsE(this, r15, r10), r16, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L46
    L51:
        e = move-exception;
        a.a(TAG, "BLE scan permission denied", e);
        GarageApScanStatus r13 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    L53:
        finish(r15, r10, r13, true);
    L49:
        e = move-exception;
        a.a(TAG, "BLE scan start failed", e);
        r13 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
        goto L53
    L19:
        if (r7.isEnabled() == false) goto L23;
        r8 = r7.getBluetoothLeScanner();     // Catch: SecurityException -> L61 RuntimeException -> L58
        goto L10
    L16:
        r7 = r6.getAdapter();     // Catch: SecurityException -> L61 RuntimeException -> L58
    L58:
        e = move-exception;
        a.a(TAG, "BLE scanner query failed", e);
        r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
        goto L11
    }
}
