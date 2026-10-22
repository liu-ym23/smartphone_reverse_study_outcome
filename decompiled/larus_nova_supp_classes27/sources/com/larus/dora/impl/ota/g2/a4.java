package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a4 implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ OtaMode c;

    public /* synthetic */ a4(String r1, long r2, OtaMode r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object invoke(Object r31) {
        String r10 = this.a;
        long r4 = this.b;
        OtaMode r6 = this.c;
        f r11 = (f) r31;
        Intrinsics.checkNotNullParameter(r11, "it");
        v4 r22 = new v4(InstallPhase.DECLARING_TYPE, r10, r4, r6, null, r11.f().c(), 16368);
        q5 r1 = r11.q();
        String r2 = r11.q().b();
        if (StringsKt.isBlank(r2) == true) goto L7;
        r10 = r2;
    L7:
        return f.a(r11, null, null, null, null, null, null, null, null, null, null, r22, null, null, null, q5.a(r1, null, null, r10, 3), null, null, 223231);
    }
}
