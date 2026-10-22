package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RelevanceJudgmentData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;
    public String status;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RelevanceJudgmentData() {
    }
}
