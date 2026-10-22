package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreGenOnboardingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("conversation_infos")
    public List<OnboardingGenConversationInfo> conversationInfos;
    public long count;

    @SerializedName("return_push_preview")
    public boolean returnPushPreview;
    public OnboardingSceneType scene;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreGenOnboardingRequest() {
    }
}
