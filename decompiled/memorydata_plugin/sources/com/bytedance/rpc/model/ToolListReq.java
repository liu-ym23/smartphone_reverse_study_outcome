package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ToolListReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String application;

    @SerializedName("mcp_server_names")
    public List<String> mcpServerNames;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolListReq() {
    }
}
