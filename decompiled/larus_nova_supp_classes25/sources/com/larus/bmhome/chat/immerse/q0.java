package com.larus.bmhome.chat.immerse;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ q0(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        MessageListMaskWrapper r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        r0.q = true;
        r0.r = r4;
        FLogger.a.d("MessageListMaskWrapper", "watchOnImeInsetsAnimationEnd onStart, inImePoppingProgress = true");
        return Unit.INSTANCE;
    }
}
