package com.ttnet.org.chromium.base;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean[] booleanListToBooleanArray(List<Boolean> r8) {
        boolean[] r10 = new boolean[r8.size()];
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L6;
        r10[r11] = r8.get(r11).booleanValue();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public static <T> void forEach(Collection<? extends T> r8, Callback<T> r10) {
        Iterator<? extends T> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.onResult(r11.next());
        goto L4
    }

    public static int[] integerListToIntArray(List<Integer> r8) {
        int[] r10 = new int[r8.size()];
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L6;
        r10[r11] = r8.get(r11).intValue();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public static long[] longListToLongArray(List<Long> r8) {
        long[] r10 = new long[r8.size()];
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L6;
        r10[r11] = r8.get(r11).longValue();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @VisibleForTesting
    public static <E> ArrayList<E> newArrayList(Iterable<E> r8) {
        ArrayList<E> r10 = new ArrayList();
        Iterator<E> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(r11.next());
        goto L4
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... r8) {
        s6.a.C0154a r10 = (HashMap<K, V>) new HashMap();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Pair<? extends K, ? extends V> r13 = r8[r12];
        r10.put(r13.first, r13.second);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... r8) {
        HashSet<E> r10 = new HashSet(r8.length);
        Collections.addAll(r10, r8);
        return r10;
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> r8, Callback<Map.Entry<K, V>> r10) {
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.onResult(r11.next());
        goto L4
    }

    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... r8) {
        ArrayList<E> r10 = new ArrayList(r8.length);
        Collections.addAll(r10, r8);
        return r10;
    }
}
