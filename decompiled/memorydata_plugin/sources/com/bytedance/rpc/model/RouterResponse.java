package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RouterResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long code;
    public RouterData data;
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RouterResponse() {
    }
}
