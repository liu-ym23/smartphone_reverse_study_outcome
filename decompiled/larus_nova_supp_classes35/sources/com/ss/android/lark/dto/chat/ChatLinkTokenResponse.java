package com.ss.android.lark.dto.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatLinkTokenResponse implements Serializable {
    private String displayContent;
    private long expireTime;
    private boolean isUnLimited;
    private String sharedUrl;
    private String token;

    public String getDisplayContent() {
        return this.displayContent;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getSharedUrl() {
        return this.sharedUrl;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isUnLimited() {
        return this.isUnLimited;
    }

    public void setDisplayContent(String r1) {
        this.displayContent = r1;
    }

    public void setExpireTime(long r1) {
        this.expireTime = r1;
    }

    public void setSharedUrl(String r1) {
        this.sharedUrl = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setUnLimited(boolean r1) {
        this.isUnLimited = r1;
    }

    public ChatLinkTokenResponse(String r2, String r3, String r4, long r5) {
        this.isUnLimited = false;
        this.token = r2;
        this.sharedUrl = r3;
        this.displayContent = r4;
        this.expireTime = r5;
    }

    public ChatLinkTokenResponse(String r1, String r2, String r3, long r4, boolean r6) {
        this.token = r1;
        this.sharedUrl = r2;
        this.displayContent = r3;
        this.expireTime = r4;
        this.isUnLimited = r6;
    }
}
