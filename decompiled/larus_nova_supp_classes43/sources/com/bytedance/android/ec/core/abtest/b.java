package com.bytedance.android.ec.core.abtest;

import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.Charsets;
import org.json.JSONObject;
import yf7.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements n {
    public final /* synthetic */ long a;

    public b(long r1) {
        this.a = r1;
    }

    public final void a(yf7.j.a r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        if (r10 != null) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject(new String(r10.a, Charsets.UTF_8));     // Catch: Throwable -> L7
        Lazy r1 = ECByteSyncManager.a;     // Catch: Throwable -> L7
        c.a.getClass();     // Catch: Throwable -> L7
        ECByteSyncManager.a(r11, c.a(r10), r10.b, this.a);     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L15;
        dm.a.a("EcByteSync").b("safeListenToByteSync", r13);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
