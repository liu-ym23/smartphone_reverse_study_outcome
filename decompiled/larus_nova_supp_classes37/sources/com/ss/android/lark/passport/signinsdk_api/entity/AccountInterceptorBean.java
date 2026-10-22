package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AccountInterceptorBean implements Serializable {
    private String cancelText;
    private String confirmText;
    private String desc;
    private String title;

    public String getCancelText() {
        return this.cancelText;
    }

    public String getConfirmText() {
        return this.confirmText;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCancelText(String r1) {
        this.cancelText = r1;
    }

    public void setConfirmText(String r1) {
        this.confirmText = r1;
    }

    public void setDesc(String r1) {
        this.desc = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public AccountInterceptorBean(String r1, String r2, String r3, String r4) {
        this.title = r1;
        this.desc = r2;
        this.confirmText = r3;
        this.cancelText = r4;
    }
}
