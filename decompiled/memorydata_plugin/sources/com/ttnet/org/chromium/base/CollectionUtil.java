package com.ttnet.org.chromium.base;

import android.util.Pair;
import com.ctc.wstx.util.InternCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean[] booleanListToBooleanArray(List<Boolean> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        boolean[] r0 = new boolean[r6.size()];
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L6;
        r0[r2] = ((Boolean) ZeusTransformUtils.preCheckCast(r6.get(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void forEach(Collection<? extends T> r2, Callback<T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.onResult(r6.next());
        goto L4
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> r3, Callback<Map.Entry<K, V>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.onResult((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public static int[] integerListToIntArray(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int[] r0 = new int[r6.size()];
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L6;
        r0[r2] = ((Integer) ZeusTransformUtils.preCheckCast(r6.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static long[] longListToLongArray(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        long[] r0 = new long[r6.size()];
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L6;
        r0[r2] = ((Long) ZeusTransformUtils.preCheckCast(r6.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... r5) {
        InternCache r0 = (HashMap<K, V>) new HashMap();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair<? extends K, ? extends V> r3 = r5[r2];
        r0.put(r3.first, r3.second);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... r2) {
        HashSet<E> r0 = new HashSet(r2.length);
        Collections.addAll(r0, r2);
        return r0;
    }

    public static <T> List<T> strengthen(Collection<WeakReference<T>> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r5.size());
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r2 = ((WeakReference) ZeusTransformUtils.preCheckCast(r6.next(), WeakReference.class, "com.obric.memorydata.plugin")).get();
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L4
    L7:
        r6.remove();
        goto L4
    L9:
        return r0;
    }
}
