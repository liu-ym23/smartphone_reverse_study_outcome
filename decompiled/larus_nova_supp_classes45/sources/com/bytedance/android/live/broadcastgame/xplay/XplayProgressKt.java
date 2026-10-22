package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayProgressKt {
    public static final void a(n1 r2, final c1 r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$progress");
        Intrinsics.checkNotNullParameter(r3, "pm");
        r3.getClass();
        final c1.a r0 = new c1.a(r4);
        ((ArrayList) r3.c).add(r0);
        final Function0<Unit> r5 = new XplayProgressManager$task$1(r3, r0);
        Function2<l1, m1.b, Unit> r6 = new XplayProgressKt$progress$1(r5);
        Intrinsics.checkNotNullParameter(r2, "$this$onComplete");
        Intrinsics.checkNotNullParameter(r6, "callback");
        r2.c(new XplayTasksDslKt$onComplete$1(r6));
        final Function2<l1, m1.f, Unit> r7 = new XplayProgressKt$progress$2(r5);
        Intrinsics.checkNotNullParameter(r2, "$this$onSkip");
        Intrinsics.checkNotNullParameter(r7, "callback");
        r2.c(new XplayTasksDslKt$onSkip$1(r7));
    }
}
