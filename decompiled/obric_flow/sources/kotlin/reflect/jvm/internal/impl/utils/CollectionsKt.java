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
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ncollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1208#2,2:96\n1238#2,4:98\n1#3:102\n*S KotlinDebug\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n*L\n22#1:96,2\n22#1:98,4\n*E\n"})
public final class CollectionsKt {
    public static final <T> void addIfNotNull(Collection<T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == null) goto L6;
        r5.add(r10);
        return;
    }

    private static final int capacity(int r5) {
        if (r5 >= 3) goto L6;
        return 3;
    L6:
        return ((r5 / 3) + r5) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.size();
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L11;
        r5.trimToSize();
        return r5;
    L11:
        return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first(r5));
    L9:
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<? extends K> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        int r13 = r12 + 1;
        r10.put(r11.next(), Integer.valueOf(r12));
        r12 = r13;
        goto L4
    L6:
        return r10;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r5) {
        return new HashMap(capacity(r5));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int r5) {
        return new HashSet(capacity(r5));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r5) {
        return new LinkedHashSet(capacity(r5));
    }
}
