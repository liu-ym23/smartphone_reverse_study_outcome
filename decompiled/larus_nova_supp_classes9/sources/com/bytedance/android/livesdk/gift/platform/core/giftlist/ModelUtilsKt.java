package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.c3;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.q1;
import com.bytedance.android.livesdk.gift.model.r1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.z2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ModelUtilsKt {
    public static final j d(w1 r23) {
        Intrinsics.checkNotNullParameter(r23, "$this$toPageModel");
        int r3 = r23.getPageType();
        String r4 = r23.getPageName();
        boolean r5 = r23.getDisplay();
        String r6 = r23.getEventName();
        py.k r7 = r23.getBackgroundImage();
        py.k r8 = r23.getReceiversModBg();
        py.k r9 = r23.getReceiversLongModBg();
        List<c3> r0 = r23.getSectionList();
        if (r0 == null) goto L12;
        List<c3> r1 = r0;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        c3 r11 = (c3) r2.next();
        Intrinsics.checkNotNullParameter(r11, "$this$toSectionInfo");
        int[] r14 = CollectionsKt.toIntArray(r11.f());
        int[] r15 = CollectionsKt.toIntArray(r11.e());
        py.k r16 = r11.g();
        String r17 = r11.c();
        py.k r18 = r11.a();
        List<h1> r13 = r11.d();
        Iterator r24 = r2;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r20 = r13.iterator();
    L9:
        if (r20.hasNext() == false) goto L11;
        r19.add(Long.valueOf(((h1) r20.next()).getId()));
        goto L9
    L11:
        r10.add(new s(r14, r15, r16, r17, r18, r19, r11.h(), r11.b()));
        r2 = r24;
    L13:
        x2 r110 = r23.getPageInfo();
        b3 r111 = r23.getPageNameStyleInfo();
        z2 r112 = r23.getLynxConfig();
        List<h1> r21 = r23.getGifts();
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r25 = r21.iterator();
    L15:
        if (r25.hasNext() == false) goto L17;
        r113.add(Long.valueOf(((h1) r25.next()).getId()));
        goto L15
    L17:
        List<c1> r26 = r23.getBaseGifts();
        if (r26 == null) goto L23;
        List<c1> r27 = r26;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<T> r28 = r27.iterator();
    L21:
        if (r28.hasNext() == false) goto L25;
        r114.add(Long.valueOf(((c1) r28.next()).getId()));
    L25:
        return new j(r3, r4, r5, r6, r7, r8, r9, r10, r110, r111, r112, CollectionsKt.plus(r113, r114), r23.getBaseGifts(), r23.getTopicList(), r23.getPageSortStrategy(), r23.getScrollPageNames(), r23.getForceInsertMap());
    L23:
        r114 = new ArrayList();
        goto L25
    L12:
        r10 = null;
        goto L13
    }

    public static final py.k a(c1 r2, q1 r3) {
        Integer r0 = null;
        if (r2 == null) goto L17;
        Map<Integer, r1> r4 = r2.getGiftImageGroupMap();
        if (r4 == null) goto L18;
        if (r3 == null) goto L8;
        Integer r1 = Integer.valueOf(r3.getImageType());
    L9:
        r1 r5 = r4.get(r1);
        if (r5 == null) goto L19;
        Map<Integer, py.k> r6 = r5.getGiftImageMap();
        if (r6 == null) goto L20;
        if (r3 == null) goto L16;
        r0 = Integer.valueOf(r3.getGroupId());
    L16:
        return r6.get(r0);
    L20:
        return null;
    L19:
        return null;
    L8:
        r1 = null;
        goto L9
    L18:
        return null;
    L17:
        return null;
    }

    public static final j b(final j r38, final Function1<? super h1, Boolean> r39, Function2<? super Long, ? super Integer, ? extends h1> r40) {
        final Function2<? super Long, ? super Integer, ? extends h1> r2 = r40;
        String r3 = "$this$toFilterModel";
        Intrinsics.checkNotNullParameter(r38, "$this$toFilterModel");
        String r4 = "filter";
        Intrinsics.checkNotNullParameter(r39, "filter");
        String r5 = "transform";
        Intrinsics.checkNotNullParameter(r2, "transform");
        int r7 = r38.a;
        String r8 = r38.b;
        boolean r9 = r38.c;
        String r10 = r38.d;
        py.k r11 = r38.e;
        py.k r13 = r38.f;
        py.k r14 = r38.g;
        x2 r15 = r38.i;
        b3 r16 = r38.j;
        z2 r6 = r38.k;
        List r18 = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r38.l), new ModelUtilsKt$toFilterModel$2(r38, r2, r39)));
        List<s> r17 = r38.h;
        if (r17 == null) goto L9;
        List<s> r19 = r17;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r20 = r19.iterator();
    L6:
        if (r20.hasNext() == false) goto L8;
        s r111 = (s) r20.next();
        Iterator r112 = r20;
        final Function1<Long, h1> r21 = new ModelUtilsKt$toFilterModel$$inlined$map$lambda$1(r38, r39, r2);
        Intrinsics.checkNotNullParameter(r111, r3);
        Intrinsics.checkNotNullParameter(r39, r4);
        Intrinsics.checkNotNullParameter(r21, r5);
        r110.add(new s(r111.a, r111.b, r111.c, r111.d, r111.e, SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r111.f), new ModelUtilsKt$toFilterModel$5(r21, r39))), r111.g, r111.h));
        r2 = r40;
        r20 = r112;
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r14 = r14;
        r13 = r13;
        r11 = r11;
        r10 = r10;
        goto L6
    L8:
        String r37 = r10;
        py.k r36 = r11;
        py.k r35 = r13;
        py.k r34 = r14;
    L11:
        return new j(r7, r8, r9, r37, r36, r35, r34, r110, r15, r16, r6, r18, r38.m, r38.n, r38.o, r38.p, r38.q);
    L9:
        r37 = r10;
        r36 = r11;
        r35 = r13;
        r34 = r14;
        r110 = null;
        goto L11
    }

    public static final w1 c(final j r13, final Function2<? super Long, ? super Integer, ? extends h1> r14, final Function2<? super List<h1>, ? super Integer, ? extends List<h1>> r15, final Function1<? super h1, Boolean> r16) {
        Intrinsics.checkNotNullParameter(r13, "$this$toGiftPage");
        Intrinsics.checkNotNullParameter(r14, "transform");
        Intrinsics.checkNotNullParameter(r15, "changePostion");
        Intrinsics.checkNotNullParameter(r16, "filter");
        w1 r1 = (w1) vh7.f.c(w1.class);
        r1.setPageType(r13.a);
        r1.setPageName(r13.b);
        r1.setDisplay(r13.c);
        r1.setEventName(r13.d);
        r1.setBackgroundImage(r13.e);
        r1.setReceiversModBg(r13.f);
        r1.setReceiversLongModBg(r13.g);
        r1.setPageInfo(r13.i);
        r1.setPageNameStyleInfo(r13.j);
        r1.setLynxConfig(r13.k);
        List<s> r2 = r13.h;
        List<? extends c1> r3 = null;
        if (r2 == null) goto L14;
        List<s> r4 = r2;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        s r7 = (s) r6.next();
        Function1<Long, h1> r8 = new ModelUtilsKt$toGiftPage$$inlined$also$lambda$1(r13, r14, r16, r15);
        Intrinsics.checkNotNullParameter(r7, "$this$toPageSectionInfo");
        Intrinsics.checkNotNullParameter(r8, "transform");
        c3 r9 = new c3();
        r9.n(ArraysKt.toList(r7.a));
        r9.m(ArraysKt.toList(r7.b));
        r9.o(r7.c);
        r9.i(r7.e);
        List<Long> r10 = r7.f;
        ArrayList r11 = new ArrayList();
        Iterator<T> r17 = r10.iterator();
    L9:
        if (r17.hasNext() == false) goto L13;
        h1 r18 = (h1) r8.invoke(Long.valueOf(((Number) r17.next()).longValue()));
        if (r18 == null) goto L9;
        r11.add(r18);
        goto L9
    L13:
        r9.l(r11);
        r9.p(r7.g);
        r9.j(r7.h);
        r9.k(r7.d);
        r5.add(r9);
    L15:
        r1.setSectionList(r5);
        List<Long> r0 = r13.l;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r0.iterator();
    L17:
        if (r20.hasNext() == false) goto L21;
        h1 r21 = (h1) r14.invoke(Long.valueOf(((Number) r20.next()).longValue()), Integer.valueOf(r1.getPageType()));
        if (r21 == null) goto L17;
        r19.add(r21);
        goto L17
    L21:
        List r110 = CollectionsKt.toMutableList(r19);
        ArrayList r23 = new ArrayList();
        Iterator r111 = r110.iterator();
    L23:
        if (r111.hasNext() == false) goto L27;
        Object r24 = r111.next();
        if (((Boolean) r16.invoke((h1) r24)).booleanValue() == false) goto L23;
        r23.add(r24);
        goto L23
    L27:
        r1.setGifts((List) r15.invoke(CollectionsKt.toMutableList(r23), Integer.valueOf(r13.a)));
        List<c1> r112 = r13.m;
        if (r112 == null) goto L30;
        r3 = CollectionsKt.toMutableList(r112);
    L30:
        r1.setBaseGifts(r3);
        List<d2> r113 = r13.n;
        if (r113 != null) goto L33;
        r113 = CollectionsKt.emptyList();
    L33:
        r1.setTopicList(r113);
        r1.setPageSortStrategy(r13.o);
        r1.setScrollPageNames(r13.p);
        r1.setForceInsertMap(r13.q);
        return r1;
    L14:
        r5 = null;
        goto L15
    }
}
