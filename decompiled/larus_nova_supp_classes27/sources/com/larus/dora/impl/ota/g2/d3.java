package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d3 implements Function1 {
    public final /* synthetic */ e5 a;
    public final /* synthetic */ ManualOnlyReason b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ d3(e5 r1, ManualOnlyReason r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r42) {
        e5 r8 = this.a;
        ManualOnlyReason r1 = this.b;
        boolean r2 = this.c;
        f r3 = (f) r42;
        Intrinsics.checkNotNullParameter(r3, "it");
        w4 r23 = new w4(0, null, false, null, 31);
        f5 r9 = f5.a(r3.l(), null, null, 0, 0, 0, null, r1, r8.h(), 127);
        if (r2 == false) goto L5;
        l r4 = l.a(r3.c(), null, 0, null, 0, 0, 0, false, null, false, BlockReason.MANUAL_ONLY, null, 3071);
    L7:
        return f.a(r3, null, null, null, null, null, r23, r8, r9, null, r4, null, null, null, null, null, null, null, 260671);
    L5:
        r4 = new l(null, 0, null, r3.c().g(), false, false, BlockReason.MANUAL_ONLY, null, 3063);
        goto L7
    }
}
