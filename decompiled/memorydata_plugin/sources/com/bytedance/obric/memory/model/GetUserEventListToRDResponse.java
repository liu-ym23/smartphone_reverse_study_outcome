package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetUserEventListToRDResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("next_id")
    public long nextId;
    public List<UserEvent> userEventList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetUserEventListToRDResponse() {
    }
}
