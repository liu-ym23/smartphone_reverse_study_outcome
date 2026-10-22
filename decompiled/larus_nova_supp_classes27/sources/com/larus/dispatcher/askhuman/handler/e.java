package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.ActionType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.authorize_folder";
    }

    public e() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r4) {
        Intrinsics.checkNotNullParameter(r4, "interceptorContext");
        Integer r0 = r4.b.getActionType();
        int r1 = ActionType.CUA_AUTHORIZE_FOLDER_SELECT.getValue();
        boolean r2 = false;
        if (r0 != null) goto L6;
    L14:
        return false;
    L6:
        if (r0.intValue() != r1) goto L14;
        bs8.a r5 = r4.e.b;
        if (r5 == null) goto L13;
        if (r5.b() != true) goto L13;
        r2 = true;
    L13:
        return !r2;
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
