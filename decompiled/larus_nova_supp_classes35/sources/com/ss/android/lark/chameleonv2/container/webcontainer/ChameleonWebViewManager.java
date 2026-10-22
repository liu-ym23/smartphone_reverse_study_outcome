package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonWebViewManager implements CoroutineScope {
    public final String a;
    public final HashMap<String, q0b.a> b;
    public final List<String> c;
    public final CoroutineContext d;
    public final HashMap<String, Runnable> e;
    public final a f;

    public static final class a implements Runnable {
        public String a;
        public final /* synthetic */ ChameleonWebViewManager b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
        /* JADX WARN: Type inference failed for: r3v12, types: [android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
        public final void a() {
            q0b.a r0 = this.b.b.get(this.a);
            if (r0 == 0) goto L27;
            ChameleonWebViewManager r1 = this.b;
            r1.getClass();
            WebViewPoolConfig r2 = r0.a();
            com.ss.android.lark.officesdk.utils.di.j.e(r1.a, "shrinkWebPoolSize() 11... occupiedSize = " + r0.occupiedSize() + ", poolSize = " + r0.poolSize() + ", poolConfig = " + r2);
        L6:
            if ((r0.occupiedSize() + 1) >= r0.poolSize()) goto L13;
            if (r0.poolSize() <= r2.getCoreSize()) goto L13;
            ?? r3 = r0.d(null);
            if (r3 == 0) goto L13;
            com.ss.android.lark.officesdk.utils.di.j.e(r1.a, "shrinkWebPoolSize == webView: " + r3.hashCode());
            r0.e(r3);
        L13:
            com.ss.android.lark.officesdk.utils.di.j.e(r1.a, "shrinkWebPoolSize() 22... occupiedSize = " + r0.occupiedSize() + ", poolSize = " + r0.poolSize() + ", poolConfig = " + r2);
            if (r0.occupiedSize() != 0) goto L17;
            Lazy r4 = TTWebViewUtil.a;
            TTWebViewUtil.a.b().Q();
        L17:
            if (r0.occupiedSize() != 0) goto L28;
            ?? r5 = r0.getOverMaxUsedWebView(r2.getMaxUseCount());
            if (r5 == 0) goto L29;
            com.ss.android.lark.officesdk.utils.di.j.e(r1.a, "release over-max-used WebView:  " + r5.hashCode());
            r0.e(r5);
            if (r0.poolSize() != 0) goto L30;
            com.ss.android.lark.officesdk.utils.di.j.e(r1.a, "webViewPool.poolSize() == 0. createWebView");
            r0.b(r5.getChameleonConfig(), null).z();
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ChameleonWebViewManager r1) {
            this.b = r1;
            this.a = BuildConfig.FLAVOR;
        }
    }

    public final void b() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "destroyAll()...");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$destroyAll$1(this, null), 3, null);
    }

    public ChameleonWebViewManager() {
        this.a = "CML_TAG_WebViewManager" + hashCode();
        this.b = new HashMap();
        this.c = new ArrayList();
        this.d = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
        this.e = new HashMap();
        this.f = new a(this);
    }

    public final CoroutineContext getCoroutineContext() {
        return this.d;
    }

    public static String e(ChameleonConfig r2) {
        String r0 = r2.getBizName();
        String r1 = BuildConfig.FLAVOR;
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        String r3 = r2.getSubBizname();
        if (r3 == null) goto L10;
        r1 = r3;
    L10:
        return r0.concat(r1);
    }

    public final void a(String r8) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "destroy()... bizName = " + r8);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$destroy$1(this.b.get(r8), this, r8, null), 3, null);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(ChameleonWebView r4) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "destroyWebview()... webView = " + r4.hashCode());
        q0b.a r0 = this.b.get(e(r4.getChameleonConfig()));
        if (r0 == null) goto L6;
        r0.e(r4);
        return;
    }

    public final ChameleonWebView d(ChameleonConfig r9, Object r10) {
        WebviewConfig r0 = r9.getWebviewConfig();
        if (r0 == null) goto L6;
        WebViewPoolConfig r1 = r0.getWebViewPoolConfig();
        if (r1 == null) goto L6;
    L7:
        final q0b.b r2 = new q0b.b(r1);
        this.b.put(e(r9), r2);
        r2.b = new ChameleonWebViewManager$doCreateWebView$1(this, r2);
        ChameleonWebView r11 = r2.b(r9, r10);
        r11.z();
        return r11;
    L6:
        r1 = new WebViewPoolConfig(0, 0, 0, 0, 15, null);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
    public final ChameleonWebView f(ChameleonConfig r9, Object r10) {
        Intrinsics.checkNotNullParameter(r9, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r10, "tag");
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "getWebView()... bizName = " + r9.getBizName() + ",  tag = " + r10);
        PreloadConfig r0 = r9.getPreloadConfig();
        if (r0 == null) goto L6;
        PreloadPolicy r1 = r0.getPolicy();
        if (r1 == null) goto L6;
    L8:
        if (r1 != PreloadPolicy.NO_PRELOAD) goto L11;
        int r2 = com.ss.android.lark.officesdk.utils.di.d.a;
        return new ChameleonWebView(com.ss.android.lark.officesdk.utils.di.d.a.a(), r9);
    L11:
        Runnable r3 = this.e.get(e(r9));
        if (r3 == null) goto L14;
        Lazy r4 = ThreadUtil.a;
        ThreadUtil.a.e(r3);
    L14:
        q0b.a r5 = this.b.get(e(r9));
        ViewGroup r6 = 0;
        if (r5 == null) goto L17;
        WebViewPoolConfig r7 = r5.a();
    L18:
        if (r5 == null) goto L42;
        int r8 = r5.poolSize();
        int r11 = r5.occupiedSize();
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "provideWebView occupiedSize = " + r11 + ", poolSize = " + r8 + ", poolConfig = " + r7);
        ?? r12 = r5.c(r10);
        if (r12 == 0) goto L23;
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "provideWebView()1... tag = " + r10 + ",  webview = " + r12.hashCode());
        return r12;
    L23:
        if (r11 != r8) goto L30;
        if (r7 == null) goto L26;
        int r13 = r7.getMaxSize();
    L27:
        if (r8 >= r13) goto L30;
        ChameleonWebView r14 = r5.b(r9, r10);
        r14.z();
        return r14;
    L26:
        r13 = Integer.MAX_VALUE;
    L30:
        ?? r15 = r5.d(r10);
        if (r15 == 0) goto L33;
        ViewParent r16 = r15.getParent();
    L35:
        if ((r16 instanceof ViewGroup) == false) goto L37;
        r6 = (ViewGroup) r16;
    L37:
        if (r6 == 0) goto L39;
        r15.stopLoading();
        r15.clearHistory();
        r6.removeView(r15);
    L39:
        com.ss.android.lark.officesdk.utils.di.j.e(this.a, "provideWebView()2... tag = " + r10 + ",    webview = " + r15.hashCode());
        return r15;
    L33:
        r16 = null;
        goto L35
    L42:
        return d(r9, r10);
    L17:
        r7 = null;
    L6:
        r1 = PreloadPolicy.NO_PRELOAD;
        goto L8
    }

    public final void h(ChameleonConfig r8, WebView r9) {
        Intrinsics.checkNotNullParameter(r8, "chameleonConfig");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$preloadWebview$1(this, r8, r9, null), 3, null);
    }

    public final void g(ChameleonConfig r11, ChameleonWebView r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r12, "webView");
        Intrinsics.checkNotNullParameter(r13, "tag");
        BuildersKt.launch$default(this, null, null, new ChameleonWebViewManager$onWebViewDetached$1(this, r13, r11, r12, null), 3, null);
    }
}
