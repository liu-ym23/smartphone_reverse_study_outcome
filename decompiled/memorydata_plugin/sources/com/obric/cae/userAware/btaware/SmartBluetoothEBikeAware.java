package com.obric.cae.userAware.btaware;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SmartBluetoothEBikeAware {
    private static final String BAND_SPEED = "0x0020";
    private static final String DEVICE_NAME_BIKE = "bike";
    private static final String[] DEVICE_NAME_CONTAINS = null;
    private static final String DEVICE_NAME_MOBIKE = "mobike";
    private static final String DEVICE_NAME_NINE_EBIKE = "九号电动";
    private static final String DEVICE_NAME_NIU_LINK = "NIU Link";
    private static final String DEVICE_NAME_Q_BASH = "Q_BASH";
    private static final String[] DEVICE_PREFIXES = null;
    private static final String DEVICE_PREFIX_AIMA = "AIMA-";
    private static final String DEVICE_PREFIX_LUYUAN = "LuYuan-";
    private static final String DEVICE_PREFIX_MOTO = "MOTO-";
    private static final String DEVICE_PREFIX_TL = "TL_";
    private static final String DEVICE_PREFIX_XIAODAO = "XiaoDao_";
    private static final String DEVICE_PREFIX_YD = "YD_";
    private static final long DEVICE_REFRESH_INTERVAL = 5000;
    private static final String HM = "0x034C";
    private static final long LISTENER_REFRESH_INTERVAL = 3000;
    private static final String[] MANUFACTURER_IDS = null;
    private static final int MIN_RSSI = -90;
    private static final String MOBIKE = "0x04B3";
    private static final String TAG = "SmartBluetoothEBikeAware";
    private static final String TAOBAO = "0x01A8";
    private static final String[] UUIDS = null;
    private static final String UUID_1 = "0000ff78-0000-1000-8000-00805f9b34fb";
    private static final String UUID_2 = "8ec94e30-f315-4f60-9fb8-838830daea50";
    private static final String UUID_3 = "8ec94e30-f315-4f60-9fb8-838830daea51";
    private static final String UUID_4 = "0000feb0-0000-1000-8000-00805f9b34fb";
    private static final String UUID_5 = "e7810bd2-73ae-499d-8c15-faa9aef0c3f2";
    private static final String UUID_6 = "8ec94e30-f315-4f60-9fb8-838830daea52";
    private static final String UUID_7 = "616c6970-6179-626f-7869-62656f706f6c";
    private static volatile SmartBluetoothEBikeAware sInstance;
    private final SmartBluetoothAwareManager mBluetoothAwareManager;
    private final Runnable mCleanupRunnable;
    private final Context mContext;
    private final Map<BluetoothDevice, DeviceInfo> mFilteredScanList;
    private final Handler mHandler;

    public static class DeviceInfo {
        private final BluetoothDevice mDevice;
        private final long mLastProcessTime;

        public DeviceInfo(BluetoothDevice r1, long r2) {
            this.mDevice = r1;
            this.mLastProcessTime = r2;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        public long getLastProcessTime() {
            return this.mLastProcessTime;
        }
    }

    static {
        MANUFACTURER_IDS = new String[]{TAOBAO, MOBIKE, HM, BAND_SPEED};
        UUIDS = new String[]{UUID_1, UUID_2, UUID_3, UUID_4, UUID_5, UUID_6, UUID_7};
        DEVICE_NAME_CONTAINS = new String[]{DEVICE_NAME_MOBIKE, DEVICE_NAME_NIU_LINK, DEVICE_NAME_Q_BASH, DEVICE_NAME_BIKE, DEVICE_NAME_NINE_EBIKE};
        DEVICE_PREFIXES = new String[]{DEVICE_PREFIX_YD, DEVICE_PREFIX_TL, DEVICE_PREFIX_AIMA, DEVICE_PREFIX_XIAODAO, DEVICE_PREFIX_LUYUAN, DEVICE_PREFIX_MOTO};
    }

    public SmartBluetoothEBikeAware(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mFilteredScanList = new HashMap();
        Runnable r0 = new AnonymousClass1(this);
        this.mCleanupRunnable = r0;
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mBluetoothAwareManager = SmartBluetoothAwareManager.getInstance(r5);
        Handler r6 = new Handler(Looper.getMainLooper());
        this.mHandler = r6;
        r6.postDelayed(r0, 3000);
    }

    public static /* synthetic */ Map access$000(SmartBluetoothEBikeAware r0) {
        return r0.mFilteredScanList;
    }

    public static /* synthetic */ SmartBluetoothAwareManager access$100(SmartBluetoothEBikeAware r0) {
        return r0.mBluetoothAwareManager;
    }

    public static /* synthetic */ Handler access$200(SmartBluetoothEBikeAware r0) {
        return r0.mHandler;
    }

    public static SmartBluetoothEBikeAware getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothEBikeAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothEBikeAware(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothEBikeAware.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private String getManufacturerInfo(ScanResult r5) {
        ScanRecord r4 = r5.getScanRecord();
        if (r4 != null) goto L5;
        return "None";
    L5:
        SparseArray<byte[]> r6 = r4.getManufacturerSpecificData();
        if (r6 != null) goto L8;
    L19:
        return "None";
    L8:
        if (r6.size() == 0) goto L19;
        StringBuilder r7 = new StringBuilder();
        int r1 = 0;
    L12:
        if (r1 >= r6.size()) goto L18;
        int r2 = r6.keyAt(r1);
        if (r1 <= 0) goto L16;
        r7.append(", ");
    L16:
        r7.append(String.format("0x%04X", new Object[]{Integer.valueOf(r2)}));
        r1 = r1 + 1;
        goto L12
    L18:
        return r7.toString();
    }

    private boolean hasMatchingDeviceName(String r8) {
        String r7 = r8.toLowerCase();
        String[] r0 = DEVICE_PREFIXES;
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if (r8.startsWith(r0[r3]) == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return true;
    L9:
        String[] r2 = DEVICE_NAME_CONTAINS;
        int r4 = r2.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L23;
        String r6 = r2[r5];
        if (r6.equals(DEVICE_NAME_MOBIKE) == true) goto L20;
        if (r6.equals(DEVICE_NAME_BIKE) == true) goto L20;
        if (r8.contains(r6) == false) goto L22;
        return true;
    L22:
        r5 = r5 + 1;
    L20:
        if (r7.contains(r6) == false) goto L22;
        return true;
    L23:
        return false;
    }

    private boolean hasMatchingManufacturerId(ScanResult r5) {
        String r4 = getManufacturerInfo(r5);
        String[] r6 = MANUFACTURER_IDS;
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4.equals(r6[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean hasMatchingUuid(ScanResult r6) {
        ScanRecord r5 = r6.getScanRecord();
        if (r5 == null) goto L16;
        List<ParcelUuid> r7 = r5.getServiceUuids();
        if (r7 == null) goto L16;
        Iterator<ParcelUuid> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        String r0 = ((ParcelUuid) ZeusTransformUtils.preCheckCast(r8.next(), ParcelUuid.class, "com.obric.memorydata.plugin")).toString();
        String[] r1 = UUIDS;
        int r2 = r1.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L8;
        if (r0.equals(r1[r3]) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    }

    private boolean isEBikeDevice(ScanResult r4) {
        String r0 = r4.getDevice().getName();
        if (hasMatchingUuid(r4) == false) goto L5;
        return true;
    L5:
        if (r0 == null) goto L13;
        if (hasMatchingDeviceName(r0) == false) goto L10;
        return true;
    L10:
        if (r0.matches("^(HBB|HB|MT|QJ|YD)[0-9]+.*$") == false) goto L13;
        return true;
    L13:
        return hasMatchingManufacturerId(r4);
    }

    public void cleanup() {
        this.mHandler.removeCallbacks(this.mCleanupRunnable);
        sInstance = null;
    }

    public void onScanResult(ScanResult r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (isEBikeDevice(r4) == false) goto L12;
        a.c(TAG, "onScanEBike: " + r4.getDevice().getName() + " rssi: " + r4.getRssi());
        if (r4.getRssi() >= MIN_RSSI) goto L10;
        a.c(TAG, "rssi is below min rssi limit, ignore");
        return;
    L10:
        long r0 = System.currentTimeMillis();
        BluetoothDevice r5 = r4.getDevice();
        this.mFilteredScanList.put(r5, new DeviceInfo(r5, r0));
        return;
    }
}
