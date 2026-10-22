package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushEventRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String context;

    @SerializedName("Head")
    public Head head;
    public int type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushEventRequest() {
    }
}
