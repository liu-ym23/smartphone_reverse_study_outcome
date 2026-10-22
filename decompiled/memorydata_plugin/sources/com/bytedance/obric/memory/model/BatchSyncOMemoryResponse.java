package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatchSyncOMemoryResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("episodic_results")
    public List<OMemoryEpisodicSyncResult> episodicResults;
    public String msg;

    @SerializedName("semantic_results")
    public List<OMemorySemanticSyncResult> semanticResults;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BatchSyncOMemoryResponse() {
    }
}
