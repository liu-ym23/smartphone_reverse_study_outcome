package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpsertOnboardingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("onboarding_presets")
    public List<OnboardingPreset> onboardingPresets;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpsertOnboardingRequest() {
    }
}
