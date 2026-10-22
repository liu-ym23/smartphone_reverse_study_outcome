package com.larus.business.markdown.impl.markwon;

import android.text.SpannableStringBuilder;
import android.view.View;
import io.noties.markwon.ext.tables.TableRowSpan2;
import io.noties.markwon.ext.tables.g;
import io.noties.markwon.ext.tables.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static final Map<View, a> a = null;

    public static final class a {
        public final SpannableStringBuilder a;
        public final HashMap<String, Integer> b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            HashMap<String, Integer> r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            boolean r4 = this.c;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "IncrementalTextSpanCache(markdownSpan=" + this.a + ", nodeInfo=" + this.b + ", hasTable=" + this.c + ')';
        }

        public a(SpannableStringBuilder r2, HashMap<String, Integer> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "markdownSpan");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static SpannableStringBuilder a(SpannableStringBuilder r26, boolean r27) {
        SpannableStringBuilder r1 = new SpannableStringBuilder(r26);
        if (r27 == false) goto L41;
        IdentityHashMap r2 = new IdentityHashMap();
        Object[] r3 = r26.getSpans(0, r26.length(), s.class);
        int r4 = r3.length;
        int r6 = 0;
    L5:
        if (r6 >= r4) goto L41;
        s r7 = (s) r3[r6];
        int r8 = r26.getSpanStart(r7);
        int r9 = r26.getSpanEnd(r7);
        if (r8 < 0) goto L39;
        if (r9 < r8) goto L39;
        IdentityHashMap r10 = new IdentityHashMap();
        IdentityHashMap r11 = new IdentityHashMap();
        r2.clear();
        Object[] r12 = r26.getSpans(r8, r9, TableRowSpan2.class);
        int r13 = r12.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L34;
        TableRowSpan2 r15 = (TableRowSpan2) r12[r14];
        int r5 = r26.getSpanStart(r15);
        Object[] r16 = r3;
        int r17 = r26.getSpanEnd(r15);
        if (r5 < r8) goto L32;
        if (r17 > r9) goto L32;
        r15.getClass();
        List r18 = r15.n;
        Object r19 = r10.get(r18);
        if (r19 != null) goto L23;
        List r20 = r15.n;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L19:
        if (r22.hasNext() == false) goto L21;
        g.b r23 = (g.b) r22.next();
        Iterator r110 = r22;
        g.b r24 = TableRowSpan2.c(r23);
        r11.put(r23, r24);
        r21.add(r24);
        r22 = r110;
        goto L19
    L21:
        r10.put(r18, r21);
        r19 = r21;
    L23:
        List r25 = (List) r19;
        g.b r28 = (g.b) r11.get(r15.o);
        if (r28 != null) goto L27;
        r28 = TableRowSpan2.c(r15.o);
        r11.put(r15.o, r28);
    L27:
        g.b r29 = r28;
        ctc.a r30 = r15.p;
        Object r31 = r2.get(r30);
        if (r31 != null) goto L31;
        ctc.a r32 = r15.p;
        r32.getClass();
        ctc.a r33 = new ctc.a(r32.c);
        r33.b = Math.max(0.0f, r32.b);
        r33.b(r32.a);
        r2.put(r30, r33);
        r31 = r33;
    L31:
        ctc.a r210 = (ctc.a) r31;
        TableRowSpan2 r34 = new TableRowSpan2(r15.l, r15.m, r25, r29, r210);
        r34.b = r15.b;
        b(r26, r1, r15, r34);
    L33:
        r14 = r14 + 1;
        r3 = r16;
        r4 = r4;
        r8 = r8;
        r9 = r9;
    L32:
        r4 = r4;
        r8 = r8;
        r9 = r9;
        goto L33
    L34:
        Object[] r111 = r3;
        int r112 = r4;
        Iterator r35 = r2.entrySet().iterator();
    L36:
        if (r35.hasNext() == false) goto L38;
        Map.Entry r36 = (Map.Entry) r35.next();
        b(r26, r1, (ctc.a) r36.getKey(), (ctc.a) r36.getValue());
        goto L36
    L38:
        r7.getClass();
        b(r26, r1, r7, new s(r7.a));
    L40:
        r6 = r6 + 1;
        r3 = r111;
        r4 = r112;
    L39:
        r111 = r3;
        r112 = r4;
    L41:
        return r1;
    }

    public static void b(SpannableStringBuilder r2, SpannableStringBuilder r3, Object r4, Object r5) {
        int r0 = r2.getSpanStart(r4);
        int r1 = r2.getSpanEnd(r4);
        if (r0 < 0) goto L7;
        if (r1 < r0) goto L8;
        int r6 = r2.getSpanFlags(r4);
        r3.removeSpan(r4);
        r3.setSpan(r5, r0, r1, r6);
        return;
    L8:
        return;
    }
}
