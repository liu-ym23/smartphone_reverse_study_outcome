package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityRegion implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("city_localID")
    public String cityLocalID;

    @SerializedName("city_name")
    public String cityName;
    public long cnt;
    public String geohash8;
    public double latitude;
    public double longitude;

    @SerializedName("pred_score")
    public double predScore;
    public double radius;
    public double ratio;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ActivityRegion() {
    }
}
