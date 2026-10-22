package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OnboardingGenConversationInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("conversation_id")
    public long conversationId;
    public String language;

    @SerializedName("msg_idx")
    public long msgIdx;

    @SerializedName("recent_user_questions")
    public List<String> recentUserQuestions;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OnboardingGenConversationInfo() {
    }
}
