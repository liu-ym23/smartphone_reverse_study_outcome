package com.obric.cae.location.geofence.vendor;

import android.content.Context;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.location.geofence.vendor.mtk.MtkGeoManager;
import com.obric.cae.location.geofence.vendor.qcom.QcomGeoManager;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes.dex */
public class VendorGeoManager {
    private static final String TAG = "StarLocation-VendorGeoManager";
    private static final String XIAOMI_GEO_MANAGER_CLASS = "com.obric.cae.location.geofence.vendor.xiaomi.XiaomiGeoManager";
    private static VendorGeoManager instance;
    private IVendorGeoManager vendorGeoManager;

    private VendorGeoManager(Context r8) {
        this.vendorGeoManager = null;
        Context r10 = r8.getApplicationContext();
        if (CaelibUtils.isXiaomiPlatform() == false) goto L7;
        CommSenseLog.d(TAG, "vendorGeo: xiaomi");
        IVendorGeoManager r11 = getXiaomiGeoManager(r10);
    L5:
        this.vendorGeoManager = r11;
        return;
    L7:
        if (CaelibUtils.isQcomPlatform() == false) goto L10;
        CommSenseLog.d(TAG, "vendorGeo: qcom");
        r11 = QcomGeoManager.getInstance(r10);
        goto L5
    L10:
        if (CaelibUtils.isMtkPlatform() == false) goto L13;
        CommSenseLog.d(TAG, "vendorGeo: mtk");
        r11 = MtkGeoManager.getInstance(r10);
        goto L5
    }

    public static synchronized VendorGeoManager getInstance(Context r8) {
        monitor-enter(VendorGeoManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new VendorGeoManager(r8);     // Catch: Throwable -> L10
    L7:
        VendorGeoManager r10 = instance;     // Catch: Throwable -> L10
        monitor-exit(VendorGeoManager.class);
        return r10;
    }

    private IVendorGeoManager getXiaomiGeoManager(Context r8) {
        Object r10 = Class.forName(XIAOMI_GEO_MANAGER_CLASS).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r8});     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        if ((r10 instanceof IVendorGeoManager) == true) goto L6;
        CommSenseLog.e(TAG, "xiaomi geo manager does not implement IVendorGeoManager");     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L14:
        return null;
    L6:
        return (IVendorGeoManager) r10;
    L11:
        e = e;
        String r11 = "xiaomi geo manager is not included in this build";
    L13:
        CommSenseLog.e(TAG, r11, e);
    L9:
        e = e;
        r11 = "failed to load xiaomi geo manager";
        goto L13
    }

    public IVendorGeoManager getManager() {
        return this.vendorGeoManager;
    }
}
