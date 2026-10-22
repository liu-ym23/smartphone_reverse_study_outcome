package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.fallback";
    }

    public g() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r4) {
        Intrinsics.checkNotNullParameter(r4, "interceptorContext");
        if (r4.e.a() == true) goto L5;
        return false;
    L5:
        Map r0 = r4.b.getExtraParams();
        if (r0 == null) goto L8;
        String r1 = (String) r0.get("pc_native_may_involve");
    L10:
        if (Intrinsics.areEqual(r1, "1") == false) goto L20;
        Set<Integer> r2 = n.a;
        Integer r5 = r4.g;
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == true) goto L21;
        return true;
    L21:
        return false;
    L14:
        if (n.a.contains(r5) == false) goto L16;
        r6 = true;
        goto L17
    L20:
        return false;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r9) {
        Intrinsics.checkNotNullParameter(r9, "interceptorContext");
        return IQuickReplyClickInterceptor.DefaultImpls.b(r9, IQuickReplyClickInterceptor.DefaultImpls.d(this, r9.c, r9.h, r9.j, r9.m, r9.n, r9.o));
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
