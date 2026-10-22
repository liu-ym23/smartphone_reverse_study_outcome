package com.obric.cae.smartBluetooth.btaware;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.obric.cae.log.CaeLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        public DeviceInfo(BluetoothDevice r8, long r10) {
            this.mDevice = r8;
            this.mLastProcessTime = r10;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        public long getLastProcessTime() {
            return this.mLastProcessTime;
        }
    }

    static {
        MANUFACTURER_IDS = new String[]{MOBIKE, HM, BAND_SPEED};
        UUIDS = new String[]{UUID_1, UUID_2, UUID_3, UUID_4, UUID_5, UUID_6, UUID_7};
        DEVICE_NAME_CONTAINS = new String[]{DEVICE_NAME_MOBIKE, DEVICE_NAME_NIU_LINK, DEVICE_NAME_Q_BASH, DEVICE_NAME_BIKE, DEVICE_NAME_NINE_EBIKE};
        DEVICE_PREFIXES = new String[]{DEVICE_PREFIX_YD, DEVICE_PREFIX_TL, DEVICE_PREFIX_AIMA, DEVICE_PREFIX_XIAODAO, DEVICE_PREFIX_LUYUAN, DEVICE_PREFIX_MOTO};
    }

    public SmartBluetoothEBikeAware(Context r8) {
        this.mFilteredScanList = new HashMap();
        Runnable r10 = new AnonymousClass1(this);
        this.mCleanupRunnable = r10;
        this.mContext = r8;
        this.mBluetoothAwareManager = SmartBluetoothAwareManager.getInstance(r8);
        Handler r11 = new Handler(Looper.getMainLooper());
        this.mHandler = r11;
        r11.postDelayed(r10, 3000);
    }

    public static /* synthetic */ Map access$000(SmartBluetoothEBikeAware r8) {
        return r8.mFilteredScanList;
    }

    public static /* synthetic */ SmartBluetoothAwareManager access$100(SmartBluetoothEBikeAware r8) {
        return r8.mBluetoothAwareManager;
    }

    public static /* synthetic */ Handler access$200(SmartBluetoothEBikeAware r8) {
        return r8.mHandler;
    }

    public static SmartBluetoothEBikeAware getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothEBikeAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothEBikeAware(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothEBikeAware.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private String getManufacturerInfo(ScanResult r8) {
        ScanRecord r10 = r8.getScanRecord();
        if (r10 != null) goto L5;
        return "None";
    L5:
        SparseArray<byte[]> r11 = r10.getManufacturerSpecificData();
        if (r11 != null) goto L8;
    L19:
        return "None";
    L8:
        if (r11.size() == 0) goto L19;
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L12:
        if (r13 >= r11.size()) goto L18;
        int r14 = r11.keyAt(r13);
        if (r13 <= 0) goto L16;
        r12.append(", ");
    L16:
        r12.append(String.format("0x%04X", new Object[]{Integer.valueOf(r14)}));
        r13 = r13 + 1;
        goto L12
    L18:
        return r12.toString();
    }

    private boolean hasMatchingDeviceName(String r8) {
        String r10 = r8.toLowerCase();
        String[] r11 = DEVICE_PREFIXES;
        int r12 = r11.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L9;
        if (r8.startsWith(r11[r13]) == true) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        return true;
    L9:
        String[] r14 = DEVICE_NAME_CONTAINS;
        int r15 = r14.length;
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L23;
        String r17 = r14[r16];
        if (r17.equals(DEVICE_NAME_MOBIKE) == true) goto L20;
        if (r17.equals(DEVICE_NAME_BIKE) == true) goto L20;
        if (r8.contains(r17) == false) goto L22;
        return true;
    L22:
        r16 = r16 + 1;
    L20:
        if (r10.contains(r17) == false) goto L22;
        return true;
    L23:
        return false;
    }

    private boolean hasMatchingManufacturerId(ScanResult r8) {
        String r10 = getManufacturerInfo(r8);
        String[] r11 = MANUFACTURER_IDS;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10.equals(r11[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean hasMatchingUuid(ScanResult r8) {
        ScanRecord r10 = r8.getScanRecord();
        if (r10 == null) goto L16;
        List<ParcelUuid> r11 = r10.getServiceUuids();
        if (r11 == null) goto L16;
        Iterator<ParcelUuid> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L16;
        String r13 = r12.next().toString();
        String[] r14 = UUIDS;
        int r15 = r14.length;
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L8;
        if (r13.equals(r14[r16]) == true) goto L13;
        r16 = r16 + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    }

    public void cleanup() {
        this.mHandler.removeCallbacks(this.mCleanupRunnable);
        sInstance = null;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isEBikeDevice(BluetoothDevice r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this.mFilteredScanList.containsKey(r8) == false) goto L8;
        return true;
    L8:
        String r10 = r8.getName();
        if (r10 != null) goto L11;
    L16:
        return false;
    L11:
        if (hasMatchingDeviceName(r10) == false) goto L14;
        return true;
    L14:
        if (r10.matches("^(HBB|HB|MT|QJ|YD)[0-9]+.*$") == false) goto L16;
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public void onScanResult(ScanResult r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (isEBikeDevice(r8) == false) goto L8;
        CaeLog.d(TAG, "onScanEBike: " + r8.getDevice().getName());
        long r10 = System.currentTimeMillis();
        BluetoothDevice r11 = r8.getDevice();
        this.mFilteredScanList.put(r11, new DeviceInfo(r11, r10));
        return;
    }

    @SuppressLint({"MissingPermission"})
    private boolean isEBikeDevice(ScanResult r8) {
        if (isEBikeDevice(r8.getDevice()) == false) goto L6;
        return true;
    L6:
        if (hasMatchingUuid(r8) == false) goto L9;
        return true;
    L9:
        return hasMatchingManufacturerId(r8);
    }
}
