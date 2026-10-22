package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatchSyncOMemoryRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("episodic_items")
    public List<OMemoryEpisodicSyncItem> episodicItems;

    @SerializedName("Head")
    public Head head;

    @SerializedName("request_id")
    public String requestId;

    @SerializedName("semantic_items")
    public List<OMemorySemanticSyncItem> semanticItems;

    @SerializedName("sync_mode")
    public String syncMode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BatchSyncOMemoryRequest() {
    }
}
