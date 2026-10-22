package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatSetting implements Serializable {
    private String chatId;
    private boolean isInBox;
    private boolean isRemind;
    private long updateTime;

    public ChatSetting() {
        this.isRemind = true;
        this.updateTime = 0;
        this.isInBox = false;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isInBox() {
        return this.isInBox;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setInBox(boolean r1) {
        this.isInBox = r1;
    }

    public void setRemind(boolean r1) {
        this.isRemind = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public ChatSetting(String r2, boolean r3, long r4) {
        this.isInBox = false;
        this.isRemind = r3;
        this.updateTime = r4;
        this.chatId = r2;
    }

    public ChatSetting(String r1, boolean r2, long r3, boolean r5) {
        this.isRemind = r2;
        this.updateTime = r3;
        this.chatId = r1;
        this.isInBox = r5;
    }
}
