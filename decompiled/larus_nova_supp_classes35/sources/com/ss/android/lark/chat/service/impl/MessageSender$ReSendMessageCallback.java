package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MessageSender$ReSendMessageCallback implements IGetDataCallback<String>, u, m6b.p {
    private final IGetDataCallback<String> originalCallback;

    public MessageSender$ReSendMessageCallback(IGetDataCallback<String> r1) {
        this.originalCallback = r1;
    }

    @Override // m6b.p
    public void onBeginSendMessage(Message r3) {
        m6b.p r0 = this.originalCallback;
        if ((r0 instanceof m6b.p) == false) goto L6;
        r0.onBeginSendMessage(r3);
        return;
    }

    public void onError(ErrorResult r2) {
        com.ss.android.lark.chat.utils.n0.a(r2);
        this.originalCallback.onError(r2);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((String) r1);
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r3) {
        u r0 = this.originalCallback;
        if ((r0 instanceof u) == false) goto L6;
        r0.onUpdateMediaCompressProgress(r3);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(String r2) {
        this.originalCallback.onSuccess(r2);
    }
}
