package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionsKt {
    public static final <T> void addIfNotNull(Collection<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == null) goto L6;
        r10.add(r11);
        return;
    }

    private static final int capacity(int r10) {
        if (r10 >= 3) goto L6;
        return 3;
    L6:
        return (r10 + (r10 / 3)) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        r10.trimToSize();
        return r10;
    L11:
        return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first(r10));
    L9:
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<? extends K> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        int r14 = r13 + 1;
        r11.put(r12.next(), Integer.valueOf(r13));
        r13 = r14;
        goto L4
    L6:
        return r11;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r10) {
        return new HashMap(capacity(r10));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int r10) {
        return new HashSet(capacity(r10));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r10) {
        return new LinkedHashSet(capacity(r10));
    }
}
