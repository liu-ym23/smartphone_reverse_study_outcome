package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 implements IIMCallback<Message> {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ n0 b;
    public final /* synthetic */ Function1<Message, Unit> c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r6) {
        Message r7 = (Message) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        if ((r7.getLocalIndex() % ((long) 1000)) != 0) goto L9;
        Ref.BooleanRef r0 = this.a;
        if (r0.element == true) goto L10;
        r0.element = true;
        com.larus.im.d.e().unregisterOnGlobalMessageObserver(this.b);
        this.c.invoke(r7);
        return;
    L10:
        return;
    }

    public m0(Ref.BooleanRef r1, n0 r2, l0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
