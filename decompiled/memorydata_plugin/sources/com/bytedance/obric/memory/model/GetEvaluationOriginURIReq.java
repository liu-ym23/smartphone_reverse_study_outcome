package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetEvaluationOriginURIReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<String> uris;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetEvaluationOriginURIReq() {
    }
}
