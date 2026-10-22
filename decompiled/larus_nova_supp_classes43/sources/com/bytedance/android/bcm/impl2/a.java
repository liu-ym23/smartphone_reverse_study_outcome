package com.bytedance.android.bcm.impl2;

import android.util.Log;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import zc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Throwable b;

    public a(Function0 r1, Throwable r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L18
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L18
        Unit r11 = null;
        Function0 r12 = this.a;     // Catch: Throwable -> L21
        if (r12 == null) goto L7;
        Unit r13 = (Unit) r12.invoke();     // Catch: Throwable -> L21
    L8:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, String.valueOf(r13));     // Catch: Throwable -> L21
        Throwable r14 = this.b;     // Catch: Throwable -> L21
        if (r14 == null) goto L13;
        String r15 = Log.getStackTraceString(r14);     // Catch: Throwable -> L21
        int r16 = RangesKt.coerceAtMost(r15.length(), 500);     // Catch: Throwable -> L21
        if (r16 <= 0) goto L13;
        r10.put("stack_trace", r15.substring(0, r16));     // Catch: Throwable -> L21
        goto L13
    L7:
        r13 = null;
    L13:
        g r17 = BtmHostDependManager.F.f();     // Catch: Throwable -> L18
        if (r17 == null) goto L16;
        r17.a("bizbcm_monitor", r1, r10);     // Catch: Throwable -> L18
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(r11);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
