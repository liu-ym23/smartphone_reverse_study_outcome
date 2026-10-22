package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v3 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ a5 b;

    public /* synthetic */ v3(long r1, a5 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r28) {
        long r2 = this.a;
        a5 r1 = this.b;
        f r4 = (f) r28;
        Intrinsics.checkNotNullParameter(r4, "it");
        CheckPurpose r5 = CheckPurpose.PREDOWNLOAD;
        c4 r7 = c4.INSTANCE;
        String r3 = r1.g();
        r7.getClass();
        return f.a(r4, null, null, null, null, null, new w4(r2, r5, true, c4.T(r3, r2), 8), null, null, null, null, null, null, null, null, null, null, null, 262079);
    }
}
