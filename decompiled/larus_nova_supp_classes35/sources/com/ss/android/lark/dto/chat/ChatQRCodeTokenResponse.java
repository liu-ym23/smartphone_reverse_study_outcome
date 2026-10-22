package com.ss.android.lark.dto.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatQRCodeTokenResponse implements Serializable {
    private long expireTime;
    private boolean isUnLimited;
    private String token;
    private String url;

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isUnLimited() {
        return this.isUnLimited;
    }

    public void setExpireTime(long r1) {
        this.expireTime = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setUnLimited(boolean r1) {
        this.isUnLimited = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public ChatQRCodeTokenResponse(String r2, String r3, long r4) {
        this.isUnLimited = false;
        this.token = r2;
        this.url = r3;
        this.expireTime = r4;
    }

    public ChatQRCodeTokenResponse(String r1, String r2, long r3, boolean r5) {
        this.token = r1;
        this.url = r2;
        this.expireTime = r3;
        this.isUnLimited = r5;
    }
}
