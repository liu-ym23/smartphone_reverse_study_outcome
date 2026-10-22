package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 {
    public final List<t1> a;
    public final List<q1> b;
    public final Map<String, t1> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s1) == true) goto L8;
        return false;
    L8:
        s1 r6 = (s1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "SkillPanelSearchResult(matches=" + this.a + ", groups=" + this.b + ')';
    }

    public s1(List<t1> r3, List<q1> r4) {
        Intrinsics.checkNotNullParameter(r3, "matches");
        Intrinsics.checkNotNullParameter(r4, "groups");
        this.a = r3;
        this.b = r4;
        List<t1> r5 = r3;
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Object r7 = r6.next();
        r0.put(((t1) r7).a.a, r7);
        goto L4
    L6:
        this.c = r0;
    }
}
