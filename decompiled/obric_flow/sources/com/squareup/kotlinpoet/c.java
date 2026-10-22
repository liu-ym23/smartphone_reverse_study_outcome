package com.squareup.kotlinpoet;

import ai.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a0 implements Comparable {
    public final List e;
    public final String f;

    public /* synthetic */ c(List r5) {
        this(r5, CollectionsKt.emptyList(), false, MapsKt.emptyMap());
    }

    @Override // com.squareup.kotlinpoet.a0
    public final a0 a(Map r5, boolean r10, List r11) {
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r5, "tags");
        return new c(this.e, r11, r10, r5);
    }

    @Override // com.squareup.kotlinpoet.a0
    public final f c(f r15) {
        Intrinsics.checkNotNullParameter(r15, "out");
        r15.getClass();
        Intrinsics.checkNotNullParameter(this, "className");
        c r5 = this;
        boolean r10 = false;
    L3:
        LinkedHashSet r11 = r15.f15145n;
        List r12 = this.e;
        Map r13 = r15.f15137b;
        if (r5 == null) goto L48;
        if (r13.get(r5.f) != null) goto L47;
        String r14 = r5.e();
        ArrayList r16 = r15.f15141j;
        int r17 = r16.size() - 1;
        if (r17 < 0) goto L22;
    L9:
        int r18 = r17 - 1;
        if (((d0) r16.get(r17)).f15129t.contains(r14) == true) goto L11;
        if (r18 < 0) goto L22;
        r17 = r18;
        goto L9
    L11:
        String r19 = r15.f15140i;
        String r110 = ((d0) r16.get(0)).f15117c;
        Intrinsics.checkNotNull(r110);
        c r20 = new c(r19, new String[]{r110});
        if (1 > r17) goto L17;
        int r111 = 1;
    L14:
        String r112 = ((d0) r16.get(r111)).f15117c;
        Intrinsics.checkNotNull(r112);
        r20 = r20.f(r112);
        if (r111 == r17) goto L17;
        r111 = r111 + 1;
    L17:
        c r21 = r20.f(r14);
    L35:
        if (r21 == null) goto L37;
        boolean r22 = true;
    L38:
        List r23 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r23, "annotations");
        boolean r24 = Intrinsics.areEqual(r21, r5.a((Map) r5.f15076b.f23297a, false, r23));
        List r25 = r5.e;
        if (r24 == true) goto L40;
        if (r25.size() == 2) goto L44;
        r5 = new c(r25.subList(0, r25.size() - 1));
    L45:
        r10 = r22;
        goto L3
    L44:
        r5 = null;
        goto L45
    L40:
        int r26 = r25.subList(1, r25.size()).size() - 1;
        r11.add(g().e());
        String r113 = CollectionsKt.q(r12.subList(1, r12.size()).subList(r26, r12.subList(1, r12.size()).size()), ".", null, null, 0, null, null, 62);
    L63:
        r15.b(f0.f(r113), false);
        return r15;
    L37:
        r22 = false;
    L22:
        if (r16.size() <= 0) goto L31;
        d0 r27 = (d0) r16.get(0);
        if (Intrinsics.areEqual(r27.f15117c, r14) == false) goto L27;
        r21 = new c(r15.f15140i, new String[]{r14});
        goto L35
    L27:
        if (r27.f15120j == false) goto L31;
        if (r27.f15124n.keySet().contains(r14) == false) goto L31;
        String r28 = r15.f15140i;
        String r29 = r27.f15117c;
        Intrinsics.checkNotNull(r29);
        r21 = new c(r28, new String[]{r29}).f(r14);
    L31:
        r21 = (c) r15.f15138c.get(r14);
        if (r21 != null) goto L35;
        r21 = null;
        goto L35
    L47:
        throw new ClassCastException();
    L48:
        String r30 = this.f;
        if (r10 == false) goto L52;
    L50:
        r113 = r30;
        goto L63
    L52:
        if (Intrinsics.areEqual(r15.f15140i, (String) r12.get(0)) == false) goto L55;
        r11.add(g().e());
        r113 = CollectionsKt.q(r12.subList(1, r12.size()), ".", null, null, 0, null, null, 62);
        goto L63
    L55:
        if (r15.g == true) goto L50;
        c r114 = g();
        if (r13.get(r30) != null) goto L62;
        String r31 = r114.e();
        if (r15.f15144m.containsKey(r31) == true) goto L50;
        r15.f15143l.putIfAbsent(r31, r114);
        goto L50
    L62:
        throw new ClassCastException();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        c r10 = (c) r5;
        Intrinsics.checkNotNullParameter(r10, "other");
        return this.f.compareTo(r10.f);
    }

    public final String e() {
        return (String) j0.e(this.e, 1);
    }

    public final c f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return new c(CollectionsKt.plus(this.e, r5));
    }

    public final c g() {
        return new c(this.e.subList(0, 2));
    }

    public c(List r10, List r11, boolean r12, Map r13) {
        Intrinsics.checkNotNullParameter(r10, "names");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r13, "tags");
        super(r12, r11, new ym.d(r13));
        this.e = f0.i(r10);
        if (((CharSequence) r10.get(0)).length() != 0) goto L5;
        String r14 = CollectionsKt.q(r10.subList(1, r10.size()), ".", null, null, 0, null, null, 62);
    L6:
        this.f = r14;
        return;
    L5:
        r14 = CollectionsKt.q(r10, ".", null, null, 0, null, null, 62);
        goto L6
    }

    public c(String r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "simpleNames");
        SpreadBuilder r11 = new SpreadBuilder(2);
        r11.add(r5);
        r11.addSpread(r10);
        this(CollectionsKt.listOf(r11.toArray(new String[r11.size()])));
        if (r10.length == 0) goto L13;
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (r10[r13].length() == 0) goto L10;
        r13 = r13 + 1;
        goto L5
    L10:
        throw new IllegalArgumentException(("simpleNames must not contain empty items: " + Arrays.toString(r10)).toString());
    L11:
        return;
    L13:
        throw new IllegalArgumentException("simpleNames must not be empty");
    }
}
