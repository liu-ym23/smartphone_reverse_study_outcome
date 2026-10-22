package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CustomModelConfig implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String ak;
    public String endpoint;

    @SerializedName("max_tokens")
    public int maxTokens;

    @SerializedName("min_tokens")
    public int minTokens;

    @SerializedName("model_id")
    public long modelId;

    @SerializedName("model_name")
    public ModelName modelName;

    @SerializedName("model_type")
    public long modelType;
    public String sk;
    public double temperature;

    @SerializedName("top_k")
    public int topK;

    @SerializedName("top_p")
    public double topP;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CustomModelConfig() {
    }
}
