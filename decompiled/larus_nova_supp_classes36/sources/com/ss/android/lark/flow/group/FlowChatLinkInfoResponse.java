package com.ss.android.lark.flow.group;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class FlowChatLinkInfoResponse implements Serializable {
    private boolean canInvited;
    private Chat chat;
    private String chatId;
    private String inviterId;
    private boolean isInChat;
    private String token;

    public Chat getChat() {
        return this.chat;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isCanInvited() {
        return this.canInvited;
    }

    public boolean isInChat() {
        return this.isInChat;
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

    public void setToken(String r1) {
        this.token = r1;
    }

    public FlowChatLinkInfoResponse(boolean r1, String r2, String r3, Chat r4, boolean r5, String r6) {
        this.isInChat = r1;
        this.chatId = r2;
        this.token = r3;
        this.chat = r4;
        this.canInvited = r5;
        this.inviterId = r6;
    }
}
