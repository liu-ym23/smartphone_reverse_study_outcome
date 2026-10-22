package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class LightInfo {

    @SerializedName("light_value")
    public float lightValue;

    @SerializedName("timestamp")
    public long timestamp;

    public LightInfo() {
    }
}
