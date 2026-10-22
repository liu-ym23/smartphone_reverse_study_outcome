package com.larus.bmhome.chat.model.strategy.block;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements IIMCallback<Message> {
    public o() {
    }

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        Message r2 = (Message) r1;
    }
}
