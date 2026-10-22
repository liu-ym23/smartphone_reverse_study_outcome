package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Activity.ScreenCaptureCallback {
    public final /* synthetic */ d a;
    public final /* synthetic */ Activity b;

    public e(d r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.app.Activity.ScreenCaptureCallback
    public final void onScreenCaptured() {
        d r0 = this.a;
        Activity r1 = this.b;
        r0.getClass();
        long r2 = SystemClock.uptimeMillis();
        long r4 = r2 - r0.c;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Long.valueOf(w4c.c.a().o0()));     // Catch: Throwable -> L5
    L7:
        long r8 = 1500;
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = 1500L;
    L10:
        long r9 = ((Number) r7).longValue();
        if (r9 <= 0) goto L14;
        r8 = r9;
    L14:
        if (r4 >= r8) goto L16;
        Log.i("OfficeSDKScreenAudit", "screen captured on " + r1.getClass().getSimpleName() + ", dedup'd (" + r4 + "ms < " + r8 + "ms window)");
        return;
    L16:
        r0.c = r2;
        Log.i("OfficeSDKScreenAudit", "screen captured on ".concat(r1.getClass().getSimpleName()));
        r0.a.b();
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
