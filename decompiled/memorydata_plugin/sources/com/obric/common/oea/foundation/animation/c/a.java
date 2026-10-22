package com.obric.common.oea.foundation.animation.c;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<a> f7687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f7688b;
    long c;
    private final ArrayMap<b, Long> d;
    private final C0373a e;
    private c f;
    private boolean g;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.c.a$a, reason: collision with other inner class name */
    class C0373a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f7689a;

        C0373a(a r1) {
            this.f7689a = r1;
        }

        void a() {
            a r0 = this.f7689a;
            r0.c = SystemClock.uptimeMillis();
            a r1 = this.f7689a;
            r1.a(r1.c);
            if (this.f7689a.f7688b.size() <= 0) goto L6;
            this.f7689a.b().a();
            return;
        }
    }

    interface b {
        boolean a(long r1);
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0373a f7690a;

        c(C0373a r1) {
            this.f7690a = r1;
        }

        abstract void a();
    }

    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7691b;
        private final Runnable c;
        private final Handler d;

        d(C0373a r3) {
            super(r3);
            this.f7691b = -1;
            this.c = new AnonymousClass1(this);
            this.d = new Handler(Looper.myLooper());
        }

        @Override // com.obric.common.oea.foundation.animation.c.a.c
        void a() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.f7691b), 0);
            this.d.postDelayed(this.c, r0);
        }
    }

    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f7693b;
        private final Choreographer.FrameCallback c;

        e(C0373a r1) {
            super(r1);
            this.f7693b = Choreographer.getInstance();
            this.c = new AnonymousClass1(this);
        }

        @Override // com.obric.common.oea.foundation.animation.c.a.c
        void a() {
            this.f7693b.postFrameCallback(this.c);
        }
    }

    static {
        f7687a = new ThreadLocal();
    }

    a() {
        this.d = new ArrayMap();
        this.f7688b = new ArrayList();
        this.e = new C0373a(this);
        this.c = 0;
        this.g = false;
    }

    public static a a() {
        ThreadLocal<a> r0 = f7687a;
        if (r0.get() != null) goto L6;
        r0.set(new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.memorydata.plugin");
    }

    private boolean b(b r5, long r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(r7), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.d.remove(r7);
        return true;
    L9:
        return false;
    }

    private void c() {
        if (this.g == false) goto L15;
        int r0 = this.f7688b.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.f7688b.get(r0) != null) goto L9;
        this.f7688b.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.g = false;
        return;
    }

    void a(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.f7688b.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f7688b.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (b(r3, r0) == false) goto L11;
        r3.a(r7);
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        c();
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.d.remove(r4);
        int r5 = this.f7688b.indexOf(r4);
        if (r5 < 0) goto L6;
        this.f7688b.set(r5, null);
        this.g = true;
        return;
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (this.f7688b.size() != 0) goto L6;
        b().a();
    L6:
        if (this.f7688b.contains(r5) == true) goto L9;
        this.f7688b.add(r5);
    L9:
        if (r4 <= 0) goto L12;
        this.d.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    c b() {
        if (this.f != null) goto L10;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        c r0 = new e(this.e);
    L8:
        this.f = r0;
        goto L10
    L7:
        r0 = new d(this.e);
    L10:
        return this.f;
    }
}
