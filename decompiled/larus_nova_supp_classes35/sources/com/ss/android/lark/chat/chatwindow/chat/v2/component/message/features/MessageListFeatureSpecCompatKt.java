package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.x0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t6b.e;
import t6b.g;
import t6b.i;
import t6b.k;
import t6b.m;
import t6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListFeatureSpecCompatKt {
    public static final o a(x0 r24) {
        Intrinsics.checkNotNullParameter(r24, "<this>");
        o r1 = new o(r24);
        boolean r4 = !r24.q;
        long r6 = r24.h;
        Map r8 = MapsKt.emptyMap();
        List r9 = CollectionsKt.emptyList();
        FirstMessagePaddingType r12 = r24.j;
        a1 r13 = r24.k;
        v4b.c r15 = r24.r;
        Set r2 = r24.i.entrySet();
        LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) r3.next();
        Pair r11 = TuplesKt.to(r10.getKey(), r10.getValue());
        r14.put(r11.getFirst(), r11.getSecond());
        goto L4
    L6:
        r1.a(new k(false, r4, null, r6, r8, r9, null, null, r12, r13, null, r15, r14, null, r24.w, null, null, 409604));
        r1.a(new t6b.a(r24.a, r24.b, r24.c, r24.d, r24.s));
        r1.a(new t6b.c(r24.e, r24.g, r24.l, r24.o, r24.v, r24.w, 1088));
        List r5 = CollectionsKt.emptyList();
        boolean r7 = r24.t;
        List r16 = r24.u;
        if (r16 != null) goto L9;
        r16 = CollectionsKt.emptyList();
    L9:
        r1.a(new g(r5, r7, r16, 56));
        r1.a(new i(r24.f));
        r1.a(new m(r24.k, r24.m, r24.p, false));
        r1.a(new e(null, null, null));
        return r1;
    }
}
