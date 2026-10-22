package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MGetOnboardingPresetByBotIDsResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("onboarding_preset_map")
    public Map<Long, List<OnboardingPreset>> onboardingPresetMap;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MGetOnboardingPresetByBotIDsResponse() {
    }
}
