package com.ss.android.lark.filedetail.impl.open;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BizErrorResult extends ErrorResult {
    private int mShowMessage;

    public int getShowMessage() {
        return this.mShowMessage;
    }

    public void setShowMessage(int r1) {
        this.mShowMessage = r1;
    }

    public BizErrorResult(int r1, int r2) {
        super(r1);
        this.mShowMessage = r2;
    }
}
