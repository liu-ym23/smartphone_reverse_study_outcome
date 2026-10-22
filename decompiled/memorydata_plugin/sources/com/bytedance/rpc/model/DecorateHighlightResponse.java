package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DecorateHighlightResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public List<ReplaceReference> references;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DecorateHighlightResponse() {
    }
}
