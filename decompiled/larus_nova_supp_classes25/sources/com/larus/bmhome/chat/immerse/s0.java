package com.larus.bmhome.chat.immerse;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ s0(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        MessageListMaskWrapper r0 = this.a;
        boolean r9 = ((Boolean) r8).booleanValue();
        r0.i();
        if (Intrinsics.areEqual(r0.l, Boolean.TRUE) == false) goto L5;
        r0.o((int) (((double) r0.h) * 0.45d));
        r0.a(r0.k);
    L7:
        r0.q = false;
        r0.r = r9;
        FLogger.a.d("MessageListMaskWrapper", "watchOnImeInsetsAnimationEnd onEnd, inImePoppingProgress = false");
        return Unit.INSTANCE;
    L5:
        if (r9 == true) goto L7;
        r0.a(0);
        goto L7
    }
}
