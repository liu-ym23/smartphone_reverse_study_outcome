package com.bytedance.android.annie.business.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b36.k;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends c26.d {
    public final m16.b b;
    public final Boolean c;

    public static final class a {
    }

    static {
    }

    public b(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        this.b = r10;
        this.c = AnnieConfigSettingKeys.ENABLE_HANDLE_HTTP_SCHEME.a();
    }

    public final WebResourceResponse b(WebView r10, k r11) {
        if (h.n0() == false) goto L13;
        if (r11 == null) goto L8;
        Uri r0 = r11.getUrl();
        if (r0 == null) goto L8;
        WebResourceResponse r1 = com.bytedance.android.annie.service.resource.a.a.j(r0.toString());
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        super/*b36.q*/.b(r10, r11);
        throw null;
    L8:
        r1 = null;
        goto L9
    L13:
        super/*b36.q*/.b(r10, r11);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPageFinished(WebView r10, String r11) {
        super/*android.webkit.WebViewClient*/.onPageFinished(r10, r11);
        if (this.c.booleanValue() == false) goto L13;
        Context r0 = (Context) this.b.c(Context.class);
        ia.c r1 = (ia.c) this.b.c(ia.c.class);
        if (r1 == null) goto L9;
        t36.d r12 = r1.getCurrentSchema();
        if (r12 == null) goto L9;
        Map<String, String> r13 = r12.c();
    L10:
        if (r0 == null) goto L14;
        w9.a.a.v1(r0, r11, r10, r13);
        return;
    L14:
        return;
    L9:
        r13 = null;
        goto L10
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r10, String r11) {
        if (h.n0() == false) goto L11;
        if (r11 == null) goto L6;
        WebResourceResponse r0 = com.bytedance.android.annie.service.resource.a.a.j(r11);
    L7:
        if (r0 == null) goto L9;
        return r0;
    L9:
        super/*b36.q*/.shouldInterceptRequest(r10, r11);
        throw null;
    L6:
        r0 = null;
        goto L7
    L11:
        super/*b36.q*/.shouldInterceptRequest(r10, r11);
        throw null;
    }

    public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        boolean r0 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L39;
        return super/*b36.q*/.shouldOverrideUrlLoading(r10, r11);
    L39:
        Uri r13 = UriProtector.parse(r11);     // Catch: Exception -> L35
        String r14 = r13.getScheme();     // Catch: Exception -> L35
        if (r14 != null) goto L16;
    L18:
        r0 = false;
    L19:
        if (r0 == false) goto L25;
        Context r1 = (Context) this.b.c(Context.class);     // Catch: Exception -> L35
        if (r1 == null) goto L38;
        return w9.a.a.j0(r1, r13, null, null);
    L38:
        return super/*b36.q*/.shouldOverrideUrlLoading(r10, r11);
    L25:
        if (this.c.booleanValue() == false) goto L38;
        Context r15 = (Context) this.b.c(Context.class);     // Catch: Exception -> L35
        ia.c r16 = (ia.c) this.b.c(ia.c.class);     // Catch: Exception -> L35
        if (r16 == null) goto L31;
        t36.d r17 = r16.getCurrentSchema();     // Catch: Exception -> L35
        if (r17 == null) goto L31;
        Map<String, String> r18 = r17.c();     // Catch: Exception -> L35
    L32:
        if (r15 == null) goto L38;
        return w9.a.a.handleHttpSchema(r15, r13, r10, r18);
    L31:
        r18 = null;
        goto L32
    L16:
        if (StringsKt.startsWith$default(r14, "http", false, 2, null) == true) goto L18;
    L35:
        e = move-exception;
        HybridLogger r19 = HybridLogger.a;
        HybridLogger.i("AnnieXLiveWebViewClient", String.valueOf(e.getMessage()), null, 12);
        goto L38
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r12 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPageStarted(WebView r1, String r10, Bitmap r11) {
        super/*android.webkit.WebViewClient*/.onPageStarted(r1, r10, r11);
        int r12 = p7.a.a;
        if ((r1 instanceof o7.b) == false) goto L7;
        if (r10 == null) goto L8;
        ((o7.b) r1).setSafeUrl(r10);
        return;
    L8:
        return;
    }
}
