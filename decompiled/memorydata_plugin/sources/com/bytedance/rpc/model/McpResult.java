package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class McpResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<McpContent> content;
    public String meta;

    @SerializedName("structured_content")
    public String structuredContent;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public McpResult() {
    }
}
