package com.bytedance.applog.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1746b;
    private volatile boolean c;
    private boolean d;
    private long e;
    private d f;
    private Handler g;
    private final b h;
    private final List<d> i;
    private boolean j;
    private volatile a k;
    private volatile com.bytedance.applog.collector.b l;
    private final com.bytedance.applog.b m;
    private final Runnable n;
    private final Runnable o;

    static {
        f1745a = Collections.singletonList("TaskPresenter");
    }

    public c(com.bytedance.applog.b r4, com.bytedance.applog.n.b r5, com.bytedance.applog.k.c r6) {
        this.f1746b = false;
        this.c = false;
        this.d = true;
        this.e = System.currentTimeMillis();
        this.i = new ArrayList();
        this.j = false;
        this.n = new AnonymousClass2(this);
        this.o = new AnonymousClass3(this);
        this.m = r4;
        this.h = new b(r4, r5, r6);
    }

    static /* synthetic */ long a(c r0, long r1) {
        r0.e = r1;
        return r1;
    }

    static /* synthetic */ d a(c r0) {
        return r0.f;
    }

    static /* synthetic */ d a(c r0, d r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    private void a(String r3) {
        Handler r2 = e();
        r2.removeMessages(1);
        r2.sendMessageDelayed(Message.obtain(r2, 1, r3), 5000);
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ boolean b(c r0) {
        return r0.d;
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.c = r1;
        return r1;
    }

    static /* synthetic */ List c() {
        return f1745a;
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.c;
    }

    static /* synthetic */ boolean c(c r0, boolean r1) {
        r0.f1746b = r1;
        return r1;
    }

    private Handler d() {
        final Looper r1 = e.a().getLooper();
        return new AnonymousClass1(this, r1);
    }

    static /* synthetic */ b d(c r0) {
        return r0.h;
    }

    static /* synthetic */ boolean d(c r0, boolean r1) {
        r0.d = r1;
        return r1;
    }

    private Handler e() {
        if (this.g != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.g != null) goto L8;
        this.g = d();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.g;
    }

    static /* synthetic */ void e(c r0) {
        r0.f();
    }

    static /* synthetic */ com.bytedance.applog.b f(c r0) {
        return r0.m;
    }

    private void f() {
        a r0 = this.k;
        if (r0 == null) goto L11;
        boolean r1 = r0.a();
        if (this.c == r1) goto L12;
        this.m.aA().a(f1745a, "[Task] tryCorrectTaskState newIsTaskRunning : " + r1, new Object[0]);
        if (r1 == false) goto L9;
        a();
        return;
    L9:
        b();
        return;
    L12:
        return;
    }

    private void g() {
        this.f1746b = false;
        this.i.clear();
        this.j = false;
    }

    static /* synthetic */ boolean g(c r0) {
        return r0.j;
    }

    static /* synthetic */ List h(c r0) {
        return r0.i;
    }

    private void h() {
        e().removeMessages(1);
    }

    static /* synthetic */ Runnable i(c r0) {
        return r0.n;
    }

    static /* synthetic */ com.bytedance.applog.collector.b j(c r0) {
        return r0.l;
    }

    static /* synthetic */ void k(c r0) {
        r0.h();
    }

    static /* synthetic */ Runnable l(c r0) {
        return r0.o;
    }

    static /* synthetic */ boolean m(c r0) {
        return r0.f1746b;
    }

    static /* synthetic */ long n(c r2) {
        return r2.e;
    }

    static /* synthetic */ void o(c r0) {
        r0.g();
    }

    public void a() {
        final long r0 = System.currentTimeMillis();
        e.a().d(new AnonymousClass4(this, r0));
    }

    public void a(final long r3, final String r5) {
        e.a().d(new AnonymousClass6(this, r3, r5));
    }

    public void a(com.bytedance.applog.collector.b r3) {
        this.l = (com.bytedance.applog.collector.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.collector.b.class, "com.obric.memorydata.plugin");
    }

    public void a(a r3) {
        this.k = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public void b() {
        final long r0 = System.currentTimeMillis();
        e.a().d(new AnonymousClass5(this, r0));
    }

    public void b(final long r3, final String r5) {
        e.a().d(new AnonymousClass7(this, r3, r5));
    }
}
