package com.ss.android.lark.forwardv3.data;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardErrorResultV3 extends ErrorResult {
    private boolean mIsClose;
    private boolean mIsDialog;
    private String mMessage;
    private String mTitle;

    public String getMessage() {
        return this.mMessage;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isIsDialog() {
        return this.mIsDialog;
    }

    public boolean isWillClose() {
        return this.mIsClose;
    }

    public ForwardErrorResultV3(String r2, boolean r3) {
        super(r2);
        this.mTitle = null;
        this.mMessage = r2;
        this.mIsClose = r3;
    }

    public ForwardErrorResultV3(String r1, String r2, boolean r3) {
        super(r2);
        this.mTitle = r1;
        this.mMessage = r2;
        this.mIsClose = r3;
        this.mIsDialog = true;
    }
}
