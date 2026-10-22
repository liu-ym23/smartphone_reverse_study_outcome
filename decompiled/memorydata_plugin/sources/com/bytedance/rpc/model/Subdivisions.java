package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Subdivisions implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ASCIName")
    public String aSCIName;

    @SerializedName(i.K)
    public String code;

    @SerializedName("Confidence")
    public double confidence;

    @SerializedName("GeoNameID")
    public long geoNameID;

    @SerializedName("LocalID")
    public String localID;

    @SerializedName("Name")
    public String name;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Subdivisions() {
    }
}
