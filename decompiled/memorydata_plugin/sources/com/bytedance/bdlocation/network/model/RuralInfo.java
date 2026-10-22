package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;

/* JADX INFO: loaded from: classes.dex */
public class RuralInfo {

    @SerializedName("ASCIName")
    public String asciName;

    @SerializedName(i.K)
    public String code;

    @SerializedName("GeoNameID")
    public long geoNameID;

    @SerializedName("LocalID")
    public String localID;

    @SerializedName("Name")
    public String name;

    public RuralInfo() {
    }

    public String toString() {
        return "Town{code=" + this.code + "', geoNameID='" + this.geoNameID + "', asciName='" + this.asciName + "', name='" + this.name + "', localID='" + this.localID + "'}";
    }
}
