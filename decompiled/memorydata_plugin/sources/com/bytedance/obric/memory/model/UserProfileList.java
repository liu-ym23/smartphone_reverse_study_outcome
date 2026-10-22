package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserProfileList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<MemoryData> data;

    @SerializedName("next_id")
    public long nextId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserProfileList() {
    }
}
