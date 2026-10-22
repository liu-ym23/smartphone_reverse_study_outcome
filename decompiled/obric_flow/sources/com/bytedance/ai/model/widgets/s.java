package com.bytedance.ai.model.widgets;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.lynx.tasm.ui.image.f0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends sj.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2370b;

    public /* synthetic */ s(Object r5, int r10) {
        this.f2369a = r10;
        this.f2370b = r5;
    }

    @Override // ol.c
    public final void d(ViewGroup r5) {
        switch(this.f2369a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "view");
        if ((r5 instanceof WebView) == false) goto L7;
        WebView r10 = (WebView) r5;
    L8:
        j1.e r11 = (j1.e) this.f2370b;
        r11.e = r10;
        if (r10 == null) goto L22;
        r10.getSettings().setTextZoom((int) (1.0f * 100));
        r10.setOverScrollMode(2);
        r10.getSettings().setJavaScriptEnabled(true);
        r10.getSettings().setDisplayZoomControls(false);
        r10.getSettings().setBuiltInZoomControls(false);
        j1.g r12 = f0.b(r10);
        g1.d r13 = r11.f18226c;
        r13.f17015a.c(r10);
        if (r12 == null) goto L13;
        r13.f17015a.d(r12);
        return;
    L13:
        Intrinsics.checkNotNullParameter("WebRenderView", "tag");
        Intrinsics.checkNotNullParameter("webViewPort is NULL", "msg");
        a1.a.f43a.e("WebRenderView", "webViewPort is NULL", null);
        return;
    L22:
        return;
    L7:
        r10 = null;
        goto L8
    L15:
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r5, "view");
        WebViewFloatingPageV2 r14 = (WebViewFloatingPageV2) this.f2370b;
        r5.setOnFocusChangeListener(new h(r14, 1));
        if ((r5 instanceof WebView) == false) goto L18;
        WebView r15 = (WebView) r5;
    L19:
        if (r15 == null) goto L24;
        r14.i(r15);
        return;
    L24:
        return;
    L18:
        r15 = null;
        goto L19
    }
}
