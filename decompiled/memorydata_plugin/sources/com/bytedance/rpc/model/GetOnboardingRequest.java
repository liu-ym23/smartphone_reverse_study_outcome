package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetOnboardingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long count;
    public List<EntityOfGetOnboarding> entities;

    @SerializedName("only_use_preset")
    public boolean onlyUsePreset;
    public OnboardingSceneType scene;

    @SerializedName("target_lang")
    public String targetLang;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetOnboardingRequest() {
    }
}
