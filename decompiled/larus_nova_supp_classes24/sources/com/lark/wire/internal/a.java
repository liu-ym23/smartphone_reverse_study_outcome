package com.lark.wire.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final void a(List<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (ListProtector.get(r3, r1) == null) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new NullPointerException("Element at index " + r1 + " is null");
    }

    public static final void e(Object... r6) {
        Intrinsics.checkNotNullParameter(r6, "args");
        StringBuilder r0 = new StringBuilder();
        int r1 = ProgressionUtilKt.getProgressionLastElement(0, r6.length - 1, 2);
        String r2 = "";
        if (r1 < 0) goto L17;
        int r4 = 0;
    L6:
        if (r6[r4] == null) goto L8;
    L14:
        if (r4 == r1) goto L17;
        r4 = r4 + 2;
        goto L6
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        r2 = "s";
    L13:
        r0.append("\n  ");
        r0.append(r6[r4 + 1]);
        goto L14
    L10:
        r5 = false;
    L17:
        throw new IllegalStateException("Required field" + r2 + " not set:" + r0.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List, java.util.List<T>] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    public static final <T> List<T> c(String r1, List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "list");
        boolean r0 = r2 instanceof MutableOnWriteList;
        ?? r3 = r2;
        if (r0 == false) goto L6;
        r3 = ((MutableOnWriteList) r2).getMutableList$wire_runtime();
    L6:
        if (((??[int, boolean, OBJECT, ARRAY, byte, short, char]) r3) != CollectionsKt.emptyList()) goto L8;
        return (List<T>) r3;
    L8:
        if ((((??[OBJECT, ARRAY]) r3) instanceof ImmutableList) == true) goto L17;
        AbstractCollection r4 = (List<T>) new ImmutableList((List) r3);
        if ((!r4.contains(null)) == false) goto L14;
        return r4;
    L14:
        throw new IllegalArgumentException(r1.concat(".contains(null)").toString());
    L17:
        return (List<T>) r3;
    }

    public static final <K, V> Map<K, V> d(String r3, Map<K, ? extends V> r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "map");
        if (r4.isEmpty() == true) goto L15;
        LinkedHashMap r0 = new LinkedHashMap(r4);
        Set<K> r5 = r0.keySet();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Collection<K of com.lark.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if ((!r5.contains(null)) == false) goto L14;
        Collection<V> r6 = r0.values();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.Collection<V of com.lark.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if ((!r6.contains(null)) == false) goto L12;
        return Collections.unmodifiableMap(r0);
    L12:
        throw new IllegalArgumentException(r3.concat(".containsValue(null)").toString());
    L14:
        throw new IllegalArgumentException(r3.concat(".containsKey(null)").toString());
    L15:
        return MapsKt.emptyMap();
    }

    public static final int b(Object r1, Object r2, Object r3, Object r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "rest");
        int r0 = 0;
        if (r1 == null) goto L5;
        int r6 = 1;
    L6:
        if (r2 == null) goto L8;
        r6 = r6 + 1;
    L8:
        if (r3 == null) goto L10;
        r6 = r6 + 1;
    L10:
        if (r4 == null) goto L12;
        r6 = r6 + 1;
    L12:
        int r7 = r5.length;
    L13:
        if (r0 >= r7) goto L18;
        if (r5[r0] == null) goto L17;
        r6 = r6 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L18:
        return r6;
    L5:
        r6 = 0;
        goto L6
    }
}
