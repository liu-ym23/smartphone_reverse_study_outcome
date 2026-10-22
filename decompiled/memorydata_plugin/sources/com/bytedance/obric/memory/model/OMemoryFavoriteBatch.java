package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OMemoryFavoriteBatch implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("base_event_seq")
    public long baseEventSeq;

    @SerializedName("batch_id")
    public String batchId;
    public List<OMemoryFavoriteEvent> events;

    @SerializedName("max_event_seq")
    public long maxEventSeq;

    @SerializedName("sr_type")
    public String srType;

    @SerializedName("total_count")
    public int totalCount;
    public boolean truncated;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemoryFavoriteBatch() {
    }
}
