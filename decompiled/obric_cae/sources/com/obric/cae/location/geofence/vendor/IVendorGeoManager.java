package com.obric.cae.location.geofence.vendor;

import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.geofence.StarGeofenceError;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IVendorGeoManager {
    @StarGeofenceError
    byte addStarGeofence(StarGeofence r8);

    @StarGeofenceError
    byte deleteStarGeofence(StarGeofence r8);

    @StarGeofenceError
    byte deleteStarGeofenceById(String r8);

    String getSource();

    String getVersion();

    @StarGeofenceError
    byte syncStarGeofence(List<StarGeofence> r8);

    @StarGeofenceError
    byte updateStarGeofence(StarGeofence r8);
}
