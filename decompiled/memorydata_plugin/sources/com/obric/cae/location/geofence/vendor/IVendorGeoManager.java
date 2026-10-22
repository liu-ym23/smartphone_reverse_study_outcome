package com.obric.cae.location.geofence.vendor;

import com.obric.cae.libs.location.geofence.StarGeofence;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IVendorGeoManager {
    byte addStarGeofence(StarGeofence r1);

    byte deleteStarGeofence(StarGeofence r1);

    byte deleteStarGeofenceById(String r1);

    String getSource();

    String getVersion();

    byte syncStarGeofence(List<StarGeofence> r1);

    byte updateStarGeofence(StarGeofence r1);
}
