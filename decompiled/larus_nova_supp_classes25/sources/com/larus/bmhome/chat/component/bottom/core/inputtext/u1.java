package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(String r7, String r8) {
        List r0 = CollectionsKt.createListBuilder();
        int r1 = StringsKt.indexOf$default(r7, r8, 0, true, 2, null);
    L3:
        if (r1 < 0) goto L6;
        int r2 = r8.length() + r1;
        r0.add(new n1(r1, r2));
        r1 = StringsKt.indexOf(r7, r8, r2, true);
        goto L3
    L6:
        return CollectionsKt.build(r0);
    }

    public static List c(p1 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "index");
        Intrinsics.checkNotNullParameter(r4, "query");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        List r1 = a(r3.a, r4);
        if ((true ^ r1.isEmpty()) == false) goto L12;
        return r1;
    L12:
        String r5 = r4.toLowerCase(Locale.ROOT);
        List r2 = b(r3.b, r5, r3.c);
        if (((ArrayList) r2).isEmpty() == true) goto L15;
        return r2;
    L15:
        return b(r3.d, r5, r3.e);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    public static List b(String r6, String r7, List r8) {
        ArrayList r0 = new ArrayList();
        Iterator r9 = a(r6, r7).iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        n1 r10 = (n1) r9.next();
        int r1 = r10.a;
        int r11 = r10.b;
    L6:
        if (r1 >= r11) goto L4;
        n1 r2 = (n1) ListProtector.get(r8, r1);
        n1 r3 = (n1) CollectionsKt.lastOrNull(r0);
        if (r3 != null) goto L10;
    L12:
        r0.add(r2);
    L13:
        r1 = r1 + 1;
        goto L6
    L10:
        if (r2.a > r3.b) goto L12;
        int r4 = CollectionsKt.getLastIndex(r0);
        int r5 = Math.max(r3.b, r2.b);
        ListProtector.set(r0, r4, new n1(r3.a, r5));
        goto L13
    L14:
        return r0;
    }
}
