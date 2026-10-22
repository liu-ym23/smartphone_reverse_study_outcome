package com.bytedance.rpc.model;

import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
public class ToolsCallResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String result;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolsCallResponse() {
    }
}
