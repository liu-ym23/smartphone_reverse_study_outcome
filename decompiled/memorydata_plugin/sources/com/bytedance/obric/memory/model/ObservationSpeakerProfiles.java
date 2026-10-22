package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ObservationSpeakerProfiles implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("observation_id")
    public String observationId;
    public List<SpeakerProfileResolution> speakers;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ObservationSpeakerProfiles() {
    }
}
