package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EntityOfGetOnboarding implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("bot_platform_character")
    public String botPlatformCharacter;

    @SerializedName("conversation_id")
    public long conversationId;

    @SerializedName("msg_idx")
    public long msgIdx;

    @SerializedName("recent_user_questions")
    public List<String> recentUserQuestions;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EntityOfGetOnboarding() {
    }
}
