package com.suite.lark.platform.component.cta.model;

import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Callback {
    public final /* synthetic */ StuckSpotRequestExecutor a;
    public final /* synthetic */ i<com.larksuite.rucket.job.base.b<goc.b>> b;

    public c(StuckSpotRequestExecutor r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(Call r4, IOException r5) {
        Intrinsics.checkNotNullParameter(r4, "call");
        Intrinsics.checkNotNullParameter(r5, "e");
        StuckSpotRequestExecutor.a(this.a, this.b, new com.larksuite.rucket.job.base.b.b(new ErrorResult(r5)));
    }

    public final void onResponse(Call r3, Response r4) {
        Intrinsics.checkNotNullParameter(r3, "call");
        Intrinsics.checkNotNullParameter(r4, "response");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        d r6 = d.a;     // Catch: Throwable -> L13
        ResponseBody r0 = r4.body();     // Catch: Throwable -> L13
        if (r0 == null) goto L7;
        String r1 = r0.string();     // Catch: Throwable -> L13
    L8:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        r6.getClass();     // Catch: Throwable -> L13
        com.larksuite.rucket.job.base.b r7 = d.a(r1);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L18
    L20:
        StuckSpotRequestExecutor r9 = this.a;
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L24;
        r8 = new com.larksuite.rucket.job.base.b.b(StuckSpotRequestExecutor.b(r9, r2));
    L24:
        StuckSpotRequestExecutor.a(this.a, this.b, (com.larksuite.rucket.job.base.b) r8);
        return;
    L7:
        r1 = null;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
