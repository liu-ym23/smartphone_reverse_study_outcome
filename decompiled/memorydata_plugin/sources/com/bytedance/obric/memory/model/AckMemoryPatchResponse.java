package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AckMemoryPatchResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cursor_version")
    public long cursorVersion;

    @SerializedName("last_consumed_seq")
    public long lastConsumedSeq;
    public int status;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AckMemoryPatchResponse() {
    }
}
