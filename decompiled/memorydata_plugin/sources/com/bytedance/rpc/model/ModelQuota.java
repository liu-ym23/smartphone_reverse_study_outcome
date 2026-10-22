package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ModelQuota implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("price_in")
    public double priceIn;

    @SerializedName("price_out")
    public double priceOut;

    @SerializedName("request_per_minute")
    public long requestPerMinute;

    @SerializedName("token_cut_switch")
    public boolean tokenCutSwitch;

    @SerializedName("token_data")
    public long tokenData;

    @SerializedName("token_history")
    public long tokenHistory;

    @SerializedName("token_limit")
    public long tokenLimit;

    @SerializedName("token_per_minute")
    public long tokenPerMinute;

    @SerializedName("token_persona")
    public double tokenPersona;

    @SerializedName("token_resp")
    public long tokenResp;

    @SerializedName("token_system")
    public long tokenSystem;

    @SerializedName("token_tools_in")
    public long tokenToolsIn;

    @SerializedName("token_tools_out")
    public long tokenToolsOut;

    @SerializedName("token_user_in")
    public long tokenUserIn;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ModelQuota() {
    }
}
