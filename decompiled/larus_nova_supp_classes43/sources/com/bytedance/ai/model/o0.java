package com.bytedance.ai.model;

import android.view.View;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o0 extends h0 {
    public final k2.j a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.model.h0
    public final String a() {
        return this.a.getAppletRuntime().h.K;
    }

    @Override // com.bytedance.ai.model.h0
    public final WebView b() {
        View r0 = this.a.engineView();
        if ((r0 instanceof WebView) == true) goto L7;
        return null;
    L7:
        return (WebView) r0;
    }

    public o0(k2.j r10) {
        Intrinsics.checkNotNullParameter(r10, "webViewPage");
        this.a = r10;
    }

    @Override // com.bytedance.ai.model.h0
    public final void c(String r10) {
        if (r10 == null) goto L5;
        this.a.getAppletRuntime().A(r10);
        return;
    }
}
