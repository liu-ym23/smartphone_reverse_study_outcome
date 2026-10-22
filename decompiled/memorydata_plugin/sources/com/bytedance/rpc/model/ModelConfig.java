package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ModelConfig implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("max_tokens")
    public int maxTokens;

    @SerializedName("model_id")
    public long modelId;

    @SerializedName("model_name")
    public ModelName modelName;
    public double temperature;

    @SerializedName("top_k")
    public int topK;

    @SerializedName("top_p")
    public double topP;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ModelConfig() {
    }
}
