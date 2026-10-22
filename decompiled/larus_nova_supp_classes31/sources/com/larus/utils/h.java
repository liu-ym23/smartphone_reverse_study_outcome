package com.larus.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public static final <E> List<E> d(List<? extends E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Collections.unmodifiableList(r1);
    }

    public static final <T> boolean a(List<? extends T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= r1.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static final <T> List<T> b(List<? extends T> r4, Function1<? super T, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "predicate");
        ArrayList r0 = new ArrayList();
        Iterator<? extends T> r6 = r4.iterator();
        boolean r1 = false;
    L4:
        if (r6.hasNext() == false) goto L11;
        T r2 = r6.next();
        if (r1 == true) goto L10;
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L10;
        r1 = true;
    L10:
        r0.add(r2);
        goto L4
    L11:
        return r0;
    }

    public static final <K, V> Map<K, V> c(Map<K, V> r1, Pair<? extends K, ? extends V>... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "pairs");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r1);
        MapsKt.putAll(r0, r2);
        return r0;
    }

    public static final <E> boolean e(Collection<E> r2, Function1<? super E, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "filter");
        Iterator<E> r4 = r2.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (((Boolean) r3.invoke(r4.next())).booleanValue() == false) goto L4;
        r4.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static final <T> int f(List<? extends T> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return r3;
    L10:
        if (r3 >= 0) goto L13;
        return 0;
    L13:
        return CollectionsKt.getLastIndex(r2);
    L5:
        if (r3 >= r2.size()) goto L7;
        r1 = true;
        goto L8
    }

    public static final <E> int g(Collection<E> r3, Function1<? super E, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "filter");
        monitor-enter(r3);
        Iterator<T> r0 = r3.iterator();     // Catch: Throwable -> L17
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L14;
        Object r2 = r0.next();     // Catch: Throwable -> L17
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L17
    L11:
        if (((Boolean) r4.invoke(r2)).booleanValue() == true) goto L15;
        r1 = r1 + 1;
    L15:
        monitor-exit(r3);
        return r1;
    L14:
        r1 = -1;
    L17:
        th = move-exception;
        throw th;
    }

    public static final <E> boolean h(Collection<E> r1, Function1<? super E, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "filter");
        monitor-enter(r1);
        boolean r3 = e(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static final <T> List<T> i(List<? extends T> r2, Function1<? super T, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Iterator<? extends T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        T r0 = r4.next();
        if (((Boolean) r3.invoke(r0)).booleanValue() == false) goto L4;
        return CollectionsKt.listOf(r0);
    L10:
        return CollectionsKt.emptyList();
    }
}
