package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LngLat implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Accuracy")
    public double accuracy;

    @SerializedName("Latitude")
    public double latitude;

    @SerializedName("Longitude")
    public double longitude;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LngLat() {
    }
}
