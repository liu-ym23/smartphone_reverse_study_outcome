package com.bytedance.bdlocation.utils.cell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CellInfoUtil {
    public CellInfoUtil() {
    }

    public static List<CellInfo> getAllCellInfo(Context r8, TelephonyManager r10, Object r11, boolean r12, boolean r13, RefreshBaseStationInfo r14) {
        if (r13 == false) goto L6;
        return getAllCellInfoBeforeInit(r8, r10);
    L6:
        return getAllCellInfoAfterInit(r10, r11, r12, r14);
    }

    @SuppressLint({"MissingPermission"})
    public static List<CellInfo> getAllCellInfoAfterInit(TelephonyManager r8, Object r10, boolean r11, RefreshBaseStationInfo r12) {
        List<CellInfo> r13 = null;
        if (r8 != null) goto L15;
        return null;
    L15:
    L13:
        Logger.e("LocationInfoCollector#getAllCellInfo occur throwable !");
        return r13;
    L7:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L17;
        requestCellInfoUpdate(r8, r10, r11, r12);     // Catch: Throwable -> L13
        if (r12 == null) goto L11;
        return null;
    L11:
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L13
        r13 = BDLocationExtrasService.getBPEAManager().getAllCellInfo(r8, r10);     // Catch: Throwable -> L13
        Logger.i("getAllCellInfo duration:" + (System.currentTimeMillis() - r14));     // Catch: Throwable -> L13
        return r13;
    L17:
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static List<CellInfo> getAllCellInfoBeforeInit(Context r8, TelephonyManager r10) {
        return r10.getAllCellInfo();
    L4:
        Logger.e("getAllCellInfoBeforeInit#getAllCellInfo occur throwable !");
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static CellLocation getCellLocation(Context r8, TelephonyManager r10, Object r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r12 == false) goto L8;
        return r10.getCellLocation();
    L8:
        if (PermissionManager.hasAnyPermission(r8, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getCellLocation(r10, r11);
    }

    private static void requestCellInfoUpdate(TelephonyManager r8, final Object r10, boolean r11, final RefreshBaseStationInfo r12) {
        if (r11 == false) goto L4;
        final long r13 = System.currentTimeMillis();
        BDLocationExtrasService.getBPEAManager().requestCellInfoUpdate(r8, AppExecutors.getInstance().networkIO(), new AnonymousClass1(r13, r12, r10), r10);
        return;
    L4:
        if (r12 != null) goto L11;
        return;
    L11:
        r12.setRequestCellInfoResult(3);     // Catch: Exception -> L8
        r12.downLatch.countDown();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Logger.e("requestCellInfoUpdate occur exception!", e);
    }
}
