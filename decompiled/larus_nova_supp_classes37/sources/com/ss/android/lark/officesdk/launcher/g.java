package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class g implements com.ss.android.lark.app.initiator.c {
    public final com.ss.android.lark.app.initiator.d a;

    @Inject
    public g(com.ss.android.lark.app.initiator.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mainProcessInitiator");
        this.a = r2;
    }

    public final com.ss.android.lark.app.initiator.d a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a;
    }
}
