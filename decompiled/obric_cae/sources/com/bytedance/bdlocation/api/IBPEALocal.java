package com.bytedance.bdlocation.api;

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
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface IBPEALocal extends IManager {
    void addGpsStatusListener(LocationManager r8, GpsStatus.Listener r10, Object r11);

    void bluetoothStartScan(BluetoothLeScanner r8, List<ScanFilter> r10, ScanSettings r11, ScanCallback r12, Object r13);

    BPEACertCheckResult checkAndTranslateCert(Object r8, String r10);

    String getAddress(BluetoothDevice r8, Object r10);

    List<CellInfo> getAllCellInfo(TelephonyManager r8, Object r10);

    String getBSSID(WifiInfo r8, Object r10);

    int getBaseStationId(CdmaCellLocation r8, Object r10);

    int getBaseStationLatitude(CdmaCellLocation r8, Object r10);

    int getBaseStationLongitude(CdmaCellLocation r8, Object r10);

    Object getBpeaCert(String r8);

    String getBpeaToken(Object r8);

    CellLocation getCellLocation(TelephonyManager r8, Object r10);

    int getCid(GsmCellLocation r8, Object r10);

    WifiInfo getConnectionInfo(WifiManager r8, Object r10);

    Sensor getDefaultSensor(SensorManager r8, int r10, Object r11);

    int getLac(GsmCellLocation r8, Object r10);

    Location getLastKnownLocation(LocationManager r8, String r10, Object r11);

    int getNetworkId(CdmaCellLocation r8, Object r10);

    int getPsc(GsmCellLocation r8, Object r10);

    String getSSID(WifiInfo r8, Object r10);

    List<ScanResult> getScanResults(WifiManager r8, Object r10);

    int getSystemId(CdmaCellLocation r8, Object r10);

    int getTac(CellIdentityLte r8, Object r10);

    void registerGnssStatusCallback(LocationManager r8, GnssStatus.Callback r10, Object r11);

    void requestCellInfoUpdate(TelephonyManager r8, Executor r10, TelephonyManager.CellInfoCallback r11, Object r12);

    void requestLocationUpdates(LocationManager r8, String r10, long r11, float r12, LocationListener r13, Looper r14, Object r15);

    void requestSingleUpdate(LocationManager r8, String r10, LocationListener r11, Looper r12, Object r13);

    boolean startDiscovery(BluetoothAdapter r8, Object r10);

    boolean startLeScan(BluetoothAdapter r8, BluetoothAdapter.LeScanCallback r10, Object r11);

    boolean wifiStartScan(WifiManager r8, Object r10);
}
