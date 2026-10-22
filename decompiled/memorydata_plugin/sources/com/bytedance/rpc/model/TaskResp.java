package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class TaskResp implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public CopilotResult code;

    @SerializedName("llm_input_tokens")
    public int llmInputTokens;

    @SerializedName("next_key")
    public String nextKey;

    @SerializedName("result_key")
    public String resultKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TaskResp() {
    }
}
