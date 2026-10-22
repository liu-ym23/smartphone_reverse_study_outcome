package com.obric.assistant.chat.internal;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements IIMCallback<Message> {
    public final /* synthetic */ Function0<Unit> a;

    public final boolean mustInMain() {
        return true;
    }

    public j(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L6;
        r3.invoke();
        return;
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((Message) r2, "result");
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L6;
        r3.invoke();
        return;
    }
}
