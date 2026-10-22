package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Event implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;
    public String params;
    public long type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Event() {
    }
}
