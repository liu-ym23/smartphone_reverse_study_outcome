package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetUserProfileAndMemoryListByTimeRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int category;

    @SerializedName("Head")
    public Head head;

    @SerializedName("next_id")
    public long nextId;
    public long num;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetUserProfileAndMemoryListByTimeRequest() {
    }
}
