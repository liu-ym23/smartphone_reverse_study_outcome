package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f15011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f15012c;
    public final Set d;
    public final List e;
    public final x f;
    public final List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f15013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f15014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f15015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f15016k;

    public t(s r10) {
        i r5 = s.a(r10).f();
        boolean r11 = true;
        if (r5.b() == false) goto L5;
    L8:
        boolean r12 = true;
    L9:
        com.bytedance.android.anniex.base.service.f.r(r12, "abstract method %s cannot have code", new Object[]{s.b(r10)});
        if (s.c(r10) == false) goto L17;
        ArrayList r13 = r10.f15009k;
        if (r13.isEmpty() == false) goto L14;
    L16:
        r11 = false;
        goto L17
    L14:
        if (x.a(((u) r13.get(r13.size() - 1)).d) == null) goto L16;
    L17:
        com.bytedance.android.anniex.base.service.f.r(r11, "last parameter of varargs method %s must be an array", new Object[]{s.b(r10)});
        String r14 = s.b(r10);
        com.bytedance.android.anniex.base.service.f.s(r14, "name == null", new Object[0]);
        this.f15010a = r14;
        this.f15011b = s.d(r10).f();
        this.f15012c = com.bytedance.android.anniex.base.service.f.x(r10.f15007i);
        this.d = com.bytedance.android.anniex.base.service.f.y(r10.f15008j);
        this.e = com.bytedance.android.anniex.base.service.f.x(r10.f15006h);
        this.f = s.e(r10);
        this.g = com.bytedance.android.anniex.base.service.f.x(r10.f15009k);
        this.f15013h = s.c(r10);
        this.f15014i = com.bytedance.android.anniex.base.service.f.x(s.f(r10));
        this.f15016k = s.g(r10);
        this.f15015j = r5;
        return;
    L5:
        if (r10.f15008j.contains(Modifier.ABSTRACT) == false) goto L8;
        r12 = false;
        goto L9
    }

    public static s a() {
        return new s("<init>");
    }

    public static s e(String r5) {
        return new s(r5);
    }

    public final void b(k r10, String r11, Set r12) {
        i r5 = this.f15011b;
        r5.getClass();
        g r13 = new g();
        r13.f14965a.addAll(r5.f14971a);
        r13.f14966b.addAll(r5.f14972b);
        Iterator r14 = this.g.iterator();
        boolean r15 = true;
    L4:
        if (r14.hasNext() == false) goto L12;
        u r16 = (u) r14.next();
        if (r16.e.f14971a.isEmpty() == true) goto L4;
        if (r15 == true) goto L9;
    L11:
        r13.b("@param $L $L", new Object[]{r16.f15017a, r16.e});
        r15 = false;
        goto L4
    L9:
        if (r5.f14971a.isEmpty() == true) goto L11;
        r13.b("\n", new Object[0]);
        goto L11
    L12:
        r10.g(r13.f());
        r10.f(this.f15012c, false);
        r10.h(this.d, r12);
        if (this.e.isEmpty() == true) goto L16;
        r10.i(this.e);
        r10.d(" ");
    L16:
        if (d() == false) goto L18;
        r10.b("$L($Z", new Object[]{r11});
    L19:
        Iterator r17 = this.g.iterator();
        boolean r18 = true;
    L21:
        if (r17.hasNext() == false) goto L32;
        u r19 = (u) r17.next();
        if (r18 == true) goto L26;
        r10.d(",");
        r10.j();
    L26:
        if (r17.hasNext() == false) goto L28;
    L30:
        boolean r110 = false;
    L31:
        r19.c(r10, r110);
        r18 = false;
        goto L21
    L28:
        if (this.f15013h == false) goto L30;
        r110 = true;
        goto L31
    L32:
        r10.d(")");
        i r111 = this.f15016k;
        if (r111 == null) goto L38;
        if (r111.b() == true) goto L38;
        r10.d(" default ");
        r10.a(this.f15016k);
    L38:
        if (this.f15014i.isEmpty() == true) goto L47;
        r10.j();
        r10.d("throws");
        Iterator r112 = this.f15014i.iterator();
        boolean r113 = true;
    L41:
        if (r112.hasNext() == false) goto L47;
        x r20 = (x) r112.next();
        if (r113 == true) goto L45;
        r10.d(",");
    L45:
        r10.j();
        r10.b("$T", new Object[]{r20});
        r113 = false;
    L47:
        if (this.d.contains(Modifier.ABSTRACT) == false) goto L50;
        r10.d(";\n");
    L53:
        r10.o(this.e);
        return;
    L50:
        if (this.d.contains(Modifier.NATIVE) == false) goto L52;
        r10.a(this.f15015j);
        r10.d(";\n");
        goto L53
    L52:
        r10.d(" {\n");
        r10.l();
        r10.c(this.f15015j, true);
        r10.q();
        r10.d("}\n");
        goto L53
    L18:
        r10.b("$T $L($Z", new Object[]{this.f, this.f15010a});
        goto L19
    }

    public final boolean c(Modifier r5) {
        return this.d.contains(r5);
    }

    public final boolean d() {
        return this.f15010a.equals("<init>");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (t.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final s f() {
        s r5 = new s(this.f15010a);
        i r10 = this.f15011b;
        r5.f15004b.a(r10);
        r5.f15007i.addAll(this.f15012c);
        r5.f15008j.addAll(this.d);
        r5.f15006h.addAll(this.e);
        r5.f15005c = this.f;
        r5.f15009k.addAll(this.g);
        r5.d.addAll(this.f15014i);
        i r11 = this.f15015j;
        r5.e.a(r11);
        r5.f = this.f15013h;
        r5.g = this.f15016k;
        return r5;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        b(new k(r5), "Constructor", Collections.emptySet());     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }
}
