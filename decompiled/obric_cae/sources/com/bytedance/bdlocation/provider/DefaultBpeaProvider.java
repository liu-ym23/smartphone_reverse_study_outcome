package com.bytedance.bdlocation.provider;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
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
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBpeaProvider implements IBPEALocal {
    public DefaultBpeaProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void addGpsStatusListener(LocationManager r8, GpsStatus.Listener r10, Object r11) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API addGpsStatusListener");     // Catch: Throwable -> L5
        r8.addGpsStatusListener(r10);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void bluetoothStartScan(BluetoothLeScanner r8, List<ScanFilter> r10, ScanSettings r11, ScanCallback r12, Object r13) {
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L11;
        return;
    L11:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L8
        Logger.i("LocationPrivacy API bluetooth StartScan");     // Catch: Throwable -> L8
        r8.startScan(r10, r11, r12);     // Catch: Throwable -> L8
        LocateState.privacyMethodExecuteSubtract();
        return;
    L8:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public BPEACertCheckResult checkAndTranslateCert(Object r8, String r10) {
        return new BPEACertCheckResult();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getAddress(BluetoothDevice r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        String r11 = r8.getAddress();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public List<CellInfo> getAllCellInfo(TelephonyManager r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getAllCellInfo");     // Catch: Throwable -> L5
        List<CellInfo> r11 = r8.getAllCellInfo();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBSSID(WifiInfo r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBSSID");     // Catch: Throwable -> L5
        String r11 = r8.getBSSID();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationId(CdmaCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationId");     // Catch: Throwable -> L5
        int r11 = r8.getBaseStationId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLatitude(CdmaCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationLatitude");     // Catch: Throwable -> L5
        int r11 = r8.getBaseStationLatitude();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLongitude(CdmaCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getBaseStationLongitude");     // Catch: Throwable -> L5
        int r11 = r8.getBaseStationLongitude();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Object getBpeaCert(String r8) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBpeaToken(Object r8) {
        return "DefaultBpeaProvider";
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public CellLocation getCellLocation(TelephonyManager r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getCellLocation");     // Catch: Throwable -> L5
        CellLocation r11 = r8.getCellLocation();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getCid(GsmCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getCid");     // Catch: Throwable -> L5
        int r11 = r8.getCid();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public WifiInfo getConnectionInfo(WifiManager r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getConnectionInfo");     // Catch: Throwable -> L5
        WifiInfo r11 = r8.getConnectionInfo();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Sensor getDefaultSensor(SensorManager r8, int r10, Object r11) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API sensor getDefaultSensor");     // Catch: Throwable -> L5
        Sensor r12 = r8.getDefaultSensor(r10);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r12;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getLac(GsmCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getLac");     // Catch: Throwable -> L5
        int r11 = r8.getLac();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Location getLastKnownLocation(LocationManager r8, String r10, Object r11) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getLastKnownLocation");     // Catch: Throwable -> L5
        Location r12 = r8.getLastKnownLocation(r10);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r12;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getNetworkId(CdmaCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getNetworkId");     // Catch: Throwable -> L5
        int r11 = r8.getNetworkId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getPsc(GsmCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getPsc");     // Catch: Throwable -> L5
        int r11 = r8.getPsc();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getSSID(WifiInfo r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getSSID");     // Catch: Throwable -> L5
        String r11 = r8.getSSID();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public List<ScanResult> getScanResults(WifiManager r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getScanResults");     // Catch: Throwable -> L5
        List<ScanResult> r11 = r8.getScanResults();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getSystemId(CdmaCellLocation r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getSystemId");     // Catch: Throwable -> L5
        int r11 = r8.getSystemId();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getTac(CellIdentityLte r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API getTac");     // Catch: Throwable -> L5
        int r11 = r8.getTac();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void registerGnssStatusCallback(LocationManager r8, GnssStatus.Callback r10, Object r11) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API registerGnssStatusCallback");     // Catch: Throwable -> L5
        r8.registerGnssStatusCallback(r10);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestCellInfoUpdate(TelephonyManager r8, Executor r10, TelephonyManager.CellInfoCallback r11, Object r12) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API requestCellInfoUpdate");     // Catch: Throwable -> L5
        r8.requestCellInfoUpdate(r10, r11);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestLocationUpdates(LocationManager r8, String r10, long r11, float r12, LocationListener r13, Looper r14, Object r15) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API requestLocationUpdates");     // Catch: Throwable -> L5
        r8.requestLocationUpdates(r10, r11, r12, r13, r14);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public void requestSingleUpdate(LocationManager r8, String r10, LocationListener r11, Looper r12, Object r13) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API requestSingleUpdate");     // Catch: Throwable -> L5
        r8.requestSingleUpdate(r10, r11, r12);     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean startDiscovery(BluetoothAdapter r8, Object r10) {
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L12;
        return false;
    L12:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L9
        Logger.i("LocationPrivacy API bluetooth startDiscovery");     // Catch: Throwable -> L9
        boolean r11 = r8.startDiscovery();     // Catch: Throwable -> L9
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L9:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean startLeScan(BluetoothAdapter r8, BluetoothAdapter.LeScanCallback r10, Object r11) {
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L12;
        return false;
    L12:
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L9
        Logger.i("LocationPrivacy API bluetooth startLeScan");     // Catch: Throwable -> L9
        boolean r12 = r8.startLeScan(r10);     // Catch: Throwable -> L9
        LocateState.privacyMethodExecuteSubtract();
        return r12;
    L9:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean wifiStartScan(WifiManager r8, Object r10) {
        LocateState.privacyMethodExecuteAdd();     // Catch: Throwable -> L5
        Logger.i("LocationPrivacy API wifiStartScan");     // Catch: Throwable -> L5
        boolean r11 = r8.startScan();     // Catch: Throwable -> L5
        LocateState.privacyMethodExecuteSubtract();
        return r11;
    L5:
        th = move-exception;
        LocateState.privacyMethodExecuteSubtract();
        throw th;
    }
}
