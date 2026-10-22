package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class VoiceInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_minor_voice")
    public boolean isMinorVoice;

    @SerializedName("voice_infomation")
    public String voiceInfomation;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public VoiceInfo() {
    }
}
