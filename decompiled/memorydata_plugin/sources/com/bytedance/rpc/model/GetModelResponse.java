package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GetModelResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<Long, ModelDesc> models;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetModelResponse() {
    }
}
