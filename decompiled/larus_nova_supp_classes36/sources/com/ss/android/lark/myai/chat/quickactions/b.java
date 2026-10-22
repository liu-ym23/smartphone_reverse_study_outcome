package com.ss.android.lark.myai.chat.quickactions;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final QuickActionParamSpan a;
        public final int b;
        public final int c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "QuickActionParamSpanInfo(span=" + this.a + ", start=" + this.b + ", end=" + this.c + ')';
        }

        public a(QuickActionParamSpan r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "span");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.quickactions.b$b, reason: collision with other inner class name */
    public static final class C0195b<T> implements Comparator {
        public C0195b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((a) r1).b), Integer.valueOf(((a) r2).b));
        }
    }

    static {
    }

    public static Map a(SpannableStringBuilder r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        LinkedHashMap r0 = new LinkedHashMap();
        Object[] r1 = r11.getSpans(0, r11.length(), QuickActionParamSpan.class);
        ArrayList r2 = new ArrayList(r1.length);
        int r4 = r1.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        QuickActionParamSpan r6 = (QuickActionParamSpan) r1[r5];
        r2.add(new a(r6, r11.getSpanStart(r6), r11.getSpanEnd(r6)));
        r5 = r5 + 1;
        goto L3
    L5:
        ArrayList r3 = new ArrayList();
        Iterator r7 = r2.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        Object r8 = r7.next();
        a r9 = (a) r8;
        int r10 = r9.b;
        if (r10 < 0) goto L14;
        int r12 = r9.c;
        if (r12 < 0) goto L14;
        if (r12 < r10) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L7;
        r3.add(r8);
    L14:
        r13 = false;
        goto L15
    L17:
        List r14 = CollectionsKt.sortedWith(r3, new C0195b());
        int r15 = r14.size();
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L30;
        a r17 = (a) ListProtector.get(r14, r16);
        r16 = r16 + 1;
        a r18 = (a) CollectionsKt.getOrNull(r14, r16);
        if (r18 == null) goto L22;
        int r19 = r18.b;
    L24:
        if (r17.c == r19) goto L25;
        IntRange r20 = new IntRange(r17.c, r19);
        if (((QuickActionParamPlaceholderSpan) ArraysKt.getOrNull(r11.getSpans(r20.getFirst(), r20.getLast(), QuickActionParamPlaceholderSpan.class), 0)) != null) goto L28;
        r0.put(r17.a.a, r11.subSequence(r20.getFirst(), r20.getLast()));
        goto L18
    L28:
        r0.put(r17.a.a, "");
        goto L18
    L25:
        r0.put(r17.a.a, "");
        goto L18
    L22:
        r19 = r11.length();
        goto L24
    L30:
        return r0;
    }
}
