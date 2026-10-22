package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MessageBizInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("attachment_local_msg_id")
    public String attachmentLocalMsgId;

    @SerializedName("bot_converastion_type")
    public BotConversationType botConverastionType;

    @SerializedName("conversation_id")
    public long conversationId;

    @SerializedName("message_id")
    public long messageId;

    @SerializedName("message_index")
    public long messageIndex;
    public boolean resend;

    @SerializedName("section_id")
    public long sectionId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MessageBizInfo() {
    }
}
