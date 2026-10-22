package com.squareup.kotlinpoet;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements r {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e f15169q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f15170r = null;
    public static final e s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f15171t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f15172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f15174c;
    public final e d;
    public final e e;
    public final List f;
    public final Set g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f15175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f15176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a0 f15177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f15178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f15179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f15180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f15181n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f15182o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f15183p;

    static {
        Set r5 = e.f15130c;
        f15169q = com.bytedance.apm.util.a.p("return ", new Object[0]);
        f15170r = com.bytedance.apm.util.a.p("return·", new Object[0]);
        s = com.bytedance.apm.util.a.p("throw ", new Object[0]);
        f15171t = com.bytedance.apm.util.a.p("throw·", new Object[0]);
    }

    public k(j r13) {
        com.lynx.tasm.p.g(r13);
        Intrinsics.checkNotNullParameter(r13, "<this>");
        this.f15172a = new p(f0.i(r13.a()));
        String r5 = r13.f15158a;
        this.f15173b = r5;
        this.f15174c = r13.f15159b.d();
        this.d = r13.f15160c;
        this.e = r13.d;
        this.f = f0.i(r13.f15163j);
        ArrayList r10 = r13.f15164k;
        Set r11 = f0.j(r10);
        this.g = r11;
        List r12 = f0.i(r13.f15165l);
        this.f15175h = r12;
        this.f15176i = f0.i(r13.e);
        this.f15177j = r13.f;
        List r14 = f0.i(r13.f15166m);
        this.f15178k = r14;
        this.f15179l = r13.g;
        this.f15180m = f0.i(r13.f15161h);
        e r15 = r13.f15162i.d();
        this.f15181n = r15;
        boolean r16 = false;
        if (Intrinsics.areEqual(r5, "get()") == true) goto L5;
    L7:
        boolean r17 = false;
    L8:
        this.f15182o = r17;
        if (Intrinsics.areEqual(r5, "set()") == true) goto L11;
    L13:
        this.f15183p = r16;
        List r18 = r15.f15131a;
        if (r18.isEmpty() == true) goto L21;
        if (f0.c(r10, new KModifier[]{KModifier.ABSTRACT, KModifier.EXPECT}) == false) goto L21;
        throw new IllegalArgumentException(j0.q(new StringBuilder("abstract or expect function "), r13.f15158a, " cannot have code").toString());
    L21:
        if (Intrinsics.areEqual(r5, "get()") == false) goto L29;
        if (r17 == false) goto L42;
        if (r18.isEmpty() == true) goto L42;
        throw new IllegalArgumentException("external getter cannot have code");
    L42:
        if (r11.contains(KModifier.INLINE) == true) goto L55;
        if (r12 != null) goto L45;
    L47:
        Iterator r19 = r12.iterator();
    L49:
        if (r19.hasNext() == false) goto L60;
        if (((e0) r19.next()).f15135h == false) goto L49;
        throw new IllegalArgumentException("only type parameters of inline functions can be reified!");
    L60:
        return;
    L45:
        if (r12.isEmpty() == false) goto L47;
        return;
    L55:
        return;
    L29:
        if (Intrinsics.areEqual(r5, "set()") == false) goto L42;
        if (r14.size() > 1) goto L40;
        if (r14.isEmpty() == false) goto L42;
        if (r18.isEmpty() == true) goto L42;
        throw new IllegalArgumentException("parameterless setter cannot have code");
    L40:
        throw new IllegalArgumentException(j0.j(r5, " can have at most one parameter").toString());
    L11:
        if (r14.isEmpty() == false) goto L13;
        r16 = true;
        goto L13
    L5:
        if (r10.contains(KModifier.EXTERNAL) == false) goto L7;
        r17 = true;
        goto L8
    }

    public static e b(e r5) {
        e r10 = r5.c();
        e r11 = r10.d(f15169q);
        if (r11 != null) goto L5;
        r11 = r10.d(f15170r);
    L5:
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (r10.d(s) == null) goto L10;
        return r10;
    L10:
        if (r10.d(f15171t) != null) goto L15;
        return null;
    L15:
        return r10;
    }

    @Override // com.squareup.kotlinpoet.r
    public final List a() {
        return this.f15172a.a();
    }

    public final void c(final f r20, String r21, Set r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r20, "codeWriter");
        Intrinsics.checkNotNullParameter(r22, "implicitModifiers");
        List r5 = this.f15178k;
        e r10 = this.f15174c;
        boolean r11 = false;
        if (r23 == false) goto L32;
        d r12 = f0.d(r10).b();
        boolean r13 = r12.f15113a.isEmpty();
        e r14 = this.e;
        if (r14.a() == false) goto L10;
        if (r13 == true) goto L8;
        r12.a("\n", new Object[0]);
        boolean r15 = true;
    L9:
        r12.a("@receiver %L", new Object[]{f0.d(r14)});
    L11:
        Iterator r16 = r5.iterator();
        int r17 = 0;
    L13:
        if (r16.hasNext() == false) goto L25;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        s r110 = (s) r18;
        if (r110.f15193b.a() == false) goto L24;
        if (r15 == true) goto L23;
        if (r17 != 0) goto L23;
        if (r13 == true) goto L23;
        r12.a("\n", new Object[0]);
        r15 = true;
    L23:
        r12.a("@param %L %L", new Object[]{r110.f15192a, f0.d(r110.f15193b)});
    L24:
        r17 = r19;
        goto L13
    L25:
        e r111 = this.d;
        if (r111.a() == false) goto L31;
        if (r15 == true) goto L30;
        if (r13 == true) goto L30;
        r12.a("\n", new Object[0]);
    L30:
        r12.a("@return %L", new Object[]{f0.d(r111)});
    L31:
        r20.n(r12.d());
    L33:
        r20.m(this.f15176i);
        r20.d(this.f, false);
        Set r24 = this.g;
        r20.p(r24, r22);
        boolean r25 = d();
        String r112 = this.f15173b;
        if (r25 == false) goto L36;
    L38:
        List r26 = this.f15175h;
        if (r26.isEmpty() == true) goto L42;
        r20.q(r26);
        r20.b(" ", false);
    L42:
        if (d() == false) goto L45;
        r20.e("constructor", new Object[]{r21});
    L51:
        boolean r113 = this.f15183p;
        if (r113 == false) goto L54;
    L87:
        e r27 = this.f15181n;
        a0 r28 = this.f15177j;
        if (r28 == null) goto L91;
        r20.e(": %T", new Object[]{r28});
    L101:
        d r29 = null;
        String r30 = this.f15179l;
        if (r30 == null) goto L104;
        f.g(r20, com.bytedance.ies.bullet.base.utils.b.q(this.f15180m, null, androidx.room.jarjarred.org.antlr.runtime.a.p(" : ", '(', r30), ")", 1), false, false, 6);
    L104:
        r20.J(r26);
        KModifier r31 = KModifier.ABSTRACT;
        if (r24.contains(r31) == true) goto L108;
        Set r32 = r22;
        if (SetsKt.plus(r24, r32).contains(KModifier.EXPECT) == true) goto L108;
        if (d() == true) goto L116;
        if (SetsKt.plus(r24, r32).contains(KModifier.EXTERNAL) == true) goto L116;
        if (r24.contains(r31) == true) goto L116;
    L118:
        e r33 = b(r27);
        if (r33 == null) goto L122;
        Set r34 = e.f15130c;
        f.g(r20, com.bytedance.apm.util.a.p(" = %L", new Object[]{r33}), false, true, 2);
        return;
    L122:
        if (r113 == true) goto L135;
        r20.f("·{\n");
        r20.f++;
        String r35 = (String) f15169q.f15131a.get(0);
        String r36 = (String) f15170r.f15131a.get(0);
        Iterator r37 = r27.f15131a.iterator();
        int r38 = 0;
    L125:
        if (r37.hasNext() == false) goto L132;
        int r39 = r38 + 1;
        String r40 = (String) r37.next();
        if (StringsKt.P(r40, r35) == false) goto L131;
        if (r29 != null) goto L130;
        r29 = r27.b();
    L130:
        r29.f15113a.set(r38, StringsKt.H(r40, r35, r36));
    L131:
        r38 = r39;
        goto L125
    L132:
        if (r29 == null) goto L134;
        r27 = r29.d();
    L134:
        f.g(r20, r27, false, true, 2);
        r20.K(1);
        r20.b("}\n", false);
        return;
    L135:
        r20.b("\n", false);
        return;
    L116:
        if (r27.f15131a.isEmpty() == false) goto L118;
        boolean r41 = false;
    L139:
        r20.b("\n", r41);
        return;
    L108:
        r41 = false;
        if (r27.f15131a.isEmpty() == true) goto L139;
        throw new IllegalStateException(j0.k("function ", r112, " cannot have code").toString());
    L91:
        if (d() == true) goto L101;
        if (Intrinsics.areEqual(r112, "get()") == true) goto L101;
        if (Intrinsics.areEqual(r112, "set()") == true) goto L101;
        if (b(r27) != null) goto L101;
        r20.e(": %T", new Object[]{b0.f15082c});
        goto L101
    L54:
        if (this.f15182o == true) goto L87;
        Function1<s, Unit> r42 = new FunSpec$emitSignature$1(r20, this);
        Set r114 = t.f15195a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r20, "codeWriter");
        Intrinsics.checkNotNullParameter(r42, "emitBlock");
        r20.b("(", false);
        if (r5.isEmpty() == false) goto L58;
        boolean r43 = false;
    L86:
        r20.b(")", r43);
        goto L87
    L58:
        if (r5.size() > 2) goto L60;
        boolean r44 = false;
    L61:
        if (r44 == false) goto L64;
        r20.b("\n", false);
        r20.f++;
    L64:
        Iterator r45 = r5.iterator();
        int r115 = 0;
    L66:
        if (r45.hasNext() == false) goto L82;
        Object r116 = r45.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        s r46 = (s) r116;
        if (r115 <= 0) goto L77;
        if (r44 == false) goto L75;
        String r118 = "\n";
    L74:
        boolean r47 = false;
        r20.b(r118, false);
    L78:
        r42.invoke(r46);
        if (r44 == false) goto L81;
        r20.b(",", r47);
    L81:
        r11 = r47;
        r115 = r117;
        r45 = r45;
        goto L66
    L75:
        r118 = ", ";
        goto L74
    L77:
        r45 = r45;
        r47 = false;
        goto L78
    L82:
        r43 = r11;
        if (r44 == false) goto L86;
        r20.K(1);
        r20.b("\n", r43);
        goto L86
    L60:
        r44 = true;
        goto L61
    L45:
        if (Intrinsics.areEqual(r112, "get()") == false) goto L48;
        r20.f("get");
        goto L51
    L48:
        if (Intrinsics.areEqual(r112, "set()") == false) goto L50;
        r20.f("set");
        goto L51
    L50:
        r20.e("%N", new Object[]{this});
        goto L51
    L36:
        if (io.reactivex.exceptions.a.o(r112) == true) goto L38;
        r20.f("fun·");
        goto L38
    L8:
        r15 = false;
        goto L9
    L10:
        r15 = false;
        goto L11
    L32:
        r20.n(f0.d(r10));
        goto L33
    }

    public final boolean d() {
        String r5 = this.f15173b;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Intrinsics.areEqual(r5, "constructor()");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(k.class, r5.getClass()) == true) goto L12;
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
        c(r11, "Constructor", TypeSpec$Kind.implicitFunctionModifiers$kotlinpoet$default(TypeSpec$Kind.CLASS, null, 1, null), true);     // Catch: Throwable -> L6
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
