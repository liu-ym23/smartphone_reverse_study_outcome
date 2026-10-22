package com.bytedance.android.anniex.lite.container;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements ib.f {
    public final qa.a a;
    public final com.bytedance.android.anniex.base.lifecycle.a b;
    public final ia.c c;

    @Override // ib.f
    public final void onLoadStart(String r10, WebView r11) {
        this.b.h(r10, this.c);
    }

    @Override // ib.f
    public final void onLoadUriSuccess(String r10, WebView r11) {
        com.bytedance.android.anniex.base.lifecycle.a r12 = this.b;
        if (r10 != null) goto L5;
        r10 = this.a.e;
    L5:
        r12.i(r10, this.c);
    }

    public p(qa.a r10, AnnieXLiteContainer.b r11, ia.c r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXContext");
        Intrinsics.checkNotNullParameter(r11, "originLifeCycle");
        Intrinsics.checkNotNullParameter(r12, "iContainer");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    @Override // ib.f
    public final void onLoadFail(String r10, WebView r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r12, "e");
        com.bytedance.android.anniex.base.lifecycle.a r13 = this.b;
        if (r10 != null) goto L5;
        r10 = this.a.e;
    L5:
        r13.g(r10, this.c, r12);
    }
}
