package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AgentLockScreenAuthResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String message;

    @SerializedName("pass_status")
    public String passStatus;
    public String style;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AgentLockScreenAuthResponse() {
    }
}
