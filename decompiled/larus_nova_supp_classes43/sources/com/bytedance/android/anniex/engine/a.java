package com.bytedance.android.anniex.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends com.bytedance.android.anniex.ui.b {
    public WeakReference<com.bytedance.android.anniex.ui.e> h;
    public WeakReference<AnnieXLynxView> i;
    public volatile boolean j;
    public final Queue<b> k;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.engine.a$a, reason: collision with other inner class name */
    public static final class C0093a {
    }

    public static final class b {
        public final Handler a;
        public final Runnable b;

        public b(Handler r10, Runnable r11) {
            Intrinsics.checkNotNullParameter(r10, "handler");
            Intrinsics.checkNotNullParameter(r11, "runnable");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;
        public final /* synthetic */ Transformer g;
        public final /* synthetic */ com.lynx.tasm.behavior.m.a h;

        public c(a r1, Context r10, String r11, String r12, float r13, float r14, Transformer r15, com.lynx.tasm.behavior.m.a r16) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.c(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.d(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ v0 b;

        public f(a r1, v0 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.f(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.g(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public h(a r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.h(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ a a;

        public i(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.i(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ LynxEventDetail b;

        public j(a r1, LynxEventDetail r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.j(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public k(a r1, String r10, String r11, int r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.k(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public l(a r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.m(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ a a;

        public m(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.n(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public n(a r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.p(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ LynxError b;

        public o(a r1, LynxError r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.o(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p implements Runnable {
        public final /* synthetic */ a a;

        public p(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.q(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ q1.b b;

        public q(a r1, q1.b r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.r(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class r implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ q1.b b;

        public r(a r1, q1.b r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.s(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ TemplateBundle b;

        public s(a r1, TemplateBundle r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.t(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class t implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public t(a r1, String r10, boolean r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<com.bytedance.android.anniex.ui.e> r0 = this.a.h;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            com.bytedance.android.anniex.ui.e r1 = r0.get();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.onTemplateReady(this.b, this.c);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class u implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Map<String, Object> b;

        public u(a r1, Map<String, Object> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.u(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class v implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Map<String, Object> b;
        public final /* synthetic */ Map<String, Long> c;
        public final /* synthetic */ String d;

        public v(a r1, Map<String, Object> r10, Map<String, Long> r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.v(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class w implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ v0 b;

        public w(a r1, v0 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.w(this.a, this.b);     // Catch: Throwable -> L4
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

    public final void x() {
        monitor-enter(this);
        this.j = false;     // Catch: Throwable -> L16
    L6:
        if ((!((ConcurrentLinkedQueue) this.k).isEmpty()) == false) goto L13;
        b r0 = (b) ((ConcurrentLinkedQueue) this.k).poll();     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        if (Intrinsics.areEqual(r0.a.getLooper(), Looper.myLooper()) == true) goto L11;
        r0.a.post(r0.b);     // Catch: Throwable -> L16
        goto L6
    L11:
        r0.b.run();     // Catch: Throwable -> L16
        goto L6
    L13:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onDataUpdated() {
        z(new d(this));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onDestroy() {
        z(new e(this));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onFirstScreen() {
        z(new g(this));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onLoadSuccess() {
        z(new i(this));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onPageUpdate() {
        z(new m(this));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onRuntimeReady() {
        z(new p(this));
    }

    public static final /* synthetic */ void c(a r0) {
        super.onDataUpdated();
    }

    public static final /* synthetic */ void d(a r0) {
        super.onDestroy();
    }

    public static final /* synthetic */ void g(a r0) {
        super.onFirstScreen();
    }

    public static final /* synthetic */ void i(a r0) {
        super.onLoadSuccess();
    }

    public static final /* synthetic */ void n(a r0) {
        super.onPageUpdate();
    }

    public static final /* synthetic */ void q(a r0) {
        super.onRuntimeReady();
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onFirstLoadPerfReady(v0 r10) {
        z(new f(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onLoadFailed(String r10) {
        z(new h(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onLynxEvent(LynxEventDetail r10) {
        z(new j(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onPageStart(String r10) {
        z(new l(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onReceivedError(LynxError r10) {
        z(new o(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onScrollStart(q1.b r10) {
        z(new q(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onScrollStop(q1.b r10) {
        z(new r(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onTemplateBundleReady(TemplateBundle r10) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        z(new s(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onTimingSetup(Map<String, Object> r10) {
        z(new u(this, r10));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onUpdatePerfReady(v0 r10) {
        z(new w(this, r10));
    }

    public final void z(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        if (this.j == false) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.j == false) goto L13;
        Looper r0 = Looper.myLooper();     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        r0 = Looper.getMainLooper();     // Catch: Throwable -> L16
    L10:
        Handler r1 = new Handler(r0);     // Catch: Throwable -> L16
        Queue<b> r11 = this.k;     // Catch: Throwable -> L16
        ConcurrentLinkedQueue r12 = (ConcurrentLinkedQueue) r11;     // Catch: Throwable -> L16
        r12.add(new b(r1, r10));     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    L19:
        r10.run();
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onReceivedError(String r10) {
        z(new n(this, r10));
    }

    public a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        super(null, r11, r10);
        this.k = new ConcurrentLinkedQueue();
    }

    public static final /* synthetic */ void f(a r0, v0 r1) {
        super.onFirstLoadPerfReady(r1);
    }

    public static final /* synthetic */ void h(a r0, String r1) {
        super.onLoadFailed(r1);
    }

    public static final /* synthetic */ void j(a r0, LynxEventDetail r1) {
        super.onLynxEvent(r1);
    }

    public static final /* synthetic */ void m(a r0, String r1) {
        super.onPageStart(r1);
    }

    public static final /* synthetic */ void o(a r0, LynxError r1) {
        super.onReceivedError(r1);
    }

    public static final /* synthetic */ void p(a r0, String r1) {
        super.onReceivedError(r1);
    }

    public static final /* synthetic */ void r(a r0, q1.b r1) {
        super.onScrollStart(r1);
    }

    public static final /* synthetic */ void s(a r0, q1.b r1) {
        super.onScrollStop(r1);
    }

    public static final /* synthetic */ void t(a r0, TemplateBundle r1) {
        super.onTemplateBundleReady(r1);
    }

    public static final /* synthetic */ void u(a r0, Map r1) {
        super.onTimingSetup(r1);
    }

    public static final /* synthetic */ void w(a r0, v0 r1) {
        super.onUpdatePerfReady(r1);
    }

    public final void y(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "resFrom");
        z(new t(this, r10, r11));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onModuleMethodInvoked(String r10, String r11, int r12) {
        z(new k(this, r10, r11, r12));
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        z(new v(this, r10, r11, r12));
    }

    public static final /* synthetic */ void k(a r0, String r1, String r10, int r11) {
        super.onModuleMethodInvoked(r1, r10, r11);
    }

    public static final /* synthetic */ void v(a r0, Map r1, Map r10, String r11) {
        super.onTimingUpdate(r1, r10, r11);
    }

    @Override // com.bytedance.android.anniex.ui.b
    public final void loadImage(Context r11, String r12, String r13, float r14, float r15, Transformer r16, com.lynx.tasm.behavior.m.a r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r17, "handler");
        z(new c(this, r11, r12, r13, r14, r15, r16, r17));
    }

    public static final /* synthetic */ void b(a r0, Context r1, String r10, String r11, float r12, float r13, Transformer r14, com.lynx.tasm.behavior.m.a r15) {
        super.loadImage(r1, r10, r11, r12, r13, r14, r15);
    }
}
