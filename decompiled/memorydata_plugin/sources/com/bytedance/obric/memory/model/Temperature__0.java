package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Temperature__0 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public double avg;
    public String date;
    public double max;
    public double min;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Temperature__0() {
    }
}
