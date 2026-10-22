package com.ss.android.lark.contact.impl.group.manage;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class MyManageGroupModel$1 implements IGetDataCallback<List<Chat>> {
    final /* synthetic */ d this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(List<Chat> r2) {
        this.this$0.h(r2);
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    public MyManageGroupModel$1(d r1, IGetDataCallback r2) {
        this.this$0 = r1;
        this.val$callback = r2;
    }
}
