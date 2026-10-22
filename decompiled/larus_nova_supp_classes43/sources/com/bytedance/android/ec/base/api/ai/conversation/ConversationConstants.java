package com.bytedance.android.ec.base.api.ai.conversation;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/ConversationConstants;", "", "()V", "KEY_AI_PARAMS", "", "KEY_BCM_ID", "KEY_CONVERSATION_CID", "KEY_CONVERSATION_ID", "KEY_CONVERSATION_ORIGIN_BCM_ID", "KEY_CONVERSATION_ORIGIN_MSG_ID", "KEY_ECOM_SAAS_EXTRA", "KEY_FIRST_MSG", "KEY_ORIGIN_BCM_ID", "KEY_ORIGIN_MESSAGE_ID", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class ConversationConstants {
    public static final ConversationConstants INSTANCE = null;
    public static final String KEY_AI_PARAMS = "ec_ai_params";
    public static final String KEY_BCM_ID = "bcm_id";
    public static final String KEY_CONVERSATION_CID = "ec_conversation_cid";
    public static final String KEY_CONVERSATION_ID = "conversation_id";
    public static final String KEY_CONVERSATION_ORIGIN_BCM_ID = "ec_conversation_origin_bcm_id";
    public static final String KEY_CONVERSATION_ORIGIN_MSG_ID = "ec_conversation_origin_msg_id";
    public static final String KEY_ECOM_SAAS_EXTRA = "ecom_saas_extra";
    public static final String KEY_FIRST_MSG = "ec_conversation_first_msg";
    public static final String KEY_ORIGIN_BCM_ID = "origin_bcm_id";
    public static final String KEY_ORIGIN_MESSAGE_ID = "origin_message_id";

    private ConversationConstants() {
    }

    static {
        INSTANCE = new ConversationConstants();
    }
}
