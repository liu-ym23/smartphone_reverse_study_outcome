package com.larus.bmhome.chat.immerse;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ w0(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        MessageListMaskWrapper r0 = this.a;
        boolean r7 = ((Boolean) r6).booleanValue();
        FLogger.a.d(r0.g, "watchOnImeInsetsAnimation: onEnd isImeShow=" + r7);
        if (r7 == true) goto L5;
        r0.b.n.smoothScrollToPosition(0);
    L5:
        r0.q = false;
        r0.r = r7;
        return Unit.INSTANCE;
    }
}
