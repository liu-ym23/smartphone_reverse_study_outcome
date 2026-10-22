package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DelRecommendRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;
    public long id;
    public int recommendType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DelRecommendRequest() {
    }
}
