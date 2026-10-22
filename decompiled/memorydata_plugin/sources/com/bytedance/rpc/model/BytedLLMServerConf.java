package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BytedLLMServerConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chat_template")
    public String chatTemplate;
    public String cluster;
    public List<String> idc;

    @SerializedName("orca_model_param")
    public OrcaModelParamConf orcaModelParam;
    public String psm;

    @SerializedName("request_type")
    public String requestType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BytedLLMServerConf() {
    }
}
