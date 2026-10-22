package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AudioSegment implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_end_ms")
    public long audioEndMs;

    @SerializedName("audio_start_ms")
    public long audioStartMs;

    @SerializedName("source_end_ms")
    public long sourceEndMs;

    @SerializedName("source_start_ms")
    public long sourceStartMs;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AudioSegment() {
    }
}
