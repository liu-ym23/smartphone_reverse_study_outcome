package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import ha.s;
import ia.b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationResult {

    @b("AoiInfos")
    public List<PoiInfoEntity> aoiList;

    @b("City")
    public PlaceInfo city;

    @b("Continent")
    public PlaceInfo continent;

    @b("Country")
    public PlaceInfo country;

    @b("District")
    public PlaceInfo district;

    @b("Extra")
    public s extra;

    @b("GPS")
    public GPSResult gps;

    @b("IsDisputed")
    public boolean isDisputed;

    @b("ISP")
    public String isp;

    @b("LocateMethod")
    public String locateMethod;

    @b("Place")
    public Place place;

    @b("PoiInfos")
    public List<PoiInfoEntity> poiList;

    @b("Subdivisions")
    public PlaceInfo[] subdivisions;

    @b(BwdlDropProvider.BwdlDropEntry.TIMESTAMP)
    public long timestamp;

    @b("Town")
    public RuralInfo town;

    @b("Village")
    public RuralInfo village;

    public LocationResult() {
    }

    public String toString() {
        return "LocationResult{continent=" + this.continent + ", country=" + this.country + ", subdivisions=" + Arrays.toString(this.subdivisions) + ", city=" + this.city + ", district=" + this.district + ", place=" + this.place + ", gps=" + this.gps + ", isp='" + this.isp + "', locateMethod='" + this.locateMethod + "', isDisputed='" + this.isDisputed + "', timestamp='" + this.timestamp + "', town'" + this.town + "', PoiInfos'" + this.poiList + "', AoiInfos'" + this.aoiList + "'}";
    }
}
