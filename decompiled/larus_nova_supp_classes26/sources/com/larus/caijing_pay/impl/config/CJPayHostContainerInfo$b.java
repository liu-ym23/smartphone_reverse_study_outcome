package com.larus.caijing_pay.impl.config;

import cd4.o;
import com.bytedance.security.android.polaris.PolarisFile;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJPayHostContainerInfo$b implements o {
    public CJPayHostContainerInfo$b() {
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uriPath");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        return PolarisFile.isFileInAppSandbox(r2, AppHost.a.getApplication());
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return false;
    }
}
