package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AskUserRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ask_content")
    public String askContent;
    public Map<String, String> extra;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("user_answer")
    public String userAnswer;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AskUserRequest() {
    }
}
