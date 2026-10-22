package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelUuid;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothGattCentral {
    private static final int BLE_REQUEST_MTU = 512;
    private static final int RETRY_INTERVAL_MS = 1000;
    private static final int RETRY_LIMIT = 5;
    private static final int SCANNING = 2;
    private static final int STARTED = 1;
    private static final int STOPPED = 0;
    private static final String TAG = "BluetoothGattCentral";
    private final ConcurrentMap<BluetoothDevice, BluetoothGatt> mBluetoothGattMap;
    private Context mContext;
    private BluetoothGattCentralCallback mGattCentralCallback;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    @SuppressLint({"MissingPermission"})
    private final BluetoothGattCallback mInternalGattCallback;
    private final ScanCallback mInternalScanCallback;
    private ScanSettings mScanSettings;
    private BluetoothLeScanner mScanner;
    private int mScannerStartCount;
    private AtomicInteger mScannerState;
    private final ConcurrentMap<BluetoothGattService, List<BluetoothGattCharacteristic>> mServicesMap;

    /* JADX INFO: renamed from: com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattCentral$1, reason: invalid class name */
    public class AnonymousClass1 extends ScanCallback {
        final /* synthetic */ BluetoothGattCentral this$0;

        public AnonymousClass1(BluetoothGattCentral r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8) {
            r8.lambda$onScanFailed$0();
        }

        private /* synthetic */ void lambda$onScanFailed$0() {
            if (BluetoothGattCentral.access$300(this.this$0) == null) goto L6;
            BluetoothGattCentral r8 = this.this$0;
            BluetoothGattCentral.access$400(r8, BluetoothGattCentral.access$300(r8));
            return;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r8) {
            if (BluetoothGattCentral.access$100(this.this$0) < 5) goto L8;
            LogUtil.e(BluetoothGattCentral.TAG, "Cannot start BLE Scanner. Scanning Retry count: " + BluetoothGattCentral.access$100(this.this$0));
            if (BluetoothGattCentral.access$000(this.this$0) == null) goto L15;
            BluetoothGattCentral.access$000(this.this$0).onScanFailed(r8);
            return;
        L15:
            return;
        L8:
            BluetoothGattCentral.access$108(this.this$0);
            LogUtil.w(BluetoothGattCentral.TAG, "BLE Scanner failed to start. Error: " + r8 + " Retry: " + BluetoothGattCentral.access$100(this.this$0));
            if (r8 != 2) goto L11;
        L13:
            BluetoothGattCentral.access$200(this.this$0).postDelayed(new a(this, 0), 1000);
            return;
        L11:
            if (r8 == 3) goto L13;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r8, ScanResult r10) {
            if (BluetoothGattCentral.access$000(this.this$0) == null) goto L13;
            if (r10 != null) goto L6;
            return;
        L6:
            if (r8 != 1) goto L8;
        L9:
            BluetoothDevice r11 = r10.getDevice();
            if (r11 == null) goto L16;
            BluetoothGattCentral.access$000(this.this$0).onDeviceFound(r11);
            return;
        L16:
            return;
        L8:
            if (r8 == 2) goto L9;
            return;
        }
    }

    public @interface ScannerState {
    }

    public BluetoothGattCentral(Context r8) {
        this.mServicesMap = new ConcurrentHashMap();
        this.mBluetoothGattMap = new ConcurrentHashMap();
        this.mScannerState = new AtomicInteger(0);
        this.mInternalScanCallback = new AnonymousClass1(this);
        this.mInternalGattCallback = new AnonymousClass2(this);
        this.mContext = r8;
        HandlerThread r10 = new HandlerThread("GattCentral");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public static /* synthetic */ void a(BluetoothGattCentral r8, ScanSettings r10) {
        r8.lambda$startInternally$0(r10);
    }

    public static /* synthetic */ BluetoothGattCentralCallback access$000(BluetoothGattCentral r8) {
        return r8.mGattCentralCallback;
    }

    public static /* synthetic */ int access$100(BluetoothGattCentral r8) {
        return r8.mScannerStartCount;
    }

    public static /* synthetic */ int access$108(BluetoothGattCentral r8) {
        int r10 = r8.mScannerStartCount;
        r8.mScannerStartCount = r10 + 1;
        return r10;
    }

    public static /* synthetic */ Handler access$200(BluetoothGattCentral r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ ScanSettings access$300(BluetoothGattCentral r8) {
        return r8.mScanSettings;
    }

    public static /* synthetic */ void access$400(BluetoothGattCentral r8, ScanSettings r10) {
        r8.startInternally(r10);
    }

    public static /* synthetic */ void access$500(BluetoothGattCentral r8, BluetoothGatt r10, int r11) {
        r8.requestConnectionPriority(r10, r11);
    }

    public static /* synthetic */ ConcurrentMap access$600(BluetoothGattCentral r8) {
        return r8.mServicesMap;
    }

    private boolean isScanning() {
        if (this.mScannerState.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$startInternally$0(ScanSettings r8) {
        LogUtil.w(TAG, "Scanner unavailable. Trying again.");
        startInternally(r8);
    }

    private void requestConnectionPriority(BluetoothGatt r8, int r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (androidx.core.content.a.a(this.mContext, "android.permission.BLUETOOTH_CONNECT") == 0) goto L8;
        BWDLLog.d(TAG, "requestConnectionPriority checkSelfPermission BLUETOOTH_CONNECT failed.");
        return;
    L8:
        if (r8.requestConnectionPriority(r10) == false) goto L10;
        String r11 = "requestConnectionPriority success.";
    L11:
        BWDLLog.d(TAG, r11);
        return;
    L10:
        r11 = "requestConnectionPriority failed.";
        goto L11
    }

    @SuppressLint({"MissingPermission"})
    private void startInternally(ScanSettings r8) {
        LogUtil.d(TAG, "Attempting to start scanning");
        if (this.mScanner == null) goto L5;
    L7:
        BluetoothLeScanner r10 = this.mScanner;
        if (r10 == null) goto L10;
        r10.startScan(null, r8, this.mInternalScanCallback);
        updateScannerState(2);
        return;
    L10:
        this.mHandler.postDelayed(new x(10, this, r8), 1000);
        return;
    L5:
        if (BluetoothAdapter.getDefaultAdapter() == null) goto L7;
        this.mScanner = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();
        goto L7
    }

    private void updateScannerState(@ScannerState int r8) {
        this.mScannerState.set(r8);
    }

    @SuppressLint({"MissingPermission"})
    public boolean centralConnect(BluetoothDevice r8) {
        if (r8 == null) goto L6;
        this.mBluetoothGattMap.put(r8, r8.connectGatt(this.mContext, false, this.mInternalGattCallback));
        return true;
    L6:
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean centralDisconnect(BluetoothDevice r8) {
        if (r8 == null) goto L9;
        BluetoothGatt r10 = this.mBluetoothGattMap.get(r8);
        if (r10 != null) goto L7;
        return false;
    L7:
        r10.disconnect();
        this.mBluetoothGattMap.remove(r8);
        return true;
    L9:
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean centralReadCharacteristic(BluetoothDevice r8, ParcelUuid r10) {
        BluetoothGatt r11 = this.mBluetoothGattMap.get(r8);
        if (r11 == null) goto L17;
        if (r10 == null) goto L17;
        Iterator<BluetoothGattService> r12 = r11.getServices().iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        BluetoothGattCharacteristic r13 = r12.next().getCharacteristic(r10.getUuid());
        if (r13 == null) goto L8;
    L14:
        if ((r13.getProperties() & 2) <= 0) goto L17;
        r11.readCharacteristic(r13);
        return true;
    L12:
        r13 = null;
    L17:
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean centralWriteCharacteristic(BluetoothDevice r8, ParcelUuid r10, byte[] r11) {
        BluetoothGatt r12 = this.mBluetoothGattMap.get(r8);
        LogUtil.d(TAG, "centralWriteCharacteristic:" + r8);
        if (r12 == null) goto L20;
        if (r10 == null) goto L20;
        Iterator<BluetoothGattService> r13 = r12.getServices().iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        BluetoothGattCharacteristic r14 = r13.next().getCharacteristic(r10.getUuid());
        if (r14 == null) goto L8;
    L13:
        if (r14 == null) goto L15;
        int r15 = r14.getProperties();
    L17:
        if ((r15 & 8) <= 0) goto L20;
        r14.setValue(r11);
        return r12.writeCharacteristic(r14);
    L15:
        r15 = 0;
        goto L17
    L12:
        r14 = null;
    L20:
        return false;
    }

    public void cleanup() {
        if (isScanning() == false) goto L11;
        stopScan();
        if (this.mHandler == null) goto L7;
        this.mHandler = null;
    L7:
        HandlerThread r8 = this.mHandlerThread;
        if (r8 == null) goto L12;
        r8.quitSafely();
        this.mHandlerThread = null;
        return;
    L12:
        return;
    }

    @SuppressLint({"MissingPermission"})
    public boolean enableNotification(BluetoothDevice r8, ParcelUuid r10) {
        BluetoothGatt r11 = this.mBluetoothGattMap.get(r8);
        if (r11 == null) goto L20;
        if (r10 == null) goto L22;
        Iterator<BluetoothGattService> r12 = r11.getServices().iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        BluetoothGattCharacteristic r13 = r12.next().getCharacteristic(r10.getUuid());
        if (r13 == null) goto L8;
    L14:
        if ((r13.getProperties() & 16) <= 0) goto L21;
        r11.setCharacteristicNotification(r13, true);
        BluetoothGattDescriptor r14 = r13.getDescriptor(BluetoothLeManager.CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID.getUuid());
        r14.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        r11.writeDescriptor(r14);
        return true;
    L21:
        return false;
    L12:
        r13 = null;
        goto L14
    L22:
        return false;
    L20:
        return false;
    }

    public void registerGattCentralCallback(BluetoothGattCentralCallback r8) {
        this.mGattCentralCallback = r8;
    }

    public boolean startScan(ScanSettings r8) {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") == true) goto L6;
        LogUtil.e(TAG, "Attempted start scanning, but system does not support BLE. Ignoring");
        return false;
    L6:
        LogUtil.d(TAG, "start Scanning.");
        this.mScannerStartCount = 0;
        this.mScanSettings = r8;
        updateScannerState(1);
        startInternally(r8);
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public boolean stopScan() {
        LogUtil.d(TAG, "Attempting to stop scanning");
        BluetoothLeScanner r8 = this.mScanner;
        if (r8 == null) goto L6;
        r8.stopScan(this.mInternalScanCallback);
        updateScannerState(0);
        return true;
    L6:
        return false;
    }

    public void unregisterGattCentralCallback(BluetoothGattCentralCallback r8) {
        if (this.mGattCentralCallback != r8) goto L7;
        this.mGattCentralCallback = null;
        return;
    L7:
        throw new IllegalArgumentException("unregister callback is not same as registered.");
    }

    @SuppressLint({"MissingPermission"})
    public boolean centralConnect(BluetoothDevice r8, boolean r10, int r11, int r12) {
        if (r8 == null) goto L5;
        this.mBluetoothGattMap.put(r8, r8.connectGatt(this.mContext, r10, this.mInternalGattCallback, r11, r12));
        return true;
    L5:
        return false;
    }
}
