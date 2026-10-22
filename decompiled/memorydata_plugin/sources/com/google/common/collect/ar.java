package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4664a = null;

    static {
        f4664a = Logger.getLogger(ar.class.getName());
    }

    private ar() {
    }

    static MapMaker a(MapMaker r0) {
        return r0.d();
    }

    static <E extends Enum<E>> Class<E> a(E r0) {
        return r0.getDeclaringClass();
    }

    static <K, V> Map<K, V> a() {
        return Maps.d();
    }

    static <K, V> Map<K, V> a(int r0) {
        return Maps.a(r0);
    }

    static <T> T[] a(T[] r1, int r2) {
        if (r1.length == 0) goto L7;
        r1 = (T[]) Arrays.copyOf(r1, 0);
    L7:
        return (T[]) Arrays.copyOf(r1, r2);
    }

    static <T> T[] a(Object[] r0, int r1, int r2, T[] r3) {
        return (T[]) Arrays.copyOfRange(r0, r1, r2, r3.getClass());
    }

    static <K, V> Map<K, V> b(int r0) {
        return Maps.c(r0);
    }

    static <E> Set<E> b() {
        return Sets.b();
    }

    static <E> Set<E> c(int r0) {
        return Sets.a(r0);
    }

    static <E> Set<E> d(int r0) {
        return Sets.b(r0);
    }
}
