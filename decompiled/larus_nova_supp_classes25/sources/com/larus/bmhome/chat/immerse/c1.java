package com.larus.bmhome.chat.immerse;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c1 implements Function0 {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ c1(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final MessageListMaskWrapper r0 = this.a;
        r0.b.n.postDelayed(new t0(r0), 200);
        return Unit.INSTANCE;
    }
}
