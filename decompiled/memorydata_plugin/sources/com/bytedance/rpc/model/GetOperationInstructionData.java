package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetOperationInstructionData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<OperationInstruction> instructions;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetOperationInstructionData() {
    }
}
