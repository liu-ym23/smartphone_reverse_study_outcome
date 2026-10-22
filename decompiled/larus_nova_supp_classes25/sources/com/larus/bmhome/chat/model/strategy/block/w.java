package com.larus.bmhome.chat.model.strategy.block;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements IIMCallback<Message> {
    public final /* synthetic */ Function2<Message, IIMError, Unit> a;

    public final boolean mustInMain() {
        return true;
    }

    public w(Function2<? super Message, ? super IIMError, Unit> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        Intrinsics.checkNotNullParameter(r3, "error");
        Function2<Message, IIMError, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(null, r3);
        return;
    }

    public final void onSuccess(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        Function2<Message, IIMError, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(r4, null);
        return;
    }
}
