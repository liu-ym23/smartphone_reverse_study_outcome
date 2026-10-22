package com.larus.dora.obric.onboarding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final Function1<ObricDoraGEnvAuthResult, Unit> a;
    public boolean b;

    public h(j r2) {
        Intrinsics.checkNotNullParameter(r2, "onResult");
        this.a = r2;
    }

    public final void a(ObricDoraGEnvAuthResult r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        this.a.invoke(r2);
    }
}
