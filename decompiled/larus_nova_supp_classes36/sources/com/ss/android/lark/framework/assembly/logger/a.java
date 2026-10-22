package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements com.ss.android.lark.log.b {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.log.b
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }
}
