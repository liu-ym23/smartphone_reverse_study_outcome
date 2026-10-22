package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Aqi__1 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Avg__2 avg;
    public String date;
    public Max__2 max;
    public Min__2 min;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Aqi__1() {
    }
}
