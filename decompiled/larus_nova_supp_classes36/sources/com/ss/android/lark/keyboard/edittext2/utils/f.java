package com.ss.android.lark.keyboard.edittext2.utils;

import android.text.Spannable;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lec.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public interface a extends com.ss.android.lark.widget.richtext.a {
        RichTextElement a(Object r1);
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Map a;

        public b(Map r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Pair r5 = (Pair) this.a.get(r3);
            Integer r0 = null;
            if (r5 == null) goto L5;
            Integer r6 = (Integer) r5.getFirst();
        L6:
            Pair r7 = (Pair) this.a.get(r4);
            if (r7 == null) goto L10;
            r0 = (Integer) r7.getFirst();
        L10:
            return ComparisonsKt.compareValues(r6, r0);
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public static List b(CharSequence r7) {
        Intrinsics.checkNotNullParameter(r7, "content");
        if (KeyboardBaseModule.a().isFeatureGatingEnable("mesenger.richtext.text_parse_v2") == true) goto L5;
        Map r1 = RichTextElementCreator.a;
        Intrinsics.checkNotNullParameter(r7, "content");
        int r2 = 0;
        if (r7.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return CollectionsKt.emptyList();
    L13:
        if (r7.length() == 1) goto L15;
    L17:
        LinkedList r3 = new LinkedList();
        char r4 = StringsKt.first(r7);
        char r5 = StringsKt.last(r7);
        int r6 = r7.length();
        if (r4 != '\n') goto L20;
        r2 = 1;
    L20:
        if (r5 != '\n') goto L22;
        r6 = r6 - 1;
    L22:
        if (r4 != '\n') goto L24;
        r3.add(RichTextElementCreator.d());
    L24:
        CharSequence r8 = r7.subSequence(r2, r6);
        if ((r8 instanceof Spannable) == true) goto L27;
        r3.add(RichTextElementCreator.e(r8.toString()));
    L28:
        if (r5 != '\n') goto L31;
        r3.add(RichTextElementCreator.d());
    L31:
        return r3;
    L27:
        r3.addAll(g.b((Spannable) r8));
        goto L28
    L15:
        if (r7.charAt(0) != '\n') goto L17;
        return CollectionsKt.listOf(RichTextElementCreator.d());
    L9:
        r0 = false;
        goto L10
    L5:
        return RichTextElementCreator.f(r7);
    }

    public static List c(CharSequence r13, a r14) {
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r14, "handler");
        boolean r1 = false;
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if ((r13 instanceof Spannable) == false) goto L12;
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r14.e((Spanned) r13, r3);
        Pair r4 = d((Spannable) r13, r3, r14);
        Map r5 = (Map) r4.component1();
        List r6 = (List) r4.component2();
        int r7 = r13.length();
        int r8 = r6.size();
        int r9 = 0;
        int r10 = 0;
    L14:
        if (r9 >= r8) goto L47;
        Pair r11 = a(r5, r6, r9);
        if (r11 == null) goto L23;
        CharSequence r12 = r13.subSequence(((Number) r11.getFirst()).intValue(), ((Number) r11.getSecond()).intValue());
        if (r12.length() <= 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        r2.addAll(b(r12));
        goto L23
    L20:
        r15 = false;
    L23:
        Pair r16 = (Pair) r5.get(ListProtector.get(r6, r9));
        if (r16 == null) goto L26;
        int r17 = ((Number) r16.getFirst()).intValue();
    L27:
        Pair r18 = (Pair) r5.get(ListProtector.get(r6, r9));
        if (r18 == null) goto L30;
        int r19 = ((Number) r18.getSecond()).intValue();
    L31:
        RichTextElement r110 = r14.a(ListProtector.get(r6, r9));
        if (r110 == null) goto L45;
        if (r17 < 0) goto L44;
        if (r19 > r7) goto L44;
        if (r19 <= r17) goto L44;
        Map r20 = g.d(r13.subSequence(r17, r19));
        if (r20 != null) goto L39;
    L41:
        boolean r111 = false;
    L42:
        if (r111 == false) goto L44;
        r110.setStyle(r20);
        goto L44
    L39:
        if ((!((HashMap) r20).isEmpty()) != true) goto L41;
        r111 = true;
    L44:
        r2.add(r110);
    L46:
        r10 = Math.max(r10, r19);
        r9 = r9 + 1;
        goto L14
    L45:
        Log.e("RichTextGenerateUtils", "generate richtext, element is null");
        goto L46
    L30:
        r19 = 0;
        goto L31
    L26:
        r17 = 0;
        goto L27
    L47:
        CharSequence r112 = r13.subSequence(r10, r13.length());
        if (r112.length() <= 0) goto L50;
        r1 = true;
    L50:
        if (r1 == false) goto L52;
        r2.addAll(b(r112));
    L52:
        return r2;
    L12:
        return b(r13);
    L5:
        r0 = false;
        goto L6
    }

    public static Pair a(Map r2, List r3, int r4) {
        if (r4 >= 0) goto L5;
        return null;
    L5:
        Pair r1 = (Pair) r2.get(CollectionsKt.getOrNull(r3, r4 - 1));
        if (r1 == null) goto L8;
        int r5 = ((Number) r1.getSecond()).intValue();
    L9:
        Pair r6 = (Pair) r2.get(CollectionsKt.getOrNull(r3, r4));
        if (r6 == null) goto L19;
        int r7 = ((Number) r6.getFirst()).intValue();
        int r8 = r7 - r5;
        if (r8 != 0) goto L14;
        return null;
    L14:
        if (r8 >= 0) goto L18;
        Log.e("RichTextGenerateUtils", "generateRichText: subLen <= 0 , index is " + r4);
        return null;
    L18:
        return TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r7));
    L19:
        return null;
    L8:
        r5 = 0;
        goto L9
    }

    public static Pair d(Spannable r10, List r11, com.ss.android.lark.widget.richtext.a r12) {
        List r0 = CollectionsKt.toMutableList(r11);
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator r2 = r11.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        int r4 = r10.getSpanStart(r3);
        int r5 = r10.getSpanEnd(r3);
        if (r12.c(r10, r3, r4, r5) == false) goto L8;
        r4 = r10.getSpanStart(r3);
        r5 = r10.getSpanEnd(r3);
    L8:
        r1.put(r3, TuplesKt.to(Integer.valueOf(r4), Integer.valueOf(r5)));
        goto L4
    L10:
        if (r0.size() <= 1) goto L12;
        CollectionsKt.sortWith(r0, new b(r1));
    L12:
        ArrayList r13 = new ArrayList();
        Iterator r6 = r0.iterator();
        int r7 = -1;
        int r8 = -1;
    L14:
        if (r6.hasNext() == false) goto L29;
        Object r9 = r6.next();
        Pair r14 = (Pair) r1.get(r9);
        if (r14 != null) goto L18;
        r14 = TuplesKt.to(-1, -1);
    L18:
        int r15 = ((Number) r14.component1()).intValue();
        int r16 = ((Number) r14.component2()).intValue();
        boolean r17 = false;
        if (r15 == (-1)) goto L22;
        if (r16 == (-1)) goto L22;
        boolean r18 = true;
    L23:
        if (r7 > r15) goto L26;
        if (r15 >= r8) goto L26;
        r17 = true;
    L26:
        if (r18 == false) goto L14;
        if (r17 == true) goto L14;
        r13.add(r9);
        r8 = r16;
        r7 = r15;
    L22:
        r18 = false;
        goto L23
    L29:
        Log.i("RichTextGenerateUtils", "getValidSpanAndIndex: spans count : " + ((ArrayList) r11).size() + " , valid spans count: " + r13.size());
        return TuplesKt.to(r1, r13);
    }
}
