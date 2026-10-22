package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PreGenOnboardingResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("entity_to_onboarding_preview")
    public Map<Long, OnboardingContent> entityToOnboardingPreview;

    @SerializedName("fail_infos")
    public List<PreGenOnboardingFailInfo> failInfos;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreGenOnboardingResponse() {
    }
}
