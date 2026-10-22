package com.ss.android.lark.download.service.impl;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class DownloadService$4 implements IGetDataCallback<wbb.d.b> {
    final /* synthetic */ j this$0;
    final /* synthetic */ IGetDataCallback val$callback;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Token val$token;

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(wbb.d.b r3) {
        String r4 = r3.a;
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L5;
        r0.onSuccess(r4);
    L5:
        j.a(this.val$context, r4, this.val$token);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((wbb.d.b) r1);
    }

    public DownloadService$4(j r1, IGetDataCallback r2, Context r3, Token r4) {
        this.this$0 = r1;
        this.val$callback = r2;
        this.val$context = r3;
        this.val$token = r4;
    }
}
