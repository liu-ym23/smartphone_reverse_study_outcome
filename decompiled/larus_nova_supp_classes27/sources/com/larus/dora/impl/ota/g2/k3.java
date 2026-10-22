package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k3 implements Function1 {
    public final /* synthetic */ ManualOnlyReason a;
    public final /* synthetic */ d5 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ OtaMode d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ e5 f;
    public final /* synthetic */ q5 g;
    public final /* synthetic */ a5 h;

    public /* synthetic */ k3(ManualOnlyReason r1, d5 r2, long r3, OtaMode r5, boolean r6, e5 r7, q5 r8, a5 r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final Object invoke(Object r310) {
        ManualOnlyReason r11 = this.a;
        d5 r12 = this.b;
        long r14 = this.c;
        OtaMode r13 = this.d;
        boolean r10 = this.e;
        e5 r8 = this.f;
        q5 r9 = this.g;
        a5 r6 = this.h;
        f r7 = (f) r310;
        Intrinsics.checkNotNullParameter(r7, "it");
        w4 r31 = new w4(0, null, false, null, 31);
        f5 r1 = f5.a(r7.l(), null, null, 0, 0, 0, null, r11, r12, 127);
        if (r7.c().j() == DownloadPhase.CHECKING) goto L5;
    L7:
        l r2 = r7.c();
    L9:
        return f.a(r7, null, null, null, null, null, r31, r8, r1, null, r2, null, null, null, j5.a(r7.m(), 0, "", 0, 0, 0, 0, 60), r9, null, r6, 76351);
    L5:
        if (r7.c().i() != r14) goto L7;
        r2 = new l(null, 0, null, r13, false, r10, null, null, 3575);
        goto L9
    }
}
