package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Daily implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("air_quality")
    public AirQuality__1 airQuality;
    public List<Astro> astro;

    @SerializedName("life_index")
    public LifeIndex__0 lifeIndex;
    public List<Precipitation__2> precipitation;
    public List<Skycon__0> skycon;
    public List<Temperature__0> temperature;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Daily() {
    }
}
