package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class WeatherInfoReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("daily_steps")
    public int dailySteps;

    @SerializedName("hourly_steps")
    public int hourlySteps;
    public String lang;
    public double latitude;
    public double longitude;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public WeatherInfoReq() {
    }
}
