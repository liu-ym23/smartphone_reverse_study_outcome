package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetRecommendListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;
    public long num;
    public long page;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetRecommendListRequest() {
    }
}
