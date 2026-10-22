package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GPS implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Accuracy")
    public double accuracy;

    @SerializedName("Altitude")
    public double altitude;

    @SerializedName("CoordinateSystem")
    public String coordinateSystem;

    @SerializedName("Latitude")
    public double latitude;

    @SerializedName("Longitude")
    public double longitude;

    @SerializedName("Timestamp")
    public double timestamp;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GPS() {
    }
}
