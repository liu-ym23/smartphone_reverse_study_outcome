package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SyncManualPresetOnboardingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id")
    public long botId;
    public OnboardingContent contents;

    @SerializedName("target_lang")
    public String targetLang;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SyncManualPresetOnboardingRequest() {
    }
}
