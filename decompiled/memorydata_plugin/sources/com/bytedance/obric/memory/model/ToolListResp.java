package com.bytedance.obric.memory.model;

import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
public class ToolListResp implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public int code;

    @RpcField(FieldType.BODY)
    public String data;

    @RpcField(FieldType.BODY)
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolListResp() {
    }
}
