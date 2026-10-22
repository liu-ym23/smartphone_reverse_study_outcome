package com.ss.android.lark.contact.base.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class DefaultOfficeContactRepository$4 implements IGetDataCallback<com.ss.android.lark.contact.base.dto.a> {
    final /* synthetic */ y this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(com.ss.android.lark.contact.base.dto.a r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((com.ss.android.lark.contact.base.dto.a) r1);
    }

    public DefaultOfficeContactRepository$4(y r1, IGetDataCallback r2) {
        this.this$0 = r1;
        this.val$callback = r2;
    }
}
