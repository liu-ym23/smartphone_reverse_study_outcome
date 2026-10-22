package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OrcaModelParamConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("in_customer_param")
    public OrcaCustomerParam inCustomerParam;

    @SerializedName("openai_req_key")
    public String openaiReqKey;

    @SerializedName("openai_resp_key")
    public String openaiRespKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OrcaModelParamConf() {
    }
}
