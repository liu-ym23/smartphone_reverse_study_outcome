package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubmitAudioASRTaskRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_start_ms")
    public String audioStartMs;

    @SerializedName("audio_uri")
    public String audioUri;

    @SerializedName("device_id")
    public String deviceId;
    public List<String> hotwords;
    public AudioManifest manifest;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SubmitAudioASRTaskRequest() {
    }
}
