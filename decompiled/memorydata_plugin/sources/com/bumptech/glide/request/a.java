package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.j;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f954b;
    private com.bumptech.glide.load.engine.h c;
    private Priority d;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private com.bumptech.glide.load.c l;
    private boolean m;
    private boolean n;
    private Drawable o;
    private int p;
    private com.bumptech.glide.load.e q;
    private Map<Class<?>, com.bumptech.glide.load.h<?>> r;
    private Class<?> s;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public a() {
        this.f954b = 1.0f;
        this.c = com.bumptech.glide.load.engine.h.e;
        this.d = Priority.NORMAL;
        this.i = true;
        this.j = -1;
        this.k = -1;
        this.l = com.bumptech.glide.e.c.a();
        this.n = true;
        this.q = new com.bumptech.glide.load.e();
        this.r = new CachedHashCodeArrayMap();
        this.s = Object.class;
        this.y = true;
    }

    private T a() {
        return this;
    }

    private boolean a(int r1) {
        return b(this.f953a, r1);
    }

    private static boolean b(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean A() {
        return this.y;
    }

    public final boolean B() {
        return this.w;
    }

    public final boolean C() {
        return this.z;
    }

    public final boolean D() {
        return this.x;
    }

    public T a(float r2) {
        if (this.v == false) goto L7;
        return (T) b().a(r2);
    L7:
        if (r2 < 0.0f) goto L13;
        if (r2 > 1.0f) goto L13;
        this.f954b = r2;
        this.f953a |= 2;
        return (T) e();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T a(int r2, int r3) {
        if (this.v == true) goto L5;
        this.k = r2;
        this.j = r3;
        this.f953a |= 512;
        return (T) e();
    L5:
        return (T) b().a(r2, r3);
    }

    public T a(Resources.Theme r3) {
        if (this.v == true) goto L5;
        this.u = r3;
        if (r3 == null) goto L10;
        this.f953a |= 32768;
        return (T) a(com.bumptech.glide.load.resource.b.e.f833a, r3);
    L10:
        this.f953a &= -32769;
        return (T) a(com.bumptech.glide.load.resource.b.e.f833a);
    L5:
        return (T) b().a(r3);
    }

    public T a(Priority r3) {
        if (this.v == true) goto L5;
        this.d = (Priority) ZeusTransformUtils.preCheckCast(j.a(r3), Priority.class, "com.obric.memorydata.plugin");
        this.f953a |= 8;
        return (T) e();
    L5:
        return (T) b().a(r3);
    }

    public T a(com.bumptech.glide.load.c r3) {
        com.bumptech.glide.load.c r4 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        if (this.v == true) goto L5;
        this.l = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(j.a(r4), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.f953a |= 1024;
        return (T) e();
    L5:
        return (T) b().a(r4);
    }

    T a(com.bumptech.glide.load.d<?> r2) {
        if (this.v == true) goto L5;
        this.q.a(r2);
        return (T) e();
    L5:
        return (T) b().a(r2);
    }

    public <Y> T a(com.bumptech.glide.load.d<Y> r2, Y r3) {
        if (this.v == true) goto L5;
        j.a(r2);
        j.a(r3);
        this.q.a(r2, r3);
        return (T) e();
    L5:
        return (T) b().a(r2, r3);
    }

    public T a(com.bumptech.glide.load.engine.h r3) {
        if (this.v == true) goto L5;
        this.c = (com.bumptech.glide.load.engine.h) ZeusTransformUtils.preCheckCast(j.a(r3), com.bumptech.glide.load.engine.h.class, "com.obric.memorydata.plugin");
        this.f953a |= 4;
        return (T) e();
    L5:
        return (T) b().a(r3);
    }

    public T a(com.bumptech.glide.load.h<Bitmap> r3) {
        return (T) a((com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin"), true);
    }

    T a(com.bumptech.glide.load.h<Bitmap> r3, boolean r4) {
        com.bumptech.glide.load.h<Y> r5 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        if (this.v == true) goto L5;
        l r0 = new l(r5, r4);
        a(Bitmap.class, r5, r4);
        a(Drawable.class, r0, r4);
        a(BitmapDrawable.class, r0.a(), r4);
        a(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(r5), r4);
        return (T) e();
    L5:
        return (T) b().a(r5, r4);
    }

    public T a(Class<?> r3) {
        if (this.v == true) goto L5;
        this.s = (Class) ZeusTransformUtils.preCheckCast(j.a(r3), Class.class, "com.obric.memorydata.plugin");
        this.f953a |= 4096;
        return (T) e();
    L5:
        return (T) b().a(r3);
    }

    <Y> T a(Class<Y> r3, com.bumptech.glide.load.h<Y> r4, boolean r5) {
        com.bumptech.glide.load.h<?> r6 = (com.bumptech.glide.load.h) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        if (this.v == true) goto L5;
        j.a(r3);
        j.a(r6);
        this.r.put(r3, r6);
        int r7 = this.f953a | 2048;
        this.f953a = r7;
        this.n = true;
        int r8 = r7 | 65536;
        this.f953a = r8;
        this.y = false;
        if (r5 == false) goto L10;
        this.f953a = r8 | 131072;
        this.m = true;
    L10:
        return (T) e();
    L5:
        return (T) b().a(r3, r6, r5);
    }

    public T a(boolean r2) {
        if (this.v == true) goto L5;
        this.z = r2;
        this.f953a |= 1048576;
        return (T) e();
    L5:
        return (T) b().a(r2);
    }

    public T b() {
        T r0 = (T) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L4
        com.bumptech.glide.load.e r1 = new com.bumptech.glide.load.e();     // Catch: CloneNotSupportedException -> L4
        r0.q = r1;     // Catch: CloneNotSupportedException -> L4
        r1.a(this.q);     // Catch: CloneNotSupportedException -> L4
        CachedHashCodeArrayMap r2 = new CachedHashCodeArrayMap();     // Catch: CloneNotSupportedException -> L4
        r0.r = r2;     // Catch: CloneNotSupportedException -> L4
        r2.putAll(this.r);     // Catch: CloneNotSupportedException -> L4
        r0.t = false;     // Catch: CloneNotSupportedException -> L4
        r0.v = false;     // Catch: CloneNotSupportedException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public T b(a<?> r5) {
        if (this.v == false) goto L7;
        return (T) b().b(r5);
    L7:
        if (b(r5.f953a, 2) == false) goto L10;
        this.f954b = r5.f954b;
    L10:
        if (b(r5.f953a, 262144) == false) goto L13;
        this.w = r5.w;
    L13:
        if (b(r5.f953a, 1048576) == false) goto L16;
        this.z = r5.z;
    L16:
        if (b(r5.f953a, 4) == false) goto L19;
        this.c = r5.c;
    L19:
        if (b(r5.f953a, 8) == false) goto L22;
        this.d = r5.d;
    L22:
        if (b(r5.f953a, 16) == false) goto L25;
        this.e = r5.e;
        this.f = 0;
        this.f953a &= -33;
    L25:
        if (b(r5.f953a, 32) == false) goto L28;
        this.f = r5.f;
        this.e = null;
        this.f953a &= -17;
    L28:
        if (b(r5.f953a, 64) == false) goto L31;
        this.g = r5.g;
        this.h = 0;
        this.f953a &= -129;
    L31:
        if (b(r5.f953a, 128) == false) goto L34;
        this.h = r5.h;
        this.g = null;
        this.f953a &= -65;
    L34:
        if (b(r5.f953a, 256) == false) goto L37;
        this.i = r5.i;
    L37:
        if (b(r5.f953a, 512) == false) goto L40;
        this.k = r5.k;
        this.j = r5.j;
    L40:
        if (b(r5.f953a, 1024) == false) goto L43;
        this.l = r5.l;
    L43:
        if (b(r5.f953a, 4096) == false) goto L46;
        this.s = r5.s;
    L46:
        if (b(r5.f953a, 8192) == false) goto L49;
        this.o = r5.o;
        this.p = 0;
        this.f953a &= -16385;
    L49:
        if (b(r5.f953a, 16384) == false) goto L52;
        this.p = r5.p;
        this.o = null;
        this.f953a &= -8193;
    L52:
        if (b(r5.f953a, 32768) == false) goto L55;
        this.u = r5.u;
    L55:
        if (b(r5.f953a, 65536) == false) goto L58;
        this.n = r5.n;
    L58:
        if (b(r5.f953a, 131072) == false) goto L61;
        this.m = r5.m;
    L61:
        if (b(r5.f953a, 2048) == false) goto L64;
        this.r.putAll(r5.r);
        this.y = r5.y;
    L64:
        if (b(r5.f953a, 524288) == false) goto L67;
        this.x = r5.x;
    L67:
        if (this.n == true) goto L69;
        this.r.clear();
        int r0 = this.f953a & (-2049);
        this.f953a = r0;
        this.m = false;
        this.f953a = r0 & (-131073);
        this.y = true;
    L69:
        this.f953a |= r5.f953a;
        this.q.a(r5.q);
        return (T) e();
    }

    public T b(boolean r3) {
        if (this.v == true) goto L5;
        this.i = !r3;
        this.f953a |= 256;
        return (T) e();
    L5:
        return (T) b().b(true);
    }

    public T c() {
        this.t = true;
        return (T) a();
    }

    public final boolean c(a<?> r3) {
        if (Float.compare(r3.f954b, this.f954b) == 0) goto L5;
    L45:
        return false;
    L5:
        if (this.f != r3.f) goto L45;
        if (k.a(this.e, r3.e) == false) goto L45;
        if (this.h != r3.h) goto L45;
        if (k.a(this.g, r3.g) == false) goto L45;
        if (this.p != r3.p) goto L45;
        if (k.a(this.o, r3.o) == false) goto L45;
        if (this.i != r3.i) goto L45;
        if (this.j != r3.j) goto L45;
        if (this.k != r3.k) goto L45;
        if (this.m != r3.m) goto L45;
        if (this.n != r3.n) goto L45;
        if (this.w != r3.w) goto L45;
        if (this.x != r3.x) goto L45;
        if (this.c.equals(r3.c) == false) goto L45;
        if (this.d != r3.d) goto L45;
        if (this.q.equals(r3.q) == false) goto L45;
        if (this.r.equals(r3.r) == false) goto L45;
        if (this.s.equals(r3.s) == false) goto L45;
        if (k.a(this.l, r3.l) == false) goto L45;
        if (k.a(this.u, r3.u) == false) goto L45;
        return true;
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public T d() {
        if (this.t == true) goto L5;
    L9:
        this.v = true;
        return (T) c();
    L5:
        if (this.v == true) goto L9;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public final T e() {
        if (this.t == true) goto L7;
        return (T) a();
    L7:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L5;
        return false;
    L5:
        return c((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    }

    public final boolean f() {
        return this.v;
    }

    public final Map<Class<?>, com.bumptech.glide.load.h<?>> g() {
        return this.r;
    }

    public final boolean h() {
        return this.m;
    }

    public int hashCode() {
        int r0 = k.a(this.f954b);
        int r1 = k.b(this.f, r0);
        int r2 = k.a(this.e, r1);
        int r3 = k.b(this.h, r2);
        int r4 = k.a(this.g, r3);
        int r5 = k.b(this.p, r4);
        int r6 = k.a(this.o, r5);
        int r7 = k.a(this.i, r6);
        int r8 = k.b(this.j, r7);
        int r9 = k.b(this.k, r8);
        int r10 = k.a(this.m, r9);
        int r11 = k.a(this.n, r10);
        int r12 = k.a(this.w, r11);
        int r13 = k.a(this.x, r12);
        int r14 = k.a(this.c, r13);
        int r15 = k.a(this.d, r14);
        int r16 = k.a(this.q, r15);
        int r17 = k.a(this.r, r16);
        int r18 = k.a(this.s, r17);
        int r19 = k.a(this.l, r18);
        return k.a(this.u, r19);
    }

    public final com.bumptech.glide.load.e i() {
        return this.q;
    }

    public final Class<?> j() {
        return this.s;
    }

    public final com.bumptech.glide.load.engine.h k() {
        return this.c;
    }

    public final Drawable l() {
        return this.e;
    }

    public final int m() {
        return this.f;
    }

    public final int n() {
        return this.h;
    }

    public final Drawable o() {
        return this.g;
    }

    public final int p() {
        return this.p;
    }

    public final Drawable q() {
        return this.o;
    }

    public final Resources.Theme r() {
        return this.u;
    }

    public final boolean s() {
        return this.i;
    }

    public final com.bumptech.glide.load.c t() {
        return this.l;
    }

    public final boolean u() {
        return a(8);
    }

    public final Priority v() {
        return this.d;
    }

    public final int w() {
        return this.k;
    }

    public final boolean x() {
        return k.a(this.k, this.j);
    }

    public final int y() {
        return this.j;
    }

    public final float z() {
        return this.f954b;
    }
}
