package com.ss.android.lark.contact.base.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class ContactServiceUtils$1 implements IGetDataCallback<com.ss.android.lark.contact.base.entity.b> {
    final /* synthetic */ IGetDataCallback val$callback;

    public ContactServiceUtils$1(IGetDataCallback r1) {
        this.val$callback = r1;
    }

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(com.ss.android.lark.contact.base.entity.b r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((com.ss.android.lark.contact.base.entity.b) r1);
    }
}
