package com.obric.cae.location.geofence.vendor.mtk;

import android.content.Context;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MtkGeoManager implements IVendorGeoManager {
    private static MtkGeoManager sInstance;
    private boolean hasMtkGeoManagerInit;

    private MtkGeoManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.hasMtkGeoManagerInit = false;
        this.hasMtkGeoManagerInit = initMtkGeoManager();
    }

    public static synchronized MtkGeoManager getInstance(Context r3) {
        monitor-enter(MtkGeoManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new MtkGeoManager(r4);     // Catch: Throwable -> L10
    L7:
        MtkGeoManager r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(MtkGeoManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean initMtkGeoManager() {
        return false;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte addStarGeofence(StarGeofence r1) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofence(StarGeofence r1) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofenceById(String r1) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public String getSource() {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public String getVersion() {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte syncStarGeofence(List<StarGeofence> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte updateStarGeofence(StarGeofence r1) {
        throw new UnsupportedOperationException("wait for adapt.");
    }
}
