package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatAnnouncement implements Serializable {
    private static final long serialVersionUID = 9059996248975978048L;
    private String announceUrl;
    private String chatId;
    private String content;
    private String docUrl;
    private String lastEditorId;
    private long updateTime;
    private boolean useOpenDoc;

    public ChatAnnouncement() {
    }

    public String getAnnounceUrl() {
        return this.announceUrl;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getContent() {
        return this.content;
    }

    public String getDocUrl() {
        return this.docUrl;
    }

    public String getLastEditorId() {
        return this.lastEditorId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isUseOpenDoc() {
        return this.useOpenDoc;
    }

    public void setAnnounceUrl(String r1) {
        this.announceUrl = r1;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setDocUrl(String r1) {
        this.docUrl = r1;
    }

    public void setLastEditorId(String r1) {
        this.lastEditorId = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setUseOpenDoc(boolean r1) {
        this.useOpenDoc = r1;
    }
}
