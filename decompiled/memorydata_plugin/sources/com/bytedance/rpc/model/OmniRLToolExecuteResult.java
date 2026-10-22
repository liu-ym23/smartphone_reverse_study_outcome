package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OmniRLToolExecuteResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String resp;
    public boolean success;

    @SerializedName("tool_call_id")
    public String toolCallId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniRLToolExecuteResult() {
    }
}
