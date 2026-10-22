package com.ss.android.lark.contact.base.dto;

import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatSelectBean extends BaseSelectBean {
    private static final long serialVersionUID = -559082424577654718L;
    private Chat.Type chatType;
    private boolean isMeeting;
    private boolean isOffical;

    @Override // com.ss.android.lark.contact.base.dto.BaseSelectBean
    public int getType() {
        return 1;
    }

    public ChatSelectBean() {
    }

    public Chat.Type getChatType() {
        return this.chatType;
    }

    public boolean isMeeting() {
        return this.isMeeting;
    }

    public boolean isOffical() {
        return this.isOffical;
    }

    public void setChatType(Chat.Type r1) {
        this.chatType = r1;
    }

    public void setIsMeeting(boolean r1) {
        this.isMeeting = r1;
    }

    public void setOffical(boolean r1) {
        this.isOffical = r1;
    }
}
