package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Realtime implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("air_quality")
    public AirQuality airQuality;

    @SerializedName("apparent_temperature")
    public double apparentTemperature;
    public double cloudrate;
    public double humidity;

    @SerializedName("life_index")
    public LifeIndex lifeIndex;
    public Precipitation precipitation;
    public double pressure;
    public String skycon;
    public double temperature;
    public double visibility;
    public Wind wind;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Realtime() {
    }
}
