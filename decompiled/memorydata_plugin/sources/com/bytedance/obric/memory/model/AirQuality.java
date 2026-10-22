package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AirQuality implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Aqi aqi;
    public double co;
    public int no2;
    public int o3;
    public int pm10;
    public int pm25;
    public int so2;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AirQuality() {
    }
}
