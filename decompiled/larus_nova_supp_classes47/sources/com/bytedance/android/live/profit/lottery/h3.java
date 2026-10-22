package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h3<T, R> implements Function {
    public final /* synthetic */ g3.e a;

    public h3(g3.e r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        LotteryState r6 = (LotteryState) r5;
        Intrinsics.checkNotNullParameter(r6, "state");
        if ((r6 instanceof LotteryState.g) == false) goto L6;
        return new g3.a.b(((LotteryState.g) r6).a, false);
    L6:
        if ((r6 instanceof LotteryState.d) == false) goto L12;
        if (w2.c() == true) goto L55;
        LotteryState.d r7 = (LotteryState.d) r6;
        this.a.a.f.a(sh6.c.a(r7.b));
        return new g3.a.b(r7.a, true);
    L55:
        return g3.a.C0033a.a;
    L12:
        if ((r6 instanceof LotteryState.a) == false) goto L53;
        Boolean r3 = null;
        if (((Boolean) w2.j.getValue(null, w2.a[8])).booleanValue() == false) goto L34;
        LotteryState.a r8 = (LotteryState.a) r6;
        String r0 = String.valueOf(r8.a.d);
        x2 r2 = f3.a;
        if (r2 == null) goto L18;
        String r4 = r2.lotteryType;
    L20:
        if (Intrinsics.areEqual(r0, r4) == false) goto L59;
        if (w2.c() == true) goto L57;
        x2 r1 = f3.a;
        if (r1 == null) goto L30;
        u0 r9 = r1.iconConfig;
        if (r9 == null) goto L30;
        r3 = r9.anchorIconDismiss;
    L30:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L58;
        g3.a.C0033a r10 = g3.a.C0033a.a;
    L60:
        return r10;
    L58:
        return new g3.a.b(r8.a, true);
    L57:
        return g3.a.C0033a.a;
    L59:
        return g3.a.C0033a.a;
    L18:
        r4 = null;
        goto L20
    L34:
        LotteryState.a r12 = (LotteryState.a) r6;
        String r13 = String.valueOf(r12.a.d);
        x2 r14 = f3.a;
        if (r14 == null) goto L37;
        String r15 = r14.lotteryType;
    L39:
        if (Intrinsics.areEqual(r13, r15) == false) goto L61;
        x2 r16 = f3.a;
        if (r16 == null) goto L46;
        u0 r17 = r16.iconConfig;
        if (r17 == null) goto L46;
        r3 = r17.anchorIconDismiss;
    L46:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L61;
        if (w2.c() == false) goto L61;
        r10 = g3.a.C0033a.a;
    L61:
        return new g3.a.b(r12.a, true);
    L37:
        r15 = null;
        goto L39
    L53:
        return g3.a.C0033a.a;
    }
}
