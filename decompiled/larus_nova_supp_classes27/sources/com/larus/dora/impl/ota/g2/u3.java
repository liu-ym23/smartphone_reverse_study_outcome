package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class u3 implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;

    public /* synthetic */ u3(boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r40) {
        boolean r1 = this.a;
        String r2 = this.b;
        f r3 = (f) r40;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r1 == false) goto L5;
        w4 r9 = new w4(0, null, false, null, 31);
    L6:
        l r13 = r3.c();
        OtaMode r4 = OtaMode.SILENT_G2;
        g5 r14 = r3.c().l();
        if (r14 == null) goto L9;
        g5 r24 = g5.a(r14, r4);
    L10:
        l r15 = l.a(r13, null, 0, r4, 0, 0, 0, false, r24, true, null, null, 3319);
        v4 r20 = r3.f();
        if (r3.f().b() != BlockReason.MANUAL_ENTERED_TONIGHT) goto L13;
        BlockReason r16 = BlockReason.NONE;
    L15:
        return f.a(r3, null, null, null, null, null, r9, null, null, null, r15, v4.a(r20, null, 0, r4, 0, 0, false, null, null, 0, 0, 0, r16, null, false, 12279), null, null, null, q5.a(r3.q(), r2, null, "", 2), null, null, 95167);
    L13:
        r16 = r3.f().b();
        goto L15
    L9:
        r24 = null;
        goto L10
    L5:
        r9 = r3.i();
        goto L6
    }
}
