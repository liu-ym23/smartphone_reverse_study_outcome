package com.bytedance.android.annie.monitor.web;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.web.jsbridge2.u;
import java.util.List;
import jz2.d;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements n9.b {
    public a() {
    }

    @Override // n9.b
    public final List<com.bytedance.android.annie.card.base.b> a() {
        return CollectionsKt.listOf(new AnnieWebMonitorCallback());
    }

    @Override // n9.b
    public final List<u> b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if ((r10 instanceof WebView) == false) goto L5;
        WebView r11 = (WebView) r10;
    L6:
        if (r11 == null) goto L10;
        return CollectionsKt.listOf(new c(r11));
    L10:
        return CollectionsKt.emptyList();
    L5:
        r11 = null;
        goto L6
    }

    @Override // n9.b
    public final void g(View r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, int r16) {
        m r0 = m.f;
        if ((r10 instanceof WebView) == false) goto L5;
        WebView r17 = (WebView) r10;
    L6:
        r0.getClass();
        nz2.b.f("WebViewMonitorHelper", "custom final: bid: , url: " + r12 + ", eventName: " + r11);
        if (r15 != null) goto L10;
        r15 = new JSONObject();
    L10:
        if (r16 < 0) goto L12;
        if (r16 > 8) goto L12;
    L13:
        d.a r1 = new d.a(r11);
        r1.b = "";
        r1.a = r12;
        r1.d = r13;
        r1.e = r14;
        r1.f = null;
        r1.h = r15;
        r1.b(r16);
        r0.j(r17, r1.a());
        return;
    L12:
        r16 = 8;
        goto L13
    L5:
        r17 = null;
        goto L6
    }
}
