package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public final Message a;
    public final String b;
    public final f0 c;
    public final Map<String, fn8.c> d;
    public final Map<String, Integer> e;
    public final Map<String, Integer> f;
    public final Map<String, kc8.d0> g;

    public final void a() {
        Iterator r0 = ((LinkedHashMap) this.g).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((kc8.d0) r0.next()).recycle();
        goto L4
    L6:
        ((LinkedHashMap) this.g).clear();
    }

    public b0(Message r5, String r6, f0 r7, List<fn8.c> r8) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r8, "items");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        List<fn8.c> r9 = r8;
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r0 = r11.next();
        r10.put(((fn8.c) r0).a, r0);
        goto L4
    L6:
        this.d = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r13 = r9.iterator();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r13.hasNext() == false) goto L13;
        Object r3 = r13.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r12.add(TuplesKt.to(((fn8.c) r3).a, Integer.valueOf(r4)));
        r2 = r4;
        goto L8
    L13:
        this.e = MapsKt.toMap(r12);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r9.iterator();
    L15:
        if (r15.hasNext() == false) goto L24;
        fn8.c r16 = (fn8.c) r15.next();
        fn8.b r17 = r16.h;
        Pair r18 = null;
        if ((r17 instanceof fn8.b.a) == false) goto L19;
        fn8.b.a r19 = (fn8.b.a) r17;
    L20:
        if (r19 == null) goto L22;
        r18 = TuplesKt.to(r16.a, r19.a);
    L22:
        if (r18 == null) goto L15;
        r14.add(r18);
        goto L15
    L19:
        r19 = null;
        goto L20
    L24:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r21 = r14.iterator();
    L26:
        if (r21.hasNext() == false) goto L31;
        Object r22 = r21.next();
        int r23 = r1 + 1;
        if (r1 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        r20.add(TuplesKt.to((String) ((Pair) r22).component1(), Integer.valueOf(r1)));
        r1 = r23;
        goto L26
    L31:
        this.f = MapsKt.toMap(r20);
        this.g = new LinkedHashMap();
    }
}
