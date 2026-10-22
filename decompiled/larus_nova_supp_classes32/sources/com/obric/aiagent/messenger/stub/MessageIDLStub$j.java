package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.obric.aiagent.assistant.idl.IFlowMessageMainTextBlockCallbackIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$j implements IIMCallback<Message> {
    public final /* synthetic */ IFlowMessageMainTextBlockCallbackIDL a;

    public final boolean mustInMain() {
        return true;
    }

    public MessageIDLStub$j(IFlowMessageMainTextBlockCallbackIDL r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        IFlowMessageMainTextBlockCallbackIDL r3 = this.a;
        if (r3 == null) goto L6;
        r3.onResult(null);
        return;
    }

    public final void onSuccess(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        IFlowMessageMainTextBlockCallbackIDL r0 = this.a;
        if (r0 == null) goto L6;
        r0.onResult(com.larus.im.bean.message.a.B(r3));
        return;
    }
}
