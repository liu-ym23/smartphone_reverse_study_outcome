package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ModelConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("byted_llm_server")
    public BytedLLMServerConf bytedLlmServer;

    @SerializedName("gpt_engine")
    public GptEngineConf gptEngine;

    @SerializedName("gpt_openapi")
    public GptOpenApiConf gptOpenapi;
    public MaasConf maas;

    @SerializedName("print_behavior")
    public PrintBehavior printBehavior;
    public ModelProvider provider;
    public QianFanConf qianfan;

    @SerializedName("retry_times")
    public int retryTimes;
    public int timeout;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ModelConf() {
    }
}
