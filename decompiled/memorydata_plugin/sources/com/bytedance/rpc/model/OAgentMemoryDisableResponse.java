package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OAgentMemoryDisableResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public boolean disable;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OAgentMemoryDisableResponse() {
    }
}
