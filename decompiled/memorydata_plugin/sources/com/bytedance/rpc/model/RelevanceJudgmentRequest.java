package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RelevanceJudgmentRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("relevance_judgment_fields")
    public Map<String, String> relevanceJudgmentFields;

    @SerializedName("relevance_judgment_type")
    public String relevanceJudgmentType;

    @SerializedName("user_query")
    public String userQuery;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RelevanceJudgmentRequest() {
    }
}
