package com.bytedance.ai.model.widgets;

import android.webkit.WebResourceResponse;
import com.bytedance.ai.model.objects.PageInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements ol.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageInfo f2371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewFloatingPageV2 f2372b;

    public t(PageInfo r5, WebViewFloatingPageV2 r10) {
        this.f2371a = r5;
        this.f2372b = r10;
    }

    @Override // ol.f
    public final WebResourceResponse a(String r10, WebResourceResponse r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        if (r11 != null) goto L5;
    L25:
        Intrinsics.checkNotNullParameter(r10, "url");
        return r11;
    L5:
        if (Intrinsics.areEqual(r11.getMimeType(), "text/html") == false) goto L25;
        String r12 = "[afterLoadResource] " + r11.getMimeType() + " inject data for the floatingPage";
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L9;
        r5.i("WebViewFloatingPageV2", r12);
    L9:
        InputStream r13 = r11.getData();
        if (r13 == null) goto L24;
        String r14 = "window.__APPLET_VIEW_DATA__ = " + this.f2371a.getPageData() + ";\n";
        StringBuilder r15 = new StringBuilder("window.__APPLET_VIEW_CONTEXT__ = ");
        WebViewFloatingPageV2 r16 = this.f2372b;
        r16.f2330b.setPageId(r16.f2331c);
        r15.append(r16.f2330b.toViewContext());
        r15.append(";\n");
        String r17 = r15.toString();
        Intrinsics.checkNotNullParameter(r13, "<this>");
        StringBuilder r18 = new StringBuilder();
        BufferedReader r19 = new BufferedReader(new InputStreamReader(r13));
        String r20 = r19.readLine();     // Catch: Throwable -> L15
    L13:
        if (r20 == null) goto L17;
        r18.append(r20);     // Catch: Throwable -> L15
        r18.append("\n");     // Catch: Throwable -> L15
        r20 = r19.readLine();     // Catch: Throwable -> L15
        goto L13
    L17:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r19, null);
        return new WebResourceResponse(r11.getMimeType(), "utf-8", new ByteArrayInputStream(StringsKt.F(r18.toString(), "<!-- INJECT_GLOBAL_VARIABLES_CONTENT -->", com.lynx.tasm.utils.b.j("<script> window.__AI_SDK_VERSION__ = '0.90.0-rc.37-miniapp';\n", r14, r17, " </script>")).getBytes(Charsets.UTF_8)));
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);
        throw th;
    L24:
        return null;
    }
}
