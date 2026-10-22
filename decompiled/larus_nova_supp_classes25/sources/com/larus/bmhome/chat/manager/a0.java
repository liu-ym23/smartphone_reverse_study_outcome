package com.larus.bmhome.chat.manager;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements Function1<wc9.e, Unit> {
    public final /* synthetic */ wc9.e a;
    public final /* synthetic */ ReplyOption b;

    public a0(wc9.e r1, ReplyOption r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r8) {
        wc9.e r9 = (wc9.e) r8;
        Intrinsics.checkNotNullParameter(r9, "createdConversation");
        tx9.h0.c(r9.a, this.a.a, "", this.b.getModeId(), this.b.getModel().getKey(), tx9.h0.g(tx9.h0.f(r9.r).opt("fork_index")));
        return Unit.INSTANCE;
    }
}
