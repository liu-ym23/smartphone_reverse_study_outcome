package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SpeakerProfileResolution implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("embedding_type")
    public String embeddingType;

    @SerializedName("local_speaker_id")
    public String localSpeakerId;

    @SerializedName("model_version")
    public String modelVersion;

    @SerializedName("profile_id")
    public String profileId;
    public String reason;
    public long revision;
    public int state;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SpeakerProfileResolution() {
    }
}
