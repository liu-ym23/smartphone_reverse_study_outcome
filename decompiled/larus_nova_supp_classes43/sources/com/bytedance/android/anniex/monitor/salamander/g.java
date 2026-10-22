package com.bytedance.android.anniex.monitor.salamander;

import android.webkit.JavascriptInterface;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.webview.WebViewDataManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final WebViewDataManager a;
    public final String b;

    public final String a() {
        com.bytedance.android.monitorV2.webview.c r0 = this.a.c();
        if (r0 == null) goto L5;
        String r1 = r0.n;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public g(WebViewDataManager r10) {
        Intrinsics.checkNotNullParameter(r10, "webViewDataManager");
        this.a = r10;
        this.b = "SLMonitorWebViewBridge";
    }

    @JavascriptInterface
    public final void config(String r10) {
        Intrinsics.checkNotNullParameter(r10, "configString");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        HybridLogger r11 = HybridLogger.a;     // Catch: Throwable -> L8
        if (HybridLogger.c(this.b, r10, LogLevel.I) == true) goto L6;
        nz2.b.f(this.b, "sessionId: " + a() + ", config: " + r10);     // Catch: Throwable -> L8
    L6:
        c.a.a(a()).m(b.b(l.r(r10)), null);     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L16;
        nz2.b.b(this.b, "config failed, exception is " + r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @JavascriptInterface
    public final void customReport(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reportString");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        HybridLogger r11 = HybridLogger.a;     // Catch: Throwable -> L8
        if (HybridLogger.c(this.b, r10, LogLevel.I) == true) goto L6;
        nz2.b.f(this.b, "sessionId: " + a() + ", customReport: " + r10);     // Catch: Throwable -> L8
    L6:
        c.a.a(a()).A(r10);     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L16;
        nz2.b.b(this.b, "customReport failed, exception is " + r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @JavascriptInterface
    public final void reportJSError(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reportString");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        HybridLogger r11 = HybridLogger.a;     // Catch: Throwable -> L8
        if (HybridLogger.c(this.b, r10, LogLevel.I) == true) goto L6;
        nz2.b.f(this.b, "sessionId: " + a() + ", reportJSError: " + r10);     // Catch: Throwable -> L8
    L6:
        c.a.a(a()).I(r10);     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L16;
        nz2.b.b(this.b, "reportJSError failed, exception is " + r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @JavascriptInterface
    public final void reportPerformance(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reportString");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        HybridLogger r11 = HybridLogger.a;     // Catch: Throwable -> L8
        if (HybridLogger.c(this.b, r10, LogLevel.I) == true) goto L6;
        nz2.b.f(this.b, "sessionId: " + a() + ", reportPerformance");     // Catch: Throwable -> L8
    L6:
        c.a.a(a()).n(r10);     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L16;
        nz2.b.b(this.b, "reportPerformance failed, exception is " + r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
