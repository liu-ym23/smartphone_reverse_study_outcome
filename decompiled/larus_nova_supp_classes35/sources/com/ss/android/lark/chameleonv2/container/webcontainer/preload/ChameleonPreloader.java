package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import android.app.Application;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.UIThreadCallbackAdapter;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonPreloader {
    public static final Map<String, Integer> g = null;
    public final ChameleonWebView a;
    public final ChameleonConfig b;
    public volatile PreloadStatus c;
    public final PreloadPolicy d;
    public volatile b e;
    public final d f;

    public static final class a {
    }

    public interface b {
        void a(PreloadStatus r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreloadPolicy.values().length];
            r0[PreloadPolicy.PRELOAD_BIZ_HTML.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreloadPolicy.PRELOAD_EMPTY_WEBVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ChameleonPreloader a;

        public d(ChameleonPreloader r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChameleonPreloader.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final synchronized PreloadStatus c() {
        monitor-enter(this);
        PreloadStatus r0 = this.c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        g = new LinkedHashMap();
    }

    public final void d() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ChameleonPreloader$preload$1(this, null), 2, null);
    }

    public static final void a(ChameleonPreloader r6) {
        r6.getClass();
        j.f("CML_TAG_ChameleonPreloader", "checkReloadWebview====== isAttachedToWindow: " + r6.a.isAttachedToWindow());
        if (r6.a.isAttachedToWindow() == false) goto L5;
        UICallbackExecutor.removeCallbacks(r6.f);
        UICallbackExecutor.executeDelayed(r6.f, PreloadConfig.DEFAULT_TIMEOUT);
        return;
    L5:
        String r0 = r6.b.getBizName();
        if (r0 != null) goto L8;
        r0 = BuildConfig.FLAVOR;
    L8:
        Map<String, Integer> r2 = g;
        Integer r3 = (Integer) ((LinkedHashMap) r2).get(r0);
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L12:
        j.f("CML_TAG_ChameleonPreloader", "checkReloadWebview====== times: " + r4);
        if (r4 <= 0) goto L23;
        r2.put(r0, Integer.valueOf(r4 - 1));
        int r1 = com.ss.android.lark.officesdk.utils.di.d.a;
        Application r5 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        if (r5 == null) goto L24;
        v1b.a r7 = (v1b.a) k.a(r5, v1b.a.class);
        if (r7 == null) goto L25;
        ChameleonWebViewManager r8 = r7.F2();
        if (r8 == null) goto L26;
        r8.h(r6.b, r6.a);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r4 = 0;
        goto L12
    }

    public static final void b(ChameleonPreloader r1, PreloadStatus r2) {
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r2 == r1.c) goto L8;
        r1.c = r2;     // Catch: Throwable -> L10
        b r0 = r1.e;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);
    }

    public ChameleonPreloader(ChameleonWebView r3, ChameleonConfig r4, UIThreadCallbackAdapter r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r5, "callbackAdapter");
        this.a = r3;
        this.b = r4;
        Map<String, Integer> r6 = g;
        String r7 = r4.getBizName();
        String r0 = BuildConfig.FLAVOR;
        if (r7 != null) goto L6;
        r7 = BuildConfig.FLAVOR;
    L6:
        if (((LinkedHashMap) r6).get(r7) != null) goto L12;
        String r8 = r4.getBizName();
        if (r8 == null) goto L11;
        r0 = r8;
    L11:
        r6.put(r0, 5);
    L12:
        this.c = PreloadStatus.INIT;
        PreloadConfig r9 = r4.getPreloadConfig();
        if (r9 == null) goto L16;
        PreloadPolicy r10 = r9.getPolicy();
        if (r10 == null) goto L16;
    L17:
        this.d = r10;
        this.f = new d(this);
        return;
    L16:
        r10 = PreloadPolicy.NO_PRELOAD;
        goto L17
    }
}
