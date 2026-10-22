package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GetOnboardingResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<Long, OnboardingContent> onboarding;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetOnboardingResponse() {
    }
}
