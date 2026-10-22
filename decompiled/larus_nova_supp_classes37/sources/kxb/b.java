package kxb;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.HangDetectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.officewebview.quality.hang.detect.JSPingCheckSource;
import com.ss.android.lark.officewebview.quality.hang.detect.ResetPingSource;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements kxb.a {
    public final OfficeWebView a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final long d;
    public final long e;
    public final long f;
    public boolean g;
    public boolean h;
    public int i;
    public final int j;
    public final d k;
    public final c l;
    public final RunnableC0162b m;

    public static final class a {
    }

    /* JADX INFO: renamed from: kxb.b$b, reason: collision with other inner class name */
    public static final class RunnableC0162b implements Runnable {
        public final /* synthetic */ b a;

        public RunnableC0162b(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.f("RunJSPingHangDetector", "checkState timeout, force start ping");     // Catch: Throwable -> L4
            b.a(this.a, JSPingCheckSource.UNRESPONSIVE.getValue());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.g == false) goto L9;
            j.e("RunJSPingHangDetector", "delay ping start");     // Catch: Throwable -> L6
            b.a(this.a, JSPingCheckSource.NOT_READY_DELAY.getValue());     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.i++;
            j.b("RunJSPingHangDetector", "hang biz: " + this.a.a.getBizScene$webview_release() + ", timeout:" + this.a.i + ", isVisible: " + this.a.g);
            b r0 = this.a;
            if (r0.g == true) goto L5;
            return;
        L5:
            r0.b.invoke();
            b r1 = this.a;
            if (r1.i < r1.j) goto L8;
            j.b("RunJSPingHangDetector", "hang detected");
            this.a.c(ResetPingSource.HangDetected.getValue());
            return;
        L8:
            b.a(r1, JSPingCheckSource.DOUBLE_CHECK.getValue());
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
    }

    static {
    }

    @Override // kxb.a
    public final /* synthetic */ void init() {
    }

    @Override // kxb.a
    public final void start() {
        this.g = true;
        if (this.h == false) goto L7;
        j.e("RunJSPingHangDetector", "bizScene=" + this.a.getBizScene$webview_release() + " has checked");
        return;
    L7:
        if (this.a.n() == true) goto L9;
        return;
    L9:
        j.e("RunJSPingHangDetector", "start: bizScene=" + this.a.getBizScene$webview_release() + ", webViewId=" + Integer.toHexString(System.identityHashCode(this.a)) + ' ');
        this.h = true;
        this.i = 0;
        b();
        if (this.a.getWebViewIsDestroy() == true) goto L20;
        j.e("RunJSPingHangDetector", "checkReadyAndPing");
        Lazy<Handler> r0 = ThreadUtil.a;
        ThreadUtil.a.d(this.m, this.d);
        this.a.evaluateJavascript("document.readyState", new kxb.c(this));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        b();
        j.c("RunJSPingHangDetector", "checkState error", th);
        return;
    }

    public final void b() {
        Lazy<Handler> r0 = ThreadUtil.a;
        ThreadUtil.a.e(this.k);
        ThreadUtil.a.e(this.m);
        ThreadUtil.a.e(this.l);
    }

    @Override // kxb.a
    public final void stop() {
        j.e("RunJSPingHangDetector", "stop: bizScene=" + this.a.getBizScene$webview_release() + ", webViewId=" + Integer.toHexString(System.identityHashCode(this.a)));
        this.g = false;
        this.h = false;
        this.i = 0;
        b();
    }

    public final void c(String r3) {
        j.e("RunJSPingHangDetector", "resetPing, from " + r3);
        Lazy<Handler> r4 = ThreadUtil.a;
        ThreadUtil.a.e(this.k);
        this.i = 0;
    }

    public static final void a(b r3, String r4) {
        r3.getClass();
        j.e("RunJSPingHangDetector", "sendPing, from " + r4);
        if (r3.g == false) goto L5;
    L7:
        r3.b();
        Lazy<Handler> r5 = ThreadUtil.a;     // Catch: Throwable -> L10
        ThreadUtil.a.d(r3.k, r3.f);     // Catch: Throwable -> L10
        r3.a.evaluateJavascript("(function(){return 'onReceive';})()", new kxb.d(r3));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        j.c("RunJSPingHangDetector", "evaluateJavascript ping error", th);
        r3.c(ResetPingSource.Error.getValue());
        r3.c.invoke();
        return;
    L5:
        if (r3.a.getWebViewIsDestroy() == false) goto L7;
        j.e("RunJSPingHangDetector", "stop sendPing, webView is invisible or destroy");
        r3.b();
    }

    public b(OfficeWebView r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "onHang");
        Intrinsics.checkNotNullParameter(r5, "onResponsive");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        HangDetectStrategy r6 = HangDetectStrategy.UNKNOWN;
        WebViewOptimizeConfig r7 = ixb.a.a;
        if (r7 == null) goto L5;
        HangDetectConfig r8 = r7.getHangDetect();
    L6:
        long r9 = 5000;
        if (r8 == null) goto L9;
        long r0 = r8.getCheckReadyTimeout();
    L10:
        this.d = r0;
        if (r8 == null) goto L13;
        long r1 = r8.getSendPingDelay();
    L14:
        this.e = r1;
        if (r8 == null) goto L17;
        r9 = r8.getPingTimeout();
    L17:
        this.f = r9;
        if (r8 == null) goto L20;
        int r10 = r8.getMaxHangCount();
    L21:
        this.j = r10;
        this.k = new d(this);
        this.l = new c(this);
        this.m = new RunnableC0162b(this);
        return;
    L20:
        r10 = 2;
        goto L21
    L13:
        r1 = 5000;
        goto L14
    L9:
        r0 = 5000;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
