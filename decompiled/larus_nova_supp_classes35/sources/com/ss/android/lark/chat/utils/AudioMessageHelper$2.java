package com.ss.android.lark.chat.utils;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class AudioMessageHelper$2 implements IGetDataCallback<String> {
    final /* synthetic */ IGetDataCallback val$callback;

    public AudioMessageHelper$2(IGetDataCallback r1) {
        this.val$callback = r1;
    }

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(String r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((String) r1);
    }
}
