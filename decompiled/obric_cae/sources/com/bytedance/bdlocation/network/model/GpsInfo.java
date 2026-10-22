package com.bytedance.bdlocation.network.model;

import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class GpsInfo {

    @b(StarLocationDbManager.GeofenceEntry.ADDRESS)
    public String address;

    @b("city")
    public String city;

    @b("coordinateSystem")
    public String coordinateSystem;

    @b("country")
    public String country;

    @b("district")
    public String district;

    @b("latitude")
    public double latitude;

    @b("loc_time")
    public long locationTime;

    @b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public double longitude;

    @b("provider")
    public String provider;

    @b("province")
    public String province;

    @b("source")
    public int source;

    public GpsInfo() {
    }
}
