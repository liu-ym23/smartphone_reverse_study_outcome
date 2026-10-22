package com.bytedance.bdlocation.provider;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.trace.LocateState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBpeaProvider implements IBPEALocal {
    public DefaultBpeaProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void addGpsStatusListener(LocationManager r1, GpsStatus.Listener r2, Object r3) {
        GpsStatus.Listener r0 = (GpsStatus.Listener) ZeusTransformUtils.wrapperContextForParams(r2, GpsStatus.Listener.class, "com.obric.memorydata.plugin");
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L6
        Logger.i("LocationPrivacy API addGpsStatusListener");     // Catch: Throwable -> L6
        r1.addGpsStatusListener(r0);     // Catch: Throwable -> L6
        LocateState.privacyMethodExecuteSubtract();
        return;
    L6:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void bluetoothStartScan(BluetoothLeScanner r2, List<ScanFilter> r3, ScanSettings r4, ScanCallback r5, Object r6) {
        List<ScanFilter> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L13:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L10
        Logger.i("LocationPrivacy API bluetooth StartScan");     // Catch: Throwable -> L10
        r2.startScan(r1, r4, r5);     // Catch: Throwable -> L10
        LocateState.privacyMethodExecuteSubtract();
        return;
    L10:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    L5:
        if (PermissionManager.hasBluetoothPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L13;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public BPEACertCheckResult checkAndTranslateCert(Object r1, String r2) {
        return new BPEACertCheckResult();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getAddress(BluetoothDevice r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        String r0 = r1.getAddress();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public List<CellInfo> getAllCellInfo(TelephonyManager r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getAllCellInfo");     // Catch: Throwable -> L5
        List<CellInfo> r0 = r1.getAllCellInfo();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBSSID(WifiInfo r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBSSID");     // Catch: Throwable -> L5
        String r0 = r1.getBSSID();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationId(CdmaCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationId");     // Catch: Throwable -> L5
        int r0 = r1.getBaseStationId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLatitude(CdmaCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationLatitude");     // Catch: Throwable -> L5
        int r0 = r1.getBaseStationLatitude();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLongitude(CdmaCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationLongitude");     // Catch: Throwable -> L5
        int r0 = r1.getBaseStationLongitude();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Object getBpeaCert(String r1) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBpeaToken(Object r1) {
        return "DefaultBpeaProvider";
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public CellLocation getCellLocation(TelephonyManager r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getCellLocation");     // Catch: Throwable -> L5
        CellLocation r0 = r1.getCellLocation();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getCid(GsmCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getCid");     // Catch: Throwable -> L5
        int r0 = r1.getCid();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public WifiInfo getConnectionInfo(WifiManager r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getConnectionInfo");     // Catch: Throwable -> L5
        WifiInfo r0 = r1.getConnectionInfo();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Sensor getDefaultSensor(SensorManager r1, int r2, Object r3) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API sensor getDefaultSensor");     // Catch: Throwable -> L5
        Sensor r0 = r1.getDefaultSensor(r2);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getLac(GsmCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getLac");     // Catch: Throwable -> L5
        int r0 = r1.getLac();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Location getLastKnownLocation(LocationManager r1, String r2, Object r3) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getLastKnownLocation");     // Catch: Throwable -> L5
        Location r0 = r1.getLastKnownLocation(r2);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getNetworkId(CdmaCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getNetworkId");     // Catch: Throwable -> L5
        int r0 = r1.getNetworkId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getPsc(GsmCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getPsc");     // Catch: Throwable -> L5
        int r0 = r1.getPsc();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getSSID(WifiInfo r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getSSID");     // Catch: Throwable -> L5
        String r0 = r1.getSSID();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public List<ScanResult> getScanResults(WifiManager r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getScanResults");     // Catch: Throwable -> L5
        List<ScanResult> r0 = r1.getScanResults();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getSystemId(CdmaCellLocation r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getSystemId");     // Catch: Throwable -> L5
        int r0 = r1.getSystemId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getTac(CellIdentityLte r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getTac");     // Catch: Throwable -> L5
        int r0 = r1.getTac();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void registerGnssStatusCallback(LocationManager r1, GnssStatus.Callback r2, Object r3) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API registerGnssStatusCallback");     // Catch: Throwable -> L5
        r1.registerGnssStatusCallback(r2);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestCellInfoUpdate(TelephonyManager r1, Executor r2, TelephonyManager.CellInfoCallback r3, Object r4) {
        Executor r0 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L6
        Logger.i("LocationPrivacy API requestCellInfoUpdate");     // Catch: Throwable -> L6
        r1.requestCellInfoUpdate(r0, r3);     // Catch: Throwable -> L6
        LocateState.privacyMethodExecuteSubtract();
        return;
    L6:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestLocationUpdates(LocationManager r8, String r9, long r10, float r12, LocationListener r13, Looper r14, Object r15) {
        LocationListener r5 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r13, LocationListener.class, "com.obric.memorydata.plugin");
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L6
        Logger.i("LocationPrivacy API requestLocationUpdates");     // Catch: Throwable -> L6
        r8.requestLocationUpdates(r9, r10, r12, r5, r14);     // Catch: Throwable -> L6
        LocateState.privacyMethodExecuteSubtract();
        return;
    L6:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4, Object r5) {
        LocationListener r0 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r3, LocationListener.class, "com.obric.memorydata.plugin");
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L6
        Logger.i("LocationPrivacy API requestSingleUpdate");     // Catch: Throwable -> L6
        r1.requestSingleUpdate(r2, r0, r4);     // Catch: Throwable -> L6
        LocateState.privacyMethodExecuteSubtract();
        return;
    L6:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean startDiscovery(BluetoothAdapter r2, Object r3) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L14:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L11
        Logger.i("LocationPrivacy API bluetooth startDiscovery");     // Catch: Throwable -> L11
        boolean r1 = r2.startDiscovery();     // Catch: Throwable -> L11
        LocateState.privacyMethodExecuteSubtract();
        return r1;
    L11:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    L5:
        if (PermissionManager.hasBluetoothPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L14;
        return false;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean startLeScan(BluetoothAdapter r2, BluetoothAdapter.LeScanCallback r3, Object r4) {
        BluetoothAdapter.LeScanCallback r1 = (BluetoothAdapter.LeScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, BluetoothAdapter.LeScanCallback.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L14:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L11
        Logger.i("LocationPrivacy API bluetooth startLeScan");     // Catch: Throwable -> L11
        boolean r5 = r2.startLeScan(r1);     // Catch: Throwable -> L11
        LocateState.privacyMethodExecuteSubtract();
        return r5;
    L11:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    L5:
        if (PermissionManager.hasBluetoothPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L14;
        return false;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean wifiStartScan(WifiManager r1, Object r2) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API wifiStartScan");     // Catch: Throwable -> L5
        boolean r0 = r1.startScan();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r0;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }
}
