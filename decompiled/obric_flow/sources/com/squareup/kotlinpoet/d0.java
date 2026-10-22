package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f15115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeSpec$Kind f15116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15117c;
    public final e d;
    public final List e;
    public final Set f;
    public final List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f15118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f15119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f15120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f15121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f15122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f15123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f15124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f15125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f15126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f15127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f15128r;
    public final List s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Set f15129t;

    public d0(c0 r10) {
        com.lynx.tasm.p.g(r10);
        ArrayList r5 = r10.f15103h;
        ArrayList r11 = r10.f15112q;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ((d0) r13.next()).f15115a.a());
        goto L4
    L6:
        List r14 = CollectionsKt.plus(r5, r12);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        this.f15115a = new p(f0.i(r14));
        this.f15116b = r10.f15100a;
        String r15 = r10.f15101b;
        this.f15117c = r15;
        this.d = r10.f15102c.d();
        this.e = f0.i(r10.f15107l);
        Set r16 = r10.f15104i;
        this.f = f0.j(r16);
        this.g = f0.i(r10.f15108m);
        this.f15118h = r10.d;
        this.f15119i = f0.i(r10.f15109n);
        this.f15120j = r10.f();
        r10.e();
        boolean r17 = false;
        if (r10.f15100a == TypeSpec$Kind.OBJECT) goto L9;
    L11:
        boolean r18 = false;
    L12:
        this.f15121k = r18;
        if (r15 == null) goto L15;
    L17:
        this.f15122l = r17;
        if (r10.f15100a != TypeSpec$Kind.INTERFACE) goto L20;
        r16.contains(KModifier.FUN);
    L20:
        LinkedHashMap r19 = r10.f15105j;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        this.f15123m = Collections.unmodifiableMap(new LinkedHashMap(r19));
        LinkedHashMap r20 = r10.f15106k;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        this.f15124n = Collections.unmodifiableMap(new LinkedHashMap(r20));
        this.f15125o = f0.i(r10.f15110o);
        this.f15126p = r10.e.d();
        this.f15127q = r10.f;
        this.f15128r = f0.i(r10.f15111p);
        List r21 = f0.i(r10.f15112q);
        this.s = r21;
        ArrayList r22 = new ArrayList(CollectionsKt.h(r21));
        Iterator r23 = r21.iterator();
    L22:
        if (r23.hasNext() == false) goto L24;
        r22.add(((d0) r23.next()).f15117c);
        goto L22
    L24:
        this.f15129t = f0.j(r22);
        return;
    L15:
        if (r10.f15100a != TypeSpec$Kind.CLASS) goto L17;
        r17 = true;
        goto L17
    L9:
        if (r16.contains(KModifier.COMPANION) == false) goto L11;
        r18 = true;
        goto L12
    }

    public static /* synthetic */ void c(d0 r5, f r10, String r11) {
        r5.b(r10, r11, SetsKt.emptySet(), false);
    }

    public static final void d(Ref.BooleanRef r5, boolean r10, Ref.BooleanRef r11, f r12, d0 r13) {
        if (r5.element == false) goto L5;
        return;
    L5:
        r5.element = true;
        if (r10 == true) goto L8;
        return;
    L8:
        if (r11.element == true) goto L10;
        r12.b("\n", false);
    L10:
        f.g(r12, r13.f15126p, false, false, 6);
        r11.element = false;
    }

    @Override // com.squareup.kotlinpoet.r
    public final List a() {
        return this.f15115a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.squareup.kotlinpoet.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.ArrayList] */
    public final void b(f r25, String r26, Set r27, boolean r28) {
        List r5 = this.g;
        Intrinsics.checkNotNullParameter(r25, "codeWriter");
        Intrinsics.checkNotNullParameter(r27, "implicitModifiers");
        KModifier r10 = KModifier.EXTERNAL;
        Set<? extends KModifier> r11 = this.f;
        if (r11.contains(r10) == true) goto L7;
        if (r28 == true) goto L7;
        boolean r12 = false;
    L8:
        int r13 = r25.f15147p;
        r25.f15147p = -1;
        Map r14 = MapsKt.emptyMap();
        e r15 = com.bytedance.ies.bullet.base.utils.b.q(this.f15119i, null, null, null, 7);
        e r16 = this.d;
        boolean r17 = this.f15122l;
        List r18 = this.e;
        String r19 = this.f15117c;
        List r20 = this.f15128r;
        Map r110 = r14;
        TypeSpec$Kind r111 = this.f15116b;
        List r112 = r20;
        if (r26 == null) goto L23;
        r25.n(f0.d(r16));     // Catch: Throwable -> L14
        r25.d(r18, false);     // Catch: Throwable -> L14
        r25.e("%N", new Object[]{r26});     // Catch: Throwable -> L14
        if (r15.a() == false) goto L17;
        r25.b("(", false);     // Catch: Throwable -> L14
        f.g(r25, r15, false, false, 6);     // Catch: Throwable -> L14
        r25.b(")", false);     // Catch: Throwable -> L14
    L17:
        if (e() == false) goto L21;
        r25.f15147p = r13;
        return;
    L21:
        r25.b(" {\n", false);     // Catch: Throwable -> L14
        String r21 = "\n";
        boolean r22 = r17;
    L105:
        Intrinsics.checkNotNullParameter(this, "type");     // Catch: Throwable -> L14
        ArrayList r23 = r25.f15141j;
        r23.add(this);     // Catch: Throwable -> L14
        r25.f++;     // Catch: Throwable -> L14
        Ref.BooleanRef r24 = new Ref.BooleanRef();     // Catch: Throwable -> L14
        r24.element = true;     // Catch: Throwable -> L14
        Iterator r29 = this.f15124n.entrySet().iterator();     // Catch: Throwable -> L14
    L109:
        if (r29.hasNext() == false) goto L115;
        Map.Entry r30 = (Map.Entry) r29.next();     // Catch: Throwable -> L14
        String r113 = (String) r30.getKey();     // Catch: Throwable -> L14
        d0 r31 = (d0) r30.getValue();     // Catch: Throwable -> L14
        if (r24.element == true) goto L113;
        boolean r114 = false;
        r25.b(r21, false);     // Catch: Throwable -> L14
    L114:
        c(r31, r25, r113);     // Catch: Throwable -> L14
        r25.b(",", r114);     // Catch: Throwable -> L14
        r24.element = r114;     // Catch: Throwable -> L14
        goto L109
    L113:
        r114 = false;
        goto L114
    L115:
        boolean r32 = this.f15120j;     // Catch: Throwable -> L14
        List r33 = this.s;
        List r115 = this.f15125o;
        if (r32 == true) goto L119;
    L128:
        int r34 = this.f15127q;
        if (r34 != (-1)) goto L131;
    L133:
        boolean r116 = false;
    L134:
        Ref.BooleanRef r117 = new Ref.BooleanRef();     // Catch: Throwable -> L14
        Iterator r118 = r115.iterator();     // Catch: Throwable -> L14
        int r119 = 0;
    L136:
        if (r118.hasNext() == false) goto L156;
        int r120 = r119 + 1;
        Iterator r210 = r118;
        w r121 = (w) r118.next();     // Catch: Throwable -> L154
        if (r119 != r34) goto L141;
        d(r117, r116, r24, r25, this);     // Catch: Throwable -> L14
    L141:
        int r122 = r34;
        r110 = r110;
        if (r110.containsKey(r121.f15205c) == false) goto L145;
        int r211 = r13;
    L151:
        r118 = r210;
        r34 = r122;
        r119 = r120;
        r13 = r211;
        goto L136
    L145:
        if (r24.element == false) goto L147;
    L148:
        r211 = r13;
        w.b(r121, r25, r111.implicitPropertyModifiers$kotlinpoet(r11), false, 60);     // Catch: Throwable -> L152
        r24.element = false;     // Catch: Throwable -> L152
    L152:
        th = th;
    L153:
        int r35 = r211;
    L187:
        r25.f15147p = r35;
        throw th;
    L147:
        r25.b(r21, false);     // Catch: Throwable -> L14
    L154:
        th = th;
        r211 = r13;
        goto L153
    L156:
        r211 = r13;
        d(r117, r116, r24, r25, this);     // Catch: Throwable -> L152
        Iterator r36 = r112.iterator();     // Catch: Throwable -> L152
    L158:
        if (r36.hasNext() == false) goto L165;
        k r37 = (k) r36.next();     // Catch: Throwable -> L152
        if (r37.d() == false) goto L158;
        if (r24.element == true) goto L164;
        r25.b(r21, false);     // Catch: Throwable -> L152
    L164:
        r37.c(r25, r19, r111.implicitFunctionModifiers$kotlinpoet(SetsKt.plus(r11, r27)), false);     // Catch: Throwable -> L152
        r24.element = false;     // Catch: Throwable -> L152
        r112 = r112;
        goto L158
    L165:
        Iterator r38 = r112.iterator();     // Catch: Throwable -> L152
    L167:
        if (r38.hasNext() == false) goto L174;
        k r39 = (k) r38.next();     // Catch: Throwable -> L152
        if (r39.d() == true) goto L167;
        if (r24.element == true) goto L173;
        r25.b(r21, false);     // Catch: Throwable -> L152
    L173:
        r39.c(r25, r19, r111.implicitFunctionModifiers$kotlinpoet(SetsKt.plus(r11, r27)), true);     // Catch: Throwable -> L152
        r24.element = false;     // Catch: Throwable -> L152
        goto L167
    L174:
        Iterator r40 = r33.iterator();     // Catch: Throwable -> L152
    L176:
        if (r40.hasNext() == false) goto L181;
        d0 r41 = (d0) r40.next();     // Catch: Throwable -> L152
        if (r24.element == true) goto L180;
        r25.b(r21, false);     // Catch: Throwable -> L152
    L180:
        r41.b(r25, null, r111.implicitTypeModifiers$kotlinpoet(SetsKt.plus(r11, r27)), r12);     // Catch: Throwable -> L152
        r24.element = false;     // Catch: Throwable -> L152
        goto L176
    L181:
        r25.K(1);     // Catch: Throwable -> L152
        r23.remove(r23.size() - 1);     // Catch: Throwable -> L152
        r25.b("}", false);     // Catch: Throwable -> L152
        if (r26 != null) goto L185;
        if (r22 == true) goto L185;
        r25.b(r21, false);     // Catch: Throwable -> L152
    L185:
        r25.f15147p = r211;
        return;
    L131:
        if (this.f15126p.a() == false) goto L133;
        r116 = true;
        goto L134
    L119:
        if (r24.element == true) goto L122;
        r25.b(r21, false);     // Catch: Throwable -> L14
    L122:
        if (r115.isEmpty() == true) goto L124;
    L127:
        r25.b(";\n", false);     // Catch: Throwable -> L14
        goto L128
    L124:
        if (r112.isEmpty() == false) goto L127;
        if (r33.isEmpty() == true) goto L128;
    L23:
        Map r42 = this.f15123m;
        a0 r43 = this.f15118h;
        if (r17 == false) goto L51;
        r25.f("object");     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r43, b0.f15080a) == true) goto L33;
        if (r12 == false) goto L30;
    L32:
        Set r44 = e.f15130c;     // Catch: Throwable -> L14
        List r45 = CollectionsKt.listOf(com.bytedance.apm.util.a.p(" %T", new Object[]{r43}));     // Catch: Throwable -> L14
    L35:
        if (r42.isEmpty() == true) goto L40;
        Set r46 = r42.keySet();     // Catch: Throwable -> L14
        ?? r47 = new ArrayList(CollectionsKt.h(r46));     // Catch: Throwable -> L14
        Iterator r48 = r46.iterator();     // Catch: Throwable -> L14
    L38:
        if (r48.hasNext() == false) goto L41;
        a0 r123 = (a0) r48.next();     // Catch: Throwable -> L14
        Set r124 = e.f15130c;     // Catch: Throwable -> L14
        r47.add(com.bytedance.apm.util.a.p(" %T", new Object[]{r123}));     // Catch: Throwable -> L14
    L41:
        List r49 = CollectionsKt.plus(r45, r47);     // Catch: Throwable -> L14
        if (r49.isEmpty() == true) goto L45;
        r25.f(" :");     // Catch: Throwable -> L14
        f.g(r25, com.bytedance.ies.bullet.base.utils.b.q(r49, ",", null, null, 6), false, false, 6);     // Catch: Throwable -> L14
    L45:
        if (e() == false) goto L50;
        r25.b(" {\n}", false);     // Catch: Throwable -> L14
        r25.f15147p = r13;
        return;
    L50:
        r25.b(" {\n", false);     // Catch: Throwable -> L14
        r22 = r17;
        r21 = "\n";
        goto L105
    L40:
        r47 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
        goto L41
    L30:
        if (r11.contains(KModifier.EXPECT) == true) goto L32;
        Set r50 = e.f15130c;     // Catch: Throwable -> L14
        r45 = CollectionsKt.listOf(com.bytedance.apm.util.a.p(" %T(%L)", new Object[]{r43, r15}));     // Catch: Throwable -> L14
        goto L35
    L33:
        r45 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
        goto L35
    L51:
        r25.n(f0.d(r16));     // Catch: Throwable -> L14
        r25.d(r18, false);     // Catch: Throwable -> L14
        if (r28 == false) goto L54;
        Set r51 = SetsKt.setOf(new KModifier[]{KModifier.PUBLIC, r10});     // Catch: Throwable -> L14
    L55:
        r25.p(r11, r51);     // Catch: Throwable -> L14
        r25.b(r111.getDeclarationKeyword$kotlinpoet(), false);     // Catch: Throwable -> L14
        if (r19 == null) goto L58;
        r25.e(" %N", new Object[]{this});     // Catch: Throwable -> L14
    L58:
        r25.q(r5);     // Catch: Throwable -> L14
        List r52 = CollectionsKt.listOf(r43);     // Catch: Throwable -> L14
        ArrayList r125 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r53 = r52.iterator();     // Catch: Throwable -> L14
    L60:
        if (r53.hasNext() == false) goto L65;
        Object r126 = r53.next();     // Catch: Throwable -> L14
        Iterator r212 = r53;
        boolean r213 = r17;
        if (Intrinsics.areEqual((a0) r126, b0.f15080a) == true) goto L64;
        r125.add(r126);     // Catch: Throwable -> L14
    L64:
        r53 = r212;
        r17 = r213;
        goto L60
    L65:
        r22 = r17;
        ArrayList r54 = new ArrayList(CollectionsKt.h(r125));     // Catch: Throwable -> L14
        Iterator r55 = r125.iterator();     // Catch: Throwable -> L14
    L68:
        if (r55.hasNext() == false) goto L87;
        a0 r127 = (a0) r55.next();     // Catch: Throwable -> L14
        if (r112 != null) goto L72;
    L74:
        Iterator r214 = r112.iterator();     // Catch: Throwable -> L14
    L76:
        if (r214.hasNext() == false) goto L80;
        if (((k) r214.next()).d() == false) goto L76;
        Set r215 = e.f15130c;     // Catch: Throwable -> L14
        e r128 = com.bytedance.apm.util.a.p("%T", new Object[]{r127});     // Catch: Throwable -> L14
        Iterator r216 = r55;
    L86:
        r54.add(r128);     // Catch: Throwable -> L14
        r55 = r216;
    L80:
        if (r12 == true) goto L84;
        r216 = r55;
        if (r11.contains(KModifier.EXPECT) == true) goto L85;
        Set r56 = e.f15130c;     // Catch: Throwable -> L14
        r128 = com.bytedance.apm.util.a.p("%T(%L)", new Object[]{r127, r15});     // Catch: Throwable -> L14
    L85:
        Set r57 = e.f15130c;     // Catch: Throwable -> L14
        r128 = com.bytedance.apm.util.a.p("%T", new Object[]{r127});     // Catch: Throwable -> L14
        goto L86
    L84:
        r216 = r55;
        goto L85
    L72:
        if (r112.isEmpty() == false) goto L74;
    L87:
        Set r58 = r42.entrySet();     // Catch: Throwable -> L14
        ArrayList r59 = new ArrayList(CollectionsKt.h(r58));     // Catch: Throwable -> L14
        Iterator r60 = r58.iterator();     // Catch: Throwable -> L14
    L89:
        if (r60.hasNext() == false) goto L95;
        Map.Entry r129 = (Map.Entry) r60.next();     // Catch: Throwable -> L14
        a0 r130 = (a0) r129.getKey();     // Catch: Throwable -> L14
        e r131 = (e) r129.getValue();     // Catch: Throwable -> L14
        if (r131 != null) goto L93;
        Set r132 = e.f15130c;     // Catch: Throwable -> L14
        e r133 = com.bytedance.apm.util.a.p("%T", new Object[]{r130});     // Catch: Throwable -> L14
    L94:
        r59.add(r133);     // Catch: Throwable -> L14
        r60 = r60;
        goto L89
    L93:
        Set r217 = e.f15130c;     // Catch: Throwable -> L14
        r133 = com.bytedance.apm.util.a.p("%T by %L", new Object[]{r130, r131});     // Catch: Throwable -> L14
        goto L94
    L95:
        List r61 = CollectionsKt.plus(r54, r59);     // Catch: Throwable -> L14
        if (r61.isEmpty() == true) goto L98;
        f.g(r25, com.bytedance.ies.bullet.base.utils.b.q(r61, ", ", " : ", null, 4), false, false, 6);     // Catch: Throwable -> L14
    L98:
        r25.J(r5);     // Catch: Throwable -> L14
        if (e() == false) goto L103;
        r25.b("\n", false);     // Catch: Throwable -> L14
        r25.f15147p = r13;
        return;
    L103:
        r21 = "\n";
        r25.b(" {\n", false);     // Catch: Throwable -> L14
        goto L105
    L54:
        r51 = SetsKt.setOf(KModifier.PUBLIC);     // Catch: Throwable -> L14
    L14:
        th = th;
        r35 = r13;
    L7:
        r12 = true;
        goto L8
    }

    public final boolean e() {
        List r5 = this.f15125o;
        if (r5.isEmpty() == true) goto L11;
        Map r10 = MapsKt.emptyMap();
        Iterator r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        if (r10.containsKey(((w) r11.next()).f15205c) == true) goto L6;
        return false;
    L11:
        if (this.f15124n.isEmpty() == true) goto L13;
        return false;
    L13:
        if (this.f15126p.f15131a.isEmpty() == true) goto L15;
        return false;
    L15:
        if (this.f15128r.isEmpty() == true) goto L17;
        return false;
    L17:
        if (this.s.isEmpty() == false) goto L26;
        return true;
    L26:
        return false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(d0.class, r5.getClass()) == true) goto L12;
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
        c(this, r11, null);     // Catch: Throwable -> L6
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
