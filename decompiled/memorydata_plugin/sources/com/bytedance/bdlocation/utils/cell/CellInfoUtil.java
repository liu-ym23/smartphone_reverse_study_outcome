package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CellInfoUtil {
    public CellInfoUtil() {
    }

    public static List<CellInfo> getAllCellInfo(Context r2, TelephonyManager r3, Object r4, boolean r5, boolean r6, RefreshBaseStationInfo r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L7;
        return getAllCellInfoBeforeInit(r8, r3);
    L7:
        return getAllCellInfoAfterInit(r3, r4, r5, r7);
    }

    public static List<CellInfo> getAllCellInfoAfterInit(TelephonyManager r3, Object r4, boolean r5, RefreshBaseStationInfo r6) {
        List<CellInfo> r0 = null;
        if (r3 != null) goto L16;
        return null;
    L16:
    L14:
        Logger.e("LocationInfoCollector#getAllCellInfo occur throwable !");
        return r0;
    L6:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L18;
        requestCellInfoUpdate(r3, r4, r5, r6);     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        return null;
    L11:
        if (Build.VERSION.SDK_INT < 17) goto L19;
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L14
        r0 = BDLocationExtrasService.getBPEAManager().getAllCellInfo(r3, r4);     // Catch: Throwable -> L14
        Logger.i("getAllCellInfo duration:" + (System.currentTimeMillis() - r7));     // Catch: Throwable -> L14
        return r0;
    L19:
        return null;
    L18:
        return null;
    }

    private static List<CellInfo> getAllCellInfoBeforeInit(Context r2, TelephonyManager r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L7:
        Logger.e("getAllCellInfoBeforeInit#getAllCellInfo occur throwable !");
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 17) goto L12;
        return r3.getAllCellInfo();
    L12:
        return null;
    }

    public static CellLocation getCellLocation(Context r2, TelephonyManager r3, Object r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r5 == false) goto L8;
        return r3.getCellLocation();
    L8:
        if (PermissionManager.hasAnyPermission(r6, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getCellLocation(r3, r4);
    }

    private static void requestCellInfoUpdate(TelephonyManager r4, final Object r5, boolean r6, final RefreshBaseStationInfo r7) {
        if (r6 == true) goto L4;
    L6:
        if (r7 != null) goto L13;
        return;
    L13:
        r7.setRequestCellInfoResult(3);     // Catch: Exception -> L10
        r7.downLatch.countDown();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.e("requestCellInfoUpdate occur exception!", e);
        return;
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L6;
        final long r0 = System.currentTimeMillis();
        BDLocationExtrasService.getBPEAManager().requestCellInfoUpdate(r4, AppExecutors.getInstance().networkIO(), new AnonymousClass1(r0, r7, r5), r5);
    }
}
