package com.obric.cae.smartBluetooth.btaware.carkey;

import android.app.ActivityManager;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothScanListener;
import com.obric.cae.smartBluetooth.scan.SmartBluetoothBleScanManager;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfo;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import com.obric.cae.smartBluetooth.util.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothCarKeyManager {
    private static final long SCAN_DELAY_MS = 6000;
    private static final String TAG = "SmartBluetoothCarKeyManager";
    private static final List<CarkeyAppInfo> sCarkeyAppInfos = null;
    private static final List<String> sDisconnectedAddresses = null;
    private static volatile SmartBluetoothCarKeyManager sInstance;
    private SmartBluetoothBleScanManager mBleScanManager;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mIsInit;
    private volatile boolean mIsScanStarted;
    private final SmartBluetoothScanListener mScanListener;
    private final Object mScanLock;
    private final Runnable mScanRunnable;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.btaware.carkey.SmartBluetoothCarKeyManager$1, reason: invalid class name */
    public class AnonymousClass1 implements CarkeyAppRepository.ResultCallback<List<CarkeyAppInfo>> {
        final /* synthetic */ SmartBluetoothCarKeyManager this$0;

        public AnonymousClass1(SmartBluetoothCarKeyManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8) {
            r8.lambda$onSuccess$0();
        }

        private /* synthetic */ void lambda$onSuccess$0() {
            SmartBluetoothCarKeyManager.access$400(this.this$0);
        }

        @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository.ResultCallback
        public void onError(Throwable r8) {
            SmartBluetoothCarKeyManager.access$000().clear();
            SmartBluetoothCarKeyManager.access$100().clear();
            CaeLog.e(SmartBluetoothCarKeyManager.TAG, "Failed to initialize CarkeyAppInfos: " + r8.getMessage());
        }

        @Override // com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository.ResultCallback
        public /* bridge */ /* synthetic */ void onSuccess(List<CarkeyAppInfo> r8) {
            onSuccess2(r8);
        }

        /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
        public void onSuccess2(List<CarkeyAppInfo> r8) {
            if (r8 == null) goto L32;
            SmartBluetoothCarKeyManager.access$000().clear();
            SmartBluetoothCarKeyManager.access$000().addAll(r8);
            SmartBluetoothCarKeyManager.access$100().clear();
            Iterator r10 = SmartBluetoothCarKeyManager.access$000().iterator();
        L5:
            if (r10.hasNext() == false) goto L13;
            Iterator<String> r11 = ((CarkeyAppInfo) r10.next()).addressList.iterator();
        L8:
            if (r11.hasNext() == false) goto L5;
            String r12 = r11.next();
            if (SmartBluetoothCarKeyManager.access$100().contains(r12) == true) goto L8;
            Log.d(SmartBluetoothCarKeyManager.TAG, "add address to sDisconnectedAddresses " + Utils.maskBluetoothAddress(r12));
            SmartBluetoothCarKeyManager.access$100().add(r12);
            goto L8
        L13:
            if (SmartBluetoothCarKeyManager.access$100().isEmpty() == true) goto L22;
            Object r13 = SmartBluetoothCarKeyManager.access$200(this.this$0);
            monitor-enter(r13);
            SmartBluetoothCarKeyManager.access$300(this.this$0).postDelayed(new a(this), 1000);     // Catch: Throwable -> L19
            monitor-exit(r13);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L22:
            CaeLog.d(SmartBluetoothCarKeyManager.TAG, "Initialized with " + SmartBluetoothCarKeyManager.access$100().size() + " disconnected addresses");
            return;
        }
    }

    static {
        sCarkeyAppInfos = new CopyOnWriteArrayList();
        sDisconnectedAddresses = new CopyOnWriteArrayList();
    }

    private SmartBluetoothCarKeyManager(Context r8) {
        this.mIsScanStarted = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsInit = false;
        this.mScanLock = new Object();
        this.mScanRunnable = new AnonymousClass2(this);
        this.mScanListener = new AnonymousClass3(this);
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mBleScanManager = SmartBluetoothBleScanManager.getInstance(r10);
    }

    public static /* synthetic */ List access$000() {
        return sCarkeyAppInfos;
    }

    public static /* synthetic */ List access$100() {
        return sDisconnectedAddresses;
    }

    public static /* synthetic */ Object access$200(SmartBluetoothCarKeyManager r8) {
        return r8.mScanLock;
    }

    public static /* synthetic */ Handler access$300(SmartBluetoothCarKeyManager r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$400(SmartBluetoothCarKeyManager r8) {
        r8.startBleScanWithFilters();
    }

    public static /* synthetic */ boolean access$500(SmartBluetoothCarKeyManager r8) {
        return r8.mIsScanStarted;
    }

    public static /* synthetic */ boolean access$502(SmartBluetoothCarKeyManager r8, boolean r10) {
        r8.mIsScanStarted = r10;
        return r10;
    }

    public static /* synthetic */ SmartBluetoothScanListener access$600(SmartBluetoothCarKeyManager r8) {
        return r8.mScanListener;
    }

    public static /* synthetic */ SmartBluetoothBleScanManager access$700(SmartBluetoothCarKeyManager r8) {
        return r8.mBleScanManager;
    }

    public static /* synthetic */ boolean access$800(SmartBluetoothCarKeyManager r8, Intent r10) {
        return r8.isServiceRunning(r10);
    }

    public static /* synthetic */ Context access$900(SmartBluetoothCarKeyManager r8) {
        return r8.mContext;
    }

    public static SmartBluetoothCarKeyManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothCarKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothCarKeyManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothCarKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isServiceRunning(Intent r8) {
        if (r8 != null) goto L5;
    L15:
        CaeLog.e(TAG, "Intent or component is null");
        return false;
    L5:
        if (r8.getComponent() == null) goto L15;
        Iterator<ActivityManager.RunningServiceInfo> r10 = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
    L9:
        if (r10.hasNext() == false) goto L14;
        ActivityManager.RunningServiceInfo r11 = r10.next();
        if (r8.getComponent().equals(r11.service) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private void onBleCarKyeConnectionChanged(boolean r8, BluetoothDevice r10, String r11) {
        if (r10 == null) goto L38;
        if (r11 == null) goto L38;
        if (r8 == false) goto L33;
        String r12 = r10.getAddress();
        Iterator<CarkeyAppInfo> r13 = sCarkeyAppInfos.iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        CarkeyAppInfo r14 = r13.next();
        if (r11.equals(r14.appName) == false) goto L9;
    L14:
        boolean r15 = true;
        if (r14 != null) goto L17;
        CopyOnWriteArrayList r16 = new CopyOnWriteArrayList();
        r16.add(r12);
        sCarkeyAppInfos.add(new CarkeyAppInfo(r11, r16));
        StringBuilder r17 = new StringBuilder("Created new CarkeyAppInfo for app: ");
    L23:
        r17.append(r11);
        r17.append(", address: ");
        r17.append(Utils.maskBluetoothAddress(r12));
        CaeLog.d(TAG, r17.toString());
    L25:
        if (r15 == false) goto L30;
        CarkeyAppRepository r18 = CarkeyAppRepository.getInstance(this.mContext);
        Iterator<CarkeyAppInfo> r19 = sCarkeyAppInfos.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        r18.upsertSync(r19.next());
    L30:
        List<String> r20 = sDisconnectedAddresses;
        if (r20.contains(r12) == false) goto L44;
        r20.remove(r12);
        CaeLog.d(TAG, "Removed address from disconnected list: " + Utils.maskBluetoothAddress(r12));
        return;
    L44:
        return;
    L17:
        List<String> r21 = r14.addressList;
        if (r21.contains(r12) == true) goto L24;
        r21.add(r12);
        if (r21.size() <= 5) goto L22;
        r21.remove(0);
    L22:
        r17 = new StringBuilder("Added address to existing CarkeyAppInfo for app: ");
        goto L23
    L24:
        r15 = false;
        goto L25
    L13:
        r14 = null;
        goto L14
    L33:
        String r22 = r10.getAddress();
        List<String> r23 = sDisconnectedAddresses;
        if (r23.contains(r22) == true) goto L36;
        r23.add(r22);
        CaeLog.d(TAG, "Added address to disconnected list: " + Utils.maskBluetoothAddress(r22));
    L36:
        startBleScanWithFilters();
        return;
    L38:
        CaeLog.w(TAG, "device or appName is null");
    }

    private void startBleScanWithFilters() {
        Object r8 = this.mScanLock;
        monitor-enter(r8);
        this.mHandler.removeCallbacks(this.mScanRunnable);     // Catch: Throwable -> L7
        CaeLog.d(TAG, "Scheduling BLE scan to start in 6000ms");     // Catch: Throwable -> L7
        this.mHandler.postDelayed(this.mScanRunnable, 6000);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        Log.d(TAG, "cleanup");
        List<CarkeyAppInfo> r8 = sCarkeyAppInfos;
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        CarkeyAppRepository r10 = CarkeyAppRepository.getInstance(this.mContext);
        Iterator<CarkeyAppInfo> r11 = r8.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.upsertSync(r11.next());
        goto L7
    L9:
        sCarkeyAppInfos.clear();
        sDisconnectedAddresses.clear();
        if (this.mIsScanStarted == false) goto L14;
        SmartBluetoothBleScanManager r12 = this.mBleScanManager;
        if (r12 == null) goto L14;
        r12.stopScan(this.mScanListener);
    L14:
        sInstance = null;
        this.mIsInit = false;
        this.mIsScanStarted = false;
    }

    public void init() {
        Log.d(TAG, "init");
        if (this.mIsInit == false) goto L5;
        return;
    L5:
        this.mIsInit = true;
        CarkeyAppRepository.getInstance(this.mContext).getAllAsync(new AnonymousClass1(this));
    }

    public void onBluetoothBleOn() {
        Object r8 = this.mScanLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsScanStarted == false) goto L7;
        Log.d(TAG, "mIsScanStarted is true");     // Catch: Throwable -> L19
    L7:
        List<String> r10 = sDisconnectedAddresses;     // Catch: Throwable -> L19
        if (r10.isEmpty() == false) goto L11;
        Log.d(TAG, "sDisconnectedAddresses is empty");     // Catch: Throwable -> L19
    L11:
        if (this.mBleScanManager != null) goto L13;
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L13:
        if (this.mIsScanStarted == true) goto L17;
        if (r10.isEmpty() == true) goto L17;
        Log.d(TAG, "onBluetoothBleOn");     // Catch: Throwable -> L19
        startBleScanWithFilters();     // Catch: Throwable -> L19
        goto L17
    }

    public void onBluetoothOff() {
        Log.d(TAG, "onBluetoothOff");
        this.mIsScanStarted = false;
    }

    public void onBluetoothOn() {
        Object r8 = this.mScanLock;
        monitor-enter(r8);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsScanStarted == false) goto L9;
        Log.d(TAG, "mIsScanStarted is true");     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
        return;
    L9:
        Iterator<CarkeyAppInfo> r10 = sCarkeyAppInfos.iterator();     // Catch: Throwable -> L32
    L11:
        if (r10.hasNext() == false) goto L18;
        Iterator<String> r11 = r10.next().addressList.iterator();     // Catch: Throwable -> L32
    L14:
        if (r11.hasNext() == false) goto L11;
        String r12 = r11.next();     // Catch: Throwable -> L32
        List<String> r13 = sDisconnectedAddresses;     // Catch: Throwable -> L32
        if (r13.contains(r12) == true) goto L14;
        Log.d(TAG, "onBluetoothOn: add address to sDisconnectedAddresses " + Utils.maskBluetoothAddress(r12));     // Catch: Throwable -> L32
        r13.add(r12);     // Catch: Throwable -> L32
        goto L14
    L18:
        List<String> r14 = sDisconnectedAddresses;     // Catch: Throwable -> L32
        if (r14.isEmpty() == false) goto L24;
        Log.d(TAG, "sDisconnectedAddresses is empty");     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
        return;
    L24:
        if (this.mBleScanManager != null) goto L26;
    L30:
        monitor-exit(r8);     // Catch: Throwable -> L32
        return;
    L26:
        if (this.mIsScanStarted == true) goto L30;
        if (r14.isEmpty() == true) goto L30;
        Log.d(TAG, "onBluetoothOn()");     // Catch: Throwable -> L32
        startBleScanWithFilters();     // Catch: Throwable -> L32
        goto L30
    }

    public void onEventReported(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r10 = r8.getInt("event");
        String r11 = r8.getString("appName");
        BluetoothDevice r12 = (BluetoothDevice) r8.getParcelable("device");
        if (r11 == null) goto L15;
        if (r12 == null) goto L15;
        if (r10 != 1) goto L12;
        onBleCarKyeConnectionChanged(true, r12, r11);
        return;
    L12:
        if (r10 != 4) goto L18;
        onBleCarKyeConnectionChanged(false, r12, r11);
        return;
    L18:
        return;
    L15:
        CaeLog.w(TAG, "appName or device is null");
    }
}
