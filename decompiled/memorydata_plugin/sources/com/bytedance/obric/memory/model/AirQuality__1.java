package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AirQuality__1 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<Aqi__1> aqi;
    public List<Pm25__0> pm25;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AirQuality__1() {
    }
}
