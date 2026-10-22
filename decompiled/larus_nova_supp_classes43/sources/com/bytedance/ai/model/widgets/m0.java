package com.bytedance.ai.model.widgets;

import android.webkit.WebResourceResponse;
import com.bytedance.ai.model.objects.PageInfo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m0 implements ix7.g {
    public final /* synthetic */ WebEngineAssem a;

    public m0(WebEngineAssem r1) {
        this.a = r1;
    }

    public final WebResourceResponse a(String r11, WebResourceResponse r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r12 != null) goto L5;
    L48:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return r12;
    L5:
        if (Intrinsics.areEqual(r12.getMimeType(), "text/html") == false) goto L48;
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "[afterLoadResource] " + r12.getMimeType() + " inject data for the webview");
        InputStream r13 = r12.getData();
        String r0 = null;
        if (r13 == null) goto L50;
        WebEngineAssem r1 = this.a;
        int r10 = WebEngineAssem.C;
        k2.b r14 = r1.t();
        if (r14 == null) goto L15;
        k2.j r15 = r14.n;
        if (r15 == null) goto L15;
        PageInfo r16 = r15.getPageInfo();
        if (r16 == null) goto L15;
        String r17 = r16.getPageData();
    L16:
        if (r17 != null) goto L18;
    L21:
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
        String r19 = "JSON.stringify('')";
    L32:
        String r20 = "window.__APPLET_VIEW_DATA__ = " + r19 + ";\n";
        StringBuilder r21 = new StringBuilder("window.getBotId = function() { return '");
        k2.b r22 = r1.t();
        if (r22 == null) goto L39;
        k2.j r23 = r22.n;
        if (r23 == null) goto L39;
        PageInfo r24 = r23.getPageInfo();
        if (r24 == null) goto L39;
        r0 = r24.getBotId();
    L39:
        r21.append(r0);
        r21.append("'; };\n");
        String r25 = r21.toString();
        StringBuilder r26 = new StringBuilder("window.__APPLET_VIEW_CONTEXT__ = ");
        k2.b r27 = r1.t();
        if (r27 == null) goto L45;
        k2.j r28 = r27.n;
        if (r28 == null) goto L45;
        String r29 = r28.viewContext();
        if (r29 == null) goto L45;
    L46:
        r26.append(r29);
        r26.append(";\n");
        String r30 = r26.toString();
        return new WebResourceResponse(r12.getMimeType(), "utf-8", new ByteArrayInputStream(StringsKt.replace$default(com.bytedance.ai.utils.f.k(r13), "<!-- INJECT_GLOBAL_VARIABLES_CONTENT -->", "<script> window.__AI_SDK_VERSION__ = '1.15.0-rc.7';\n" + r20 + r25 + r30 + "window.__START_GET_FMP__ = true;\n </script>", false, 4, null).getBytes(Charsets.UTF_8)));
    L45:
        r29 = "";
        goto L46
    L24:
        k2.b r31 = r1.t();
        if (r31 == null) goto L31;
        k2.j r32 = r31.n;
        if (r32 == null) goto L31;
        PageInfo r33 = r32.getPageInfo();
        if (r33 == null) goto L31;
        r19 = r33.getPageData();
    L31:
        r19 = null;
        goto L32
    L18:
        if (r17.length() == 0) goto L21;
        r18 = false;
    L15:
        r17 = null;
        goto L16
    L50:
        return null;
    }
}
