package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class SystemContentUtil$6$1$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ SystemContentUtil.AnonymousClass6.a this$1;

    public SystemContentUtil$6$1$1(SystemContentUtil.AnonymousClass6.a r1) {
        this.this$1 = r1;
    }

    public void onError(ErrorResult r1) {
        if (TextUtils.isEmpty(r1.getDisplayMsg()) == false) goto L5;
        return;
    L5:
        this.this$1.getClass();
        throw null;
    }

    public void onSuccess(Boolean r1) {
        this.this$1.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Boolean) r1);
    }
}
