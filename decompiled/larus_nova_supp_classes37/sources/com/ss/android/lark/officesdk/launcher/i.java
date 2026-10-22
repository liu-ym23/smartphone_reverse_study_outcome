package com.ss.android.lark.officesdk.launcher;

import android.app.Application;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements fva.c.a {

    @Inject
    public Lazy<com.ss.android.lark.app.initiator.a> a;

    @Inject
    public i() {
    }

    public final com.ss.android.lark.app.initiator.b a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Lazy<com.ss.android.lark.app.initiator.a> r3 = this.a;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("appLauncher");
        r3 = null;
    L7:
        return (com.ss.android.lark.app.initiator.b) r3.get();
    }
}
