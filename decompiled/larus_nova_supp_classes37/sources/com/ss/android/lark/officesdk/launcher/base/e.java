package com.ss.android.lark.officesdk.launcher.base;

import android.app.Application;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements b {
    public e() {
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final String name() {
        return "InitUniStore";
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final void a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        new InitUniStoreTask().a(r2);
    }
}
