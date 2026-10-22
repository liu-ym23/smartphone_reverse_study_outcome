package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class n {

    @SerializedName("bool_val")
    public boolean boolVal;

    @SerializedName("bool_array_val")
    public List<Boolean> booleanArrayVal;

    @SerializedName("float64_array_val")
    public List<Double> doubleArrayVal;

    @SerializedName("float64_val")
    public double float64Val;

    @SerializedName("int64_val")
    public long int64Val;

    @SerializedName("int64_array_val")
    public List<Long> longArrayVal;

    @SerializedName("map_val")
    public Map<String, String> mapVal;

    @SerializedName("string_array_val")
    public List<String> stringArrayVal;

    @SerializedName("string_val")
    public String stringVal;

    @SerializedName("val_type")
    public int valType;

    public n() {
    }
}
