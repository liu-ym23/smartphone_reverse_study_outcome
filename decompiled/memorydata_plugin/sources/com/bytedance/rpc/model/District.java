package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class District implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Confidence")
    public double confidence;
    public LngLat lnglat;

    @SerializedName("LocalID")
    public String localID;

    @SerializedName("Name")
    public String name;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public District() {
    }
}
