package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ChatWithBotResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("result_key")
    public String resultKey;

    @SerializedName("ret_code")
    public CopilotResult retCode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatWithBotResponse() {
    }
}
