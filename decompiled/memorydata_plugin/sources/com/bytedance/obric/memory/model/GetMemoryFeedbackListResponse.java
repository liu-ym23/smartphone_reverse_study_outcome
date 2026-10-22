package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetMemoryFeedbackListResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<MemoryFeedback> data;

    @SerializedName("has_more")
    public boolean hasMore;
    public int total;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetMemoryFeedbackListResponse() {
    }
}
