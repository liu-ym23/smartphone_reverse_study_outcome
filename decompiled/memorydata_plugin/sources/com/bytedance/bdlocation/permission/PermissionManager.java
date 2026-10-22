package com.bytedance.bdlocation.permission;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PermissionManager {
    public static int BLUETOOTH_PERMISSION_NO = 71;
    public static int BLUETOOTH_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_NO = 71;
    public static int LOCATION_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_UNKNOWN;

    static {
    }

    public PermissionManager() {
    }

    public static boolean canRequestLocationPermission() {
        LocationCache r0 = LocationCache.getInstance();
        if ((System.currentTimeMillis() - r0.getLocationDenyTime()) <= 172800000) goto L6;
        return true;
    L6:
        return false;
    }

    public static int checkBluetoothPermissions(Context r3) {
        if (hasAnyPermission((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}) == false) goto L8;
        return BLUETOOTH_PERMISSION_OK;
    L8:
        return BLUETOOTH_PERMISSION_NO;
    L10:
        return BLUETOOTH_PERMISSION_NO;
    }

    public static int checkBluetoothScanPermission(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (LocationUtil.getTargetSdkVersion() < 31) goto L15;
        if (Build.VERSION.SDK_INT < 31) goto L15;
        if (ContextCompat.checkSelfPermission(r3, "android.permission.BLUETOOTH_SCAN") != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        return BLUETOOTH_PERMISSION_OK;
    L13:
        return BLUETOOTH_PERMISSION_NO;
    L9:
        r4 = false;
    L15:
        return BLUETOOTH_PERMISSION_OK;
    }

    public static int checkLocationPermissions(Context r2) {
        return checkLocationPermissions((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false);
    }

    public static int checkLocationPermissions(Context r2, boolean r3) {
        if (hasAnyPermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L8;
        return LOCATION_PERMISSION_OK;
    L8:
        return LOCATION_PERMISSION_NO;
    L10:
        return LOCATION_PERMISSION_NO;
    }

    private static boolean checkPermissions(Context r6, boolean r7, String... r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L14:
        int r0 = r8.length;
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L22;
        String r4 = r8[r3];
        if (TextUtils.isEmpty(r4) == true) goto L21;
        if (checkSelfPermissionWrapper(r7, r9, r4) != 0) goto L21;
        return true;
    L21:
        r3 = r3 + 1;
        goto L15
    L22:
        return false;
    L5:
        if (BDLocationConfig.enableUseCoarseLocation() == true) goto L14;
        List<String> r10 = getDeniedPermissions(r9, r7, r8);
        if (r10 != null) goto L10;
        return true;
    L10:
        if (r10.isEmpty() == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static int checkSelfPermissionWrapper(boolean r2, Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L7;
        return forceUseSystemCheckSelfPermission(r5, r4);
    L7:
        return ContextCompat.checkSelfPermission(r5, r4);
    }

    private static int forceUseSystemCheckSelfPermission(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return -1;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        IPermissionChecker r0 = BDLocationConfig.getPermissionChecker();
        if (r0 == null) goto L12;
        return r0.systemCheckSelfPermission(r4, r3);
    L12:
        return ContextCompat.checkSelfPermission(r4, r3);
    L15:
        return -1;
    }

    public static int getBackgroundLocationPermissionStatus(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
    L12:
        e = move-exception;
        Logger.e("getBackgroundLocationPermissionStatus error", e);
        goto L15
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if (ContextCompat.checkSelfPermission(r3, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L11;
        return LOCATION_PERMISSION_OK;
    L11:
        return LOCATION_PERMISSION_NO;
    L15:
        return LOCATION_PERMISSION_UNKNOWN;
    }

    private static List<String> getDeniedPermissions(Context r6, boolean r7, String... r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        String r3 = r8[r2];
        if (checkSelfPermissionWrapper(r7, r9, r3) != (-1)) goto L11;
        r0.add(r3);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r0;
    }

    public static boolean hasAnyPermission(Context r2, LocationTraceLogger r3, String... r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        LocationMonitor.locationTraceLogBegin(r3, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        boolean r6 = hasAnyPermission(r5, false, r4);
        LocationMonitor.locationTraceLogEnd(r3, LocationMonitorConst.CHECK_LOCATION_PERMISSION_DURATION);
        return r6;
    }

    public static boolean hasAnyPermission(Context r2, boolean r3, String... r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return false;
    L7:
        return checkPermissions(r5, r3, r4);
    }

    public static boolean hasAnyPermission(Context r2, String... r3) {
        return hasAnyPermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false, r3);
    }

    public static boolean hasAnyPermission(String... r3) {
        return hasAnyPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static boolean hasBluetoothPermissions(Context r2) {
        if (checkBluetoothPermissions((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) != BLUETOOTH_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasLocationPermissions(Context r2) {
        if (checkLocationPermissions((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) != LOCATION_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isApproximateLocation(Context r2) {
        return isApproximateLocation((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false);
    }

    public static boolean isApproximateLocation(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = hasAnyPermission(r5, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        boolean r6 = hasAnyPermission(r5, new String[]{"android.permission.ACCESS_COARSE_LOCATION"});
        Logger.i("PermissionManager isApproximateLocation coarseLocationPermission:" + r6 + "--fineLocationPermission:" + r0);
        if (r6 == false) goto L7;
        if (r0 == true) goto L7;
        return true;
    L7:
        if (r4 == false) goto L9;
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
}
