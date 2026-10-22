package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Pm25__0 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int avg;
    public String date;
    public int max;
    public int min;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Pm25__0() {
    }
}
