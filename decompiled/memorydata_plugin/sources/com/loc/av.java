package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f5332a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f5333b = false;
    static int c = 20;
    static int d = 0;
    private static WeakReference<as> e = null;
    private static int f = 10;

    static class a extends bq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f5335b;
        private au c;

        a(Context r3, int r4) {
            this.f5335b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f5334a = r4;
        }

        a(Context r3, au r4) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 1);
            this.c = r4;
        }

        @Override // com.loc.bq
        public final void a() {
            int r0 = this.f5334a;
            if (r0 != 1) goto L19;
            monitor-enter(av.class);     // Catch: Throwable -> L15
            String r1 = Long.toString(System.currentTimeMillis());     // Catch: Throwable -> L12
            as r2 = ay.a(av.a());     // Catch: Throwable -> L12
            ay.a(this.f5335b, r2, o.i, av.f5332a, 2097152, "6");     // Catch: Throwable -> L12
            if (r2.e != null) goto L9;
            r2.e = new ac(new ae(new af(new ae())));     // Catch: Throwable -> L12
        L9:
            at.a(r1, this.c.a(), r2);     // Catch: Throwable -> L12
            monitor-exit(av.class);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            q.b(th, "ofm", "aple");
            return;
        L19:
            if (r0 != 2) goto L37;
            as r3 = ay.a(av.a());     // Catch: Throwable -> L28
            ay.a(this.f5335b, r3, o.i, av.f5332a, 2097152, "6");     // Catch: Throwable -> L28
            r3.h = 14400000;     // Catch: Throwable -> L28
            if (r3.g != null) goto L24;
            ac r7 = new ac(new ae(new af()));     // Catch: Throwable -> L28
            Context r5 = this.f5335b;     // Catch: Throwable -> L28
            bg r6 = new bg();     // Catch: Throwable -> L28
            String r8 = new String(b.a());     // Catch: Throwable -> L28
            com.loc.a.a(this.f5335b);     // Catch: Throwable -> L28
            r3.g = new bc(new bb(r5, r6, r7, r8, new Object[]{fm.f(this.f5335b), fp.k(), fp.h(), fp.f(this.f5335b), fp.a(), Build.MANUFACTURER, Build.DEVICE, fp.n(), fm.c(this.f5335b), Build.MODEL, fm.d(this.f5335b), fm.b(this.f5335b), fp.e(this.f5335b), fp.a(this.f5335b), String.valueOf(Build.VERSION.SDK_INT), com.loc.a.a()}));     // Catch: Throwable -> L28
        L24:
            if (TextUtils.isEmpty(r3.i) == false) goto L26;
            r3.i = "fKey";     // Catch: Throwable -> L28
        L26:
            r3.f = new bk(this.f5335b, r3.h, r3.i, new bi(this.f5335b, av.f5333b, av.b() * 1024, av.c * 1024, "offLocKey", av.d * 1024));     // Catch: Throwable -> L28
            at.a(r3);     // Catch: Throwable -> L28
            return;
        L28:
            th = move-exception;
            q.b(th, "ofm", "uold");
            return;
        }
    }

    static {
    }

    public av() {
    }

    static /* synthetic */ WeakReference a() {
        return e;
    }

    public static synchronized void a(int r1, boolean r2, int r3, int r4) {
        monitor-enter(av.class);
        f5332a = r1;     // Catch: Throwable -> L15
        f5333b = r2;     // Catch: Throwable -> L15
        if (r3 >= 10) goto L7;
    L8:
        r3 = 20;
    L9:
        c = r3;     // Catch: Throwable -> L15
        if ((r3 / 5) <= f) goto L12;
        f = r3 / 5;     // Catch: Throwable -> L15
    L12:
        d = r4;     // Catch: Throwable -> L15
        monitor-exit(av.class);
        return;
    L7:
        if (r3 <= 100) goto L9;
    L15:
        th = move-exception;
        throw th;
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        bp.a().b(new a(r4, 2));
    }

    public static synchronized void a(au r3, Context r4) {
        monitor-enter(av.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        bp.a().b(new a(r5, r3));     // Catch: Throwable -> L7
        monitor-exit(av.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int b() {
        return f;
    }
}
