package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatchQueryObservationsResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("has_more")
    public boolean hasMore;
    public List<Observation> items;
    public String message;

    @SerializedName("next_cursor")
    public String nextCursor;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BatchQueryObservationsResponse() {
    }
}
