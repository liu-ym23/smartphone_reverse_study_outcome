package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class LoginSourceInfo implements Serializable {
    private int loginSource;
    private String url;

    public LoginSourceInfo() {
        this.loginSource = 0;
    }

    public int getLoginSource() {
        return this.loginSource;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLoginSource(int r1) {
        this.loginSource = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public LoginSourceInfo(int r1, String r2) {
        this.loginSource = r1;
        this.url = r2;
    }
}
