package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ s$a0 a;
    public final /* synthetic */ f b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ s0(s$a0 r1, f r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r33) {
        s$a0 r1 = this.a;
        f r2 = this.b;
        boolean r8 = this.c;
        boolean r9 = this.d;
        f r13 = (f) r33;
        Intrinsics.checkNotNullParameter(r13, "it");
        String r4 = r1.e();
        c4 r3 = c4.INSTANCE;
        long r5 = r1.c();
        r3.getClass();
        long r11 = c4.V(r5);
        a5 r6 = r2.j();
        if (r6 == null) goto L5;
        d5 r7 = r6.h();
    L7:
        return f.a(r13, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new a5(r4, true, 0, r8, r9, r7, r11), 131071);
    L5:
        r7 = null;
        goto L7
    }
}
