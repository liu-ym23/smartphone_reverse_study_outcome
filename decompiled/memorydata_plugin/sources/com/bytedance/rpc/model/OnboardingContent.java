package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OnboardingContent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("from_preset")
    public boolean fromPreset;
    public String language;
    public List<String> prologues;
    public boolean stale;

    @SerializedName("suggested_questions")
    public List<String> suggestedQuestions;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OnboardingContent() {
    }
}
