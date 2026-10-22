package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OperationInstruction implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("instruction_detail")
    public String instructionDetail;

    @SerializedName("instruction_type")
    public String instructionType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OperationInstruction() {
    }
}
