package com.larus.chat.job.impl.page.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Set r6) {
        Intrinsics.checkNotNullParameter(r6, "weekdays");
        ChatJobEditWeekday[] r0 = ChatJobEditWeekday.values();
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        ChatJobEditWeekday r4 = r0[r3];
        if (r6.contains(r4) == false) goto L7;
        r1.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r7.add(((ChatJobEditWeekday) r5.next()).getLabel());
        goto L10
    L12:
        gz8.d.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "labels");
        return gz8.f.h(r7);
    }
}
