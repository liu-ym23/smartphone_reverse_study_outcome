package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetTopicListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName("last_topic_id")
    public long lastTopicId;
    public long num;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetTopicListRequest() {
    }
}
