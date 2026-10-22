package c4;

import android.webkit.JavascriptInterface;
import com.lynx.tasm.utils.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1116a;

    public b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        this.f1116a = r5;
    }

    @JavascriptInterface
    public final void config(String r5) {
        Intrinsics.checkNotNullParameter(r5, "configString");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        d5.b.f("SLMonitorWebViewBridge", "config: " + r5);     // Catch: Throwable -> L5
        a.f1115a.a(this.f1116a).j(d.i(qo.a.c(r5)));     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        d5.b.e("SLMonitorWebViewBridge", "config failed, exception is " + r12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JavascriptInterface
    public final void reportJSError(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reportString");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        d5.b.f("SLMonitorWebViewBridge", "reportJSError: " + r5);     // Catch: Throwable -> L5
        a.f1115a.a(this.f1116a).i(r5);     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        d5.b.e("SLMonitorWebViewBridge", "reportJSError failed, exception is " + r12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
