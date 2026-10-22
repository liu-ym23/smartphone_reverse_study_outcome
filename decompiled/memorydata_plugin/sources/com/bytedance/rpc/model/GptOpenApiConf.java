package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GptOpenApiConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("openai_api_base")
    public String openaiApiBase;

    @SerializedName("openai_api_type")
    public String openaiApiType;

    @SerializedName("openai_api_version")
    public String openaiApiVersion;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GptOpenApiConf() {
    }
}
