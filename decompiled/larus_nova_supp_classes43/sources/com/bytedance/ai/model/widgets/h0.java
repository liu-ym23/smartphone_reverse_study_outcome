package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import m5.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0 implements ix7.e {
    public final /* synthetic */ WebEngineAssem a;

    public final boolean g(WebView r1, ValueCallback r10) {
        return false;
    }

    public final void f() {
        WebEngineAssem r0 = this.a;
        int r1 = WebEngineAssem.C;
        RenderStateVM r10 = r0.u();
        if (r10 == null) goto L6;
        r10.updateState(new i5.b());
        return;
    }

    public h0(WebEngineAssem r1) {
        this.a = r1;
    }

    public final void b(SslError r10) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("onReceivedSslError ");
        r1.append(r10);
        r1.append(" url:");
        WebEngineAssem r11 = this.a;
        int r12 = WebEngineAssem.C;
        k2.b r13 = r11.t();
        if (r13 == null) goto L5;
        String r14 = r13.b;
    L6:
        r1.append(r14);
        r0.w("WebViewAssem", r1.toString());
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final lx7.b c(lx7.b r13) {
        Intrinsics.checkNotNullParameter(r13, "before");
        WebEngineAssem r0 = this.a;
        String r1 = r13.a;
        Map r10 = r13.b;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map r11 = TypeIntrinsics.asMutableMap(r10);
        int r12 = WebEngineAssem.C;
        r0.getClass();
        String r14 = (String) r11.get("Referer");
        boolean r15 = false;
        if (r0.v(r1) == false) goto L5;
    L8:
        boolean r16 = true;
    L9:
        String r17 = null;
        String r18 = "";
        if (r16 == false) goto L26;
        Uri.Builder r19 = UriProtector.parse(r1).buildUpon().appendQueryParameter("is_inapp", "1");
        k2.b r20 = r0.t();
        if (r20 != null) goto L14;
    L16:
        boolean r21 = false;
    L17:
        if (r21 == false) goto L21;
        k2.b r22 = r0.t();
        if (r22 == null) goto L24;
        String r23 = r22.g;
    L25:
        Uri r24 = r19.appendQueryParameter("api_host", r23).build();
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "addCommonQuery: called, result uri = " + r24);
        r1 = r24.toString();
        Intrinsics.checkNotNull(r1);
    L28:
        WebEngineAssem r25 = this.a;
        String r26 = r13.a;
        Map r110 = r13.b;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map r111 = TypeIntrinsics.asMutableMap(r110);
        r25.getClass();
        String r27 = (String) r111.get("Referer");
        if (r25.v(r26) == false) goto L31;
    L34:
        boolean r28 = true;
    L35:
        if (r28 == false) goto L91;
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "addCommonHeaders: called, in whitelist");
        k2.b r29 = r25.t();
        if (r29 == null) goto L44;
        Callable<String> r30 = r29.i;
        if (r30 == null) goto L44;
        String r31 = r30.call();
        if (r31 == null) goto L44;
        r18 = r31;
    L44:
        r111.put("x-tt-token", r18);
        k2.b r32 = r25.t();
        if (r32 != null) goto L47;
    L49:
        boolean r33 = false;
    L51:
        if (r33 == false) goto L68;
        r111.put("x-use-boe", "1");
        k2.b r34 = r25.t();
        if (r34 == null) goto L62;
        String r35 = r34.e;
        if (r35 == null) goto L62;
        if (r35.length() <= 0) goto L59;
        boolean r36 = true;
    L60:
        if (r36 != true) goto L62;
        boolean r37 = true;
    L63:
        if (r37 == false) goto L91;
        k2.b r38 = r25.t();
        if (r38 == null) goto L67;
        r17 = r38.e;
    L67:
        Intrinsics.checkNotNull(r17);
        r111.put("x-tt-env", r17);
        goto L91
    L59:
        r36 = false;
    L62:
        r37 = false;
        goto L63
    L68:
        k2.b r39 = r25.t();
        if (r39 != null) goto L71;
    L73:
        boolean r40 = false;
    L74:
        if (r40 == false) goto L91;
        r111.put("x-use-ppe", "1");
        k2.b r41 = r25.t();
        if (r41 == null) goto L85;
        String r42 = r41.f;
        if (r42 == null) goto L85;
        if (r42.length() <= 0) goto L82;
        boolean r43 = true;
    L83:
        if (r43 != true) goto L85;
        boolean r44 = true;
    L86:
        if (r44 == false) goto L91;
        k2.b r45 = r25.t();
        if (r45 == null) goto L90;
        r17 = r45.f;
    L90:
        Intrinsics.checkNotNull(r17);
        r111.put("x-tt-env", r17);
        goto L91
    L82:
        r43 = false;
    L85:
        r44 = false;
        goto L86
    L71:
        if (r39.d != true) goto L73;
        r40 = true;
        goto L74
    L47:
        if (r32.c != true) goto L49;
        r33 = true;
    L91:
        h2.a r46 = f2.b.c;
        if (r46 != null) goto L94;
    L96:
        if (r15 == false) goto L103;
        Iterator r47 = r111.entrySet().iterator();
        String r48 = "addCommonHeaders: called, headers: ";
    L99:
        if (r47.hasNext() == false) goto L101;
        Map.Entry r49 = (Map.Entry) r47.next();
        r48 = r48 + ((String) r49.getKey()) + " = " + ((String) r49.getValue()) + '\n';
        goto L99
    L101:
        com.bytedance.ai.utils.g.a.d("WebViewAssem", r48);
    L103:
        return new lx7.b(r1, r111);
    L94:
        if (r46.k != true) goto L96;
        r15 = true;
        goto L96
    L31:
        if (r25.v(r27) == true) goto L34;
        r28 = false;
    L24:
        r23 = null;
        goto L25
    L21:
        k2.b r50 = r0.t();
        if (r50 == null) goto L24;
        r23 = r50.h;
        goto L25
    L14:
        if (r20.c != true) goto L16;
        r21 = true;
        goto L17
    L26:
        if (r1 != null) goto L28;
        r1 = "";
        goto L28
    L5:
        if (r0.v(r14) == true) goto L8;
        r16 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.model.widgets.g0] */
    public final boolean d(final com.ivy.ivykit.plugin.impl.web.b r10) {
        WebEngineAssem r0 = this.a;
        int r1 = WebEngineAssem.C;
        k2.b r11 = r0.t();
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L14;
        if (r10 == null) goto L14;
        RenderStateVM r13 = this.a.u();
        if (r13 == null) goto L13;
        r13.updateState(new i5.i(r10.getResources(), r10.getOrigin(), new g0(r10)));
    L13:
        return true;
    L14:
        return false;
    L5:
        if (r11.q != true) goto L7;
        r12 = true;
        goto L8
    }

    public final void e(View r10) {
        WebEngineAssem r0 = this.a;
        int r1 = WebEngineAssem.C;
        RenderStateVM r11 = r0.u();
        if (r11 == null) goto L6;
        r11.updateState(new i5.j(r10));
        return;
    }

    public final void onPageStarted(String r10) {
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "onPageStarted url:" + r10);
        WebEngineAssem r0 = this.a;
        int r1 = WebEngineAssem.C;
        k2.b r11 = r0.t();
        if (r11 == null) goto L7;
        k2.j r12 = r11.n;
        if (r12 == null) goto L7;
        r12.onViewStart(r10);
    L7:
        RenderStateVM r13 = this.a.u();
        if (r13 == null) goto L10;
        r13.updateState(new i5.d(r10));
    L10:
        WebEngineAssem r14 = this.a;
        String r15 = r14.y;
        if (r15 == null) goto L16;
        String r16 = r14.z;
        if (r16 == null) goto L17;
        i1 r17 = m5.y0.a;
        m5.y0.g(r15, r16);
        return;
    L17:
        return;
    }

    public final void i(WebView r10, int r11) {
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "onProgressChanged newProgress:" + r11);
        WebEngineAssem r0 = this.a;
        int r1 = WebEngineAssem.C;
        RenderStateVM r12 = r0.u();
        if (r12 == null) goto L5;
        r12.updateState(new i5.e(r11));
    L5:
        WebEngineAssem r13 = this.a;
        if (r13.n != null) goto L15;
        r13.n = r10;
        k2.b r14 = r13.t();
        if (r14 == null) goto L16;
        k2.j r15 = r14.n;
        if (r15 == null) goto L17;
        WebView r16 = this.a.n;
        if (r16 == null) goto L18;
        r16.setTag(2131363149, new WeakReference(r15));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final boolean j(WebView r10, com.ivy.ivykit.plugin.impl.web.c r11) {
        com.bytedance.ai.utils.g.a.e("WebViewAssem", "onRenderProcessGone: " + r11);
        return true;
    }

    public final void k(WebResourceRequest r10, WebResourceError r11) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("onReceivedError ");
        r1.append(r11);
        r1.append(" url:");
        WebEngineAssem r12 = this.a;
        int r13 = WebEngineAssem.C;
        k2.b r14 = r12.t();
        String r15 = null;
        if (r14 == null) goto L5;
        String r16 = r14.b;
    L6:
        r1.append(r16);
        r1.append(' ');
        r0.w("WebViewAssem", r1.toString());
        if (Build.VERSION.SDK_INT < 23) goto L17;
        StringBuilder r17 = new StringBuilder("Request: ");
        if (r10 == null) goto L11;
        Uri r18 = r10.getUrl();
    L12:
        r17.append(r18);
        r17.append(", error: ");
        if (r11 == null) goto L15;
        CharSequence r19 = r11.getDescription();
    L16:
        r17.append(r19);
        String r20 = r17.toString();
    L22:
        k2.b r21 = this.a.t();
        if (r21 == null) goto L27;
        k2.j r22 = r21.n;
        if (r22 == null) goto L27;
        r22.onViewError(r20);
    L27:
        if (r11 != null) goto L29;
    L31:
        boolean r23 = false;
    L32:
        if (r23 == true) goto L49;
        if (r10 == null) goto L38;
        Uri r24 = r10.getUrl();
        if (r24 == null) goto L38;
        r15 = r24.getLastPathSegment();
    L38:
        if (Intrinsics.areEqual(r15, "favicon.ico") == true) goto L50;
        WebEngineAssem r25 = this.a;
        String r26 = r25.y;
        if (r26 == null) goto L51;
        String r27 = r25.z;
        if (r27 == null) goto L52;
        i1 r28 = m5.y0.a;
        if (r11 == null) goto L46;
        int r29 = r11.getErrorCode();
    L47:
        m5.y0.b(r26, r20, r29, r27);
        return;
    L46:
        r29 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        goto L47
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L29:
        if (r11.getErrorCode() != (-1)) goto L31;
        r23 = true;
        goto L32
    L15:
        r19 = null;
        goto L16
    L11:
        r18 = null;
        goto L12
    L17:
        StringBuilder r30 = new StringBuilder("Request: ");
        if (r10 == null) goto L20;
        Uri r31 = r10.getUrl();
    L21:
        r30.append(r31);
        r20 = r30.toString();
        goto L22
    L20:
        r31 = null;
        goto L21
    L5:
        r16 = null;
        goto L6
    }

    public final void onPageFinished(WebView r10, String r11) {
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        r12.i("WebViewAssem", "onPageFinished url:" + r11);
        WebEngineAssem r0 = this.a;
        int r13 = WebEngineAssem.C;
        RenderStateVM r1 = r0.u();
        if (r1 == null) goto L5;
        r1.updateState(new i5.c(r11));
    L5:
        WebEngineAssem r14 = this.a;
        WebView r15 = r14.n;
        r12.i("WebViewAssem", "injectWebViewData " + r15);
        if (r15 == null) goto L27;
        StringBuilder r16 = new StringBuilder("window.getAppData = function() { return JSON.stringify(");
        k2.b r17 = r14.t();
        if (r17 == null) goto L14;
        k2.j r18 = r17.n;
        if (r18 == null) goto L14;
        PageInfo r19 = r18.getPageInfo();
        if (r19 == null) goto L14;
        String r20 = r19.getPageData();
    L15:
        r16.append(r20);
        r16.append("); }; \n");
        String r21 = r16.toString();
        StringBuilder r22 = new StringBuilder("window.getViewContext = function() { return JSON.stringify(");
        k2.b r23 = r14.t();
        if (r23 == null) goto L21;
        k2.j r24 = r23.n;
        if (r24 == null) goto L21;
        String r25 = r24.viewContext();
        if (r25 == null) goto L21;
    L22:
        r22.append(r25);
        r22.append("); };\n");
        r15.evaluateJavascript(r21 + r22.toString(), null);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.bytedance.ai.utils.g.a.e("WebViewPage", "JavaScript execution error: " + th.getMessage());
    L21:
        r25 = "";
    L14:
        r20 = null;
    L27:
        k2.b r26 = this.a.t();
        if (r26 == null) goto L32;
        k2.j r27 = r26.n;
        if (r27 == null) goto L32;
        r27.onViewFinish(r11);
    L32:
        WebEngineAssem r28 = this.a;
        String r29 = r28.y;
        if (r29 == null) goto L40;
        String r30 = r28.z;
        if (r30 == null) goto L41;
        i1 r31 = m5.y0.a;
        m5.y0.f(r29, r30);
        return;
    L41:
        return;
    }

    public final void onReceivedTitle(WebView r10, String r11) {
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "onReceivedTitle title:" + r11);
        WebEngineAssem r12 = this.a;
        int r0 = WebEngineAssem.C;
        RenderStateVM r13 = r12.u();
        if (r13 != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        String r14 = r10.getTitle();
    L8:
        r13.updateState(new i5.f(r14));
        return;
    L7:
        r14 = null;
        goto L8
    }

    public final boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        if (r11 == null) goto L22;
        WebEngineAssem r1 = this.a;
        int r12 = WebEngineAssem.C;
        k2.b r13 = r1.t();
        if (r13 == null) goto L7;
        Boolean r14 = Boolean.valueOf(r13.r);
    L8:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.startsWith$default(r11, "http", false, 2, null) == true) goto L11;
    L20:
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "shouldOverrideUrlLoading http url:".concat(r11));     // Catch: Exception -> L16
        Intent r0 = new Intent("android.intent.action.VIEW", UriProtector.parse(r11));     // Catch: Exception -> L16
        r0.setFlags(805306368);     // Catch: Exception -> L16
        Context r15 = r1.getContext();     // Catch: Exception -> L16
        if (r15 == null) goto L18;
        r15.startActivity(r0);     // Catch: Exception -> L16
    L18:
        return true;
    L16:
        e = move-exception;
        com.bytedance.ai.utils.g.a.w("WebViewAssem", "shouldOverrideUrlLoading http url:".concat(r11), e);
        goto L18
    L11:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L20;
        return false;
    L7:
        r14 = null;
        goto L8
    L22:
        return false;
    }

    public final void a(int r10, String r11, String r12) {
        com.bytedance.ai.utils.g.a.w("WebViewAssem", "onReceivedError code:" + r10 + " desc:" + r11 + " url:" + r12);
        StringBuilder r0 = new StringBuilder("errorCode: ");
        r0.append(r10);
        r0.append(", description: ");
        r0.append(r11);
        r0.append(", failingUrl: ");
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r0.append(r12);
        String r13 = r0.toString();
        WebEngineAssem r14 = this.a;
        int r1 = WebEngineAssem.C;
        k2.b r15 = r14.t();
        if (r15 == null) goto L11;
        k2.j r16 = r15.n;
        if (r16 == null) goto L11;
        r16.onViewError(r13);
    L11:
        if (r10 == (-1)) goto L18;
        WebEngineAssem r17 = this.a;
        String r18 = r17.y;
        if (r18 == null) goto L19;
        String r19 = r17.z;
        if (r19 == null) goto L20;
        i1 r20 = m5.y0.a;
        m5.y0.b(r18, r13, r10, r19);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void h(String r10, int r11, String r12) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        h2.a r1 = f2.b.c;
        if (r1 == null) goto L7;
        boolean r13 = true;
        if (r1.k != true) goto L7;
    L8:
        if (r13 == false) goto L22;
        if (r10 == null) goto L23;
        WebEngineAssem r14 = this.a;
        if (TextUtils.isEmpty(r12) == false) goto L14;
        r12 = "unknown-source";
    L14:
        StringBuilder r15 = new StringBuilder("[console]\"");
        r15.append(r10);
        r15.append("\", source: ");
        r15.append(r12);
        r15.append('(');
        r15.append(r11);
        r15.append("), pageId: ");
        int r16 = WebEngineAssem.C;
        k2.b r17 = r14.t();
        if (r17 == null) goto L19;
        k2.j r18 = r17.n;
        if (r18 == null) goto L19;
        String r19 = r18.getPageID();
    L20:
        r15.append(r19);
        r0.d("AppletPage", r15.toString());
        return;
    L19:
        r19 = null;
        goto L20
    L23:
        return;
    L22:
        return;
    L7:
        r13 = false;
        goto L8
    }
}
