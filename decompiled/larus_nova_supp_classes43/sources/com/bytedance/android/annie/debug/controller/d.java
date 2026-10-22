package com.bytedance.android.annie.debug.controller;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.card.AnnieCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        AnnieCard r11 = this.a.b.ac();
        if (r11 == null) goto L12;
        View r0 = r11.getHybridView();
        if ((r0 instanceof WebView) == false) goto L7;
        WebView r1 = (WebView) r0;
    L8:
        if (r1 == null) goto L10;
        int r12 = a8.a.a;
        Intrinsics.checkNotNullParameter(r1, "webView");
        r1.getSettings().setCacheMode(2);
    L10:
        a7.a.a(r11, null, null, 3);
        return;
    L7:
        r1 = null;
        goto L8
    }
}
