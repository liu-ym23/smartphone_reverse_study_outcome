package com.google.gson.internal;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements r, Cloneable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f4246l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f4247c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<com.google.gson.a> f4251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<com.google.gson.a> f4252k;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q<T> f4253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f4256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TypeToken f4257e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f4258f;

        a(c r10, boolean r11, boolean r12, com.google.gson.d r13, TypeToken r14) {
            this.f4258f = r10;
            this.f4254b = r11;
            this.f4255c = r12;
            this.f4256d = r13;
            this.f4257e = r14;
        }

        private q<T> e() {
            q<T> r10 = this.f4253a;
            if (r10 != null) goto L7;
            q<T> r11 = this.f4256d.o(this.f4258f, this.f4257e);
            this.f4253a = r11;
            return r11;
        L7:
            return r10;
        }

        @Override // com.google.gson.q
        public T b(i6.a r10) {
            if (this.f4254b == false) goto L7;
            r10.i0();
            return null;
        L7:
            return e().b(r10);
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.a r10, T r11) {
            if (this.f4255c == false) goto L6;
            r10.B();
            return;
        L6:
            e().d(r10, r11);
        }
    }

    static {
        f4246l = new c();
    }

    public c() {
        this.f4247c = -1.0d;
        this.f4248g = 136;
        this.f4249h = true;
        this.f4251j = Collections.emptyList();
        this.f4252k = Collections.emptyList();
    }

    private boolean f(Class<?> r10) {
        if (this.f4247c == (-1.0d)) goto L8;
        if (n((d6.d) r10.getAnnotation(d6.d.class), (d6.e) r10.getAnnotation(d6.e.class)) == true) goto L8;
        return true;
    L8:
        if (this.f4249h == true) goto L13;
        if (j(r10) == false) goto L13;
        return true;
    L13:
        return i(r10);
    }

    private boolean g(Class<?> r10, boolean r11) {
        if (r11 == false) goto L4;
        List<com.google.gson.a> r12 = this.f4251j;
    L5:
        Iterator<com.google.gson.a> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        if (r13.next().b(r10) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r12 = this.f4252k;
        goto L5
    }

    private boolean i(Class<?> r10) {
        if (Enum.class.isAssignableFrom(r10) == false) goto L5;
    L11:
        return false;
    L5:
        if (k(r10) == true) goto L11;
        if (r10.isAnonymousClass() == false) goto L9;
    L10:
        return true;
    L9:
        if (r10.isLocalClass() == false) goto L11;
        goto L10
    }

    private boolean j(Class<?> r10) {
        if (r10.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (k(r10) == true) goto L7;
        return true;
    }

    private boolean k(Class<?> r10) {
        if ((r10.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean l(d6.d r10) {
        if (r10 == null) goto L9;
        double r11 = r10.value();
        if (this.f4247c >= r11) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean m(d6.e r10) {
        if (r10 == null) goto L9;
        double r11 = r10.value();
        if (this.f4247c < r11) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean n(d6.d r10, d6.e r11) {
        if (l(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (m(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.d r12, TypeToken<T> r13) {
        Class<? super T> r10 = r13.getRawType();
        boolean r11 = f(r10);
        if (r11 == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r11 == false) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r14 == true) goto L20;
        if (r15 == true) goto L20;
        return null;
    L20:
        return new a(this, r15, r14, r12, r13);
    L11:
        if (g(r10, false) == true) goto L14;
        r15 = false;
        goto L15
    L5:
        if (g(r10, true) == true) goto L8;
        r14 = false;
        goto L9
    }

    protected /* bridge */ /* synthetic */ Object clone() {
        return d();
    }

    protected c d() {
        return (c) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean e(Class<?> r10, boolean r11) {
        if (f(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (g(r10, r11) == true) goto L8;
        return false;
    }

    public boolean h(Field r10, boolean r11) {
        if ((this.f4248g & r10.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.f4247c == (-1.0d)) goto L11;
        if (n((d6.d) r10.getAnnotation(d6.d.class), (d6.e) r10.getAnnotation(d6.e.class)) == true) goto L11;
        return true;
    L11:
        if (r10.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.f4250i == false) goto L25;
        d6.a r12 = (d6.a) r10.getAnnotation(d6.a.class);
        if (r12 == null) goto L23;
        if (r11 == false) goto L22;
        if (r12.serialize() == true) goto L25;
    L22:
        if (r12.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.f4249h == true) goto L30;
        if (j(r10.getType()) == false) goto L30;
        return true;
    L30:
        if (i(r10.getType()) == false) goto L32;
        return true;
    L32:
        if (r11 == false) goto L34;
        List<com.google.gson.a> r13 = this.f4251j;
    L36:
        if (r13.isEmpty() == true) goto L43;
        com.google.gson.b r14 = new com.google.gson.b(r10);
        Iterator<com.google.gson.a> r15 = r13.iterator();
    L39:
        if (r15.hasNext() == false) goto L48;
        if (r15.next().a(r14) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r13 = this.f4252k;
        goto L36
    }
}
