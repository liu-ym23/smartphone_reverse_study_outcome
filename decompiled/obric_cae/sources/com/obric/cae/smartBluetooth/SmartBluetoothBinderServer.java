package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapterExt;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.UserManager;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.BluetoothDeviceInfoExt;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothBinderServer extends ICaeBluetoothExporter.Stub {
    private static final String CAE_BT_ACCESS_PERM = "com.obric.cae.permission.BT_CLIENT_ACCESS_PERMISSION";
    private static final String CAE_BT_ACCESS_PERM_ERROR = "BT_ACCESS permission required";
    private static final String INTEROP_DISABLE_ABSOLUTE_VOLUME = "INTEROP_DISABLE_ABSOLUTE_VOLUME";
    private static final String TAG = "SmartBluetoothBinderServer";
    private final Context mContext;
    private SmartBluetoothService mService;

    public SmartBluetoothBinderServer(SmartBluetoothService r8, Context r10) {
        this.mService = r8;
        this.mContext = r10;
    }

    public void cleanup() {
        this.mService = null;
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public boolean disableBle() {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L7;
        CaeLog.e(TAG, "disableBle: adapter is null");
        return false;
    L7:
        if (r8.isLeEnabled() == true) goto L12;
        String r10 = TAG;
        String r11 = "disableBle: BLE is already unavailable";
    L9:
        CaeLog.d(r10, r11);
        return true;
    L12:
        if (r8.isEnabled() == false) goto L14;
        r10 = TAG;
        r11 = "disableBle: classic Bluetooth is enabled, skip BLE-only disable";
        goto L9
    L14:
        CaeLog.d(TAG, "disableBle: Requesting BLE-only mode off");
        return r8.disableBLE();
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public boolean enableBle() {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L7;
        CaeLog.e(TAG, "enableBle: adapter is null");
        return false;
    L7:
        if (CaeUtil.isBleAlwaysOnSupported(this.mContext) == true) goto L10;
        CaeLog.w(TAG, "enableBle: BLE always-on is not supported");
        return false;
    L10:
        UserManager r10 = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (r10 == null) goto L17;
        if (r10.hasUserRestriction("no_bluetooth") == false) goto L17;
        CaeLog.w(TAG, "enableBle: BT disallowed by policy");
        return false;
    L17:
        if (r8.isEnabled() == false) goto L19;
    L23:
        CaeLog.d(TAG, "enableBle: BLE is already available");
        return true;
    L19:
        if (r8.isLeEnabled() == true) goto L23;
        CaeLog.d(TAG, "enableBle: Requesting BLE-only mode");
        return r8.enableBLE();
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 == null) goto L5;
        BluetoothDeviceInfoExt r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothDeviceInfoExt();
        if (r10 == null) goto L11;
        return r10.getDeviceType(r8);
    L11:
        return new BtDeviceInfoExtEvent(r8, 0);
    L5:
        return new BtDeviceInfoExtEvent(null, 0);
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public int getProductId(BluetoothDevice r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L5;
        return 0;
    L5:
        BluetoothDeviceInfoExt r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothDeviceInfoExt();
        if (r10 != null) goto L8;
        return 0;
    L8:
        return r10.getProductId(r8);
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public boolean isAbsoluteVolumeSupported(BluetoothDevice r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "isAbsoluteVolumeSupported: device is null");
        return false;
    L6:
        BluetoothManager r10 = (BluetoothManager) this.mContext.getSystemService(BluetoothManager.class);
        if (r10 != null) goto L9;
        BluetoothAdapter r11 = null;
    L10:
        if (r11 != null) goto L23;
        CaeLog.e(TAG, "isAbsoluteVolumeSupported: adapter is null");
        return false;
    L23:
        BluetoothAdapterExt r12 = r11.getBluetoothExtAdapter();     // Catch: RuntimeException -> L20
        if (r12 != null) goto L19;
        CaeLog.e(TAG, "isAbsoluteVolumeSupported: bluetooth ext adapter is null");     // Catch: RuntimeException -> L20
        return false;
    L19:
        return !r12.getBluetoothInteropSupportState(r8, INTEROP_DISABLE_ABSOLUTE_VOLUME);
    L20:
        e = move-exception;
        CaeLog.e(TAG, "isAbsoluteVolumeSupported failed: " + e);
        return false;
    L9:
        r11 = r10.getAdapter();
        goto L10
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public void registerEventCallback(ICaeBluetoothCallbackExporter r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "registerEventCallback: callback is null");
        return;
    L6:
        BluetoothDeviceInfoExt r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothDeviceInfoExt();
        if (r10 == null) goto L10;
        r10.registerCaeBluetoothCallback(r8);
        return;
    }

    @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r8) {
        this.mContext.enforceCallingOrSelfPermission(CAE_BT_ACCESS_PERM, CAE_BT_ACCESS_PERM_ERROR);
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "unregisterEventCallback: callback is null");
        return;
    L6:
        BluetoothDeviceInfoExt r10 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothDeviceInfoExt();
        if (r10 == null) goto L10;
        r10.unregisterCaeBluetoothCallback(r8);
        return;
    }
}
