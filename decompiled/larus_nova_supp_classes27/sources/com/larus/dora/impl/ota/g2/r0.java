package com.larus.dora.impl.ota.g2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class r0 implements Function1 {
    public final /* synthetic */ s.g0 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;

    public /* synthetic */ r0(s.g0 r1, List r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r31) {
        s.g0 r1 = this.a;
        List r2 = this.b;
        String r3 = this.c;
        f r5 = (f) r31;
        Intrinsics.checkNotNullParameter(r5, "it");
        return f.a(r5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new n5(r1.b(), CollectionsKt.joinToString$default(CollectionsKt.plus(r2, r3), ";", null, null, 0, null, null, 62, null)), null, 196607);
    }
}
