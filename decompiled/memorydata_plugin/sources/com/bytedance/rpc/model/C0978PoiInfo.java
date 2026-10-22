package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: renamed from: com.bytedance.rpc.model.PoiInfo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0978PoiInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("AmapID")
    public String amapID;

    @SerializedName("AwemeID")
    public String awemeID;

    @SerializedName("Confidence")
    public double confidence;

    @SerializedName("LocationID")
    public String locationID;

    @SerializedName("Name")
    public String name;

    @SerializedName("Typecode")
    public String typecode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public C0978PoiInfo() {
    }
}
