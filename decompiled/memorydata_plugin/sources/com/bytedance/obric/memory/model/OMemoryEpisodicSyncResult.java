package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OMemoryEpisodicSyncResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_source_id")
    public String clientSourceId;

    @SerializedName("event_seq")
    public long eventSeq;
    public String message;
    public int status;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemoryEpisodicSyncResult() {
    }
}
