package com.bytedance.bdlocation.network.model;

import android.aimedia.a;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class RegionCountry {

    @b("ASCIName")
    public String asciName;

    @b("Code")
    public String code;

    @b("GeoNameID")
    public String geoNameID;

    @b("Name")
    public String name;

    public RegionCountry() {
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("RegionCountry{code='");
        r8.append(this.code);
        r8.append("', geoNameID=");
        r8.append(this.geoNameID);
        r8.append(", asciName='");
        r8.append(this.asciName);
        r8.append("', name='");
        return a.i(r8, this.name, "'}");
    }
}
