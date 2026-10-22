package com.bytedance.bdlocation.permission;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.a;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PermissionManager {
    public static int BLUETOOTH_PERMISSION_NO = 71;
    public static int BLUETOOTH_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_NO = 71;
    public static int LOCATION_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_UNKNOWN;

    public PermissionManager() {
    }

    public static boolean canRequestLocationPermission() {
        LocationCache r8 = LocationCache.getInstance();
        if ((System.currentTimeMillis() - r8.getLocationDenyTime()) <= 172800000) goto L6;
        return true;
    L6:
        return false;
    }

    public static int checkBluetoothPermissions(Context r8) {
        if (hasAnyPermission(r8, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}) == false) goto L8;
        return BLUETOOTH_PERMISSION_OK;
    L8:
        return BLUETOOTH_PERMISSION_NO;
    L10:
        return BLUETOOTH_PERMISSION_NO;
    }

    public static int checkBluetoothScanPermission(Context r8) {
        if (LocationUtil.getTargetSdkVersion() < 31) goto L13;
        if (a.a(r8, "android.permission.BLUETOOTH_SCAN") != 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L11;
        return BLUETOOTH_PERMISSION_OK;
    L11:
        return BLUETOOTH_PERMISSION_NO;
    L7:
        r10 = false;
        goto L8
    L13:
        return BLUETOOTH_PERMISSION_OK;
    }

    public static int checkLocationPermissions(Context r8) {
        return checkLocationPermissions(r8, false);
    }

    private static boolean checkPermissions(Context r8, boolean r10, String... r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        String r14 = r11[r13];
        if (TextUtils.isEmpty(r14) == true) goto L10;
        if (checkSelfPermissionWrapper(r10, r8, r14) != 0) goto L10;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    private static int checkSelfPermissionWrapper(boolean r8, Context r10, String r11) {
        if (r8 == false) goto L6;
        return forceUseSystemCheckSelfPermission(r10, r11);
    L6:
        return a.a(r10, r11);
    }

    private static int forceUseSystemCheckSelfPermission(Context r8, String r10) {
        if (r8 != null) goto L4;
        return -1;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        IPermissionChecker r11 = BDLocationConfig.getPermissionChecker();
        if (r11 == null) goto L11;
        return r11.systemCheckSelfPermission(r8, r10);
    L11:
        return a.a(r8, r10);
    L14:
        return -1;
    }

    public static int getBackgroundLocationPermissionStatus(Context r8) {
        if (r8 == null) goto L12;
    L9:
        e = move-exception;
        Logger.e("getBackgroundLocationPermissionStatus error", e);
        goto L12
    L4:
        if (a.a(r8, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L8;
        return LOCATION_PERMISSION_OK;
    L8:
        return LOCATION_PERMISSION_NO;
    L12:
        return LOCATION_PERMISSION_UNKNOWN;
    }

    private static List<String> getDeniedPermissions(Context r8, boolean r10, String... r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r11[r14];
        if (checkSelfPermissionWrapper(r10, r8, r15) != (-1)) goto L10;
        r12.add(r15);
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        return r12;
    }

    public static boolean hasAnyPermission(Context r8, LocationTraceLogger r10, String... r11) {
        LocationMonitor.locationTraceLogBegin(r10, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        boolean r12 = hasAnyPermission(r8, false, r11);
        LocationMonitor.locationTraceLogEnd(r10, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        return r12;
    }

    public static boolean hasBluetoothPermissions(Context r8) {
        if (checkBluetoothPermissions(r8) != BLUETOOTH_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasLocationPermissions(Context r8) {
        if (checkLocationPermissions(r8) != LOCATION_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isApproximateLocation(Context r8) {
        return isApproximateLocation(r8, false);
    }

    public static int checkLocationPermissions(Context r8, boolean r10) {
        if (hasAnyPermission(r8, r10, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L8;
        return LOCATION_PERMISSION_OK;
    L8:
        return LOCATION_PERMISSION_NO;
    L10:
        return LOCATION_PERMISSION_NO;
    }

    public static boolean hasAnyPermission(Context r8, boolean r10, String... r11) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return checkPermissions(r8, r10, r11);
    }

    public static boolean isApproximateLocation(Context r8, boolean r10) {
        boolean r11 = hasAnyPermission(r8, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        boolean r12 = hasAnyPermission(r8, new String[]{"android.permission.ACCESS_COARSE_LOCATION"});
        Logger.i("PermissionManager isApproximateLocation coarseLocationPermission:" + r12 + "--fineLocationPermission:" + r11);
        if (r12 == false) goto L7;
        if (r11 == true) goto L7;
        return true;
    L7:
        if (r10 == false) goto L9;
    L19:
        return false;
    L9:
        if (BDLocationConfig.enableDimLocationCheck() == false) goto L19;
        if (LocationUtil.isTargetBrand(DimLocationCheckUtil.XIAOMI) == false) goto L13;
    L14:
        Logger.i("PermissionManager isApproximateLocation getDimLocationState:" + DimLocationCheckUtil.getDimLocationState());
        if (DimLocationCheckUtil.getDimLocationState() != 1) goto L18;
        return true;
    L18:
        return false;
    L13:
        if (LocationUtil.isTargetBrand(DimLocationCheckUtil.VIVO) == false) goto L19;
        goto L14
    }

    public static boolean hasAnyPermission(Context r8, String... r10) {
        return hasAnyPermission(r8, false, r10);
    }

    public static boolean hasAnyPermission(String... r8) {
        return hasAnyPermission(BDLocationConfig.getContext(), r8);
    }
}
