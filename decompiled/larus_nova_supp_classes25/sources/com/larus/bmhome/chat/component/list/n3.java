package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n3 implements Function1 {
    public final /* synthetic */ wc9.e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ReplyOption c;

    public /* synthetic */ n3(wc9.e r1, String r2, ReplyOption r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8) {
        wc9.e r0 = this.a;
        String r3 = this.b;
        ReplyOption r1 = this.c;
        wc9.e r9 = (wc9.e) r8;
        int r2 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r9, "createdConversation");
        tx9.h0.c(r9.a, r0.a, r3, r1.getModeId(), r1.getModel().getKey(), tx9.h0.g(tx9.h0.f(r9.r).opt("fork_index")));
        return Unit.INSTANCE;
    }
}
