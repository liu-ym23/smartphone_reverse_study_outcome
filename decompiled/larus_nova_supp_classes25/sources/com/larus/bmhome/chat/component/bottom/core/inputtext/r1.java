package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((be8.b) r1).l, ((be8.b) r2).l);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((be8.b) r2).j, ((be8.b) r1).j);
        }
    }

    public static final List<be8.b> b(List<be8.b> r4, List<be8.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "current");
        Intrinsics.checkNotNullParameter(r5, "refreshed");
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator<T> r0 = r5.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r2 = r0.next();
        r1.put(((be8.b) r2).a, r2);
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        be8.b r7 = (be8.b) r1.get(((be8.b) r6.next()).a);
        if (r7 == null) goto L8;
        r3.add(r7);
        goto L8
    L12:
        HashSet r8 = new HashSet();
        Iterator r9 = r3.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        r8.add(((be8.b) r9.next()).a);
        goto L14
    L16:
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L18:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if (r8.contains(((be8.b) r12).a) == true) goto L18;
        r10.add(r12);
        goto L18
    L23:
        return CollectionsKt.plus(r3, r10);
    }

    public static final List<q1> a(Context r17, List<be8.b> r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "skills");
        Intrinsics.checkNotNullParameter(r19, "query");
        if (r19.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        List r2 = CollectionsKt.createListBuilder();
        List<be8.b> r3 = r18;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L15:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (((be8.b) r7).j == null) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
        r5.add(r7);
        goto L15
    L19:
        r8 = false;
        goto L20
    L22:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r5.iterator();
    L24:
        if (r10.hasNext() == false) goto L31;
        Object r11 = r10.next();
        if (((be8.b) r11).l != null) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L24;
        r9.add(r11);
        goto L24
    L28:
        r12 = false;
        goto L29
    L31:
        List r13 = CollectionsKt.sortedWith(r9, new b());
        ArrayList r14 = new ArrayList();
        Iterator r15 = r5.iterator();
    L33:
        if (r15.hasNext() == false) goto L40;
        Object r16 = r15.next();
        if (((be8.b) r16).l == null) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L33;
        r14.add(r16);
        goto L33
    L37:
        r110 = false;
        goto L38
    L40:
        List r111 = CollectionsKt.plus(r13, CollectionsKt.sortedWith(r14, new a()));
        if ((!r5.isEmpty()) == true) goto L43;
    L54:
        boolean r20 = false;
    L55:
        if (r20 == false) goto L58;
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        r2.add(new q1(String.format(r17.getString(2131906730), Arrays.copyOf(new Object[]{Integer.valueOf(r5.size())}, 1)), r111, true, false, 8));
    L77:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator<T> r4 = r3.iterator();
    L79:
        if (r4.hasNext() == false) goto L87;
        Object r23 = r4.next();
        String r24 = ((be8.b) r23).i;
        if (r24 != null) goto L83;
        r24 = "";
    L83:
        Object r25 = r22.get(r24);
        if (r25 != null) goto L86;
        r25 = new ArrayList();
        r22.put(r24, r25);
    L86:
        ((List) r25).add(r23);
        goto L79
    L87:
        Iterator r26 = r22.entrySet().iterator();
    L89:
        if (r26.hasNext() == false) goto L99;
        Map.Entry r27 = (Map.Entry) r26.next();
        String r28 = (String) r27.getKey();
        List r29 = (List) r27.getValue();
        if (r28.length() != 0) goto L93;
        boolean r30 = true;
    L94:
        if (r30 == false) goto L96;
        StringCompanionObject r31 = StringCompanionObject.INSTANCE;
        String r32 = String.format(r17.getString(2131906733), Arrays.copyOf(new Object[]{Integer.valueOf(r29.size())}, 1));
    L97:
        r2.add(new q1(r32, r29, false, false, 12));
        goto L89
    L96:
        r32 = r28 + " (" + r29.size() + ')';
        goto L97
    L93:
        r30 = false;
        goto L94
    L99:
        return CollectionsKt.build(r2);
    L58:
        if ((!r5.isEmpty()) == false) goto L77;
        Iterator<T> r33 = r3.iterator();
    L60:
        Integer r34 = null;
        if (r33.hasNext() == false) goto L65;
        Integer r35 = ((be8.b) r33.next()).m;
        if (r35 == null) goto L60;
    L66:
        if (r35 != null) goto L68;
    L75:
        int r36 = 5;
    L76:
        List r112 = CollectionsKt.take(r111, r36);
        StringCompanionObject r37 = StringCompanionObject.INSTANCE;
        r2.add(new q1(String.format(r17.getString(2131906728), Arrays.copyOf(new Object[]{Integer.valueOf(r112.size())}, 1)), r112, false, true, 4));
        goto L77
    L68:
        if (r35.intValue() < 0) goto L70;
        boolean r38 = true;
    L71:
        if (r38 == false) goto L73;
        r34 = r35;
    L73:
        if (r34 == null) goto L75;
        r36 = r34.intValue();
        goto L76
    L70:
        r38 = false;
        goto L71
    L65:
        r35 = null;
        goto L66
    L43:
        if (r5.isEmpty() == true) goto L51;
        Iterator r39 = r5.iterator();
    L47:
        if (r39.hasNext() == false) goto L51;
        if (((be8.b) r39.next()).k == true) goto L47;
        boolean r40 = false;
    L52:
        if (r40 == false) goto L54;
        r20 = true;
    L51:
        r40 = true;
        goto L52
    L8:
        if (r18.isEmpty() == false) goto L12;
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.listOf(new q1(r17.getString(2131906731), r18, false, false, 12));
    L5:
        r1 = false;
        goto L6
    }
}
