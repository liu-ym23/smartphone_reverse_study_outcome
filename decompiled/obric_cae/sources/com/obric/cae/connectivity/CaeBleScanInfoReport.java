package com.obric.cae.connectivity;

import android.aimedia.a;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.wifi.WiFiDBHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CaeBleScanInfoReport implements IAoiDataCollector {
    private static final long BLE_SCAN_WINDOW_MS = 5000;
    private static final int CONNECTIVITY_EVENT_FEATURE_ID = 143;
    private static final char[] HEX_DIGITS = null;
    private static final int MAX_BLE_RESULT_COUNT = 100;
    private static final String TAG = "CaeBleScanInfoReport";
    private static CaeBleScanInfoReport sInstance;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private Context mContext;
    private String mCurrentPoiName;
    private final Handler mHandler;
    private boolean mIsScanning;
    private final Runnable mReportRunnable;
    private final ScanCallback mScanCallback;
    private final LinkedHashMap<String, ScanResult> mScanResults;
    private long mTriggerTime;

    static {
        HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }

    public CaeBleScanInfoReport() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScanResults = new LinkedHashMap();
        this.mIsScanning = false;
        this.mCurrentPoiName = "";
        this.mTriggerTime = 0;
        this.mReportRunnable = new AnonymousClass1(this);
        this.mScanCallback = new AnonymousClass2(this);
    }

    public static /* synthetic */ void access$000(CaeBleScanInfoReport r8) {
        r8.finishAndReport();
    }

    public static /* synthetic */ void access$100(CaeBleScanInfoReport r8, ScanResult r10) {
        r8.addScanResult(r10);
    }

    private synchronized void addScanResult(ScanResult r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsScanning == false) goto L17;
        if (r8 == null) goto L17;
        String r10 = buildResultKey(r8);     // Catch: Throwable -> L19
        if (this.mScanResults.containsKey(r10) == false) goto L11;
    L14:
        this.mScanResults.put(r10, r8);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L11:
        if (this.mScanResults.size() < 100) goto L14;
        monitor-exit(this);
        return;
    L17:
        monitor-exit(this);
    }

    private void appendReportField(StringBuilder r8, String r10, Object r11) {
        if (r8.length() > 0) goto L5;
    L7:
        r8.append(r10);
        r8.append('=');
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        r8.append(r11);
        return;
    L5:
        if (r8.charAt(r8.length() - 1) == ' ') goto L7;
        r8.append("; ");
        goto L7
    }

    private BleScanResultDataReport buildBleReport(ScanResult r8, long r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        BluetoothDevice r11 = r8.getDevice();
        String r12 = safeGetAddress(r11);
        String r13 = safeGetOriginalAddress(r11, r12);
        BleScanResultDataReport.Builder r14 = BleScanResultDataReport.newBuilder().setPackageName(this.mContext.getPackageName()).setTimestamp(getResultTimestampMs(r8, r10)).setEventType(normalizeUint32(getEventType(r8))).setAddressType(normalizeAddressType(getAddressType(r8, r11))).setPrimaryPhy(normalizeUint32(r8.getPrimaryPhy())).setSecondaryPhy(normalizeUint32(r8.getSecondaryPhy())).setAdvertisingSid(normalizeUint32(r8.getAdvertisingSid())).setTxPower(r8.getTxPower()).setRssi(r8.getRssi()).setPeriodicAdvInt(normalizeUint32(r8.getPeriodicAdvertisingInterval()));
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r14.setAddress(r12);
    L9:
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r14.setOriginalAddress(r13);
    L11:
        ScanRecord r15 = r8.getScanRecord();
        if (r15 == null) goto L14;
        setScanRecordFields(r14, r15, r11);
    L18:
        return r14.build();
    L14:
        String r16 = safeGetDeviceName(r11);
        if (TextUtils.isEmpty(r16) == true) goto L18;
        r14.setDeviceName(r16);
        goto L18
    }

    private String buildResultKey(ScanResult r8) {
        String r10 = safeGetAddress(r8.getDevice());
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = "unknown@" + r8.getTimestampNanos();
    L5:
        StringBuilder r11 = a.k(r10, "#");
        r11.append(r8.getAdvertisingSid());
        r11.append("#");
        r11.append(r8.getPrimaryPhy());
        return r11.toString();
    }

    private String bytesToHex(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length == 0) goto L15;
        char[] r10 = new char[r8.length * 2];
        int r11 = 0;
    L8:
        if (r11 >= r8.length) goto L11;
        int r12 = r8[r11] & 255;
        int r13 = r11 * 2;
        char[] r14 = HEX_DIGITS;
        r10[r13] = r14[r12 >>> 4];
        r10[r13 + 1] = r14[r12 & 15];
        r11 = r11 + 1;
        goto L8
    L11:
        return new String(r10);
    L15:
        return "";
    }

    private void finishAndReport() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsScanning == false) goto L6;
    L9:
        stopScanLocked();     // Catch: Throwable -> L13
        ArrayList r8 = new ArrayList(this.mScanResults.values());     // Catch: Throwable -> L13
        this.mScanResults.clear();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        reportScanResults(r8);
        return;
    L6:
        if (this.mScanResults.isEmpty() == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    private String formatManufacturerData(SparseArray<byte[]> r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.size() == 0) goto L24;
        StringBuilder r10 = new StringBuilder();
        int r11 = 0;
    L8:
        if (r11 >= r8.size()) goto L18;
        byte[] r12 = r8.valueAt(r11);
        if (r12 == null) goto L16;
        if (r10.length() <= 0) goto L15;
        r10.append(';');
    L15:
        r10.append(toHexKey(r8.keyAt(r11), 4));
        r10.append(':');
        r10.append(bytesToHex(r12));
    L16:
        r11 = r11 + 1;
        goto L8
    L18:
        return r10.toString();
    L24:
        return "";
    }

    private String formatServiceData(Map<ParcelUuid, byte[]> r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.isEmpty() == true) goto L33;
        StringBuilder r10 = new StringBuilder();
        Iterator<Map.Entry<ParcelUuid, byte[]>> r11 = r8.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L21;
        Map.Entry<ParcelUuid, byte[]> r12 = r11.next();
        if (r12 == null) goto L8;
        if (r12.getKey() == null) goto L8;
        if (r12.getValue() == null) goto L8;
        if (r10.length() <= 0) goto L19;
        r10.append(';');
    L19:
        r10.append(r12.getKey());
        r10.append(':');
        r10.append(bytesToHex(r12.getValue()));
        goto L8
    L21:
        return r10.toString();
    L33:
        return "";
    }

    private int getAddressType(ScanResult r8, BluetoothDevice r10) {
        int r11 = invokeIntMethod(r8, "getAddressType", Integer.MIN_VALUE);
        if (r11 < 0) goto L5;
        return r11;
    L5:
        int r12 = invokeIntMethod(r10, "getAddressType", Integer.MIN_VALUE);
        if (r12 < 0) goto L8;
        return r12;
    L8:
        int r13 = getIntField(r8, "mAddressType", Integer.MIN_VALUE);
        if (r13 < 0) goto L11;
        return r13;
    L11:
        return 65535;
    }

    private byte[] getAdvertisingData(ScanRecord r8, int r10) {
        Map<Integer, byte[]> r11 = r8.getAdvertisingDataMap();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        return r11.get(Integer.valueOf(r10));
    L12:
        return null;
    L13:
        return null;
    }

    private int getEventType(ScanResult r8) {
        int r10 = getIntField(r8, "mEventType", Integer.MIN_VALUE);
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return r8.getDataStatus();
    }

    public static synchronized CaeBleScanInfoReport getInstance() {
        monitor-enter(CaeBleScanInfoReport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CaeBleScanInfoReport();     // Catch: Throwable -> L10
    L7:
        CaeBleScanInfoReport r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CaeBleScanInfoReport.class);
        return r8;
    }

    private int getIntField(Object r8, String r10, int r11) {
        if (r8 != null) goto L7;
        return r11;
    L7:
        Field r12 = r8.getClass().getDeclaredField(r10);     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return r12.getInt(r8);
    L6:
        return r11;
    }

    private long getResultTimestampMs(ScanResult r8, long r10) {
        long r11 = r8.getTimestampNanos();
        if (r11 > 0) goto L5;
        return r10;
    L5:
        long r12 = (SystemClock.elapsedRealtimeNanos() - r11) / BwdlDropUtils.DROP_SHOW_MEGABYTES;
        if (r12 >= 0) goto L9;
        return r10;
    L9:
        return r10 - r12;
    }

    private boolean hasPermission(String r8) {
        Context r10 = this.mContext;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.checkSelfPermission(r8) != 0) goto L7;
        return true;
    }

    private int invokeIntMethod(Object r8, String r10, int r11) {
        if (r8 != null) goto L10;
        return r11;
    L10:
        Method r12 = r8.getClass().getMethod(r10, new Class[0]);     // Catch: Exception -> L9
        r12.setAccessible(true);     // Catch: Exception -> L9
        Object r13 = r12.invoke(r8, new Object[0]);     // Catch: Exception -> L9
        if ((r13 instanceof Integer) == false) goto L8;
        return ((Integer) r13).intValue();
    L8:
        return r11;
    }

    private String invokeStringMethod(Object r8, String r10) {
        if (r8 != null) goto L11;
        return "";
    L11:
        Method r11 = r8.getClass().getMethod(r10, new Class[0]);     // Catch: Exception -> L10
        r11.setAccessible(true);     // Catch: Exception -> L10
        Object r12 = r11.invoke(r8, new Object[0]);     // Catch: Exception -> L10
        if ((r12 instanceof String) == false) goto L9;
        return (String) r12;
    L9:
        return "";
    }

    private String joinParcelUuids(List<ParcelUuid> r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.isEmpty() == true) goto L25;
        StringBuilder r10 = new StringBuilder();
        Iterator<ParcelUuid> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L17;
        ParcelUuid r12 = r11.next();
        if (r12 == null) goto L8;
        if (r10.length() <= 0) goto L15;
        r10.append(',');
    L15:
        r10.append(r12);
        goto L8
    L17:
        return r10.toString();
    L25:
        return "";
    }

    private void logSlardarBleReport(BleScanResultDataReport r8) {
        StringBuilder r10 = new StringBuilder("Slardar BLE scan device report: ");
        appendReportField(r10, "package_name", r8.getPackageName());
        appendReportField(r10, "timestamp", Long.valueOf(r8.getTimestamp()));
        appendReportField(r10, "event_type", Integer.valueOf(r8.getEventType()));
        appendReportField(r10, "address_type", Integer.valueOf(r8.getAddressType()));
        appendReportField(r10, StarLocationDbManager.GeofenceEntry.ADDRESS, r8.getAddress());
        appendReportField(r10, "original_address", r8.getOriginalAddress());
        appendReportField(r10, "primary_phy", Integer.valueOf(r8.getPrimaryPhy()));
        appendReportField(r10, "secondary_phy", Integer.valueOf(r8.getSecondaryPhy()));
        appendReportField(r10, "advertising_sid", Integer.valueOf(r8.getAdvertisingSid()));
        appendReportField(r10, "tx_power", toSignedHex(r8.getTxPower()));
        appendReportField(r10, WiFiDBHelper.COL_RSSI, Integer.valueOf(r8.getRssi()));
        appendReportField(r10, "periodic_adv_int", Integer.valueOf(r8.getPeriodicAdvInt()));
        appendReportField(r10, "device_name", r8.getDeviceName());
        appendReportField(r10, "advertise_flags", Integer.valueOf(r8.getAdvertiseFlags()));
        appendReportField(r10, "service_uuids", r8.getServiceUuids());
        appendReportField(r10, "service_solicitation_uuids", r8.getServiceSolicitationUuids());
        appendReportField(r10, "manufacturer_specific_Data", r8.getManufacturerSpecificData());
        appendReportField(r10, "service_data", r8.getServiceData());
        appendReportField(r10, "transport_discovery_data", r8.getTransportDiscoveryData());
        CaeLog.d(TAG, r10.toString());
    }

    private int normalizeAddressType(int r8) {
        if (r8 >= 0) goto L5;
        return 65535;
    L5:
        return r8;
    }

    private int normalizeUint32(int r8) {
        if (r8 >= 0) goto L5;
        return 0;
    L5:
        return r8;
    }

    private void reportScanResults(List<ScanResult> r10) {
        if (r10 != null) goto L5;
    L28:
        CaeLog.i(TAG, "No BLE scan results to report.");
        return;
    L5:
        if (r10.isEmpty() == true) goto L28;
        if (this.mContext != null) goto L30;
        CaeLog.e(TAG, "Cannot report BLE scan results: context is null.");
        return;
    L30:
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L25
        CaeConnectivityDataProto.Builder r11 = CaeConnectivityDataProto.newBuilder();     // Catch: Exception -> L25
        CaeConnectivityProtoData.Builder r12 = CaeConnectivityProtoData.newBuilder();     // Catch: Exception -> L25
        long r13 = this.mTriggerTime;     // Catch: Exception -> L25
        if (r13 > 0) goto L15;
        r13 = r8;
    L15:
        CaeConnectivityProtoData.Builder r14 = r12.setDeviceTime(r13).setName(this.mCurrentPoiName);     // Catch: Exception -> L25
        Iterator<ScanResult> r15 = r10.iterator();     // Catch: Exception -> L25
    L17:
        if (r15.hasNext() == false) goto L22;
        BleScanResultDataReport r16 = buildBleReport(r15.next(), r8);     // Catch: Exception -> L25
        if (r16 == null) goto L17;
        r14.addBleScanResultDataReport(r16);     // Catch: Exception -> L25
        goto L17
    L22:
        if (r14.getBleScanResultDataReportCount() <= 0) goto L37;
        r11.addCaeConnectivityProto(r14);     // Catch: Exception -> L25
        CaeUtil.writePbEventSafely(r8, CONNECTIVITY_EVENT_FEATURE_ID, r11.build().toByteArray());     // Catch: Exception -> L25
        CaeLog.i(TAG, "Reported " + r14.getBleScanResultDataReportCount() + " BLE scan results to CaeConnectivityDataProto");     // Catch: Exception -> L25
        return;
    L37:
        return;
    L25:
        e = move-exception;
        CaeLog.e(TAG, "Failed to handle and report BLE scan results", e);
    }

    private String safeGetAddress(BluetoothDevice r8) {
        if (r8 != null) goto L16;
        return "";
    L16:
        String r10 = r8.getAddress();     // Catch: Exception -> L10 SecurityException -> L12
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10;
    L12:
        e = e;
        String r11 = "Missing bluetooth permission for getAddress";
    L14:
        CaeLog.e(TAG, r11, e);
        return "";
    L10:
        e = e;
        r11 = "Failed to get BLE device address";
        goto L14
    }

    private String safeGetDeviceName(BluetoothDevice r8) {
        if (r8 != null) goto L5;
    L17:
        return "";
    L5:
        if (hasPermission("android.permission.BLUETOOTH_CONNECT") == false) goto L17;
        String r10 = r8.getName();     // Catch: Exception -> L12 SecurityException -> L14
        if (r10 != null) goto L11;
        return "";
    L11:
        return r10;
    L14:
        e = e;
        String r11 = "Missing bluetooth permission for getName";
    L16:
        CaeLog.e(TAG, r11, e);
    L12:
        e = e;
        r11 = "Failed to get BLE device name";
        goto L16
    }

    private String safeGetOriginalAddress(BluetoothDevice r8, String r10) {
        String r11 = invokeStringMethod(r8, "getIdentityAddress");
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        if (r10 != null) goto L8;
        return "";
    L8:
        return r10;
    }

    private void setScanRecordFields(BleScanResultDataReport.Builder r8, ScanRecord r10, BluetoothDevice r11) {
        String r12 = r10.getDeviceName();
        if (TextUtils.isEmpty(r12) == false) goto L6;
        r12 = safeGetDeviceName(r11);
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r8.setDeviceName(r12);
    L8:
        r8.setAdvertiseFlags(r10.getAdvertiseFlags());
        String r13 = joinParcelUuids(r10.getServiceUuids());
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r8.setServiceUuids(r13);
    L11:
        String r14 = joinParcelUuids(r10.getServiceSolicitationUuids());
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r8.setServiceSolicitationUuids(r14);
    L14:
        String r15 = formatManufacturerData(r10.getManufacturerSpecificData());
        if (TextUtils.isEmpty(r15) == true) goto L17;
        r8.setManufacturerSpecificData(r15);
    L17:
        String r16 = formatServiceData(r10.getServiceData());
        if (TextUtils.isEmpty(r16) == true) goto L20;
        r8.setServiceData(r16);
    L20:
        byte[] r17 = getAdvertisingData(r10, 38);
        if (r17 != null) goto L23;
        return;
    L23:
        if (r17.length <= 0) goto L27;
        r8.setTransportDiscoveryData(bytesToHex(r17));
        return;
    }

    private void stopScanLocked() {
        this.mHandler.removeCallbacks(this.mReportRunnable);
        if (this.mIsScanning == true) goto L25;
        return;
    L25:
    L13:
        th = move-exception;
        this.mIsScanning = false;
        throw th;
    L18:
        e = e;
        String r8 = "Missing bluetooth permission for stopScan";
    L17:
        CaeLog.e(TAG, r8, e);     // Catch: Throwable -> L13
    L21:
        this.mIsScanning = false;
        return;
    L15:
        e = e;
        r8 = "Failed to stop BLE scan";
        goto L17
    L7:
        if (this.mBluetoothLeScanner != null) goto L9;
    L11:
        CaeLog.i(TAG, "Stopped collecting: BLE scan stopped.");     // Catch: Throwable -> L13 Exception -> L15 SecurityException -> L18
    L9:
        if (hasPermission("android.permission.BLUETOOTH_SCAN") == false) goto L11;
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);     // Catch: Throwable -> L13 Exception -> L15 SecurityException -> L18
        goto L11
    }

    private String toHexKey(int r8, int r10) {
        String r11 = Integer.toHexString(r8).toUpperCase(Locale.US);
        StringBuilder r12 = new StringBuilder("0x");
        int r13 = r11.length();
    L3:
        if (r13 >= r10) goto L5;
        r12.append('0');
        r13 = r13 + 1;
        goto L3
    L5:
        r12.append(r11);
        return r12.toString();
    }

    private String toSignedHex(int r8) {
        if (r8 >= 0) goto L7;
        StringBuilder r10 = new StringBuilder("-0x");
        r8 = -r8;
    L5:
        r10.append(Integer.toHexString(r8).toUpperCase(Locale.US));
        return r10.toString();
    L7:
        r10 = new StringBuilder("0x");
        goto L5
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void destroy() {
        monitor-enter(this);
        stopCollect();     // Catch: Throwable -> L6
        this.mContext = null;     // Catch: Throwable -> L6
        this.mBluetoothAdapter = null;     // Catch: Throwable -> L6
        this.mBluetoothLeScanner = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public int getCollectorType() {
        return 2;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void init(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mContext = r8.getApplicationContext();
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        CaeLog.i(TAG, "CaeBleScanInfoReport initialized.");
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void startCollect(String r8, long r10) {
        monitor-enter(this);
        if (r8 != null) goto L48;
        r8 = "";
    L48:
        this.mCurrentPoiName = r8;     // Catch: Throwable -> L5
        this.mTriggerTime = r10;     // Catch: Throwable -> L5
        if (this.mContext != null) goto L10;
    L43:
        CaeLog.e(TAG, "Cannot start collect: Not initialized.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L10:
        if (this.mBluetoothAdapter == null) goto L43;
        if (hasPermission("android.permission.BLUETOOTH_SCAN") == true) goto L18;
        CaeLog.e(TAG, "Cannot start collect: missing BLUETOOTH_SCAN permission.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L18:
        if (this.mIsScanning == false) goto L49;
        CaeLog.d(TAG, "BLE scan is already running, ignore duplicate collect request.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L49:
    L38:
        e = e;
        this.mIsScanning = false;     // Catch: Throwable -> L5
        this.mScanResults.clear();     // Catch: Throwable -> L5
        String r11 = TAG;
        String r12 = "Missing bluetooth permission for BLE scan";
    L37:
        CaeLog.e(r11, r12, e);     // Catch: Throwable -> L5
    L41:
        monitor-exit(this);
        return;
    L35:
        e = e;
        this.mIsScanning = false;     // Catch: Throwable -> L5
        this.mScanResults.clear();     // Catch: Throwable -> L5
        r11 = TAG;
        r12 = "Failed to start BLE scan";
        goto L37
    L24:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L28;
        CaeLog.w(TAG, "Cannot start collect: Bluetooth is disabled.");     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        monitor-exit(this);
        return;
    L28:
        BluetoothLeScanner r13 = this.mBluetoothAdapter.getBluetoothLeScanner();     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mBluetoothLeScanner = r13;     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        if (r13 != null) goto L33;
        CaeLog.e(TAG, "Cannot start collect: BluetoothLeScanner is null.");     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        monitor-exit(this);
        return;
    L33:
        ScanSettings r14 = new ScanSettings.Builder().setScanMode(2).setReportDelay(0).setLegacy(false).setPhy(255).build();     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mScanResults.clear();     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mIsScanning = true;     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mBluetoothLeScanner.startScan(null, r14, this.mScanCallback);     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mHandler.removeCallbacks(this.mReportRunnable);     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        this.mHandler.postDelayed(this.mReportRunnable, 5000);     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
        CaeLog.i(TAG, "Started collecting: BLE scan started.");     // Catch: Throwable -> L5 Exception -> L35 SecurityException -> L38
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void stopCollect() {
        finishAndReport();
    }
}
