package com.larus.apm.impl;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ApmImpl$b implements e {
    public final /* synthetic */ ApmImpl a;

    public ApmImpl$b(ApmImpl r1) {
        this.a = r1;
    }

    public final void onGetId(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "did");
        Intrinsics.checkNotNullParameter(r3, "iid");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        ApmImpl r5 = this.a;
        Lazy r6 = ApmImpl.a;
        r5.d(r2);
    }
}
