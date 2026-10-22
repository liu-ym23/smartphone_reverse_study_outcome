package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;

/* JADX INFO: loaded from: classes.dex */
public class RegionCountry {

    @SerializedName("ASCIName")
    public String asciName;

    @SerializedName(i.K)
    public String code;

    @SerializedName("GeoNameID")
    public String geoNameID;

    @SerializedName("Name")
    public String name;

    public RegionCountry() {
    }

    public String toString() {
        return "RegionCountry{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "'}";
    }
}
