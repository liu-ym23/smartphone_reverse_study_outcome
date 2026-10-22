package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(j r6) {
        if ((System.currentTimeMillis() / ((long) 1000)) < r6.h) goto L14;
        List<i> r7 = r6.a;
        if (r7 != null) goto L7;
        return;
    L7:
        int r0 = r7.size();
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L18;
        i r3 = (i) ListProtector.get(r7, r2);
        List<String> r4 = r3.j;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNull(r4);
        r4 = CollectionsKt.mutableListOf(new String[]{(String) CollectionsKt.last(r4)});
    L13:
        r3.j = r4;
        r2 = r2 + 1;
        goto L8
    L18:
        return;
    }

    public static List b(List r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        ArrayList r0 = new ArrayList();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        j r1 = (j) r3.next();
        a(r1);
        r0.add(c(r1));
        goto L4
    L6:
        return r0;
    }

    public static r64.b c(j r9) {
        Intrinsics.checkNotNullParameter(r9, "playRequest");
        a(r9);
        r64.b r0 = new r64.b();
        String r1 = r9.e;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        long r3 = r9.c;
        if (r3 < 0) goto L8;
        long r7 = r9.d;
        if (r7 > 0) goto L7;
    L9:
        r0.a = r3;
        String r2 = r9.e;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
        r0.d = r9.g;
        List<i> r4 = r9.a;
        if (r4 == null) goto L15;
        List<i> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        i r10 = (i) r8.next();
        r64.a r11 = new r64.a(r10.a);
        Intrinsics.checkNotNullParameter(r10.b, "<set-?>");
        r11.a = r10.g;
        Intrinsics.checkNotNullParameter(r10.c, "<set-?>");
        String r12 = r10.i;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.b = r12;
        r11.c = r10.j;
        Intrinsics.checkNotNullParameter(r10.k, "<set-?>");
        r6.add(r11);
    L16:
        r0.c = r6;
        r0.e = r9.j;
        r0.f = null;
        r0.g = r9.l;
        r0.h = r9.m;
        return r0;
    L15:
        r6 = null;
        goto L16
    L7:
        if (r3 <= r7) goto L9;
    L8:
        r3 = 0;
        goto L9
    }
}
