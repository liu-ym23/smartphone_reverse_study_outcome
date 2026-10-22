package com.ss.android.lark.coremd.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v7b.r;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BISURelocator {
    public final int[] a;
    public final Function0<s>[] b;
    public final List<Integer> c;
    public final List<s> d;
    public final List<s> e;
    public final List<b> f;
    public final Map<s, Integer> g;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public BISURelocator() {
        this.a = new int[]{1, 2, 4, 8};
        this.b = new Function0[]{BISURelocator$styleNodeFactory$1.INSTANCE, BISURelocator$styleNodeFactory$2.INSTANCE, BISURelocator$styleNodeFactory$3.INSTANCE, BISURelocator$styleNodeFactory$4.INSTANCE};
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new LinkedHashMap();
    }

    public static int c(s r3) {
        NodeBISUUtils.c.getClass();
        Intrinsics.checkNotNullParameter(r3, "node");
        return ((Number) NodeBISUUtils.e.getValue(r3, NodeBISUUtils.d[0])).intValue();
    }

    public final void d(v7b.e r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Log.d("BISURelocator", "parseBISU: node is " + r.a(r3, false));
        b(r3, c(r3));
        ((ArrayList) this.c).clear();
        ((ArrayList) this.d).clear();
        ((ArrayList) this.f).clear();
        ((ArrayList) this.e).clear();
    }

    public final void b(s r11, int r12) {
        s r0 = r11.e;
        if (r0 != null) goto L10;
        if (r11.f != null) goto L10;
        if ((r11 instanceof v7b.a) == true) goto L10;
        this.g.put(r11, Integer.valueOf(r12));
        return;
    L10:
        if (r0 == null) goto L12;
        b(r0, c(r0) | r12);
        r0 = r0.h;
        goto L10
    L12:
        ((ArrayList) this.c).clear();
        ((ArrayList) this.d).clear();
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        s r13 = r11.e;
    L13:
        int r1 = 0;
        if (r13 == null) goto L19;
        Integer r2 = (Integer) ((LinkedHashMap) this.g).get(r13);
        if (r2 == null) goto L18;
        r1 = r2.intValue();
    L18:
        ((ArrayList) this.c).add(Integer.valueOf(r1));
        ((ArrayList) this.d).add(r13);
        s r3 = r13.h;
        r13.p();
        r13 = r3;
        goto L13
    L19:
        int r4 = 1;
        if ((!((ArrayList) this.c).isEmpty()) == false) goto L38;
        Iterator r14 = ((ArrayList) this.c).iterator();
        int r5 = 1;
        int r6 = 2;
        int r7 = 4;
        int r8 = 8;
    L23:
        if (r14.hasNext() == false) goto L26;
        int r9 = ((Number) r14.next()).intValue();
        r5 = r5 & r9;
        r6 = r6 & r9;
        r7 = r7 & r9;
        r8 = r8 & r9;
        goto L23
    L26:
        if ((r11 instanceof v7b.a) == true) goto L36;
        if (r5 == 1) goto L30;
        r4 = 0;
    L30:
        if (r6 != 2) goto L32;
        r4 = r4 | 2;
    L32:
        if (r7 != 4) goto L34;
        r4 = r4 | 4;
    L34:
        if (r8 != 8) goto L37;
        r4 = r4 | 8;
    L37:
        this.g.put(r11, Integer.valueOf(r4));
    L39:
        List<Integer> r15 = this.c;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = ((ArrayList) r15).iterator();
    L41:
        if (r16.hasNext() == false) goto L43;
        r10.add(Integer.valueOf((((Number) r16.next()).intValue() & 15) & (~(r4 & 15))));
        goto L41
    L43:
        int r17 = r10.size();
        int r18 = -1;
        int r19 = -1;
        int r20 = 0;
    L44:
        if (r20 >= r17) goto L51;
        int r21 = ((Number) ListProtector.get(r10, r20)).intValue();
        if (r21 == r19) goto L50;
        if (r18 < 0) goto L49;
        ((ArrayList) this.f).add(new b(r18, r20, r19));
    L49:
        r18 = r20;
        r19 = r21;
    L50:
        r20 = r20 + 1;
        goto L44
    L51:
        if (r18 < 0) goto L53;
        ((ArrayList) this.f).add(new b(r18, r10.size(), r19));
    L53:
        Iterator r110 = ((ArrayList) this.f).iterator();
    L55:
        if (r110.hasNext() == false) goto L63;
        b r22 = (b) r110.next();
        s r23 = a(r22.c, this.d, r22.a, r22.b);
        if (r23 != null) goto L58;
        int r24 = r22.a;
        int r25 = r22.b;
    L60:
        if (r24 >= r25) goto L55;
        ((ArrayList) this.e).add(ListProtector.get(this.d, r24));
        r24 = r24 + 1;
        goto L60
    L58:
        ((ArrayList) this.e).add(r23);
        goto L55
    L63:
        if ((r11 instanceof v7b.a) == false) goto L68;
        List<s> r111 = this.e;
        s r112 = a(r4, r111, 0, ((ArrayList) r111).size());
        if (r112 == null) goto L67;
        ((ArrayList) this.e).clear();
        ((ArrayList) this.e).add(r112);
    L67:
        this.g.remove(r11);
    L68:
        Iterator r113 = ((ArrayList) this.e).iterator();
    L70:
        if (r113.hasNext() == false) goto L72;
        r11.e((s) r113.next());
        goto L70
    L72:
        return;
    L36:
        r4 = 0;
        goto L37
    L38:
        r4 = 0;
        goto L39
    }

    public final s a(int r7, List<? extends s> r8, int r9, int r10) {
        if (r7 != 0) goto L5;
        return null;
    L5:
        int r1 = 0;
        s r2 = null;
        s r3 = null;
    L7:
        if (r1 >= 4) goto L17;
        int r4 = this.a[r1];
        if ((r7 & r4) != r4) goto L16;
        s r5 = (s) this.b[r1].invoke();
        if (r3 == null) goto L13;
        r5.e(r3);
    L13:
        if (r2 != null) goto L15;
        r2 = r5;
    L15:
        r3 = r5;
    L16:
        r1 = r1 + 1;
        goto L7
    L17:
        if (r2 == null) goto L21;
    L18:
        if (r9 >= r10) goto L20;
        r2.e((s) ListProtector.get(r8, r9));
        r9 = r9 + 1;
        goto L18
    L20:
        return r3;
    L21:
        return null;
    }
}
