package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OnboardingPreset implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("answer_cacheable")
    public boolean answerCacheable;
    public String language;

    @SerializedName("preset_content")
    public String presetContent;
    public OnboardingResultSource source;
    public OnboardingComponentType type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OnboardingPreset() {
    }
}
