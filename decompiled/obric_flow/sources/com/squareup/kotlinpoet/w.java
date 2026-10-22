package com.squareup.kotlinpoet;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f15203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15205c;
    public final a0 d;
    public final e e;
    public final List f;
    public final Set g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f15206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f15207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f15208j;

    public w(v r5) {
        com.lynx.tasm.p.g(r5);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        this.f15203a = new p(f0.i(r5.a()));
        this.f15204b = r5.f15198c;
        this.f15205c = r5.f15196a;
        this.d = r5.f15197b;
        this.e = r5.d.d();
        this.f = f0.i(r5.g);
        this.g = f0.j(r5.f15199h);
        List r10 = f0.i(r5.f15200i);
        this.f15206h = r10;
        this.f15207i = r5.e;
        this.f15208j = f0.i(r5.f);
        if (r10 != null) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        if (((e0) r11.next()).f15135h == false) goto L9;
        throw new IllegalArgumentException("only type parameters of properties with inline getters and/or setters can be reified!");
    L16:
        if (this.f15208j.isEmpty() == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("properties with context receivers require a get()");
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    public static void b(w r10, f r11, Set r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r14 & 16) == 0) goto L10;
        r13 = false;
    L10:
        if ((r14 & 32) == 0) goto L12;
        boolean r15 = r13;
    L13:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "codeWriter");
        Intrinsics.checkNotNullParameter(r12, "implicitModifiers");
        r11.n(f0.d(r10.e));
        r11.m(r10.f15208j);
        r11.d(r10.f, r15);
        Set r16 = r10.g;
        r11.p(r16, r12);
        if (r10.f15204b == false) goto L16;
        String r17 = "var·";
    L17:
        r11.f(r17);
        List r18 = r10.f15206h;
        if (r18.isEmpty() == true) goto L20;
        r11.q(r18);
        r11.b(" ", false);
    L20:
        r11.e("%N: %T", new Object[]{r10, r10.d});
        if (r5 == false) goto L37;
        e r19 = r10.f15207i;
        if (r19 == null) goto L37;
        r11.f(" = ");
        List r20 = r19.f15131a;
        if (r20 != null) goto L27;
    L29:
        Iterator r21 = r20.iterator();
    L31:
        if (r21.hasNext() == false) goto L35;
        if (StringsKt.g((String) r21.next(), "«") == false) goto L31;
        String r22 = "%L";
    L36:
        Set r23 = e.f15130c;
        f.g(r11, com.bytedance.apm.util.a.p(r22, new Object[]{r19}), r16.contains(KModifier.CONST), false, 4);
    L35:
        r22 = "«%L»";
        goto L36
    L27:
        if (r20.isEmpty() == false) goto L29;
    L37:
        r11.J(r18);
        if (r13 == true) goto L40;
        r11.b("\n", false);
    L40:
        EnumSet r24 = EnumSet.noneOf(KModifier.class);
        Iterator r25 = r12.iterator();
    L42:
        if (r25.hasNext() == false) goto L46;
        KModifier r26 = (KModifier) r25.next();
        if (m.f15184a.contains(r26) == true) goto L42;
        r24.add(r26);
        goto L42
    L46:
        return;
    L16:
        r17 = "val·";
        goto L17
    L12:
        r15 = false;
        goto L13
    L5:
        r5 = false;
        goto L7
    }

    @Override // com.squareup.kotlinpoet.r
    public final List a() {
        return this.f15203a.a();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(w.class, r5.getClass()) == true) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(toString(), r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r10 = new StringBuilder();
        f r11 = new f(r10, null, null, null, null, Integer.MAX_VALUE, 30);
        b(this, r11, SetsKt.emptySet(), false, 60);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r10.toString();
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }
}
