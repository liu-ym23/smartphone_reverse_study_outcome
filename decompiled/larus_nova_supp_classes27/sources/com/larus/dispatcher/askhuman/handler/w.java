package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.internal.jni.bean.AskHumanResultWarn;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.InteractionWarnResultPayload;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w implements IQuickReplyClickInterceptor {
    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.warn";
    }

    public w() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r5) {
        Intrinsics.checkNotNullParameter(r5, "interceptorContext");
        Integer r0 = r5.b.getActionType();
        int r1 = ActionType.CUA_WARN_REFUSE.getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != r1) goto L21;
        u r2 = h.f(r5).e;
        if (r2 == null) goto L15;
        Integer r3 = r2.b;
        if (r3 == null) goto L15;
        if (r3.intValue() != 11) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
    L19:
        return true;
    L18:
        if (r5.e.a() == true) goto L19;
        return false;
    L15:
        r4 = false;
        goto L16
    L21:
        return false;
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r33) {
        Intrinsics.checkNotNullParameter(r33, "interceptorContext");
        u r1 = r33.d.e;
        if (r1 == null) goto L11;
        Integer r2 = r1.b;
        if (r2 == null) goto L11;
        if (r2.intValue() != 11) goto L11;
        return AskHumanWarnResultUploaderKt.a(r1, r33.g);
    L11:
        String r3 = r33.e;
        DispatchCommand r4 = DispatchCommand.INTERACTION_WARN_HANDLE;
        String r5 = UUID.randomUUID().toString();
        t r6 = r33.d;
        return new p(true, IQuickReplyClickInterceptor.DefaultImpls.c(this, r33, r3, new DispatchCommandPayload(r4, r5, new DispatchCommandBody(null, null, null, null, null, new InteractionWarnResultPayload(r6.a, r6.b, new AskHumanResultWarn(r33.d.c, true)), null, null, null, null, null, null, null, null, 16351, null), null, r33.f, null, 0, null, null, 488, null)));
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
