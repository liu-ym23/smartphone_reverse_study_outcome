package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.util.j;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.bumptech.glide.i f904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.b.a f905b;
    private final Handler c;
    private final List<b> d;
    private final com.bumptech.glide.load.engine.bitmap_recycle.e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.bumptech.glide.h<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private com.bumptech.glide.load.h<Bitmap> n;
    private a o;
    private d p;
    private int q;
    private int r;
    private int s;

    static class a extends com.bumptech.glide.request.a.a<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f907b;
        private final long c;
        private Bitmap d;

        a(Handler r1, int r2, long r3) {
            this.f907b = r1;
            this.f906a = r2;
            this.c = r3;
        }

        Bitmap a() {
            return this.d;
        }

        public void a(Bitmap r3, com.bumptech.glide.request.b.b<? super Bitmap> r4) {
            com.bumptech.glide.request.b.b r5 = (com.bumptech.glide.request.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.b.b.class, "com.obric.memorydata.plugin");
            this.d = r3;
            Message r6 = this.f907b.obtainMessage(1, this);
            this.f907b.sendMessageAtTime(r6, this.c);
        }

        @Override // com.bumptech.glide.request.a.e
        public /* synthetic */ void a(Object r3, com.bumptech.glide.request.b.b r4) {
            com.bumptech.glide.request.b.b<? super Bitmap> r5 = (com.bumptech.glide.request.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.b.b.class, "com.obric.memorydata.plugin");
            a((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // com.bumptech.glide.request.a.e
        public void a_(Drawable r1) {
            this.d = null;
        }
    }

    public interface b {
        void onFrameReady();
    }

    private class c implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f908a;

        c(f r1) {
            this.f908a = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4.obj, a.class, "com.obric.memorydata.plugin");
            this.f908a.a(r5);
            return true;
        L7:
            if (r4.what != 2) goto L11;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r4.obj, a.class, "com.obric.memorydata.plugin");
            this.f908a.f904a.a(r6);
            return false;
        L11:
            return false;
        }
    }

    interface d {
        void a();
    }

    f(com.bumptech.glide.c r11, com.bumptech.glide.b.a r12, int r13, int r14, com.bumptech.glide.load.h<Bitmap> r15, Bitmap r16) {
        com.bumptech.glide.b.a r5 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.h r8 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r15, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this(r11.a(), com.bumptech.glide.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, null, a(com.bumptech.glide.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r13, r14), r8, r16);
    }

    f(com.bumptech.glide.load.engine.bitmap_recycle.e r3, com.bumptech.glide.i r4, com.bumptech.glide.b.a r5, Handler r6, com.bumptech.glide.h<Bitmap> r7, com.bumptech.glide.load.h<Bitmap> r8, Bitmap r9) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r10 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.b.a r11 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.b.a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.h<Bitmap> r12 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.d = new ArrayList();
        this.f904a = r4;
        if (r6 != null) goto L5;
        r6 = new Handler(Looper.getMainLooper(), new c(this));
    L5:
        this.e = r10;
        this.c = r6;
        this.i = r7;
        this.f905b = r11;
        a(r12, r9);
    }

    private static com.bumptech.glide.h<Bitmap> a(com.bumptech.glide.i r4, int r5, int r6) {
        return r4.h().a(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.f.b(com.bumptech.glide.load.engine.h.f780b).a(true), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).b(true), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).a(r5, r6));
    }

    private void m() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        this.k = false;
        o();
    }

    private void n() {
        this.f = false;
    }

    private void o() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.g == false) goto L8;
        return;
    L8:
        if (this.h == true) goto L10;
    L14:
        a r0 = this.o;
        if (r0 == null) goto L18;
        this.o = null;
        a(r0);
        return;
    L18:
        this.g = true;
        long r1 = SystemClock.uptimeMillis() + ((long) this.f905b.c());
        this.f905b.b();
        this.l = new a(this.c, this.f905b.e(), r1);
        this.i.a(com.bumptech.glide.request.f.b(q())).a(this.f905b).a(this.l);
        return;
    L10:
        if (this.o != null) goto L12;
        boolean r2 = true;
    L13:
        j.a(r2, "Pending target must be null when starting from the first frame");
        this.f905b.f();
        this.h = false;
        goto L14
    L12:
        r2 = false;
        goto L13
    }

    private void p() {
        Bitmap r0 = this.m;
        if (r0 == null) goto L6;
        this.e.a(r0);
        this.m = null;
        return;
    }

    private static com.bumptech.glide.load.c q() {
        return new com.bumptech.glide.e.d(Double.valueOf(Math.random()));
    }

    com.bumptech.glide.load.h<Bitmap> a() {
        return this.n;
    }

    void a(com.bumptech.glide.load.h<Bitmap> r4, Bitmap r5) {
        com.bumptech.glide.load.h<Bitmap> r6 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.n = (com.bumptech.glide.load.h) ZeusTransformUtils.preCheckCast(j.a(r6), com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        this.m = (Bitmap) ZeusTransformUtils.preCheckCast(j.a(r5), Bitmap.class, "com.obric.memorydata.plugin");
        this.i = this.i.a(new com.bumptech.glide.request.f().a(r6));
        this.q = k.a(r5);
        this.r = r5.getWidth();
        this.s = r5.getHeight();
    }

    void a(a r6) {
        d r0 = this.p;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.g = false;
        if (this.k == false) goto L10;
        this.c.obtainMessage(2, r6).sendToTarget();
        return;
    L10:
        if (this.f == true) goto L17;
        if (this.h == false) goto L14;
        this.c.obtainMessage(2, r6).sendToTarget();
        return;
    L14:
        this.o = r6;
        return;
    L17:
        if (r6.a() == null) goto L23;
        p();
        a r1 = this.j;
        this.j = r6;
        int r7 = this.d.size() - 1;
    L19:
        if (r7 < 0) goto L21;
        ((b) ZeusTransformUtils.preCheckCast(this.d.get(r7), b.class, "com.obric.memorydata.plugin")).onFrameReady();
        r7 = r7 - 1;
        goto L19
    L21:
        if (r1 == null) goto L23;
        this.c.obtainMessage(2, r1).sendToTarget();
    L23:
        o();
    }

    void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (this.k == true) goto L13;
        if (this.d.contains(r4) == true) goto L11;
        boolean r0 = this.d.isEmpty();
        this.d.add(r4);
        if (r0 == false) goto L14;
        m();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Cannot subscribe twice in a row");
    L13:
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    Bitmap b() {
        return this.m;
    }

    void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.d.remove(r4);
        if (this.d.isEmpty() == false) goto L6;
        n();
        return;
    }

    int c() {
        return this.r;
    }

    int d() {
        return this.s;
    }

    int e() {
        return this.f905b.h() + this.q;
    }

    int f() {
        a r0 = this.j;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.f906a;
    }

    ByteBuffer g() {
        return this.f905b.a().asReadOnlyBuffer();
    }

    int h() {
        return this.f905b.d();
    }

    int i() {
        return this.f905b.g();
    }

    void j() {
        this.d.clear();
        p();
        n();
        a r0 = this.j;
        if (r0 == null) goto L5;
        this.f904a.a(r0);
        this.j = null;
    L5:
        a r1 = this.l;
        if (r1 == null) goto L8;
        this.f904a.a(r1);
        this.l = null;
    L8:
        a r2 = this.o;
        if (r2 == null) goto L11;
        this.f904a.a(r2);
        this.o = null;
    L11:
        this.f905b.j();
        this.k = true;
    }

    Bitmap k() {
        a r0 = this.j;
        if (r0 == null) goto L6;
        return r0.a();
    L6:
        return this.m;
    }

    void l() {
        j.a(!this.f, "Can't restart a running animation");
        this.h = true;
        a r0 = this.o;
        if (r0 == null) goto L6;
        this.f904a.a(r0);
        this.o = null;
        return;
    }
}
