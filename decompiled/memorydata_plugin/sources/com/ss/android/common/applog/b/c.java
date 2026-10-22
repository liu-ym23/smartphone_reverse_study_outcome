package com.ss.android.common.applog.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.common.applog.ad;
import com.ss.android.common.applog.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static volatile c e;
    private static volatile a n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15057b;
    private boolean c;
    private long d;
    private d f;
    private Handler g;
    private Context h;
    private b i;
    private final List<d> j;
    private boolean k;
    private final Runnable l;
    private final Runnable m;

    private c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f15056a = false;
        this.f15057b = false;
        this.c = true;
        this.d = ae.a();
        this.j = new ArrayList();
        this.k = false;
        this.l = new AnonymousClass3(this);
        this.m = new AnonymousClass4(this);
        this.h = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.i = new b(r6);
    }

    static /* synthetic */ long a(c r0, long r1) {
        r0.d = r1;
        return r1;
    }

    public static c a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return e;
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
        Handler r2 = d();
        r2.removeMessages(1);
        r2.sendMessageDelayed(Message.obtain(r2, 1, r3), 5000);
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.c = r1;
        return r1;
    }

    static /* synthetic */ boolean b(c r0) {
        return r0.c;
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.k = r1;
        return r1;
    }

    private Handler c() {
        final Looper r1 = ad.a().getLooper();
        return new AnonymousClass1(this, r1);
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.f15057b;
    }

    static /* synthetic */ boolean c(c r0, boolean r1) {
        r0.f15057b = r1;
        return r1;
    }

    private Handler d() {
        if (this.g != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.g != null) goto L8;
        this.g = c();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.g;
    }

    static /* synthetic */ b d(c r0) {
        return r0.i;
    }

    static /* synthetic */ boolean d(c r0, boolean r1) {
        r0.f15056a = r1;
        return r1;
    }

    private void e() {
        a r0 = n;
        if (r0 == null) goto L11;
        boolean r1 = r0.a();
        if (this.f15057b == r1) goto L12;
        com.ss.android.common.b.c.a.b("tryCorrectTaskState newIsTaskRunning : " + r1);
        if (r1 == false) goto L9;
        b();
        return;
    L9:
        a();
        return;
    L12:
        return;
    }

    static /* synthetic */ void e(c r0) {
        r0.e();
    }

    static /* synthetic */ Runnable f(c r0) {
        return r0.m;
    }

    private void f() {
        this.f15056a = false;
        this.j.clear();
        this.k = false;
    }

    static /* synthetic */ Runnable g(c r0) {
        return r0.l;
    }

    private void g() {
        d().removeMessages(1);
    }

    static /* synthetic */ void h(c r0) {
        r0.g();
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.f15056a;
    }

    static /* synthetic */ long j(c r2) {
        return r2.d;
    }

    static /* synthetic */ List k(c r0) {
        return r0.j;
    }

    static /* synthetic */ void l(c r0) {
        r0.f();
    }

    static /* synthetic */ boolean m(c r0) {
        return r0.k;
    }

    public void a() {
        final long r0 = ae.a();
        ad.a().d(new AnonymousClass5(this, r0));
    }

    public void a(final long r3, final String r5) {
        ad.a().d(new AnonymousClass2(this, r3, r5));
    }

    public void b() {
        final long r0 = ae.a();
        ad.a().d(new AnonymousClass7(this, r0));
    }

    public void b(final long r3, final String r5) {
        ad.a().d(new AnonymousClass6(this, r3, r5));
    }
}
