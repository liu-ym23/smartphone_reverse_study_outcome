package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetUserTodoListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName("next_id")
    public long nextId;
    public long num;

    @SerializedName("possibility_type")
    public int possibilityType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetUserTodoListRequest() {
    }
}
