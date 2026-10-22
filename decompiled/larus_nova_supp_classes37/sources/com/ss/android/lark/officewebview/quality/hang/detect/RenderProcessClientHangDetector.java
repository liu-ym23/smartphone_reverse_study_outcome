package com.ss.android.lark.officewebview.quality.hang.detect;

import android.os.Build;
import androidx.webkit.WebViewCompat;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RenderProcessClientHangDetector implements kxb.a {
    public final OfficeWebView a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public RenderProcessClientHangDetector$init$newClient$1 d;

    public static final class a {
    }

    static {
    }

    @Override // kxb.a
    public final /* synthetic */ void start() {
    }

    @Override // kxb.a
    public final /* synthetic */ void stop() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.webkit.WebViewRenderProcessClient, com.ss.android.lark.officewebview.quality.hang.detect.RenderProcessClientHangDetector$init$newClient$1] */
    @Override // kxb.a
    public final void init() {
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        j.e("RenderProcessHangDetector", "start: api < 29, skip render process client detector");
        return;
    L7:
        if (this.d == null) goto L9;
        return;
    L9:
        ?? r0 = new RenderProcessClientHangDetector$init$newClient$1(this);
        this.d = r0;
        WebViewCompat.setWebViewRenderProcessClient(this.a, r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        j.c("RenderProcessHangDetector", "setWebViewRenderProcessClient error", th);
        this.d = null;
    }

    public RenderProcessClientHangDetector(OfficeWebView r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "onUnresponsive");
        Intrinsics.checkNotNullParameter(r4, "onResponsive");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        HangDetectStrategy r5 = HangDetectStrategy.UNKNOWN;
    }
}
