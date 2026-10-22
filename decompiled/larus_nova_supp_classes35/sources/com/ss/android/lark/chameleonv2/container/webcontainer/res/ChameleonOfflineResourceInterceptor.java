package com.ss.android.lark.chameleonv2.container.webcontainer.res;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.ResInterceptConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ChameleonDebugUtils;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.i;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.m;
import swb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonOfflineResourceInterceptor implements y0b.b {
    public static final /* synthetic */ int f = 0;
    public final ChameleonWebView a;
    public final ChameleonConfig b;
    public VFSPath c;
    public final Lazy d;
    public final Lazy e;

    public static final class a extends ServiceWorkerClient {
        public final /* synthetic */ ChameleonOfflineResourceInterceptor a;

        public a(ChameleonOfflineResourceInterceptor r1) {
            this.a = r1;
        }

        @Override // android.webkit.ServiceWorkerClient
        public final WebResourceResponse shouldInterceptRequest(WebResourceRequest r4) {
            Intrinsics.checkNotNullParameter(r4, "request");
            return this.a.shouldInterceptRequest(r4.getUrl(), r4.getMethod(), r4.getRequestHeaders());
        }
    }

    public static final class b {
        @JvmStatic
        public static VFSPath a(ChameleonConfig r8) {
            Intrinsics.checkNotNullParameter(r8, "chameleonConfig");
            String r9 = r8.getBizName();
            if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == false) goto L36;
            boolean r2 = false;
            if (r9 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L36;
            if (ChameleonDebugUtils.b().getBoolean("chameleon_disable_offline_res", false) == false) goto L16;
            return null;
        L16:
            String r4 = ChameleonDebugUtils.b().getString("chameleon_specific_bizname", null);
            String r5 = BuildConfig.FLAVOR;
            if (r4 != null) goto L20;
            r4 = BuildConfig.FLAVOR;
        L20:
            if (Intrinsics.areEqual(r4, r9) == true) goto L22;
            return null;
        L22:
            String r10 = ChameleonDebugUtils.b().getString("chameleon_specific_res_path", null);
            if (r10 == null) goto L26;
            r5 = r10;
        L26:
            j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "Using localPath: " + r5 + ", for bizName: " + r4);
            VFSFiles.b.getClass();
            VFSFile r11 = VFSFiles.b(true).i(r5);
            if (r11 != null) goto L29;
        L31:
            if (r2 == true) goto L35;
            j.b(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "file not exists: " + r5 + ", for bizName: " + r4);
            return null;
        L35:
            return VFSFiles.b(true).t(r11);
        L29:
            if (r11.exists() != true) goto L31;
            r2 = true;
            goto L31
        L7:
            if (r9.length() == 0) goto L10;
            r3 = false;
        L36:
            return null;
        }
    }

    static {
    }

    public final VFSPath b() {
        VFSPath r0 = (VFSPath) this.e.getValue();
        if (r0 == null) goto L7;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "set debug local path");
        this.c = r0;
        return r0;
    L7:
        if (this.c != null) goto L16;
        VFSPath r1 = this.a.y(true).a;
        if (r1 != null) goto L12;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "resRootPath is null");
        return null;
    L12:
        this.c = r1;
        Map<String, u1b.a.C0305a> r2 = u1b.a.a;
        u1b.a.C0305a r3 = u1b.a.a(this.a.getSession());
        if (r3 == null) goto L16;
        u1b.a.C0305a.e(r3, ChameleonOpenTracker.Stage.PRELOAD);
    L16:
        return this.c;
    }

    public static String a(String r4) {
        String r5 = UriProtector.parse(r4).getPath();
        if (r5 != null) goto L5;
    L27:
        return "text/html";
    L5:
        if (StringsKt.endsWith$default(r5, ".css", false, 2, null) == false) goto L8;
        return "text/css";
    L8:
        if (StringsKt.endsWith$default(r5, ".js", false, 2, null) == false) goto L11;
        return "application/x-javascript";
    L11:
        if (StringsKt.endsWith$default(r5, ".jpg", false, 2, null) == false) goto L13;
    L26:
        return "image/*";
    L13:
        if (StringsKt.endsWith$default(r5, ".gif", false, 2, null) == true) goto L26;
        if (StringsKt.endsWith$default(r5, ".png", false, 2, null) == true) goto L26;
        if (StringsKt.endsWith$default(r5, ".jpeg", false, 2, null) == true) goto L26;
        if (StringsKt.endsWith$default(r5, ".webp", false, 2, null) == true) goto L26;
        if (StringsKt.endsWith$default(r5, ".bmp", false, 2, null) == true) goto L26;
        if (StringsKt.endsWith$default(r5, ".svg", false, 2, null) == false) goto L27;
        return "image/svg+xml";
    }

    public final String d(String r8) {
        ResInterceptConfig r0 = this.b.getResInterceptConfig();
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.getCommonTemplateVars();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if ((!r1.isEmpty()) != true) goto L9;
    L10:
        if (r2 == false) goto L35;
        ResInterceptConfig r3 = this.b.getResInterceptConfig();
        if (r3 == null) goto L36;
        ArrayList<String> r4 = r3.getCommonTemplateVars();
        if (r4 == null) goto L37;
        Iterator<T> r5 = r4.iterator();
        String r6 = r8;
    L17:
        if (r5.hasNext() == false) goto L28;
        String r9 = (String) r5.next();
        String r7 = "{{" + r9 + "}}";
        if (TextUtils.equals(r9, "locale") == true) goto L20;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "replaceHtml it : " + r9);
        goto L17
    L20:
        int r10 = i.a;
        DependencyContainer r11 = DependencyContainer.a;
        m r12 = DependencyContainer.a(m.class, null);
        if (r12 == null) goto L24;
        Locale r13 = r12.getCurrentLocale();
        if (r13 == null) goto L24;
    L25:
        String r14 = l.a(r13.getCountry(), r13.getLanguage()).toString();
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "replaceHtml it : " + r9 + ",  locale : " + r14);
        r6 = StringsKt.replace$default(r6, r7, r14, false, 4, null);
    L24:
        r13 = Locale.getDefault();
        goto L25
    L28:
        return r6;
    L37:
        return r8;
    L36:
        return r8;
    L35:
        return r8;
    L9:
        r2 = false;
        goto L10
    }

    public ChameleonOfflineResourceInterceptor(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.a = r2;
        this.b = r3;
        ResInterceptConfig r4 = r3.getResInterceptConfig();
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        if (r5 == true) goto L9;
    L14:
        this.d = LazyKt.lazy(new ChameleonOfflineResourceInterceptor$isProxyEnabled$2(this));
        this.e = LazyKt.lazy(new ChameleonOfflineResourceInterceptor$debugOfflinePath$2(this));
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        ServiceWorkerController.getInstance().setServiceWorkerClient(new a(this));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        j.b(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "ServiceWorkerController()...e: " + th);
        goto L14
    L5:
        if (r4.getServiceWorkerEnable() != true) goto L7;
        r5 = true;
        goto L7
    }

    public static boolean c(VFSPath r4, VFSPath r5) {
        File r6 = r4.toFile().getCanonicalFile();     // Catch: Exception -> L5
        return StringsKt.startsWith$default(r5.toFile().getCanonicalFile().getPath(), StringsKt.trimEnd(r6.getPath(), new char[]{File.separatorChar}) + File.separator, false, 2, null);
    L5:
        e = move-exception;
        j.g(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "canonical path resolve failed", e);
        return false;
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r12, String r13, Map<String, String> r14) {
        if (this.b.getResInterceptConfig() != null) goto L7;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "resInterceptConfig is null");
        return null;
    L7:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L10;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "enable proxy, should not intercept.");
        return null;
    L10:
        if (r12 != null) goto L93;
    L92:
        return null;
    L93:
        String r15 = r12.toString();     // Catch: Throwable -> L90
        if (r15 == null) goto L92;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "shouldInterceptRequest url ".concat(r15));     // Catch: Throwable -> L90
        VFSPath r0 = b();     // Catch: Throwable -> L90
        boolean r1 = TextUtils.equals(r15, this.b.getLoadUrl());     // Catch: Throwable -> L90
        String r4 = BuildConfig.FLAVOR;
        if (r1 == true) goto L38;
        PreloadConfig r2 = this.b.getPreloadConfig();     // Catch: Throwable -> L90
        if (r2 == null) goto L20;
        String r3 = r2.getTemplateUrl();     // Catch: Throwable -> L90
    L22:
        if (TextUtils.equals(r15, r3) == true) goto L38;
        if (r0 == null) goto L46;
        String r5 = UriProtector.parse(r15).getPath();     // Catch: Throwable -> L90
        if (r5 == null) goto L29;
        r4 = r5;
    L29:
        ResInterceptConfig r6 = this.b.getResInterceptConfig();     // Catch: Throwable -> L90
        if (r6 == null) goto L37;
        String r7 = r6.getPathRewrites();     // Catch: Throwable -> L90
        if (r7 == null) goto L37;
        int r8 = StringsKt.indexOf$default(r4, r7, 0, false, 6, null);     // Catch: Throwable -> L90
        if (r8 == (-1)) goto L37;
        r4 = r4.substring(r8 + r7.length());     // Catch: Throwable -> L90
    L37:
        VFSPath r9 = r0.subPath(r4);     // Catch: Throwable -> L90
    L47:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "local res path = " + r9 + ", rootPath = " + r0);     // Catch: Throwable -> L90
        if (r0 == null) goto L88;
        if (r9 == null) goto L88;
        if (c(r0, r9) == true) goto L56;
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "path not safe");     // Catch: Throwable -> L90
        return null;
    L56:
        if (com.suite.lark.component.storage.ext.b.b(r9) == true) goto L58;
    L86:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "file not exists or is directory: " + r9);     // Catch: Throwable -> L90
        return null;
    L58:
        if (com.suite.lark.component.storage.ext.b.c(r9) == true) goto L86;
        Intrinsics.checkNotNullParameter(r9, "<this>");     // Catch: Throwable -> L90
        VFSFiles.b.getClass();     // Catch: Throwable -> L90
        InputStream r16 = VFSFiles.a(r9).l(r9);     // Catch: Throwable -> L90
        if (TextUtils.equals(r15, this.b.getLoadUrl()) == true) goto L70;
        PreloadConfig r17 = this.b.getPreloadConfig();     // Catch: Throwable -> L90
        if (r17 == null) goto L65;
        String r18 = r17.getTemplateUrl();     // Catch: Throwable -> L90
    L67:
        if (TextUtils.equals(r15, r18) == true) goto L70;
        InputStream r10 = r16;
    L84:
        HashMap r11 = new HashMap();     // Catch: Throwable -> L90
        r11.put("Access-Control-Allow-Origin", "*");     // Catch: Throwable -> L90
        r11.put("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");     // Catch: Throwable -> L90
        r11.put("Access-Control-Allow-Credentials", "true");     // Catch: Throwable -> L90
        r11.put("Access-Control-Allow-Headers", "accept, authorization, Content-Type");     // Catch: Throwable -> L90
        r11.put("_lkCacheFrom", "local");     // Catch: Throwable -> L90
        WebResourceResponse r19 = new WebResourceResponse(a(r15), Charset.defaultCharset().name(), 200, "OK", r11, r10);     // Catch: Throwable -> L90
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "SPOfflineResRes hit local res url " + r15 + "  ,  resLocalPath: " + r9);     // Catch: Throwable -> L90
        return r19;
    L65:
        r18 = null;
    L70:
        String r110 = d(c.b(r16));     // Catch: Throwable -> L90
        ResInterceptConfig r111 = this.b.getResInterceptConfig();     // Catch: Throwable -> L90
        if (r111 == null) goto L83;
        Function1<VFSPath, Map<String, String>> r112 = r111.getGetBizTemplateVars();     // Catch: Throwable -> L90
        if (r112 == null) goto L83;
        Map r113 = (Map) r112.invoke(r0);     // Catch: Throwable -> L90
        if (r113 == null) goto L83;
        Set r114 = r113.entrySet();     // Catch: Throwable -> L90
        if (r114 == null) goto L83;
        Iterator r115 = r114.iterator();     // Catch: Throwable -> L90
        String r20 = r110;
    L80:
        if (r115.hasNext() == false) goto L82;
        Map.Entry r116 = (Map.Entry) r115.next();     // Catch: Throwable -> L90
        r20 = StringsKt.replace$default(r20, (String) r116.getKey(), (String) r116.getValue(), false, 4, null);     // Catch: Throwable -> L90
        goto L80
    L82:
        r110 = r20;
    L83:
        r10 = new ByteArrayInputStream(r110.getBytes(Charset.forName(Charset.defaultCharset().name())));     // Catch: Throwable -> L90
    L88:
        j.f(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "rootPath or resLocalPath is null");     // Catch: Throwable -> L90
        return null;
    L46:
        r9 = null;
        goto L47
    L20:
        r3 = null;
    L38:
        if (r0 == null) goto L46;
        ResInterceptConfig r21 = this.b.getResInterceptConfig();     // Catch: Throwable -> L90
        if (r21 == null) goto L45;
        String r22 = r21.getRootHtml();     // Catch: Throwable -> L90
        if (r22 == null) goto L45;
        r4 = r22;
    L45:
        r9 = r0.subPath(r4);     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        j.c(com.ss.android.lark.chameleon.container.webcontainer.res.ChameleonOfflineResourceInterceptor.TAG, "intercept error!", th);
        goto L92
    }
}
