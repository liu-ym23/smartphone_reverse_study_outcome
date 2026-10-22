package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushInformationRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("Head")
    public Head head;
    public String through;
    public int type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushInformationRequest() {
    }
}
