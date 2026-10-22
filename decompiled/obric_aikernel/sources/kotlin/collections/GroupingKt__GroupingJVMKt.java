package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1855#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
class GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingJVMKt() {
    }

    @SinceKotlin(version = "1.1")
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<T> r12 = r10.sourceIterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        K r13 = r10.keyOf(r12.next());
        Object r14 = r11.get(r13);
        if (r14 == null) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L13;
        r14 = new Ref.IntRef();
    L13:
        Ref.IntRef r16 = (Ref.IntRef) r14;
        r16.element++;
        r11.put(r13, r16);
        goto L4
    L8:
        if (r11.containsKey(r13) == true) goto L10;
        r15 = true;
        goto L11
    L14:
        Iterator<T> r17 = r11.entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L19;
        Map.Entry r18 = (Map.Entry) r17.next();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r18).setValue(Integer.valueOf(((Ref.IntRef) r18.getValue()).element));
        goto L16
    L19:
        return TypeIntrinsics.asMutableMap(r11);
    }

    @PublishedApi
    @InlineOnly
    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "f");
        Iterator<T> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        Map.Entry r13 = (Map.Entry) r12.next();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r13).setValue(r11.invoke(r13));
        goto L4
    L7:
        return TypeIntrinsics.asMutableMap(r10);
    }
}
