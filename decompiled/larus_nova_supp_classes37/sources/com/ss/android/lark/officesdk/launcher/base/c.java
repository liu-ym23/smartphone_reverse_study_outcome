package com.ss.android.lark.officesdk.launcher.base;

import android.app.Application;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final String name() {
        return "InitLog";
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final void a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        new InitLogTask().a(r2);
    }
}
