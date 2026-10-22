package com.ttnet.org.chromium.base;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.lang.ref.WeakReference;
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

    public static boolean[] booleanListToBooleanArray(@NonNull List<Boolean> r10) {
        boolean[] r11 = new boolean[r10.size()];
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        r11[r12] = r10.get(r12).booleanValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static <T> void forEach(Collection<? extends T> r10, Callback<T> r11) {
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.onResult(r12.next());
        goto L4
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> r10, Callback<Map.Entry<K, V>> r11) {
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.onResult(r12.next());
        goto L4
    }

    public static int[] integerListToIntArray(@NonNull List<Integer> r10) {
        int[] r11 = new int[r10.size()];
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        r11[r12] = r10.get(r12).intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static long[] longListToLongArray(@NonNull List<Long> r10) {
        long[] r11 = new long[r10.size()];
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        r11[r12] = r10.get(r12).longValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... r10) {
        LruCache r11 = (HashMap<K, V>) new HashMap();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Pair<? extends K, ? extends V> r14 = r10[r13];
        r11.put(r14.first, r14.second);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... r10) {
        HashSet<E> r11 = new HashSet(r10.length);
        Collections.addAll(r11, r10);
        return r11;
    }

    public static <T> List<T> strengthen(Collection<WeakReference<T>> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<WeakReference<T>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        T r13 = r12.next().get();
        if (r13 == null) goto L7;
        r11.add(r13);
        goto L4
    L7:
        r12.remove();
        goto L4
    L9:
        return r11;
    }
}
