package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Precipitation__2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public double avg;
    public String date;
    public double max;
    public double min;
    public int probability;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Precipitation__2() {
    }
}
