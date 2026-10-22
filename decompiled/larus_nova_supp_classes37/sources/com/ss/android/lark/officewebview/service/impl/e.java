package com.ss.android.lark.officewebview.service.impl;

import android.os.Build;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.HangDetectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.officewebview.quality.hang.HangRecoveryStrategy;
import com.ss.android.lark.officewebview.quality.hang.detect.RenderProcessClientHangDetector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements jxb.a {
    public static final /* synthetic */ int m = 0;
    public OfficeWebView a;
    public final Map<HangDetectStrategy, kxb.a> b;
    public final Map<HangRecoveryStrategy, lxb.a> c;
    public HangDetectStrategy d;
    public HangRecoveryStrategy e;
    public boolean f;
    public volatile boolean g;
    public final Set<jxb.b> h;
    public boolean i;
    public int j;
    public final int k;
    public final int l;

    public static final class a {
    }

    static {
    }

    @Override // jxb.a
    public final void start() {
        if (this.f == true) goto L5;
        this.f = true;
    L5:
        this.j = 0;
        this.i = false;
        System.currentTimeMillis();
        HangDetectStrategy r0 = this.d;
        if (r0 == null) goto L8;
        kxb.a r1 = (kxb.a) ((LinkedHashMap) this.b).get(r0);
    L9:
        if (r1 == null) goto L12;
        r1.start();
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // jxb.a
    public final void stop() {
        j.e("WebViewHangService", "stop");
        this.j = 0;
        this.i = false;
        this.f = false;
        HangDetectStrategy r0 = this.d;
        if (r0 == null) goto L5;
        kxb.a r1 = (kxb.a) ((LinkedHashMap) this.b).get(r0);
    L6:
        if (r1 == null) goto L9;
        r1.stop();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public e() {
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.h = new LinkedHashSet();
        WebViewOptimizeConfig r0 = ixb.a.a;
        if (r0 == null) goto L5;
        HangDetectConfig r1 = r0.getHangDetect();
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getReportHangCount();
    L9:
        this.k = r2;
        if (r1 == null) goto L12;
        int r3 = r1.getMaxHangCount();
    L13:
        this.l = r3;
        return;
    L12:
        r3 = 3;
        goto L13
    L8:
        r2 = 1;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static final void O(e r13) {
        if (r13.f == true) goto L5;
        j.e("WebViewHangService", "onHangDetected but hang service not started");
        return;
    L5:
        int r0 = r13.j + 1;
        r13.j = r0;
        if (r13.i == true) goto L17;
        if (r0 < r13.k) goto L17;
        r13.i = true;
        Iterator<T> r1 = r13.h.iterator();
    L11:
        if (r1.hasNext() == false) goto L17;
        jxb.b r3 = (jxb.b) r1.next();
        HangDetectStrategy r4 = r13.d;
        if (r4 != null) goto L15;
        r4 = HangDetectStrategy.UNKNOWN;
    L15:
        r3.b(r4);
    L17:
        if (r13.j < r13.l) goto L64;
        OfficeWebView r2 = r13.a;
        if (r2 == null) goto L66;
        HangRecoveryStrategy r5 = r13.e;
        if (r5 != null) goto L25;
        j.e("WebViewHangService", "recovery stop, strategy is null");     // Catch: Throwable -> L50
    L52:
        r13.g = false;
        return;
    L25:
        if (r2.n() == true) goto L27;
        j.e("WebViewHangService", "recovery stop, webView isn't front");     // Catch: Throwable -> L50
        goto L52
    L27:
        WebViewOptimizeConfig r6 = ixb.a.a;     // Catch: Throwable -> L50
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L50
        if ((r7 - ixb.a.i) >= ixb.a.g) goto L30;
        j.e("WebViewOptimizeUtil", "can't kill, time too short");     // Catch: Throwable -> L50
    L33:
        boolean r8 = false;
    L35:
        if (r8 == true) goto L38;
        j.e("WebViewHangService", "recovery stop, limit");     // Catch: Throwable -> L50
        goto L52
    L38:
        if (r13.g == false) goto L40;
        j.e("WebViewHangService", "onHangDetected skip because recovering");     // Catch: Throwable -> L50
        goto L52
    L40:
        r13.g = true;     // Catch: Throwable -> L50
        lxb.a r9 = (lxb.a) ((LinkedHashMap) r13.c).get(r5);     // Catch: Throwable -> L50
        if (r9 == null) goto L43;
        boolean r10 = r9.a(r2);     // Catch: Throwable -> L50
    L44:
        Iterator<T> r11 = r13.h.iterator();     // Catch: Throwable -> L50
    L46:
        if (r11.hasNext() == false) goto L48;
        ((jxb.b) r11.next()).a(Boolean.valueOf(r10));     // Catch: Throwable -> L50
        goto L46
    L48:
        j.e("WebViewHangService", "recovery executed, strategy=" + r5 + ", result=" + r10);     // Catch: Throwable -> L50
        goto L52
    L43:
        r10 = false;
        goto L44
    L30:
        int r12 = ixb.a.h;     // Catch: Throwable -> L50
        if (r12 < ixb.a.f) goto L34;
        j.e("WebViewOptimizeUtil", "can't kill, count limit");     // Catch: Throwable -> L50
        goto L33
    L34:
        ixb.a.i = r7;     // Catch: Throwable -> L50
        ixb.a.h = r12 + 1;     // Catch: Throwable -> L50
        r8 = true;
    L50:
        th = move-exception;
        j.c("WebViewHangService", "onHangDetected error", th);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        r13.g = false;
        throw th;
    L66:
        return;
    }

    @Override // jxb.a
    public final void H(ChameleonWebView.g r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.h.add(r2);
    }

    @Override // jxb.a
    public final void N(ChameleonWebView.g r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.h.remove(r2);
    }

    @Override // jxb.a
    public final void b(OfficeWebView r7) {
        Intrinsics.checkNotNullParameter(r7, "officeWebView");
        j.e("WebViewHangService", "init");
        System.currentTimeMillis();
        this.a = r7;
        if ((!this.b.isEmpty()) == true) goto L6;
        this.b.put(HangDetectStrategy.RENDER_PROCESS_CLIENT, new RenderProcessClientHangDetector(r7, new WebViewHangService$setupStrategies$1(this), new WebViewHangService$setupStrategies$2(this)));
        this.b.put(HangDetectStrategy.JS_PING, new kxb.b(r7, new WebViewHangService$setupStrategies$3(this), new WebViewHangService$setupStrategies$4(this)));
        this.c.put(HangRecoveryStrategy.TERMINATE_RENDER_PROCESS, new lxb.c());
        this.c.put(HangRecoveryStrategy.KILL_SANDBOX_PROCESS, new lxb.b());
    L6:
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 29) goto L9;
        HangDetectStrategy r2 = HangDetectStrategy.RENDER_PROCESS_CLIENT;
    L10:
        if (r8 < 29) goto L12;
        HangRecoveryStrategy r9 = HangRecoveryStrategy.TERMINATE_RENDER_PROCESS;
    L13:
        this.d = r2;
        WebViewOptimizeConfig r1 = ixb.a.a;
        kxb.a r3 = null;
        if (r1 == null) goto L16;
        HangDetectConfig r4 = r1.getHangDetect();
    L17:
        if (r4 == null) goto L19;
        boolean r5 = r4.getEnableRecoverKill();
    L20:
        if (r5 == false) goto L22;
        this.e = r9;
    L22:
        j.e("WebViewHangService", "selectDefaultStrategy detect=" + r2 + " recovery=" + r9);
        HangDetectStrategy r10 = this.d;
        if (r10 == null) goto L25;
        r3 = (kxb.a) ((LinkedHashMap) this.b).get(r10);
    L25:
        if (r3 == null) goto L28;
        r3.init();
        return;
    L28:
        return;
    L19:
        r5 = false;
        goto L20
    L16:
        r4 = null;
        goto L17
    L12:
        r9 = HangRecoveryStrategy.KILL_SANDBOX_PROCESS;
        goto L13
    L9:
        r2 = HangDetectStrategy.JS_PING;
        goto L10
    }
}
