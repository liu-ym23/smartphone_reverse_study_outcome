package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Result implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Alert alert;
    public Daily daily;
    public Hourly hourly;
    public Realtime realtime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Result() {
    }
}
