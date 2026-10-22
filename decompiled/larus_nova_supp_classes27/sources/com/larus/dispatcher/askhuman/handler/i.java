package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.local_pc_dispatch_fallback";
    }

    public i() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptorContext");
        return j.a(r2.e);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r9) {
        Intrinsics.checkNotNullParameter(r9, "interceptorContext");
        boolean r0 = IQuickReplyClickInterceptor.DefaultImpls.d(this, r9.c, r9.h, r9.j, r9.m, r9.n, r9.o);
        BrowserTakeoverEntryMonitor r1 = r9.p;
        if (r1 == null) goto L6;
        r1.a(r0, BrowserTakeoverEntryMonitor.Reason.PC_UNAVAILABLE);
    L6:
        return IQuickReplyClickInterceptor.DefaultImpls.b(r9, r0);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void a(o r1, Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r2) {
        IQuickReplyClickInterceptor.DefaultImpls.e(r1, r2);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p b(o r1, boolean r2) {
        return IQuickReplyClickInterceptor.DefaultImpls.b(r1, r2);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean d(FragmentActivity r1, String r2, Integer r3, String r4, String r5, String r6) {
        return IQuickReplyClickInterceptor.DefaultImpls.d(this, r1, r2, r3, r4, r5, r6);
    }
}
