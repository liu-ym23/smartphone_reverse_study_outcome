package com.ss.android.lark.coremd.impl.buildnode;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.e;
import v7b.s;
import v7b.v;
import x9b.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b a = null;
    public static final BISURelocator b = null;

    public interface a {
        int a(s r1, s r2);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.impl.buildnode.b$b, reason: collision with other inner class name */
    public static final class C0186b {
        public final s a;
        public final int b;
        public final int c;
        public final List<C0186b> d;

        public final String toString() {
            return "NodeWithInterval{node: " + this.a + ", start: " + this.b + ", end: " + this.c + '}';
        }

        public C0186b(s r2, int r3, int r4, List<C0186b> r5) {
            Intrinsics.checkNotNullParameter(r2, "node");
            Intrinsics.checkNotNullParameter(r5, "children");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = new BISURelocator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.ss.android.lark.coremd.impl.buildnode.b$a, com.ss.android.lark.coremd.impl.buildnode.d$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static e a(Spanned r22, d.a r23) {
        Intrinsics.checkNotNullParameter(r22, "spanned");
        Intrinsics.checkNotNullParameter(r23, "handler");
        long r2 = System.currentTimeMillis();
        e r4 = new e();
        NodeBISUUtils.c.getClass();
        Intrinsics.checkNotNullParameter(r22, "content");
        SpannableStringBuilder r5 = (SpannableStringBuilder) r22;
        int r6 = r5.length();
        char[] r7 = new char[r6];
        int r9 = 0;
    L3:
        if (r9 >= r6) goto L5;
        r7[r9] = 0;
        r9 = r9 + 1;
        goto L3
    L5:
        int r8 = r5.length();
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L25;
        int r11 = r5.nextSpanTransition(r10, r8, h.class);
        h[] r12 = (h[]) r5.getSpans(r10, r11, h.class);
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L24;
        h r15 = r12[r14];
        int r16 = r5.getSpanStart(r15);
        int r17 = r5.getSpanEnd(r15);
        if (r16 == (-1)) goto L23;
        if (r17 == (-1)) goto L23;
        NodeBISUUtils r18 = NodeBISUUtils.c;
        boolean r19 = r15.a;
        boolean r20 = r15.b;
        boolean r21 = r15.c;
        boolean r110 = r15.d;
        r18.getClass();
        ?? r24 = r19;
        if (r20 == false) goto L16;
        r24 = (r19 ? 1 : 0) | 2;
    L16:
        if (r21 == false) goto L18;
        r24 = (r24 == true ? 1 : 0) | '\b';
    L18:
        if (r110 == false) goto L20;
        r24 = (r24 == true ? 1 : 0) | 4;
    L20:
        if (r16 >= r17) goto L23;
        r7[r16] = (r7[r16] | r24) == true ? 1 : 0;
        r16 = r16 + 1;
    L23:
        r14 = r14 + 1;
        r5 = r5;
        r8 = r8;
        r12 = r12;
        goto L8
    L24:
        r10 = r11;
        goto L6
    L25:
        SpannableStringBuilder r25 = (SpannableStringBuilder) r22;
        BitSet r26 = new BitSet(r25.length());
        BitSet r27 = new BitSet(r25.length());
        LinkedHashMap r28 = new LinkedHashMap();
        Iterator r111 = r23.c().iterator();
    L27:
        if (r111.hasNext() == false) goto L53;
        Class r112 = (Class) r111.next();
        Object[] r113 = r25.getSpans(0, r25.length(), r112);
        int r114 = r113.length;
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L27;
        Object r116 = r113[r115];
        Iterator r117 = r111;
        int r118 = r25.getSpanStart(r116);
        Object[] r119 = r113;
        int r120 = r25.getSpanEnd(r116);
        Intrinsics.checkNotNull(r116);
        s r121 = r23.f(r112, r22, r116);
        if (r121 != null) goto L33;
        Class r29 = r112;
        int r210 = r114;
    L51:
        r115 = r115 + 1;
        r111 = r117;
        r113 = r119;
        r112 = r29;
        r114 = r210;
        goto L29
    L33:
        r29 = r112;
        if ((r121 instanceof v7b.h) == false) goto L36;
        r27.set(r118, r120);
    L36:
        r210 = r114;
        r28.put(r121, TuplesKt.to(Integer.valueOf(r118), Integer.valueOf(r120)));
        r26.set(r118, r120);
        if ((r121 instanceof v7b.a) == true) goto L51;
        if (r7.length != 0) goto L41;
        boolean r122 = true;
    L42:
        if (r122 == true) goto L51;
        int r123 = r118 + 1;
        char r124 = r7[r118];
    L45:
        if (r123 >= r120) goto L50;
        int r125 = r123 + 1;
        if (r7[r123] != r124) goto L51;
        r123 = r125;
        goto L45
    L50:
        NodeBISUUtils.c.getClass();
        Intrinsics.checkNotNullParameter(r121, "node");
        NodeBISUUtils.b(r121, r124);
        goto L51
    L41:
        r122 = false;
        goto L42
    L53:
        if (r25.length() <= 0) goto L55;
        boolean r126 = true;
    L56:
        char r127 = '\n';
        if (r126 == false) goto L76;
        int r128 = r25.length();
        int r129 = 0;
    L59:
        if (r129 >= r128) goto L76;
        if (r25.charAt(r129) != r127) goto L75;
        if (r26.get(r129) == true) goto L75;
        v7b.h r130 = new v7b.h();
        if (r129 != 0) goto L67;
        r28.put(r130, TuplesKt.to(0, 1));
        r26.set(0, 1);
        r27.set(0, 1);
        goto L75
    L67:
        int r131 = r129 - 1;
        if (r25.charAt(r131) != '\n') goto L75;
        if (r27.get(r131) == true) goto L75;
        if (r26.get(r131) == true) goto L74;
        r28.put(r130, TuplesKt.to(Integer.valueOf(r131), Integer.valueOf(r129)));
        r26.set(r131, r129);
        r27.set(r131, r129);
        goto L75
    L74:
        int r132 = r129 + 1;
        r28.put(r130, TuplesKt.to(Integer.valueOf(r129), Integer.valueOf(r132)));
        r26.set(r129, r132);
        r27.set(r129, r132);
    L75:
        r129 = r129 + 1;
        r127 = '\n';
    L76:
        ArrayList r30 = new ArrayList(r28.size());
        Iterator r31 = r28.entrySet().iterator();
    L78:
        if (r31.hasNext() == false) goto L80;
        Map.Entry r32 = (Map.Entry) r31.next();
        s r133 = (s) r32.getKey();
        Pair r33 = (Pair) r32.getValue();
        r30.add(new C0186b(r133, ((Number) r33.getFirst()).intValue(), ((Number) r33.getSecond()).intValue(), new ArrayList()));
        goto L78
    L80:
        List r34 = CollectionsKt.sortedWith(r30, c.a);
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L81:
        boolean r37 = r36.hasNext();
        b r134 = a;
        if (r37 == false) goto L84;
        r134.insert(r35, (C0186b) r36.next(), r23);
        goto L81
    L84:
        ArrayList r38 = new ArrayList();
        Iterator r39 = r35.iterator();
        int r135 = 0;
    L86:
        if (r39.hasNext() == false) goto L104;
        C0186b r40 = (C0186b) r39.next();
        int r136 = r40.b;
        if (r136 <= r135) goto L90;
        r38.addAll(r23.b(r40.a, r25.subSequence(r135, r136), r135, r7));
    L90:
        r38.add(b(r40.a, r22, r40, r23, r7));
        int r41 = r40.c;
        s r137 = (s) CollectionsKt.lastOrNull(r38);
        Character r138 = StringsKt.getOrNull(r22, r41);
        if (r138 != null) goto L94;
    L102:
        r135 = r41;
        goto L86
    L94:
        if (r138.charValue() != '\n') goto L102;
        if (r137 != null) goto L97;
        boolean r139 = false;
    L98:
        if (r139 == false) goto L100;
    L101:
        r41 = r41 + 1;
        goto L102
    L100:
        if ((r137 instanceof v7b.h) == false) goto L102;
    L97:
        r139 = r23.d(r137);
        goto L98
    L104:
        if (r135 >= r25.length()) goto L106;
        r38.addAll(r23.b(r4, r25.subSequence(r135, r25.length()), r135, r7));
    L106:
        List r0 = ListItemBuildUtils.g(r38);
        ArrayList r42 = new ArrayList();
        LinkedList r43 = new LinkedList();
        Iterator r1 = r0.iterator();
    L108:
        if (r1.hasNext() == false) goto L137;
        s r44 = (s) r1.next();
        if ((r44 instanceof v7b.h) == true) goto L112;
        if (r23.d(r44) == true) goto L122;
        r43.add(r44);
        goto L108
    L122:
        if ((!r43.isEmpty()) == true) goto L124;
        boolean r140 = false;
    L133:
        if (r140 == true) goto L108;
        r42.add(r44);
        goto L108
    L124:
        if ((r44 instanceof v) == false) goto L126;
        v r45 = (v) r44;
    L127:
        r140 = Intrinsics.areEqual(r45, r44);
        Iterator r46 = r43.iterator();
    L129:
        if (r46.hasNext() == false) goto L131;
        r45.e((s) r46.next());
        goto L129
    L131:
        r43.clear();
        r42.add(r45);
        goto L133
    L126:
        r45 = new v();
        goto L127
    L112:
        if ((!r43.isEmpty()) == false) goto L118;
        v r47 = new v();
        Iterator r48 = r43.iterator();
    L115:
        if (r48.hasNext() == false) goto L117;
        r47.e((s) r48.next());
        goto L115
    L117:
        r42.add(r47);
        r43.clear();
    L118:
        r42.add(r44);
        goto L108
    L137:
        if ((!r43.isEmpty()) == false) goto L143;
        v r3 = new v();
        Iterator r49 = r43.iterator();
    L140:
        if (r49.hasNext() == false) goto L142;
        r3.e((s) r49.next());
        goto L140
    L142:
        r42.add(r3);
    L143:
        Iterator r50 = r42.iterator();
    L145:
        if (r50.hasNext() == false) goto L147;
        r4.e((s) r50.next());
        goto L145
    L147:
        b.d(r4);
        Log.d("SpannedNodeGenerateUtils", "build node cost " + (System.currentTimeMillis() - r2) + " mills.");
        return r4;
    L55:
        r126 = false;
        goto L56
    }

    private final void insert(List<C0186b> r11, C0186b r12, a r13) {
        Iterator<T> r0 = r11.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L32;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        C0186b r5 = (C0186b) r3;
        int r6 = r5.b;
        int r7 = r12.b;
        b r8 = a;
        if (r6 == r7) goto L11;
    L17:
        int r9 = r5.c;
        boolean r10 = true;
        if (r6 > r7) goto L21;
        if (r7 > r9) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L31;
        int r15 = r12.c;
        if (r6 > r15) goto L27;
        if (r15 > r9) goto L27;
    L28:
        if (r10 == false) goto L31;
        r8.insert(r5.d, r12, r13);
        return;
    L27:
        r10 = false;
    L31:
        r2 = r4;
    L21:
        r14 = false;
        goto L22
    L11:
        if (r5.c != r12.c) goto L17;
        if (r13.a(r5.a, r12.a) > 0) goto L15;
        r8.insert(r5.d, r12, r13);
        return;
    L15:
        r8.insert(r12.d, r5, r13);
        ListProtector.set(r11, r2, r12);
        return;
    L32:
        r11.add(r12);
    }

    public static s b(s r10, Spanned r11, C0186b r12, d.a r13, char[] r14) {
        s r0 = r12.a;
        int r1 = r12.c;
        int r2 = r12.b;
        ArrayList r3 = new ArrayList();
        boolean r4 = false;
        if (r0 != null) goto L5;
        boolean r5 = false;
    L6:
        if (r5 == true) goto L8;
        return r0;
    L8:
        Iterator<T> r15 = r12.d.iterator();
    L10:
        if (r15.hasNext() == false) goto L33;
        C0186b r6 = (C0186b) r15.next();
        int r7 = r6.b;
        if (r7 <= r2) goto L14;
        r3.addAll(r13.b(r6.a, ((SpannableStringBuilder) r11).subSequence(r2, r7), r2, r14));
    L14:
        r3.add(b(r6.a, r11, r6, r13, r14));
        r2 = r6.c;
        s r8 = (s) CollectionsKt.lastOrNull(r3);
        if (r8 != null) goto L17;
        boolean r9 = false;
    L18:
        if (r9 == false) goto L10;
        Character r16 = StringsKt.getOrNull(r11, r2 - 1);
        if (r16 != null) goto L23;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == true) goto L10;
        Character r18 = StringsKt.getOrNull(r11, r2);
        if (r18 == null) goto L10;
        if (r18.charValue() != '\n') goto L10;
        r2 = r2 + 1;
        goto L10
    L23:
        if (r16.charValue() != '\n') goto L25;
        r17 = true;
        goto L26
    L17:
        r9 = r13.d(r8);
        goto L18
    L33:
        if (r0 == null) goto L36;
        r4 = r13.d(r0);
    L36:
        if (r4 == false) goto L43;
        int r19 = r1 - 1;
        Character r20 = StringsKt.getOrNull(r11, r19);
        if (r20 == null) goto L43;
        if (r20.charValue() != '\n') goto L43;
        r1 = r19;
    L43:
        if (r2 >= r1) goto L45;
        r3.addAll(r13.b(r10, ((SpannableStringBuilder) r11).subSequence(r2, r1), r2, r14));
    L45:
        Iterator r110 = r3.iterator();
    L47:
        if (r110.hasNext() == false) goto L49;
        r0.e((s) r110.next());
        goto L47
    L49:
        return r0;
    L5:
        r5 = r13.e(r0);
        goto L6
    }
}
