package n30;

import android.webkit.WebView;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.monitor.webview.h;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements v30.a {
    public static final boolean a = false;
    public static final d b = null;

    public d() {
    }

    static {
        b = new d();
        a = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
    }

    @Override // v30.a
    public final com.bytedance.android.monitorV2.webview.c b() {
        m.f.getClass();
        com.bytedance.android.monitorV2.webview.c r0 = new com.bytedance.android.monitorV2.webview.c();
        r0.h = "88888";
        return r0;
    }

    @Override // v30.a
    public final com.bytedance.android.monitor.webview.b buildConfig() {
        h.g.getClass();
        com.bytedance.android.monitor.webview.b r0 = new com.bytedance.android.monitor.webview.b();
        r0.a = "88888";
        return r0;
    }

    @Override // v30.a
    public final void c(com.bytedance.android.monitorV2.webview.c r2) {
        m r0 = m.f;
        r0.getClass();
        r0.h(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    @Override // v30.a
    public final void d(com.bytedance.android.monitor.webview.b r2) {
        h r0 = h.g;
        r0.getClass();
        r0.e(r2);     // Catch: Exception -> L5
        return;
    L5:
        bz2.c.a();
    }

    @Override // v30.a
    public final void a(WebView r14, String r15, String r16, int r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "method");
        Object r12 = 0;
        if (r18 == null) goto L14;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        int r1 = StringsKt.lastIndexOf$default(r18, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L7
        int r5 = StringsKt.indexOf$default(r18, ',', r1, false, 4, null);     // Catch: Throwable -> L7
        r12 = Integer.valueOf(CastIntegerProtector.parseInt(r18.substring(r1 + 18, r5)));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r2 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r2) == true) goto L12;
        r12 = r2;
    L12:
        r12 = (Number) r12;
    L14:
        if (a == false) goto L20;
        jz2.g r3 = new jz2.g();
        r3.b = r15;
        r3.c = r17;
        if (r12 == null) goto L19;
        r3.d = ((Integer) r12).intValue();
        r3.e = r18;
        r3.a = r16;
        m.f.n(r14, r3);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L20:
        py2.f r4 = new py2.f();
        r4.b = r15;
        r4.c = r17;
        if (r12 == null) goto L25;
        r4.d = ((Integer) r12).intValue();
        r4.e = r18;
        r4.a = r16;
        h.g.n(r14, r4);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
