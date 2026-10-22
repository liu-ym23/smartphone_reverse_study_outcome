package com.obric.cae.smartBluetooth.scan;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothEventReceiver;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothScanListener;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class SmartBluetoothBleScanManager {
    private static final String TAG = "SmartBluetoothBleScanManager";
    private static BluetoothAdapter sAdapter;
    private static final List<SmartScanClient> sBleScanClientList = null;
    private static Context sContext;
    private static volatile SmartBluetoothBleScanManager sInstance;
    private static final List<ScanFilter> sLastFilters = null;
    private static ScanSettings sLastScanSetting;
    private static ScanSettings.Builder sScanBuilder;
    private boolean isScanning;
    private BluetoothLeScanner mBleScanner;
    private final Handler mHandler;
    private final ScanCallback mScanCallback;
    private int mScannerId;

    static {
        sLastFilters = new CopyOnWriteArrayList();
        sBleScanClientList = new CopyOnWriteArrayList();
        sScanBuilder = new ScanSettings.Builder();
    }

    private SmartBluetoothBleScanManager(Context r8) {
        this.isScanning = false;
        this.mScannerId = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScanCallback = new AnonymousClass1(this);
        CaeLog.w(TAG, TAG);
        sContext = r8.getApplicationContext();
        BluetoothAdapter r10 = BluetoothAdapter.getDefaultAdapter();
        sAdapter = r10;
        if (r10 == null) goto L6;
        this.mBleScanner = r10.getBluetoothLeScanner();
        return;
    }

    public static /* synthetic */ void a(SmartBluetoothBleScanManager r8) {
        r8.lambda$updateScanModeScreenOn$2();
    }

    public static /* synthetic */ List access$000() {
        return sBleScanClientList;
    }

    public static /* synthetic */ boolean access$100(SmartScanClient r8, ScanResult r10) {
        return matchesFilters(r8, r10);
    }

    public static /* synthetic */ boolean access$202(SmartBluetoothBleScanManager r8, boolean r10) {
        r8.isScanning = r10;
        return r10;
    }

    public static /* synthetic */ void b(SmartBluetoothBleScanManager r8) {
        r8.lambda$updateScanModeScreenOn$3();
    }

    public static /* synthetic */ void c(SmartBluetoothBleScanManager r8) {
        r8.lambda$startScan$0();
    }

    public static /* synthetic */ void d(SmartBluetoothBleScanManager r8) {
        r8.lambda$updateScanModeScreenOff$4();
    }

    public static /* synthetic */ void e(SmartBluetoothBleScanManager r8) {
        r8.lambda$updateScanModeScreenOff$5();
    }

    public static /* synthetic */ void f(SmartBluetoothBleScanManager r8) {
        r8.lambda$stopScan$1();
    }

    private ScanSettings.Builder getAggressiveClient() {
        Iterator<SmartScanClient> r8 = sBleScanClientList.iterator();
        int r10 = -1;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r8.hasNext() == false) goto L24;
        SmartScanClient r13 = r8.next();
        if (r13.getSettings() == null) goto L4;
        if (SmartBluetoothEventReceiver.getScreenState() == true) goto L15;
        if (r13.getFilters() == null) goto L4;
        if (r13.getFilters().isEmpty() == true) goto L4;
    L15:
        ScanSettings r14 = r13.getSettings();
        if (r14.getScanMode() <= r10) goto L19;
        r10 = r14.getScanMode();
    L19:
        if (r14.getRssiHighThreshold() <= r11) goto L22;
        r11 = r14.getRssiHighThreshold();
    L22:
        if (r14.getRssiLowThreshold() >= r12) goto L4;
        r12 = r14.getRssiLowThreshold();
        goto L4
    L24:
        StringBuilder r15 = defpackage.a.g("getAggressiveClient, mode: ", r10, ", highThreshold: ", r11, ", lowThreshold: ");
        r15.append(r12);
        CaeLog.d(TAG, r15.toString());
        return new ScanSettings.Builder().setLegacy(false).setScanMode(r10).setRssiHighThreshold(r11).setRssiLowThreshold(r12);
    }

    public static SmartBluetoothBleScanManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothBleScanManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothBleScanManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothBleScanManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initBleScanConfig() {
        CaeLog.d(TAG, "initBleScanConfig");
        sScanBuilder = new ScanSettings.Builder();
        if (this.mBleScanner != null) goto L6;
        this.mBleScanner = sAdapter.getBluetoothLeScanner();
    L6:
        if (sLastScanSetting != null) goto L9;
        sLastScanSetting = sScanBuilder.setLegacy(false).setScanMode(-1).setRssiHighThreshold(-35).setRssiLowThreshold(-35).build();
        return;
    }

    private boolean isBleScannerDown() {
        if (CaeUtil.isBleAlwaysOnSupported(sContext) == false) goto L12;
        if (sAdapter.isEnabled() == true) goto L15;
        if (sAdapter.isLeEnabled() == true) goto L15;
        String r8 = "BLE adapter is disabled, return";
    L9:
        CaeLog.d(TAG, r8);
        return true;
    L15:
        if (this.mBleScanner != null) goto L17;
        r8 = "mBleScanner is null";
        goto L9
    L17:
        return false;
    L12:
        if (sAdapter.isEnabled() == true) goto L15;
        return true;
    }

    private /* synthetic */ void lambda$startScan$0() {
        this.mBleScanner.startScan(sLastFilters, sScanBuilder.build(), this.mScanCallback);
    }

    private /* synthetic */ void lambda$stopScan$1() {
        this.mBleScanner.startScan(sLastFilters, sScanBuilder.build(), this.mScanCallback);
    }

    private /* synthetic */ void lambda$updateScanModeScreenOff$4() {
        this.mBleScanner.startScan(sLastFilters, sScanBuilder.build(), this.mScanCallback);
    }

    private /* synthetic */ void lambda$updateScanModeScreenOff$5() {
        this.mBleScanner.startScan(sLastFilters, sLastScanSetting, this.mScanCallback);
    }

    private /* synthetic */ void lambda$updateScanModeScreenOn$2() {
        this.mBleScanner.startScan(sLastFilters, sScanBuilder.build(), this.mScanCallback);
    }

    private /* synthetic */ void lambda$updateScanModeScreenOn$3() {
        this.mBleScanner.startScan(sLastFilters, sLastScanSetting, this.mScanCallback);
    }

    private static boolean matchesFilters(SmartScanClient r8, ScanResult r10) {
        List<ScanFilter> r11 = r8.mFilters;
        if (r11 != null) goto L5;
    L15:
        return true;
    L5:
        if (r11.isEmpty() == true) goto L15;
        Iterator<ScanFilter> r12 = r8.mFilters.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        if (r12.next().matches(r10) == false) goto L9;
        return true;
    L13:
        return false;
    }

    private static boolean shouldUpdateScan(ScanSettings r8) {
        ScanSettings.Builder r10 = new ScanSettings.Builder();
        if (r8 != null) goto L6;
        Log.d(TAG, "newScanSetting is null");
        return false;
    L6:
        Log.d(TAG, "mode is " + r8.getScanMode());
        Log.d(TAG, "sLastScanSetting mode is " + sLastScanSetting.getScanMode());
        if (r8.getScanMode() <= sLastScanSetting.getScanMode()) goto L9;
        r10.setScanMode(r8.getScanMode());
        boolean r11 = true;
    L11:
        if (r8.getRssiLowThreshold() >= sLastScanSetting.getRssiLowThreshold()) goto L13;
        r10.setRssiLowThreshold(r8.getRssiLowThreshold());
        r11 = true;
    L13:
        if (r11 == false) goto L16;
        CaeLog.d(TAG, "shouldUpdateScan, update: " + r11);
        sLastScanSetting = r10.setLegacy(false).build();
        return true;
    L16:
        return false;
    L9:
        r11 = false;
        goto L11
    }

    private void updateScanModeScreenOff() {
        if (isBleScannerDown() == false) goto L6;
        return;
    L6:
        if (this.isScanning == false) goto L51;
        List<SmartScanClient> r8 = sBleScanClientList;
        if (r8.isEmpty() == true) goto L69;
        CaeLog.d(TAG, "updateScanModeScreenOff");
        ScanSettings.Builder r10 = getAggressiveClient();
        boolean r11 = shouldUpdateScan(r10.build());
        if (r11 == false) goto L13;
        sScanBuilder = r10;
    L13:
        monitor-enter(r8);
        Iterator<SmartScanClient> r12 = r8.iterator();     // Catch: Throwable -> L48
        int r13 = 0;
        boolean r14 = false;
    L16:
        if (r12.hasNext() == false) goto L35;
        SmartScanClient r15 = r12.next();     // Catch: Throwable -> L48
        if (r15.getFilters() == null) goto L16;
        if (r15.getFilters().isEmpty() == true) goto L16;
        List<ScanFilter> r16 = sLastFilters;     // Catch: Throwable -> L48
        monitor-enter(r16);     // Catch: Throwable -> L48
        Iterator<ScanFilter> r17 = r15.getFilters().iterator();     // Catch: Throwable -> L32
    L26:
        if (r17.hasNext() == false) goto L30;
        ScanFilter r18 = r17.next();     // Catch: Throwable -> L32
        List<ScanFilter> r19 = sLastFilters;     // Catch: Throwable -> L32
        if (r19.contains(r18) == true) goto L26;
        r19.add(r18);     // Catch: Throwable -> L32
        r14 = true;
        goto L26
    L30:
        monitor-exit(r16);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L35:
        monitor-exit(r8);     // Catch: Throwable -> L48
        if (sLastFilters.isEmpty() == false) goto L40;
        this.mBleScanner.stopScan(this.mScanCallback);
        this.isScanning = false;
        return;
    L40:
        if (r14 == true) goto L42;
        if (r11 == true) goto L42;
        return;
    L42:
        this.mBleScanner.stopScan(this.mScanCallback);
        CaeLog.d(TAG, "updateScanModeScreenOff, updateFilters: " + r14 + ", update: " + r11);
        StringBuilder r20 = new StringBuilder("updateScanModeScreenOff, mode: ");
        r20.append(sScanBuilder.build().getScanMode());
        CaeLog.d(TAG, r20.toString());
        if (r11 == false) goto L45;
        Handler r21 = this.mHandler;
        Runnable r22 = new b(this, r13);
    L46:
        r21.postDelayed(r22, 1000);
        return;
    L45:
        r21 = this.mHandler;
        r22 = new c(this, r13);
    L48:
        th = move-exception;
        throw th;
    L69:
        return;
    }

    private void updateScanModeScreenOn() {
        if (isBleScannerDown() == false) goto L5;
        return;
    L5:
        List<SmartScanClient> r8 = sBleScanClientList;
        if (r8.isEmpty() == false) goto L8;
        return;
    L8:
        CaeLog.d(TAG, "updateScanModeScreenOn");
        ScanSettings.Builder r10 = getAggressiveClient();
        boolean r11 = shouldUpdateScan(r10.build());
        if (r11 == false) goto L11;
        sScanBuilder = r10;
    L11:
        monitor-enter(r8);
        Iterator<SmartScanClient> r12 = r8.iterator();     // Catch: Throwable -> L50
        boolean r13 = false;
    L13:
        int r14 = 1;
        if (r12.hasNext() == false) goto L41;
        SmartScanClient r15 = r12.next();     // Catch: Throwable -> L50
        if (r15.getFilters() == null) goto L33;
        if (r15.getFilters().isEmpty() == true) goto L33;
        List<ScanFilter> r16 = sLastFilters;     // Catch: Throwable -> L50
        monitor-enter(r16);     // Catch: Throwable -> L50
        Iterator<ScanFilter> r17 = r15.getFilters().iterator();     // Catch: Throwable -> L30
    L24:
        if (r17.hasNext() == false) goto L28;
        ScanFilter r18 = r17.next();     // Catch: Throwable -> L30
        List<ScanFilter> r19 = sLastFilters;     // Catch: Throwable -> L30
        if (r19.contains(r18) == true) goto L24;
        r19.add(r18);     // Catch: Throwable -> L30
        r13 = true;
        goto L24
    L28:
        monitor-exit(r16);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L33:
        List<ScanFilter> r20 = sLastFilters;     // Catch: Throwable -> L50
        monitor-enter(r20);     // Catch: Throwable -> L50
        r20.clear();     // Catch: Throwable -> L38
        monitor-exit(r20);     // Catch: Throwable -> L38
        r13 = true;
        goto L41
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L41:
        monitor-exit(r8);     // Catch: Throwable -> L50
        if (r13 == true) goto L44;
        if (r11 == true) goto L44;
        return;
    L44:
        this.mBleScanner.stopScan(this.mScanCallback);
        CaeLog.d(TAG, "updateScanModeScreenOn, updateFilters: " + r13 + ", update: " + r11);
        StringBuilder r21 = new StringBuilder("updateScanModeScreenOn, mode: ");
        r21.append(sScanBuilder.build().getScanMode());
        CaeLog.d(TAG, r21.toString());
        if (r11 == false) goto L47;
        Handler r22 = this.mHandler;
        Runnable r23 = new b(this, r14);
    L48:
        r22.postDelayed(r23, 1000);
        return;
    L47:
        r22 = this.mHandler;
        r23 = new c(this, r14);
    L50:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        this.isScanning = false;
        sLastFilters.clear();
        sBleScanClientList.clear();
        this.mScannerId = 0;
    }

    public void init() {
        CaeLog.d(TAG, "init");
        if (sAdapter.isEnabled() == false) goto L6;
    L4:
        initBleScanConfig();
        return;
    L6:
        if (CaeUtil.isBleAlwaysOnSupported(sContext) == true) goto L8;
        return;
    L8:
        if (sAdapter.isLeEnabled() == true) goto L4;
    }

    public void onBluetoothBleOn() {
        CaeLog.d(TAG, "onBluetoothBleOn");
        if (CaeUtil.isBleAlwaysOnSupported(sContext) == false) goto L6;
        initBleScanConfig();
        return;
    }

    public void onBluetoothOff() {
        CaeLog.d(TAG, "onBluetoothOff");
        if (CaeUtil.isBleAlwaysOnSupported(sContext) == true) goto L5;
    L7:
        boolean r8 = true;
    L8:
        if (r8 == true) goto L10;
        CaeLog.d(TAG, "onBluetoothOff reset = false");
    L10:
        this.isScanning = false;
        sLastFilters.clear();
        sBleScanClientList.clear();
        this.mScannerId = 0;
        sLastScanSetting = null;
        return;
    L5:
        if (sAdapter.isLeEnabled() == false) goto L7;
        r8 = false;
        goto L8
    }

    public void onBluetoothOn() {
        CaeLog.d(TAG, "onBluetoothOn");
        initBleScanConfig();
    }

    public void onScreenStateChange(boolean r8) {
        CaeLog.w(TAG, "onScreenStateChange screenOn " + r8);
        if (r8 == false) goto L5;
        updateScanModeScreenOn();
        return;
    L5:
        updateScanModeScreenOff();
    }

    public boolean startScan(List<ScanFilter> r8, ScanSettings r10, SmartBluetoothScanListener r11) {
        CaeLog.d(TAG, "startScan start");
        int r12 = 0;
        if (r11 != null) goto L7;
        CaeLog.d(TAG, "startScan callback is null");
        return false;
    L7:
        if (isBleScannerDown() == false) goto L9;
        return false;
    L9:
        List<SmartScanClient> r13 = sBleScanClientList;
        monitor-enter(r13);
        Iterator<SmartScanClient> r14 = r13.iterator();     // Catch: Throwable -> L68
    L13:
        if (r14.hasNext() == false) goto L19;
        if (r11.equals(r14.next().getCallback()) == false) goto L13;
        CaeLog.d(TAG, "startScan callback is already registered");     // Catch: Throwable -> L68
        monitor-exit(r13);     // Catch: Throwable -> L68
        return false;
    L19:
        monitor-exit(r13);     // Catch: Throwable -> L68
        sBleScanClientList.add(new SmartScanClient(this.mScannerId, r10, r8, r11));
        this.mScannerId++;
        if (this.isScanning == true) goto L29;
        this.isScanning = true;
        if (r8 != null) goto L25;
    L27:
        sLastScanSetting = r10;
        this.mBleScanner.startScan(r8, r10, this.mScanCallback);
        return true;
    L25:
        if (r8.isEmpty() == true) goto L27;
        sLastFilters.addAll(r8);
        goto L27
    L29:
        ScanSettings.Builder r15 = getAggressiveClient();
        boolean r16 = shouldUpdateScan(r15.build());
        if (r16 == false) goto L32;
        sScanBuilder = r15;
    L32:
        if (r8 == null) goto L59;
        if (r8.isEmpty() == true) goto L59;
        List<ScanFilter> r17 = sLastFilters;
        monitor-enter(r17);
    L55:
        th = move-exception;
        throw th;
    L39:
        if (SmartBluetoothEventReceiver.getScreenState() == true) goto L42;
    L40:
        boolean r18 = true;
    L45:
        if (r18 == false) goto L53;
        Iterator<ScanFilter> r19 = r8.iterator();     // Catch: Throwable -> L55
    L48:
        if (r19.hasNext() == false) goto L53;
        ScanFilter r20 = r19.next();     // Catch: Throwable -> L55
        List<ScanFilter> r21 = sLastFilters;     // Catch: Throwable -> L55
        if (r21.contains(r20) == true) goto L48;
        r21.add(r20);     // Catch: Throwable -> L55
        r16 = true;
    L53:
        monitor-exit(r17);     // Catch: Throwable -> L55
    L65:
        if (r16 == false) goto L67;
        this.mBleScanner.stopScan(this.mScanCallback);
        this.mHandler.postDelayed(new a(this, r12), 1000);
    L67:
        return true;
    L42:
        if (r17.isEmpty() == false) goto L40;
        r18 = false;
    L59:
        if (SmartBluetoothEventReceiver.getScreenState() == true) goto L62;
        return true;
    L62:
        if (sLastFilters.isEmpty() == false) goto L65;
        if (r16 == true) goto L65;
        return true;
    L68:
        th = move-exception;
        throw th;
    }

    public void stopScan(SmartBluetoothScanListener r8) {
        CaeLog.w(TAG, "stopScan");
        if (r8 != null) goto L7;
        String r10 = TAG;
        String r11 = "stopScan callback is null";
    L5:
        CaeLog.d(r10, r11);
        return;
    L7:
        List<SmartScanClient> r12 = sBleScanClientList;
        monitor-enter(r12);
        Iterator<SmartScanClient> r13 = r12.iterator();     // Catch: Throwable -> L41
    L11:
        if (r13.hasNext() == false) goto L15;
        SmartScanClient r14 = r13.next();     // Catch: Throwable -> L41
        if (r8.equals(r14.getCallback()) == false) goto L11;
        sBleScanClientList.remove(r14);     // Catch: Throwable -> L41
        List<ScanFilter> r15 = r14.getFilters();     // Catch: Throwable -> L41
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L41
        List<ScanFilter> r16 = sLastFilters;
        monitor-enter(r16);
        if (r15 != null) goto L44;
    L23:
        boolean r17 = false;
    L24:
        monitor-exit(r16);     // Catch: Throwable -> L38
        if (isBleScannerDown() == false) goto L29;
        r10 = TAG;
        r11 = "BLE adapter is disabled, return";
        goto L5
    L29:
        if (sBleScanClientList.isEmpty() == false) goto L31;
        this.mBleScanner.stopScan(this.mScanCallback);
        return;
    L31:
        ScanSettings.Builder r18 = getAggressiveClient();
        boolean r19 = shouldUpdateScan(r18.build());
        if (r19 == false) goto L34;
        sScanBuilder = r18;
    L34:
        if (r17 == true) goto L36;
        if (r19 == true) goto L36;
        return;
    L36:
        this.mBleScanner.stopScan(this.mScanCallback);
        this.mHandler.postDelayed(new a(this, 1), 1000);
        return;
    L38:
        th = move-exception;
        throw th;
    L44:
        if (r15.isEmpty() == true) goto L23;
        r17 = r16.removeAll(r15);     // Catch: Throwable -> L38
        goto L24
    L15:
        r15 = null;
    L41:
        th = move-exception;
        throw th;
    }
}
