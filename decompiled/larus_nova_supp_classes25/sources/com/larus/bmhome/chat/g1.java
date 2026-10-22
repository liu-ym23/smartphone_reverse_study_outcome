package com.larus.bmhome.chat;

import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g1 implements Function1 {
    public final /* synthetic */ h1 a;

    public /* synthetic */ g1(h1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        h1 r0 = this.a;
        Pair r8 = (Pair) r7;
        if (com.larus.platform.service.z2.a.enableChatWithTab() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Integer r3 = r0.i;
        int r4 = ((Number) r8.getSecond()).intValue();
        if (r3 != null) goto L12;
    L13:
        if (r1 == true) goto L16;
    L14:
        float r2 = RangesKt.coerceAtLeast(1 - ((((Number) r8.getFirst()).intValue() / v19.i5.x0(v19.c.b(2130971547, null, 2131167463))) * 0.5f), 0.5f);
        r0.b.i.setAlpha(r2);
        r0.b.n.setAlpha(r2);
        r0.b.r.setAlpha(r2);
        FLogger.a.i(r0.f, "slideDistance=" + r8);
    L16:
        return Unit.INSTANCE;
    L12:
        if (r3.intValue() == r4) goto L14;
    L5:
        if ((r0.a.getActivity() instanceof j4) == false) goto L7;
        r1 = true;
        goto L8
    }
}
