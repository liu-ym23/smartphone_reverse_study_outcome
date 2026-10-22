package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushToolRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;
    public long id;

    @SerializedName("tool_content")
    public String toolContent;

    @SerializedName("tool_name")
    public String toolName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushToolRequest() {
    }
}
