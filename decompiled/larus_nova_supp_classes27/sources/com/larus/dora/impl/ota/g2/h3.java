package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h3 implements Function1 {
    public final /* synthetic */ ManualOnlyReason a;
    public final /* synthetic */ d5 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ BlockReason d;
    public final /* synthetic */ e5 e;
    public final /* synthetic */ q5 f;
    public final /* synthetic */ a5 g;

    public /* synthetic */ h3(ManualOnlyReason r1, d5 r2, boolean r3, BlockReason r4, e5 r5, q5 r6, a5 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r310) {
        ManualOnlyReason r11 = this.a;
        d5 r12 = this.b;
        boolean r14 = this.c;
        BlockReason r15 = this.d;
        e5 r13 = this.e;
        q5 r10 = this.f;
        a5 r8 = this.g;
        f r9 = (f) r310;
        Intrinsics.checkNotNullParameter(r9, "it");
        w4 r31 = new w4(0, null, false, null, 31);
        f5 r1 = f5.a(r9.l(), null, null, 0, 0, 0, null, r11, r12, 127);
        if (r14 == false) goto L5;
        l r2 = l.a(r9.c(), null, 0, null, 0, 0, 0, false, null, false, r15, null, 3071);
    L7:
        return f.a(r9, null, null, null, null, null, r31, r13, r1, null, r2, null, null, null, j5.a(r9.m(), 0, "", 0, 0, 0, 0, 60), r10, null, r8, 76351);
    L5:
        r2 = new l(null, 0, null, r9.c().g(), false, false, r15, null, 3063);
        goto L7
    }
}
