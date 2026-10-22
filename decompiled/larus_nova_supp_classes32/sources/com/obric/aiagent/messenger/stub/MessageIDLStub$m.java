package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$m implements IIMCallback<Message> {
    public MessageIDLStub$m() {
    }

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        Message r2 = (Message) r1;
    }
}
