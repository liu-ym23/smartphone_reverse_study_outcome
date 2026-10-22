package com.obric.cae.smartBluetooth.deviceIdentification;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.BdimPredictEvent;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimFeatureController;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BluetoothDeviceIdentificationModel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothDeviceInfoExt {
    private static final String TAG = "BluetoothDeviceInfoExt";
    private static volatile BluetoothDeviceInfoExt sInstance;
    private BdimFeatureController mBdimFeatureController;
    private BluetoothDeviceIdentificationModel mBdimModel;
    private RemoteCallbackList<ICaeBluetoothCallbackExporter> mBluetoothCallbacksExporter;
    private final Context mContext;
    private final ConcurrentMap<BluetoothDevice, BtDeviceInfoExtEvent> mDeviceTypeMap;
    private final ConcurrentMap<BluetoothDevice, Integer> mProductIdMap;

    private BluetoothDeviceInfoExt(Context r8) {
        this.mProductIdMap = new ConcurrentHashMap();
        this.mDeviceTypeMap = new ConcurrentHashMap();
        this.mContext = r8;
        this.mBluetoothCallbacksExporter = new RemoteCallbackList();
        BdimFeatureController r10 = BdimFeatureController.getInstance(r8);
        this.mBdimFeatureController = r10;
        r10.initPropertyIfNeeded();
        this.mBdimFeatureController.start();
        BluetoothDeviceIdentificationModel r11 = new BluetoothDeviceIdentificationModel();
        this.mBdimModel = r11;
        r11.initialize(r8, "device_classification_dnn.tflite");
    }

    public static BluetoothDeviceInfoExt getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BluetoothDeviceInfoExt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BluetoothDeviceInfoExt(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BluetoothDeviceInfoExt.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void notifyDeviceTypeUpdate(BtDeviceInfoExtEvent r8) {
        RemoteCallbackList<ICaeBluetoothCallbackExporter> r10 = this.mBluetoothCallbacksExporter;
        if (r10 == null) goto L19;
        monitor-enter(r10);
        int r11 = this.mBluetoothCallbacksExporter.beginBroadcast();     // Catch: Throwable -> L16
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L13;
        ((ICaeBluetoothCallbackExporter) this.mBluetoothCallbacksExporter.getBroadcastItem(r12)).onDeviceTypeUpdate(r8);     // Catch: RemoteException -> L10 Throwable -> L16
        CaeLog.d(TAG, "notifyDeviceTypeUpdate: device = " + r8.getDevice() + ", type = " + r8.getDeviceType());     // Catch: RemoteException -> L10 Throwable -> L16
    L12:
        r12 = r12 + 1;     // Catch: Throwable -> L16
    L10:
        e = move-exception;
        CaeLog.e(TAG, "Failed to notify device type update", e);     // Catch: Throwable -> L16
        goto L12
    L13:
        this.mBluetoothCallbacksExporter.finishBroadcast();     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void cleanUp() {
        RemoteCallbackList<ICaeBluetoothCallbackExporter> r8 = this.mBluetoothCallbacksExporter;
        if (r8 == null) goto L11;
        monitor-enter(r8);
        this.mBluetoothCallbacksExporter.kill();     // Catch: Throwable -> L8
        this.mBluetoothCallbacksExporter = null;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        this.mDeviceTypeMap.clear();
        this.mProductIdMap.clear();
        BdimFeatureController r10 = this.mBdimFeatureController;
        if (r10 == null) goto L14;
        r10.stop();
    L14:
        BluetoothDeviceIdentificationModel r11 = this.mBdimModel;
        if (r11 == null) goto L20;
        r11.close();
        this.mBdimModel = null;
        return;
    }

    public BluetoothDeviceIdentificationModel getBdimModel() {
        return this.mBdimModel;
    }

    @SuppressLint({"MissingPermission"})
    public void getBondedDevicesBdimInfo() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L5;
        return;
    L5:
        SmartBluetoothBinderClient r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r10 != null) goto L9;
        CaeLog.w(TAG, "binderClient is null");
        return;
    L9:
        Iterator<BluetoothDevice> r11 = r8.getBondedDevices().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        BluetoothDevice r12 = r11.next();
        BdimPredictEvent r13 = r10.getBdimEvent(r12);
        if (r13 == null) goto L11;
        CaeLog.d(TAG, "getBondedDevicesBdimInfo: got bdim event for device = " + r12);
        parseBluetoothDeviceFactors(r13);
        goto L11
    }

    @SuppressLint({"MissingPermission"})
    public void getBondedDevicesProductId() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L5;
        return;
    L5:
        SmartBluetoothBinderClient r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r10 != null) goto L9;
        CaeLog.w(TAG, "binderClient is null");
        return;
    L9:
        Iterator<BluetoothDevice> r11 = r8.getBondedDevices().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        BluetoothDevice r12 = r11.next();
        int r13 = r10.getProductId(r12);
        CaeLog.d(TAG, "getBondedDevicesProductId: productId = " + r13 + " device = " + r12);
        if (r13 == 0) goto L11;
        this.mProductIdMap.put(r12, Integer.valueOf(r13));
        goto L11
    }

    @SuppressLint({"MissingPermission"})
    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8) {
        BtDeviceInfoExtEvent r10 = this.mDeviceTypeMap.get(r8);
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (r8 != null) goto L8;
        return null;
    L8:
        SmartBluetoothBinderClient r11 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        String r12 = "";
        if (r11 == null) goto L19;
        BdimPredictEvent r13 = r11.getBdimEvent(r8);
        if (r13 == null) goto L19;
        BluetoothDeviceIdentificationModel r14 = this.mBdimModel;
        if (r14 == null) goto L19;
        int r15 = r14.predict(r13);
        BluetoothClass r16 = r8.getBluetoothClass();
        Context r17 = this.mContext;
        String r18 = r13.getActualCodType();
        if (r16 == null) goto L17;
        r12 = r16.toString();
    L17:
        int r19 = DeviceIdentificationRuleAlgorithm.resolveFinalDeviceType(r17, r8, r15, r18, r12);
        BtDeviceInfoExtEvent r20 = new BtDeviceInfoExtEvent(r8, getProductId(r8), r19);
        this.mDeviceTypeMap.put(r8, r20);
        return r20;
    L19:
        BluetoothClass r21 = r8.getBluetoothClass();
        Context r22 = this.mContext;
        if (r21 == null) goto L22;
        r12 = r21.toString();
    L22:
        int r23 = DeviceIdentificationRuleAlgorithm.getDeviceTypeFromCod(r22, r8, r12);
        return new BtDeviceInfoExtEvent(r8, getProductId(r8), r23);
    }

    public int getProductId(BluetoothDevice r8) {
        return this.mProductIdMap.getOrDefault(r8, 0).intValue();
    }

    public void onBluetoothOn() {
        BdimFeatureController r8 = this.mBdimFeatureController;
        if (r8 == null) goto L6;
        r8.start();
    L6:
        if (this.mBdimModel != null) goto L9;
        BluetoothDeviceIdentificationModel r10 = new BluetoothDeviceIdentificationModel();
        this.mBdimModel = r10;
        r10.initialize(this.mContext, "device_classification_dnn.tflite");
        return;
    }

    public void parseBluetoothDeviceFactors(BdimPredictEvent r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        CaeLog.d(TAG, "parseBluetoothDeviceFactors " + r8.getAddress());
        BluetoothDeviceIdentificationModel r10 = this.mBdimModel;
        if (r10 == null) goto L8;
        r10.predict(r8);
        return;
    }

    public void parseBluetoothDeviceInfo(BtDeviceInfoExtEvent r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getDevice() != null) goto L7;
        return;
    L7:
        if (r8.getProductId() == 0) goto L11;
        this.mProductIdMap.put(r8.getDevice(), Integer.valueOf(r8.getProductId()));
        CaeLog.d(TAG, "parseBluetoothDeviceInfo: productId = " + r8.getProductId());
        return;
    }

    public void registerCaeBluetoothCallback(ICaeBluetoothCallbackExporter r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        RemoteCallbackList<ICaeBluetoothCallbackExporter> r10 = this.mBluetoothCallbacksExporter;
        if (r10 == null) goto L13;
        monitor-enter(r10);
        this.mBluetoothCallbacksExporter.register(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void removeDevice(BluetoothDevice r8) {
        if (r8 == null) goto L5;
        this.mDeviceTypeMap.remove(r8);
        CaeLog.d(TAG, "removeDevice from map: " + r8);
        return;
    }

    @SuppressLint({"MissingPermission"})
    public void setModelPredictType(BluetoothDevice r8, int r10, String r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r12 = BluetoothDeviceIdentificationModel.getDeviceTypeName(r10);
        CaeLog.d(TAG, "setModelPredictType: device = " + r8 + ", modelType = " + r12 + ", algorithmType = " + r11);
        BluetoothClass r13 = r8.getBluetoothClass();
        Context r14 = this.mContext;
        if (r13 == null) goto L7;
        String r15 = r13.toString();
    L8:
        int r16 = DeviceIdentificationRuleAlgorithm.resolveFinalDeviceType(r14, r8, r10, r11, r15);
        BtDeviceInfoExtEvent r17 = this.mDeviceTypeMap.get(r8);
        if (r17 != null) goto L11;
    L12:
        BtDeviceInfoExtEvent r18 = new BtDeviceInfoExtEvent(r8, getProductId(r8), r16);
        this.mDeviceTypeMap.put(r8, r18);
        notifyDeviceTypeUpdate(r18);
    L13:
        SmartBluetoothBinderClient r19 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r19 == null) goto L17;
        r19.setModelPredictType(r8, r12);
        return;
    L17:
        return;
    L11:
        if (r17.getDeviceType() == r16) goto L13;
    L7:
        r15 = "";
        goto L8
    }

    public void unregisterCaeBluetoothCallback(ICaeBluetoothCallbackExporter r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        RemoteCallbackList<ICaeBluetoothCallbackExporter> r10 = this.mBluetoothCallbacksExporter;
        if (r10 == null) goto L13;
        monitor-enter(r10);
        this.mBluetoothCallbacksExporter.unregister(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
