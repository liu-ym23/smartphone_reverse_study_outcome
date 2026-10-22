package com.obric.cae.location.geofence.vendor;

import android.content.Context;
import com.obric.cae.libs.utils.a;
import com.obric.cae.location.geofence.vendor.mtk.MtkGeoManager;
import com.obric.cae.location.geofence.vendor.qcom.QcomGeoManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class VendorGeoManager {
    private static final String TAG = "StarLocation-VendorGeoManager";
    private static final String XIAOMI_GEO_MANAGER_CLASS = "com.obric.cae.location.geofence.vendor.xiaomi.XiaomiGeoManager";
    private static VendorGeoManager instance;
    private IVendorGeoManager vendorGeoManager;

    private VendorGeoManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.vendorGeoManager = null;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (a.c() == false) goto L7;
        com.obric.cae.log.a.c(TAG, "vendorGeo: xiaomi");
        IVendorGeoManager r6 = getXiaomiGeoManager(r5);
    L5:
        this.vendorGeoManager = r6;
        return;
    L7:
        if (a.a() == false) goto L10;
        com.obric.cae.log.a.c(TAG, "vendorGeo: qcom");
        r6 = QcomGeoManager.getInstance(r5);
        goto L5
    L10:
        if (a.b() == false) goto L13;
        com.obric.cae.log.a.c(TAG, "vendorGeo: mtk");
        r6 = MtkGeoManager.getInstance(r5);
        goto L5
    }

    public static synchronized VendorGeoManager getInstance(Context r3) {
        monitor-enter(VendorGeoManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (instance != null) goto L7;
        instance = new VendorGeoManager(r4);     // Catch: Throwable -> L10
    L7:
        VendorGeoManager r5 = instance;     // Catch: Throwable -> L10
        monitor-exit(VendorGeoManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private IVendorGeoManager getXiaomiGeoManager(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Object r11 = ZeusTransformUtils.forName(XIAOMI_GEO_MANAGER_CLASS, "com.obric.memorydata.plugin").getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r10});     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        if (ZeusTransformUtils.instanceOf(r11, IVendorGeoManager.class) == true) goto L6;
        com.obric.cae.log.a.i(TAG, "xiaomi geo manager does not implement IVendorGeoManager");     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L14:
        return null;
    L6:
        return (IVendorGeoManager) ZeusTransformUtils.preCheckCast(r11, IVendorGeoManager.class, "com.obric.memorydata.plugin");
    L11:
        e = e;
        String r1 = "xiaomi geo manager is not included in this build";
    L13:
        com.obric.cae.log.a.a(TAG, r1, e);
    L9:
        e = e;
        r1 = "failed to load xiaomi geo manager";
        goto L13
    }

    public IVendorGeoManager getManager() {
        return this.vendorGeoManager;
    }
}
