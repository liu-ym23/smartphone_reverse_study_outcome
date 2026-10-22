package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ToolCallReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String application;
    public String arguments;

    @SerializedName("mcp_server_name")
    public String mcpServerName;
    public String tool;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolCallReq() {
    }
}
