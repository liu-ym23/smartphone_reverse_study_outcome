package com.obric.cae.location.geofence.vendor.mtk;

import android.content.Context;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MtkGeoManager implements IVendorGeoManager {
    private static MtkGeoManager sInstance;
    private boolean hasMtkGeoManagerInit;

    private MtkGeoManager(Context r8) {
        this.hasMtkGeoManagerInit = false;
        this.hasMtkGeoManagerInit = initMtkGeoManager();
    }

    public static synchronized MtkGeoManager getInstance(Context r8) {
        monitor-enter(MtkGeoManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MtkGeoManager(r8);     // Catch: Throwable -> L10
    L7:
        MtkGeoManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(MtkGeoManager.class);
        return r10;
    }

    private boolean initMtkGeoManager() {
        return false;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte addStarGeofence(StarGeofence r8) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofence(StarGeofence r8) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofenceById(String r8) {
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
    public byte syncStarGeofence(List<StarGeofence> r8) {
        throw new UnsupportedOperationException("wait for adapt.");
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte updateStarGeofence(StarGeofence r8) {
        throw new UnsupportedOperationException("wait for adapt.");
    }
}
