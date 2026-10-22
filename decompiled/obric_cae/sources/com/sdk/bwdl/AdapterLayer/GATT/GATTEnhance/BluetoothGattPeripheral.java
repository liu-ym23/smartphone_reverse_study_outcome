package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelUuid;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothGattPeripheral {
    private static final int ADD_SERVICE_WAIT_TIMEOUT_MS = 1000;
    private static final int ADVERTISING = 2;
    private static final int ADV_START_RETRY_INTERVAL_MS = 1000;
    private static final int ADV_START_RETRY_LIMIT = 5;
    private static final int GATT_SERVER_RETRY_DELAY_MS = 200;
    private static final int GATT_SERVER_RETRY_LIMIT = 10;
    private static final int STARTED = 1;
    private static final int STOPPED = 0;
    private static final String TAG = "BluetoothGattPeripheral";
    private AdvertiseData mAdvertiseData;
    private AdvertiseSettings mAdvertiseSettings;
    private AtomicInteger mAdvertiseState;
    private BluetoothLeAdvertiser mAdvertiser;
    private int mAdvertiserStartCount;
    private final BluetoothManager mBluetoothManager;
    private Context mContext;
    private BluetoothGattPeripheralCallback mGattPeripheralCallback;
    private final AtomicReference<BluetoothGattServer> mGattServer;
    private int mGattServerRetryStartCount;
    private final List<BluetoothGattService> mGattServices;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final AdvertiseCallback mInternalAdvertiseCallback;
    private final BluetoothGattServerCallback mInternalGattServerCallback;
    private AdvertiseData mScanResponse;

    /* JADX INFO: renamed from: com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothGattPeripheral$1, reason: invalid class name */
    public class AnonymousClass1 extends AdvertiseCallback {
        final /* synthetic */ BluetoothGattPeripheral this$0;

        public AnonymousClass1(BluetoothGattPeripheral r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8) {
            r8.lambda$onStartFailure$0();
        }

        private /* synthetic */ void lambda$onStartFailure$0() {
            if (BluetoothGattPeripheral.access$300(this.this$0) != null) goto L5;
            return;
        L5:
            if (BluetoothGattPeripheral.access$400(this.this$0) == null) goto L9;
            BluetoothGattPeripheral r8 = this.this$0;
            BluetoothGattPeripheral.access$600(r8, BluetoothGattPeripheral.access$300(r8), BluetoothGattPeripheral.access$400(this.this$0), BluetoothGattPeripheral.access$500(this.this$0));
            return;
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int r8) {
            if (BluetoothGattPeripheral.access$100(this.this$0) < 5) goto L8;
            LogUtil.e(BluetoothGattPeripheral.TAG, "Cannot start BLE Advertise. Advertising Retry count: " + BluetoothGattPeripheral.access$100(this.this$0));
            if (BluetoothGattPeripheral.access$000(this.this$0) == null) goto L15;
            BluetoothGattPeripheral.access$000(this.this$0).onStartFailed(r8);
            return;
        L15:
            return;
        L8:
            BluetoothGattPeripheral.access$108(this.this$0);
            LogUtil.w(BluetoothGattPeripheral.TAG, "BLE Advertise failed to start. Error: " + r8 + " Retry: " + BluetoothGattPeripheral.access$100(this.this$0));
            if (r8 != 2) goto L11;
        L13:
            BluetoothGattPeripheral.access$200(this.this$0).postDelayed(new a(this, 1), 1000);
            return;
        L11:
            if (r8 == 4) goto L13;
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings r8) {
            LogUtil.d(BluetoothGattPeripheral.TAG, "onStartSuccess");
            if (BluetoothGattPeripheral.access$000(this.this$0) == null) goto L6;
            BluetoothGattPeripheral.access$000(this.this$0).onStartSuccess();
            return;
        }
    }

    public @interface AdvertiseState {
    }

    public BluetoothGattPeripheral(Context r8) {
        this.mGattServer = new AtomicReference();
        this.mGattServices = new ArrayList();
        this.mAdvertiseState = new AtomicInteger(0);
        this.mInternalAdvertiseCallback = new AnonymousClass1(this);
        this.mInternalGattServerCallback = new AnonymousClass2(this);
        this.mContext = r8;
        this.mBluetoothManager = (BluetoothManager) r8.getSystemService(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_BT);
        HandlerThread r10 = new HandlerThread("GattPeripheral");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public static /* synthetic */ void a(BluetoothGattPeripheral r8, BluetoothGattService[] r10) {
        r8.lambda$openGattServer$0(r10);
    }

    public static /* synthetic */ BluetoothGattPeripheralCallback access$000(BluetoothGattPeripheral r8) {
        return r8.mGattPeripheralCallback;
    }

    public static /* synthetic */ int access$100(BluetoothGattPeripheral r8) {
        return r8.mAdvertiserStartCount;
    }

    public static /* synthetic */ int access$108(BluetoothGattPeripheral r8) {
        int r10 = r8.mAdvertiserStartCount;
        r8.mAdvertiserStartCount = r10 + 1;
        return r10;
    }

    public static /* synthetic */ Handler access$200(BluetoothGattPeripheral r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ AdvertiseSettings access$300(BluetoothGattPeripheral r8) {
        return r8.mAdvertiseSettings;
    }

    public static /* synthetic */ AdvertiseData access$400(BluetoothGattPeripheral r8) {
        return r8.mAdvertiseData;
    }

    public static /* synthetic */ AdvertiseData access$500(BluetoothGattPeripheral r8) {
        return r8.mScanResponse;
    }

    public static /* synthetic */ void access$600(BluetoothGattPeripheral r8, AdvertiseSettings r10, AdvertiseData r11, AdvertiseData r12) {
        r8.startInternally(r10, r11, r12);
    }

    public static /* synthetic */ List access$700(BluetoothGattPeripheral r8) {
        return r8.mGattServices;
    }

    public static /* synthetic */ int access$802(BluetoothGattPeripheral r8, int r10) {
        r8.mGattServerRetryStartCount = r10;
        return r10;
    }

    public static /* synthetic */ AtomicReference access$900(BluetoothGattPeripheral r8) {
        return r8.mGattServer;
    }

    public static /* synthetic */ void b(BluetoothGattPeripheral r8, AdvertiseSettings r10, AdvertiseData r11, AdvertiseData r12) {
        r8.lambda$startInternally$1(r10, r11, r12);
    }

    @SuppressLint({"MissingPermission"})
    private boolean cancelOpen(BluetoothDevice r8) {
        BluetoothGattServer r10 = this.mGattServer.get();
        if (r10 != null) goto L6;
        return false;
    L6:
        r10.cancelConnection(r8);
        return true;
    }

    private boolean isAdvertising() {
        if (this.mAdvertiseState.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$openGattServer$0(BluetoothGattService[] r8) {
        openGattServer(r8);
    }

    private /* synthetic */ void lambda$startInternally$1(AdvertiseSettings r8, AdvertiseData r10, AdvertiseData r11) {
        LogUtil.w(TAG, "Advertise unavailable. Trying again.");
        startInternally(r8, r10, r11);
    }

    @SuppressLint({"MissingPermission"})
    private boolean notifyCharacteristicChanged(BluetoothDevice r8, ParcelUuid r10, byte[] r11, boolean r12) {
        BluetoothGattServer r13 = this.mGattServer.get();
        if (r13 != null) goto L6;
        return false;
    L6:
        if (this.mGattServices.isEmpty() == true) goto L21;
        Iterator<BluetoothGattService> r14 = r13.getServices().iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        BluetoothGattCharacteristic r15 = r14.next().getCharacteristic(r10.getUuid());
        if (r15 == null) goto L9;
    L14:
        if (r15 == null) goto L21;
        r15.setValue(r11);
        if (r13.notifyCharacteristicChanged(r8, r15, r12) == true) goto L19;
        LogUtil.d(TAG, "notifyCharacteristicChanged failed.");
        return false;
    L19:
        return true;
    L13:
        r15 = null;
    L21:
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private void startInternally(AdvertiseSettings r10, AdvertiseData r11, AdvertiseData r12) {
        if (this.mAdvertiser == null) goto L5;
    L7:
        BluetoothLeAdvertiser r8 = this.mAdvertiser;
        if (r8 == null) goto L10;
        r8.startAdvertising(r10, r11, r12, this.mInternalAdvertiseCallback);
        updateAdvertiseState(2);
        return;
    L10:
        this.mHandler.postDelayed(new com.obric.cae.statusReport.wifi.a(this, r10, r11, r12, 1), 1000);
        return;
    L5:
        if (BluetoothAdapter.getDefaultAdapter() == null) goto L7;
        this.mAdvertiser = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
        goto L7
    }

    private void updateAdvertiseState(@AdvertiseState int r8) {
        this.mAdvertiseState.set(r8);
    }

    public void cleanup() {
        if (isAdvertising() == false) goto L11;
        stopAdvertising();
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
    public void closeGattServer() {
        if (this.mGattServer != null) goto L5;
        return;
    L5:
        LogUtil.d(TAG, "closeGattServer");
        this.mGattServer.set(null);
    }

    @SuppressLint({"MissingPermission"})
    public boolean openGattServer(BluetoothGattService... r8) {
        BluetoothGattServer r10 = this.mGattServer.get();
        BluetoothAdapter r11 = BluetoothAdapter.getDefaultAdapter();
        int r12 = 0;
        if (r11 != null) goto L5;
    L19:
        LogUtil.d(TAG, "adapter is not enable ");
        return false;
    L5:
        if (r11.isEnabled() == false) goto L19;
        if (r10 == null) goto L13;
        LogUtil.d(TAG, "Gatt Server created, retry count: " + this.mGattServerRetryStartCount);
        int r13 = r8.length;
    L10:
        if (r12 >= r13) goto L18;
        r10.addService(r8[r12]);
        r12 = r12 + 1;
    L18:
        return true;
    L13:
        if (this.mGattServerRetryStartCount < 10) goto L15;
        LogUtil.d(TAG, "Gatt server not created - exceeded retry limit.");
        goto L18
    L15:
        if (this.mGattPeripheralCallback == null) goto L18;
        this.mGattServer.set(this.mBluetoothManager.openGattServer(this.mContext, this.mInternalGattServerCallback));
        this.mGattServerRetryStartCount++;
        this.mHandler.postDelayed(new x(11, this, r8), 200);
        goto L18
    }

    public boolean peripheralCancelOpen(BluetoothDevice r8) {
        return cancelOpen(r8);
    }

    public boolean peripheralCharacteristicNotify(BluetoothDevice r8, ParcelUuid r10, byte[] r11, boolean r12) {
        return notifyCharacteristicChanged(r8, r10, r11, r12);
    }

    public void registerGattPeripheralCallback(BluetoothGattPeripheralCallback r8) {
        this.mGattPeripheralCallback = r8;
    }

    public boolean startAdvertising(AdvertiseSettings r8, AdvertiseData r10, AdvertiseData r11) {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") == true) goto L6;
        LogUtil.e(TAG, "Attempted start scanning, but system does not support BLE. Ignoring");
        return false;
    L6:
        LogUtil.d(TAG, "start Advertising.");
        this.mAdvertiserStartCount = 0;
        this.mAdvertiseSettings = r8;
        this.mAdvertiseData = r10;
        this.mScanResponse = r11;
        updateAdvertiseState(1);
        startInternally(r8, r10, r11);
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean stopAdvertising() {
        LogUtil.d(TAG, "Attempting to stop advertising");
        BluetoothLeAdvertiser r8 = this.mAdvertiser;
        if (r8 == null) goto L6;
        r8.stopAdvertising(this.mInternalAdvertiseCallback);
        updateAdvertiseState(0);
        return true;
    L6:
        return false;
    }

    public void unregisterGattPeripheralCallback(BluetoothGattPeripheralCallback r8) {
        if (this.mGattPeripheralCallback != r8) goto L7;
        this.mGattPeripheralCallback = null;
        return;
    L7:
        throw new IllegalArgumentException("unregister callback is not same as registered.");
    }
}
