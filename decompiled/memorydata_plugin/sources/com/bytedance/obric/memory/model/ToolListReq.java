package com.bytedance.obric.memory.model;

import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
public class ToolListReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String application;

    @SerializedName("mcp_server_names")
    @RpcField(FieldType.BODY)
    public List<String> mCPServerNames;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolListReq() {
    }
}
