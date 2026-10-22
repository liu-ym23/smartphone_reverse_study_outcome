package com.bytedance.obric.memory.model;

import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
public class ToolCallReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String application;

    @RpcField(FieldType.BODY)
    public String arguments;

    @SerializedName("mcp_server_name")
    @RpcField(FieldType.BODY)
    public String mCPServerName;

    @RpcField(FieldType.BODY)
    public String tool;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolCallReq() {
    }
}
