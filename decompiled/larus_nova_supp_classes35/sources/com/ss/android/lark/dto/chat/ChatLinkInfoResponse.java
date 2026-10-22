package com.ss.android.lark.dto.chat;

import com.bytedance.lark.pb.im.v1.GetChatLinkInfoResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.parser.internal.h;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatLinkInfoResponse implements Serializable {
    private boolean canInvited;
    private Chat chat;
    private String chatId;
    private String inviterId;
    private boolean isInChat;

    public Chat getChat() {
        return this.chat;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public boolean isCanInvited() {
        return this.canInvited;
    }

    public boolean isInChat() {
        return this.isInChat;
    }

    public ChatLinkInfoResponse(GetChatLinkInfoResponse r3) {
        this.isInChat = r3.already_in_chat.booleanValue();
        String r0 = r3.chat_id;
        this.chatId = r0;
        this.chat = h.a((com.bytedance.lark.pb.basic.v1.Chat) r3.entity.chats.get(r0), null);
        this.canInvited = r3.is_inviter_can_invite_member.booleanValue();
        this.inviterId = r3.inviter_chatter_id;
    }

    public void setCanInvited(boolean r1) {
        this.canInvited = r1;
    }

    public void setChat(Chat r1) {
        this.chat = r1;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setInChat(boolean r1) {
        this.isInChat = r1;
    }

    public void setInviterId(String r1) {
        this.inviterId = r1;
    }
}
