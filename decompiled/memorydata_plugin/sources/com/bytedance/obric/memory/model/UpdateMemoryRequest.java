package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateMemoryRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public MemoryData data;

    @SerializedName("Head")
    public Head head;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateMemoryRequest() {
    }
}
