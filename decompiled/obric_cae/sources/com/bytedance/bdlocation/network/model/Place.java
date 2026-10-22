package com.bytedance.bdlocation.network.model;

import android.aimedia.a;
import com.bytedance.bdlocation.entity.GeoPoiEntity;
import com.obric.cae.log.CommSenseLog;
import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Place {

    @b("AddressLines")
    public List<String> addressLines;

    @b("AdminArea")
    public String adminArea;

    @b("AreasOfInterest")
    public List<String> areasOfInterest;

    @b("FeatureCode")
    public String featureCode;

    @b("aoi")
    public List<GeoPoiEntity> geoAoiList;

    @b("FormattedAddress")
    public String geoFormattedAddress;

    @b("GeoNameID")
    public String geoNameID;

    @b(CommSenseLog.KEY_FILE_POI)
    public List<GeoPoiEntity> geoPoiList;

    @b("Locality")
    public String locality;

    @b("Name")
    public String name;

    @b("PostalCode")
    public String postalCode;

    @b("SubAdminArea")
    public String subAdminArea;

    @b("SubLocality")
    public String subLocality;

    @b("SubThoroughfare")
    public String subThoroughfare;

    @b("TimeZone")
    public String timeZone;

    public Place() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("Place{addressLines=");
        r8.append(this.addressLines);
        r8.append(", adminArea='");
        r8.append(this.adminArea);
        r8.append("', name='");
        r8.append(this.name);
        r8.append("', areasOfInterest='");
        r8.append(this.areasOfInterest);
        r8.append("', subAdminArea='");
        r8.append(this.subAdminArea);
        r8.append("', locality='");
        r8.append(this.locality);
        r8.append("', subLocality='");
        r8.append(this.subLocality);
        r8.append("', subThoroughfare='");
        r8.append(this.subThoroughfare);
        r8.append("', postalCode='");
        r8.append(this.postalCode);
        r8.append("', featureCode='");
        r8.append(this.featureCode);
        r8.append("', geoNameID='");
        r8.append(this.geoNameID);
        r8.append("', timeZone='");
        r8.append(this.timeZone);
        r8.append("', geoAoiList='");
        r8.append(this.geoAoiList);
        r8.append("', geoPoiList='");
        r8.append(this.geoPoiList);
        r8.append("', geoFormattedAddress='");
        return a.i(r8, this.geoFormattedAddress, "'}");
    }
}
