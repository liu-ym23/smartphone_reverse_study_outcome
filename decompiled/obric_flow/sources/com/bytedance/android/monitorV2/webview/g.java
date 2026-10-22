package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3777a;

    public g(i r5) {
        this.f3777a = r5;
    }

    public final void a(WebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        r5.removeOnAttachStateChangeListener(this);
        r5.addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        i r10 = this.f3777a;
        r10.getClass();
        d5.b.c("WebViewDataManager", "onViewAttachedToWindow() called with: v = " + r5);
        if ((r5 instanceof WebView) == false) goto L6;
        r10.c(WebViewLifeState.f3744b);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        d5.b.c("WebViewDataManager", "onViewDetachedFromWindow() called with: v = " + r5);
        if ((r5 instanceof WebView) == false) goto L24;
        WebViewLifeState r10 = WebViewLifeState.f3745c;
        i r11 = this.f3777a;
        r11.c(r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        WebView r13 = (WebView) r11.f3779a.get();     // Catch: Throwable -> L8
        if (r13 == null) goto L10;
        String r14 = r13.getUrl();     // Catch: Throwable -> L8
    L11:
        Object r15 = Result.m124constructorimpl(Boolean.valueOf(Intrinsics.areEqual(Uri.parse(r14).getQueryParameter("disable_final_detect_when_detached"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST)));     // Catch: Throwable -> L8
    L14:
        Boolean r16 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r15) == false) goto L18;
        r15 = r16;
    L18:
        if (((Boolean) r15).booleanValue() == true) goto L25;
        r11.e(r11.f3792r);
        return;
    L25:
        return;
    L10:
        r14 = null;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
