package com.larus.bot.impl.feature.edit.feature.firstmet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final boolean a(Triple<String, String, String> r2) {
        if (r2 != null) goto L5;
        return true;
    L5:
        if (StringsKt.isBlank((CharSequence) r2.getFirst()) == false) goto L12;
        if (StringsKt.isBlank((CharSequence) r2.getSecond()) == false) goto L12;
        if (StringsKt.isBlank((CharSequence) r2.getThird()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static final Triple<String, String, String> b(Triple<String, String, String> r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return new Triple("", "", "");
    }

    public static final List<String> c(Triple<String, String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List r4 = TuplesKt.toList(r3);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(StringsKt.trim((String) r5.next()).toString());
        goto L4
    L6:
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (StringsKt.isBlank((String) r2) == true) goto L8;
        r6.add(r2);
        goto L8
    L12:
        return r6;
    }

    public static final Triple<String, String, String> d(List<String> r5) {
        if (r5 == null) goto L14;
        String r1 = (String) CollectionsKt.getOrNull(r5, 0);
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        String r3 = (String) CollectionsKt.getOrNull(r5, 1);
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r6 = (String) CollectionsKt.getOrNull(r5, 2);
        if (r6 == null) goto L13;
        r2 = r6;
    L13:
        Triple r0 = new Triple(r1, r3, r2);
    L16:
        return b(r0);
    L14:
        r0 = null;
        goto L16
    }
}
