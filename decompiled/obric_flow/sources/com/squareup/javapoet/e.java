package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends x implements Comparable {
    public static final e B = null;
    public final String A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f14959w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f14960x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f14961y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f14962z;

    static {
        B = n(Object.class);
    }

    public e(String r5, e r10, String r11) {
        this(r5, r10, r11, Collections.emptyList());
    }

    public static e n(Class r10) {
        com.bytedance.android.anniex.base.service.f.s(r10, "clazz == null", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(!r10.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(!Void.TYPE.equals(r10), "'void' type cannot be represented as a ClassName", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(!r10.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        String r5 = "";
        String r11 = "";
    L4:
        if (r10.isAnonymousClass() == false) goto L6;
        r11 = r10.getName().substring(r10.getName().lastIndexOf(36)) + r11;
        r10 = r10.getEnclosingClass();
        goto L4
    L6:
        String r12 = r10.getSimpleName() + r11;
        if (r10.getEnclosingClass() != null) goto L13;
        int r13 = r10.getName().lastIndexOf(46);
        if (r13 == (-1)) goto L12;
        r5 = r10.getName().substring(0, r13);
    L12:
        return new e(r5, null, r12);
    L13:
        e r14 = n(r10.getEnclosingClass());
        return new e(r14.f14959w, r14, r12);
    }

    public static e o(String r5, String r10, String... r11) {
        e r12 = new e(r5, null, r10);
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        String r15 = r11[r14];
        r14 = r14 + 1;
        r12 = new e(r12.f14959w, r12, r15);
        goto L3
    L5:
        return r12;
    }

    public static e p(TypeElement r5) {
        com.bytedance.android.anniex.base.service.f.s(r5, "element == null", new Object[0]);
        r5.getSimpleName().toString();
        return (e) r5.getEnclosingElement().accept(new d(), null);
    }

    @Override // com.squareup.javapoet.x
    public final k c(k r19) {
        ArrayList r5 = new ArrayList();
        e r10 = this;
    L3:
        if (r10 == null) goto L5;
        r5.add(r10);
        r10 = r10.f14960x;
        goto L3
    L5:
        Collections.reverse(r5);
        Iterator r11 = r5.iterator();
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r11.hasNext() == false) goto L79;
        e r14 = (e) r11.next();
        int r15 = 1;
        if (r13 != 0) goto L10;
        if (r14.i() == true) goto L17;
        if (r14 != this) goto L7;
    L17:
        r19.getClass();
        String r16 = r14.s().f14961y;
        int r17 = ((Integer) ((LinkedHashMap) r19.f14985n.f905a).getOrDefault(r16, Integer.valueOf(r12))).intValue();
        String r18 = r14.A;
        if (r17 <= 0) goto L21;
        Iterator r110 = r11;
        int r20 = 1;
    L20:
        String r21 = r18;
    L69:
        int r22 = r21.lastIndexOf(46);
        if (r22 == (-1)) goto L72;
        int r23 = r22 + 1;
        int r24 = 0;
        r19.e(r21.substring(0, r23));
        r21 = r21.substring(r23);
        r13 = r20;
    L74:
        if (r14.i() == false) goto L78;
        if (r13 == 0) goto L77;
        r19.e(" ");
    L77:
        r14.d(r19);
    L78:
        r19.e(r21);
        r13 = r20;
        r12 = r24;
        r11 = r110;
        goto L7
    L72:
        r24 = 0;
        goto L74
    L21:
        int r111 = r12;
        e r25 = r14;
    L22:
        if (r25 == null) goto L52;
        ArrayList r112 = r19.g;
        int r113 = r112.size() - r15;
    L24:
        String r114 = r25.f14961y;
        if (r113 < 0) goto L34;
        if (((z) r112.get(r113)).f15064p.contains(r114) == true) goto L28;
        r113 = r113 - 1;
        r12 = 0;
        goto L24
    L28:
        e r26 = o(r19.f, ((z) r112.get(r12)).f15054b, new String[r12]);
        int r115 = 1;
    L29:
        String r116 = r26.f14959w;
        if (r115 > r113) goto L32;
        String r27 = ((z) r112.get(r115)).f15054b;
        r115 = r115 + 1;
        r26 = new e(r116, r26, r27);
        r11 = r11;
        goto L29
    L32:
        r110 = r11;
        e r28 = new e(r116, r26, r114);
    L43:
        if (r28 == null) goto L45;
        r111 = 1;
    L46:
        if (r28 == null) goto L51;
        if (Objects.equals(r28.A, r25.A) == false) goto L51;
        r20 = 1;
        String r29 = String.join(".", r14.r().subList(r25.r().size() - 1, r14.r().size()));
    L50:
        r21 = r29;
    L51:
        r25 = r25.f14960x;
        r15 = 1;
        r11 = r110;
        r12 = 0;
        goto L22
    L45:
        r111 = 0;
        goto L46
    L34:
        r110 = r11;
        if (r112.size() > 0) goto L37;
    L39:
        r28 = (e) r19.f14982k.get(r114);
        if (r28 != null) goto L43;
        r28 = null;
        goto L43
    L37:
        if (Objects.equals(((z) r112.get(0)).f15054b, r114) == false) goto L39;
        r28 = o(r19.f, r114, new String[0]);
        goto L43
    L52:
        r110 = r11;
        r20 = r15;
        if (r111 != 0) goto L20;
        String r30 = r19.f;
        String r31 = r14.f14959w;
        if (Objects.equals(r30, r31) == false) goto L59;
        r19.f14984m.add(r16);
        r29 = String.join(".", r14.r());
        goto L50
    L59:
        if (r19.d == true) goto L20;
        if (r31.isEmpty() == true) goto L20;
        if (r19.f14981j.contains(r14.f14961y) == true) goto L20;
        e r32 = r14.s();
        String r33 = r32.f14961y;
        LinkedHashMap r34 = r19.f14983l;
        e r35 = (e) r34.put(r33, r32);
        if (r35 == null) goto L20;
        r34.put(r33, r35);
        goto L20
    L10:
        r19.e(".");
        r21 = r14.f14961y;
        r110 = r11;
        r24 = r12;
        r20 = 1;
        goto L74
    L79:
        return r19;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        return this.A.compareTo(((e) r5).A);
    }

    @Override // com.squareup.javapoet.x
    public final boolean i() {
        if (super.i() == true) goto L10;
        e r5 = this.f14960x;
        if (r5 != null) goto L7;
    L9:
        return false;
    L7:
        if (r5.i() == false) goto L9;
    L10:
        return true;
    }

    public final String q() {
        return this.f14961y;
    }

    public final List r() {
        List r5 = this.f14962z;
        if (r5 == null) goto L5;
        return r5;
    L5:
        String r10 = this.f14961y;
        e r11 = this.f14960x;
        if (r11 != null) goto L8;
        this.f14962z = Collections.singletonList(r10);
    L10:
        return this.f14962z;
    L8:
        ArrayList r12 = new ArrayList();
        r12.addAll(r11.r());
        r12.add(r10);
        this.f14962z = Collections.unmodifiableList(r12);
        goto L10
    }

    public final e s() {
        e r5 = this.f14960x;
        if (r5 != null) goto L5;
        return this;
    L5:
        return r5.s();
    }

    public final e t() {
        if (i() == true) goto L5;
        return this;
    L5:
        e r5 = this.f14960x;
        if (r5 == null) goto L8;
        e r10 = r5.t();
    L10:
        return new e(this.f14959w, r10, this.f14961y);
    L8:
        r10 = null;
        goto L10
    }

    public e(String r5, e r10, String r11, List r12) {
        super(null, r12);
        Objects.requireNonNull(r5, "packageName == null");
        this.f14959w = r5;
        this.f14960x = r10;
        this.f14961y = r11;
        if (r10 == null) goto L6;
        r11 = r10.A + '.' + r11;
    L9:
        this.A = r11;
        return;
    L6:
        if (r5.isEmpty() == true) goto L9;
        r11 = androidx.constraintlayout.motion.widget.a.m(r5, '.', r11);
        goto L9
    }
}
