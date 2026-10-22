package com.ss.android.lark.chameleonv2.container.webcontainer.res;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.ResInterceptConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.i;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSPath;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.m;
import swb.l;
import y0b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ProxyChameleonOfflineResourceInterceptor implements b {
    public final ChameleonWebView a;
    public final ChameleonConfig b;
    public final Lazy c;

    public final String a(String r11) {
        ResInterceptConfig r0 = this.b.getResInterceptConfig();
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.getCommonTemplateVars();
        if (r1 == null) goto L9;
        if ((!r1.isEmpty()) != true) goto L9;
        boolean r2 = true;
    L10:
        VFSPath r3 = null;
        if (r2 == false) goto L29;
        ResInterceptConfig r4 = this.b.getResInterceptConfig();
        if (r4 == null) goto L29;
        ArrayList<String> r5 = r4.getCommonTemplateVars();
        if (r5 == null) goto L29;
        Iterator<T> r6 = r5.iterator();
        String r7 = r11;
    L18:
        if (r6.hasNext() == false) goto L28;
        String r12 = (String) r6.next();
        String r8 = "{{" + r12 + "}}";
        if (TextUtils.equals(r12, "locale") == true) goto L21;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "Proxy replaceHtml it : " + r12);
        goto L18
    L21:
        int r9 = i.a;
        DependencyContainer r10 = DependencyContainer.a;
        m r13 = DependencyContainer.a(m.class, null);
        if (r13 == null) goto L25;
        Locale r14 = r13.getCurrentLocale();
        if (r14 == null) goto L25;
    L26:
        String r15 = l.a(r14.getCountry(), r14.getLanguage()).toString();
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "Proxy replaceHtml it : " + r12 + ",  locale : " + r15);
        r7 = StringsKt.replace$default(r7, r8, r15, false, 4, null);
    L25:
        r14 = Locale.getDefault();
        goto L26
    L28:
        r11 = r7;
    L29:
        VFSPath r16 = (VFSPath) this.c.getValue();
        if (r16 == null) goto L33;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "set debug local path");
    L32:
        r3 = r16;
    L39:
        if (r3 == null) goto L61;
        ResInterceptConfig r17 = this.b.getResInterceptConfig();
        if (r17 == null) goto L62;
        Function1<VFSPath, Map<String, String>> r18 = r17.getGetBizTemplateVars();
        if (r18 == null) goto L63;
        Map r19 = (Map) r18.invoke(r3);
        if (r19 == null) goto L64;
        Set r20 = r19.entrySet();
        if (r20 == null) goto L65;
        Iterator r21 = r20.iterator();
        String r22 = r11;
    L50:
        if (r21.hasNext() == false) goto L53;
        Map.Entry r110 = (Map.Entry) r21.next();
        r22 = StringsKt.replace$default(r22, (String) r110.getKey(), (String) r110.getValue(), false, 4, null);
        goto L50
    L53:
        return r22;
    L65:
        return r11;
    L64:
        return r11;
    L63:
        return r11;
    L62:
        return r11;
    L61:
        return r11;
    L33:
        r16 = this.a.y(true).a;
        if (r16 != null) goto L36;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "resRootPath is null");
        goto L39
    L36:
        Map<String, u1b.a.C0305a> r23 = u1b.a.a;
        u1b.a.C0305a r24 = u1b.a.a(this.a.getSession());
        if (r24 == null) goto L32;
        u1b.a.C0305a.e(r24, ChameleonOpenTracker.Stage.PRELOAD);
    L9:
        r2 = false;
        goto L10
    }

    public ProxyChameleonOfflineResourceInterceptor(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new ProxyChameleonOfflineResourceInterceptor$debugOfflinePath$2(this));
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r9, String r10, Map<String, String> r11) {
        if (r9 == null) goto L17;
        String r12 = r9.toString();
        if (r12 == null) goto L17;
        PreloadConfig r1 = this.b.getPreloadConfig();
        if (r1 == null) goto L10;
        String r2 = r1.getTemplateUrl();
    L12:
        if (TextUtils.equals(r12, r2) == false) goto L17;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "Proxy intercepting url = ".concat(r12));     // Catch: Throwable -> L15
        URL r13 = new URL(r12);     // Catch: Throwable -> L15
        ByteArrayInputStream r7 = new ByteArrayInputStream(a(new String(TextStreamsKt.readBytes(r13), Charset.defaultCharset())).getBytes(Charset.forName(Charset.defaultCharset().name())));     // Catch: Throwable -> L15
        HashMap r6 = new HashMap();     // Catch: Throwable -> L15
        r6.put("Access-Control-Allow-Origin", "*");     // Catch: Throwable -> L15
        r6.put("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");     // Catch: Throwable -> L15
        r6.put("Access-Control-Allow-Credentials", "true");     // Catch: Throwable -> L15
        r6.put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");     // Catch: Throwable -> L15
        r6.put("_lkCacheFrom", "local");     // Catch: Throwable -> L15
        return new WebResourceResponse("text/html", Charset.defaultCharset().name(), 200, "OK", r6, r7);
    L15:
        th = move-exception;
        j.c(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "Proxy intercept error!", th);
        goto L17
    L10:
        r2 = null;
    L17:
        return null;
    }
}
