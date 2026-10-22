package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.compress.VideoCompressResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PreMessageSendCallback implements IGetDataCallback<String>, m6b.p, com.ss.android.lark.chat.service.impl.u, com.ss.android.lark.chat.service.impl.v {
    public final com.ss.android.lark.im.sdk.service.o mCallback;
    private final Message mMessage;
    private long netCost;
    private Trace trace;

    @Override // com.ss.android.lark.chat.service.impl.v
    public void onCompressMediaStart() {
        com.ss.android.lark.chat.service.impl.v r0 = this.mCallback;
        if ((r0 instanceof com.ss.android.lark.chat.service.impl.v) == false) goto L6;
        r0.onCompressMediaStart();
        return;
    }

    public n6b.b getCallback() {
        return this.mCallback;
    }

    @Override // m6b.p
    public void onBeginSendMessage(Message r3) {
        m6b.p r0 = this.mCallback;
        if ((r0 instanceof m6b.p) == false) goto L6;
        r0.onBeginSendMessage(r3);
        return;
    }

    @Override // com.ss.android.lark.chat.service.impl.v
    public void onCompressMediaEnd(VideoCompressResult r3) {
        com.ss.android.lark.chat.service.impl.v r0 = this.mCallback;
        if ((r0 instanceof com.ss.android.lark.chat.service.impl.v) == false) goto L6;
        r0.onCompressMediaEnd(r3);
        return;
    }

    public void onError(ErrorResult r3) {
        this.mMessage.setSendStatus(SendStatus.FAIL);
        Log.e(r3.toString());
        this.mCallback.a(r3, this.mMessage);
    }

    public void onSuccess(String r9) {
        this.mCallback.g(new o6b.b(this.mMessage, r9, this.netCost, this.trace));
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r3) {
        com.ss.android.lark.chat.service.impl.u r0 = this.mCallback;
        if ((r0 instanceof com.ss.android.lark.chat.service.impl.u) == false) goto L6;
        r0.onUpdateMediaCompressProgress(r3);
        return;
    }

    public void setNetCost(long r1) {
        this.netCost = r1;
    }

    public void setTrace(Trace r1) {
        this.trace = r1;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((String) r1);
    }

    public PreMessageSendCallback(Message r3, com.ss.android.lark.im.sdk.service.o r4) {
        this.netCost = 0;
        this.trace = null;
        this.mMessage = r3;
        this.mCallback = r4;
    }
}
