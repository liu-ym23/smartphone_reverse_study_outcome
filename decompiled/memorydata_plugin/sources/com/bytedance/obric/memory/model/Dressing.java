package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Dressing implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String date;
    public String desc;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Dressing() {
    }
}
