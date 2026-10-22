package com.bytedance.ies.bullet.kit.web;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.service.base.YieldError;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5559b;

    public /* synthetic */ k(p r5, int r10) {
        this.f5558a = r10;
        this.f5559b = r5;
    }

    @Override // bd.c
    public void a(com.bytedance.frameworks.baselib.network.http.cronet.b r5) {
        switch(this.f5558a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.a(r5);
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r10 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r10 == null) goto L11;
        r10.a(r5);     // Catch: YieldError -> L12
        throw null;     // Catch: YieldError -> L12
    L11:
        throw new YieldError();
    }

    @Override // bd.c
    public boolean b(WebView r5, ValueCallback r10, ym.d r11) {
        switch(this.f5558a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        com.ivy.ivykit.plugin.impl.web.d r12 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r12 == null) goto L12;
        r12.b(r5, r10, r11);     // Catch: YieldError -> L13
        return false;
    L12:
        throw new YieldError();
    L5:
        return super.b(r5, r10, r11);
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        switch(this.f5558a) {
            case 0: goto L12;
            case 1: goto L5;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        com.ivy.ivykit.plugin.impl.web.d r5 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r5 == null) goto L11;
        return r5.f9538b.g;
    L11:
        throw new YieldError();
    L12:
        c2.b r10 = ((m) this.f5559b).g;
        throw new YieldError();
    L5:
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r5, int r10, String r11) {
        switch(this.f5558a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onConsoleMessage(r5, r10, r11);
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r12 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r12 == null) goto L13;
        r12.onConsoleMessage(r5, r10, r11);     // Catch: YieldError -> L10
        return;
    L14:
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        switch(this.f5558a) {
            case 1: goto L10;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onHideCustomView();
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r5 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r5 == null) goto L12;
        r5.onHideCustomView();
        return;
    L12:
        return;
    L10:
        super.onHideCustomView();
        ((com.bytedance.ies.bullet.kit.web.impl.i) this.f5559b).getClass();
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r5, String r10, String r11, JsResult r12) {
        switch(this.f5558a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.onJsBeforeUnload(r5, r10, r11, r12);
    L7:
        if (((com.ivy.ivykit.plugin.impl.web.d) this.f5559b) == null) goto L11;
        throw new YieldError();     // Catch: YieldError -> L12
    L11:
        throw new YieldError();
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r5, String r10, String r11, JsResult r12) {
        switch(this.f5558a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.onJsConfirm(r5, r10, r11, r12);
    L7:
        if (((com.ivy.ivykit.plugin.impl.web.d) this.f5559b) == null) goto L11;
        throw new YieldError();     // Catch: YieldError -> L12
    L11:
        throw new YieldError();
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r5, String r10, String r11, String r12, JsPromptResult r13) {
        switch(this.f5558a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.onJsPrompt(r5, r10, r11, r12, r13);
    L7:
        if (((com.ivy.ivykit.plugin.impl.web.d) this.f5559b) == null) goto L11;
        throw new YieldError();     // Catch: YieldError -> L12
    L11:
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView r5, int r10) {
        switch(this.f5558a) {
            case 0: goto L12;
            case 1: goto L4;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onProgressChanged(r5, r10);
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r11 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r11 != null) goto L24;
    L10:
        super.onProgressChanged(r5, r10);
        return;
    L24:
        r11.onProgressChanged(r5, r10);     // Catch: YieldError -> L23
        return;
    L12:
        super.onProgressChanged(r5, r10);
        rb.b r12 = ((m) this.f5559b).f5572n;
        if (r12 != null) goto L16;
        r12 = null;
    L16:
        if (r12 != null) goto L18;
        return;
    L18:
        if (r12.a(com.bytedance.android.anniex.base.service.e.class) != null) goto L21;
        return;
    L21:
        throw new ClassCastException();
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r5, String r10) {
        switch(this.f5558a) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        com.ivy.ivykit.plugin.impl.web.d r11 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r11 == null) goto L23;
        r11.onReceivedTitle(r5, r10);
        return;
    L23:
        return;
    L8:
        super.onReceivedTitle(r5, r10);
        ((com.bytedance.ies.bullet.kit.web.impl.i) this.f5559b).g();
        return;
    L10:
        if (r10 == null) goto L21;
        m r12 = (m) this.f5559b;
        c2.b r13 = r12.g;
        rb.b r14 = r12.f5572n;
        if (r14 != null) goto L15;
        r14 = null;
    L15:
        if (r14 == null) goto L21;
        if (r14.a(com.bytedance.android.anniex.base.service.f.class) == null) goto L21;
        throw new ClassCastException();
    L21:
        super.onReceivedTitle(r5, r10);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r5, WebChromeClient.CustomViewCallback r10) {
        switch(this.f5558a) {
            case 1: goto L12;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onShowCustomView(r5, r10);
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r11 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r11 != null) goto L17;
    L10:
        super.onShowCustomView(r5, r10);
        return;
    L17:
        r11.onShowCustomView(r5, r10);     // Catch: YieldError -> L16
        return;
    L12:
        super.onShowCustomView(r5, r10);
        if (r5 == null) goto L20;
        ((com.bytedance.ies.bullet.kit.web.impl.i) this.f5559b).getClass();
        return;
    }

    @Override // bd.c, android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r5, ValueCallback r10, WebChromeClient.FileChooserParams r11) {
        switch(this.f5558a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        com.ivy.ivykit.plugin.impl.web.d r12 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r12 == null) goto L11;
        return r12.onShowFileChooser(r5, r10, r11);
    L11:
        return super.onShowFileChooser(r5, r10, r11);
    L5:
        return super.onShowFileChooser(r5, r10, r11);
    }

    public k(com.ivy.ivykit.plugin.impl.web.d r5) {
        this.f5558a = 2;
        this.f5559b = r5;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r5, int r10, WebChromeClient.CustomViewCallback r11) {
        switch(this.f5558a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onShowCustomView(r5, r10, r11);
        return;
    L6:
        com.ivy.ivykit.plugin.impl.web.d r12 = (com.ivy.ivykit.plugin.impl.web.d) this.f5559b;
        if (r12 != null) goto L13;
    L10:
        super.onShowCustomView(r5, r10, r11);
        return;
    L13:
        r12.onShowCustomView(r5, r10, r11);     // Catch: YieldError -> L12
    }
}
