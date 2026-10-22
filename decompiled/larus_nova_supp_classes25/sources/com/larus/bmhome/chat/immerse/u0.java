package com.larus.bmhome.chat.immerse;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;
    public final /* synthetic */ Ref.IntRef b;

    public /* synthetic */ u0(MessageListMaskWrapper r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6) {
        MessageListMaskWrapper r0 = this.a;
        Ref.IntRef r1 = this.b;
        boolean r7 = ((Boolean) r6).booleanValue();
        r0.q = true;
        r0.r = r7;
        r1.element = r0.e().a;
        FLogger.a.d(r0.g, "watchOnImeInsetsAnimation: onStart it=" + r7 + ", lastRoundChatHeight=" + r1.element);
        return Unit.INSTANCE;
    }
}
