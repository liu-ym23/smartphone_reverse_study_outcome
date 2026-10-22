package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Nearest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public double distance;
    public double intensity;
    public String status;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Nearest() {
    }
}
