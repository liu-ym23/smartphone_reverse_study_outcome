package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PreDefineRetrieverResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public ResultType type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreDefineRetrieverResult() {
    }
}
