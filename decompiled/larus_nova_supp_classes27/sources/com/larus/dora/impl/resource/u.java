package com.larus.dora.impl.resource;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ x a;
    public final /* synthetic */ File b;

    public /* synthetic */ u(x r1, File r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        x r0 = this.a;
        File r1 = this.b;
        File r5 = (File) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        r0.getClass();
        return x.a(r1, r5);
    }
}
