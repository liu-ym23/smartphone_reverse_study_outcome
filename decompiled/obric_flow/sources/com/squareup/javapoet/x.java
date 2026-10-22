package com.squareup.javapoet;

import ai.j0;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes3.dex */
public class x {
    public static final x d = null;
    public static final x e = null;
    public static final x f = null;
    public static final x g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f15023h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f15024i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f15025j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f15026k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final x f15027l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f15028m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f15029n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f15030o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f15031p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e f15032q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f15033r = null;
    public static final e s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f15034t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f15035u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e f15036v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15039c;

    static {
        d = new x("void");
        e = new x("boolean");
        f = new x("byte");
        g = new x("short");
        f15023h = new x("int");
        f15024i = new x("long");
        f15025j = new x("char");
        f15026k = new x("float");
        f15027l = new x("double");
        f15028m = e.o("java.lang", "Object", new String[0]);
        f15029n = e.o("java.lang", "Void", new String[0]);
        f15030o = e.o("java.lang", "Boolean", new String[0]);
        f15031p = e.o("java.lang", "Byte", new String[0]);
        f15032q = e.o("java.lang", "Short", new String[0]);
        f15033r = e.o("java.lang", "Integer", new String[0]);
        s = e.o("java.lang", "Long", new String[0]);
        f15034t = e.o("java.lang", "Character", new String[0]);
        f15035u = e.o("java.lang", "Float", new String[0]);
        f15036v = e.o("java.lang", "Double", new String[0]);
    }

    public x(String r5) {
        this(r5, new ArrayList());
    }

    public static c a(x r5) {
        if ((r5 instanceof c) == true) goto L7;
        return null;
    L7:
        return (c) r5;
    }

    public static x e(Type r5) {
        return f(r5, new LinkedHashMap());
    }

    public static x f(Type r5, LinkedHashMap r10) {
        if ((r5 instanceof Class) == false) goto L47;
        Class r11 = (Class) r5;
        if (r5 != Void.TYPE) goto L9;
        return d;
    L9:
        if (r5 != Boolean.TYPE) goto L13;
        return e;
    L13:
        if (r5 != Byte.TYPE) goto L17;
        return f;
    L17:
        if (r5 != Short.TYPE) goto L21;
        return g;
    L21:
        if (r5 != Integer.TYPE) goto L25;
        return f15023h;
    L25:
        if (r5 != Long.TYPE) goto L29;
        return f15024i;
    L29:
        if (r5 != Character.TYPE) goto L33;
        return f15025j;
    L33:
        if (r5 != Float.TYPE) goto L37;
        return f15026k;
    L37:
        if (r5 != Double.TYPE) goto L41;
        return f15027l;
    L41:
        if (r11.isArray() == false) goto L45;
        return new c(f(r11.getComponentType(), r10));
    L45:
        return e.n(r11);
    L47:
        if ((r5 instanceof ParameterizedType) == false) goto L51;
        return v.o((ParameterizedType) r5, r10);
    L51:
        if ((r5 instanceof WildcardType) == false) goto L55;
        WildcardType r12 = (WildcardType) r5;
        return new b0(l(r12.getUpperBounds(), r10), l(r12.getLowerBounds(), r10));
    L55:
        if ((r5 instanceof TypeVariable) == false) goto L64;
        TypeVariable r13 = (TypeVariable) r5;
        a0 r14 = (a0) r10.get(r13);
        if (r14 != null) goto L70;
        ArrayList r15 = new ArrayList();
        List r16 = Collections.unmodifiableList(r15);
        a0 r17 = new a0(r13.getName(), r16);
        r10.put(r13, r17);
        Type[] r18 = r13.getBounds();
        int r19 = r18.length;
        int r20 = 0;
    L59:
        if (r20 >= r19) goto L61;
        r15.add(f(r18[r20], r10));
        r20 = r20 + 1;
        goto L59
    L61:
        r15.remove(f15028m);
        return r17;
    L70:
        return r14;
    L64:
        if ((r5 instanceof GenericArrayType) == false) goto L68;
        return new c(f(((GenericArrayType) r5).getGenericComponentType(), r10));
    L68:
        throw new IllegalArgumentException(j0.m("unexpected type: ", r5));
    }

    public static x g(TypeMirror r5) {
        return h(r5, new LinkedHashMap());
    }

    public static x h(TypeMirror r5, LinkedHashMap r10) {
        return (x) r5.accept(new w(r10), null);
    }

    public static ArrayList l(Type[] r5, LinkedHashMap r10) {
        ArrayList r11 = new ArrayList(r5.length);
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(f(r5[r13], r10));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public final x b() {
        String r5 = this.f15037a;
        if (r5 != null) goto L6;
        return this;
    L6:
        if (this != d) goto L10;
        return f15029n;
    L10:
        if (this != e) goto L14;
        return f15030o;
    L14:
        if (this != f) goto L18;
        return f15031p;
    L18:
        if (this != g) goto L22;
        return f15032q;
    L22:
        if (this != f15023h) goto L26;
        return f15033r;
    L26:
        if (this != f15024i) goto L30;
        return s;
    L30:
        if (this != f15025j) goto L34;
        return f15034t;
    L34:
        if (this != f15026k) goto L38;
        return f15035u;
    L38:
        if (this != f15027l) goto L42;
        return f15036v;
    L42:
        throw new AssertionError(r5);
    }

    public k c(k r5) {
        String r10 = this.f15037a;
        if (r10 == null) goto L10;
        if (i() == false) goto L7;
        r5.e("");
        d(r5);
    L7:
        r5.e(r10);
        return r5;
    L10:
        throw new AssertionError();
    }

    public final void d(k r5) {
        Iterator r10 = this.f15038b.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).b(r5, true);
        r5.e(" ");
        goto L4
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public boolean i() {
        return !this.f15038b.isEmpty();
    }

    public final boolean j() {
        if (equals(f15030o) == false) goto L5;
    L20:
        return true;
    L5:
        if (equals(f15031p) == true) goto L20;
        if (equals(f15032q) == true) goto L20;
        if (equals(f15033r) == true) goto L20;
        if (equals(s) == true) goto L20;
        if (equals(f15034t) == true) goto L20;
        if (equals(f15035u) == true) goto L20;
        if (equals(f15036v) == true) goto L20;
        return false;
    }

    public final boolean k() {
        if (this.f15037a != null) goto L5;
    L7:
        return false;
    L5:
        if (this == d) goto L7;
        return true;
    }

    public final x m() {
        if (this.f15037a == null) goto L6;
        return this;
    L6:
        if (equals(f15029n) == false) goto L10;
        return d;
    L10:
        if (equals(f15030o) == false) goto L14;
        return e;
    L14:
        if (equals(f15031p) == false) goto L18;
        return f;
    L18:
        if (equals(f15032q) == false) goto L22;
        return g;
    L22:
        if (equals(f15033r) == false) goto L26;
        return f15023h;
    L26:
        if (equals(s) == false) goto L30;
        return f15024i;
    L30:
        if (equals(f15034t) == false) goto L34;
        return f15025j;
    L34:
        if (equals(f15035u) == false) goto L38;
        return f15026k;
    L38:
        if (equals(f15036v) == false) goto L42;
        return f15027l;
    L42:
        throw new UnsupportedOperationException("cannot unbox " + this);
    }

    public final String toString() {
        String r5 = this.f15039c;
        if (r5 == null) goto L9;
        return r5;
    L9:
        StringBuilder r10 = new StringBuilder();     // Catch: IOException -> L6
        c(new k(r10));     // Catch: IOException -> L6
        String r11 = r10.toString();     // Catch: IOException -> L6
        this.f15039c = r11;     // Catch: IOException -> L6
        return r11;
    L7:
        throw new AssertionError();
    }

    public x(String r5, List r10) {
        this.f15037a = r5;
        this.f15038b = com.bytedance.android.anniex.base.service.f.x(r10);
    }
}
