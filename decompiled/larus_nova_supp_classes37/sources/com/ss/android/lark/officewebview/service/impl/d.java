package com.ss.android.lark.officewebview.service.impl;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.r;
import dxb.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oxb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements i {
    public byte[] a;
    public byte[] b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WebView a;

        public static final class a<T> implements ValueCallback {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r3) {
                j.e("WebErrorPageUIOptimize", "inject __errorPageHelpCenter__, result=" + ((String) r3));
            }
        }

        public b(WebView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.evaluateJavascript("javascript:(function appendErrorPageHelpCenter() {window.__errorPageHelpCenter__ = true;})()", a.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public d() {
    }

    @Override // oxb.i
    public final void A(WebResourceRequest r2) {
        if (r2 == null) goto L6;
        Uri r3 = r2.getUrl();
        if (r3 == null) goto L6;
        String r4 = r3.toString();
    L7:
        TextUtils.equals("about:blank", r4);
        return;
    L6:
        r4 = null;
        goto L7
    }

    @Override // oxb.i
    public final void z(String r2) {
        TextUtils.equals("about:blank", r2);
    }

    public static boolean O(WebView r6, String r7) {
        boolean r2 = false;
        if (TextUtils.isEmpty(r7) == false) goto L7;
        j.e("WebErrorPageUIOptimize", "TextUtils.isEmpty(url)");
        return false;
    L7:
        if (r7 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L20;
        j.e("WebErrorPageUIOptimize", "override error page schema");
        int r4 = com.ss.android.lark.officesdk.utils.di.g.a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.enable.errorpage.help.center") == false) goto L18;
        j.e("WebErrorPageUIOptimize", "inject errorPageHelpCenter");
        if (r6 == null) goto L18;
        r6.post(new b(r6));
    L18:
        r2 = true;
    L20:
        if (axb.b.c(r7) == false) goto L23;
        j.e("WebErrorPageUIOptimize", "override detect page schema");
        return true;
    L23:
        return r2;
    L9:
        if (StringsKt.startsWith$default(r7, "lkweb://local/errorpage", false, 2, null) != true) goto L11;
        r3 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oxb.i
    public final WebResourceResponse k(WebView r12, String r13) {
        WebResourceResponse r0 = null;
        if (r12 != 0) goto L5;
    L69:
        j.b("WebErrorPageUIOptimize", "tryInterceptRequest view or url is empty");
        return null;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L69;
        boolean r2 = true;
        if (r13 != null) goto L10;
    L12:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L17;
    L35:
        WebResourceResponse r5 = null;
    L37:
        if (r5 == null) goto L39;
        return r5;
    L39:
        if (axb.b.c(r13) == false) goto L68;
        if (this.b != null) goto L64;
        long r14 = System.currentTimeMillis();
        int r6 = com.ss.android.lark.officesdk.utils.di.d.a;
        Application r7 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        Intrinsics.checkNotNullParameter("op_net_detect", "fileDir");
        Intrinsics.checkNotNullParameter("op_net_detect.html", "fileName");
        if (r7 == null) goto L52;
        String r8 = axb.b.a(r7, "op_net_detect");
        if (TextUtils.isEmpty(r8) == true) goto L52;
        int r9 = r.a;
        File r10 = r.a.b(r8 + File.separator + "op_net_detect.html");
        if (r10.exists() == false) goto L52;
        String r11 = r10.getAbsolutePath();
    L53:
        if (r11 != null) goto L55;
    L60:
        r2 = false;
    L61:
        if (r2 == false) goto L64;
        this.b = axb.b.d(r11);
        j.e("WebErrorPageUIOptimize", "realtime mDetectPageByteArray cost: " + (System.currentTimeMillis() - r14));
        goto L64
    L55:
        if (r11.length() <= 0) goto L57;
        boolean r15 = true;
    L58:
        if (r15 != true) goto L60;
    L57:
        r15 = false;
    L52:
        r11 = "";
    L64:
        if (this.b != null) goto L66;
        j.e("WebErrorPageUIOptimize", "can not get detect page bytearray");
        goto L68
    L66:
        r0 = new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(this.b));
    L68:
        return r0;
    L17:
        if (this.a != null) goto L29;
        long r16 = System.currentTimeMillis();
        int r17 = com.ss.android.lark.officesdk.utils.di.d.a;
        String r18 = axb.b.b(com.ss.android.lark.officesdk.utils.di.d.a.a());
        if (TextUtils.isEmpty(r18) == false) goto L26;
        j.e("WebErrorPageUIOptimize", "error page file not unzip, try unzip again");
        if ((r12 instanceof cxb.a) == false) goto L23;
        cxb.a r19 = (cxb.a) r12;
    L24:
        Lazy<Handler> r20 = ThreadUtil.a;
        ThreadUtil.a.a(new axb.a(r19, r13));
        r18 = axb.b.b(com.ss.android.lark.officesdk.utils.di.d.a.a());
        goto L26
    L23:
        r19 = null;
    L26:
        if (TextUtils.isEmpty(r18) == true) goto L29;
        this.a = axb.b.d(r18);
        j.e("WebErrorPageUIOptimize", "realtime getByteArray cost: " + (System.currentTimeMillis() - r16));
    L29:
        if (this.a != null) goto L36;
        int r21 = t.a;
        if ((r12 instanceof cxb.a) == false) goto L33;
        cxb.a r110 = (cxb.a) r12;
    L34:
        Intrinsics.checkNotNullParameter("error page bytearray is null", "message");
        dxb.g r22 = new dxb.g("wb_container_error_page_message", dxb.c.m, r110);
        t.c(r22, r13);
        r22.a("error_page_message", "error page bytearray is null");
        r22.b();
        j.b("WebErrorPageUIOptimize", "can not get error page bytearray");
        goto L35
    L33:
        r110 = null;
        goto L34
    L36:
        ByteArrayInputStream r111 = new ByteArrayInputStream(this.a);
        j.e("WebErrorPageUIOptimize", "resetShouldLoadBlankPage");
        r5 = new WebResourceResponse("text/html", "UTF-8", r111);
        goto L37
    L10:
        if (StringsKt.startsWith$default(r13, "lkweb://local/errorpage", false, 2, null) != true) goto L12;
        r4 = true;
        goto L14
    }

    @Override // oxb.i
    public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        if (r2 == null) goto L6;
        Uri r3 = r2.getUrl();
        if (r3 == null) goto L6;
        String r4 = r3.toString();
    L8:
        return O(r1, r4);
    L6:
        r4 = null;
        goto L8
    }

    @Override // oxb.i
    public final boolean shouldOverrideUrlLoading(WebView r1, String r2) {
        return O(r1, r2);
    }
}
