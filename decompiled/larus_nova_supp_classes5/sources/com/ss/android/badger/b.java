package com.ss.android.badger;

import com.bytedance.badger.network.a0;
import com.bytedance.badger.network.b0;
import com.bytedance.badger.network.v;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.ss.android.account.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import wqa.f;
import wqa.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements v {
    public b() {
    }

    public final String getHost() {
        f r0 = k.b;
        if (r0 == null) goto L7;
        String r1 = r0.S();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public final b0 a(a0 r7) {
        String r0 = r7.a;
        List r8 = r7.b;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Pair r3 = (Pair) r9.next();
        r1.add(new i((String) r3.getFirst(), (String) r3.getSecond()));
        goto L4
    L6:
        sa7.k r10 = k.d().a();
        boolean r4 = false;
        if (r10 == null) goto L9;
        wqa.k r11 = r10.e(r0, r1, 0);
    L10:
        int r2 = r11.a;
        if (r2 >= 200) goto L13;
    L15:
        List r5 = r11.b;
        if (r5 == null) goto L21;
        List r6 = r5;
        ?? r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r13 = r6.iterator();
    L19:
        if (r13.hasNext() == false) goto L23;
        i r14 = (i) r13.next();
        r12.add(TuplesKt.to(r14.a, r14.b));
    L23:
        return new b0(r4, r2, r12, r11.c);
    L21:
        r12 = CollectionsKt.emptyList();
        goto L23
    L13:
        if (r2 >= 300) goto L15;
        r4 = true;
        goto L15
    L9:
        r11 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    public final b0 b(a0 r8) {
        String r0 = r8.a;
        Map r1 = r8.c;
        List r9 = r8.b;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Pair r4 = (Pair) r10.next();
        r2.add(new i((String) r4.getFirst(), (String) r4.getSecond()));
        goto L4
    L6:
        wqa.k r11 = NetworkUtils.b(r0, r1, r2);
        int r3 = r11.a;
        if (r3 >= 200) goto L9;
    L11:
        boolean r5 = false;
    L12:
        List r6 = r11.b;
        if (r6 == null) goto L18;
        List r7 = r6;
        ?? r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r13 = r7.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        i r14 = (i) r13.next();
        r12.add(TuplesKt.to(r14.a, r14.b));
    L20:
        return new b0(r5, r3, r12, r11.c);
    L18:
        r12 = CollectionsKt.emptyList();
        goto L20
    L9:
        if (r3 >= 300) goto L11;
        r5 = true;
        goto L12
    }
}
