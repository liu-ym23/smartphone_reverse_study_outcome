package kotlin.collections;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    private CollectionsKt() {
    }

    public static /* bridge */ /* synthetic */ void A(Collection r5, Object[] r10) {
        CollectionsKt__MutableCollectionsKt.removeAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void B(PersistentSet.Builder r5, Iterable r10) {
        CollectionsKt__MutableCollectionsKt.retainAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void C(Iterable r5, Function1 r10) {
        CollectionsKt__MutableCollectionsKt.retainAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ long D(Collection r5) {
        return CollectionsKt___CollectionsKt.sumOfLong(r5);
    }

    public static /* bridge */ /* synthetic */ List E(List r5) {
        return CollectionsKt___CollectionsKt.take(r5, 15);
    }

    public static /* bridge */ /* synthetic */ HashSet F(Collection r5) {
        return CollectionsKt___CollectionsKt.toHashSet(r5);
    }

    public static /* bridge */ /* synthetic */ List G(List r10) {
        return CollectionsKt___CollectionsKt.windowed$default(r10, 2, 0, false, 6, null);
    }

    public static /* bridge */ /* synthetic */ Iterator H(ByteIterator r5) {
        return CollectionsKt__IteratorsKt.withIndex(r5);
    }

    public static /* bridge */ /* synthetic */ void a(Collection r5, Iterable r10) {
        CollectionsKt__MutableCollectionsKt.addAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void b(Collection r5, Sequence r10) {
        CollectionsKt__MutableCollectionsKt.addAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void c(Collection r5, Object[] r10) {
        CollectionsKt__MutableCollectionsKt.addAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ boolean d(Collection r5, Function1 r10) {
        return CollectionsKt___CollectionsKt.all(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List e(java.util.AbstractList r5) {
        return CollectionsKt__ReversedViewsKt.asReversedMutable(r5);
    }

    public static /* bridge */ /* synthetic */ int f(List r10, ByteString r11) {
        return CollectionsKt__CollectionsKt.binarySearch$default(r10, r11, 0, 0, 6, null);
    }

    public static /* bridge */ /* synthetic */ List g(ArrayList r5) {
        return CollectionsKt___CollectionsKt.chunked(r5, 50);
    }

    public static /* bridge */ /* synthetic */ int h(Iterable r5) {
        return CollectionsKt__IterablesKt.collectionSizeOrDefault(r5, 10);
    }

    public static /* bridge */ /* synthetic */ List i(List r5, int r10) {
        return CollectionsKt___CollectionsKt.drop(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Object j(LinkedBlockingDeque r5, int r10) {
        return CollectionsKt___CollectionsKt.elementAt(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Object k(Set r5, int r10) {
        return CollectionsKt___CollectionsKt.elementAtOrNull(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List l(List r5, Class r10) {
        return CollectionsKt___CollectionsJvmKt.filterIsInstance(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List m(List r5) {
        return CollectionsKt___CollectionsKt.filterNotNull(r5);
    }

    public static /* bridge */ /* synthetic */ Object n(Collection r5) {
        return CollectionsKt___CollectionsKt.first(r5);
    }

    public static /* bridge */ /* synthetic */ int o(ArrayList r5, Object r10) {
        return CollectionsKt___CollectionsKt.indexOf(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Appendable p(Iterable r10, StringBuilder r11, String r12, String r13, String r14, Function1 r15, int r16) {
        return CollectionsKt___CollectionsKt.joinTo$default(r10, r11, r12, r13, r14, 0, null, r15, r16, null);
    }

    public static /* bridge */ /* synthetic */ String q(Iterable r10, String r11, String r12, String r13, int r14, String r15, Function1 r16, int r17) {
        return CollectionsKt___CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, null);
    }

    public static /* bridge */ /* synthetic */ List r(Collection r5, Function1 r10) {
        return CollectionsKt___CollectionsKt.map(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Comparable s(List r5) {
        return CollectionsKt___CollectionsKt.maxOrNull(r5);
    }

    public static /* bridge */ /* synthetic */ Comparable t(ArrayList r5) {
        return CollectionsKt___CollectionsKt.minOrNull(r5);
    }

    public static /* bridge */ /* synthetic */ List u(Iterable r5) {
        return CollectionsKt___CollectionsKt.minus(r5, "value");
    }

    public static /* bridge */ /* synthetic */ List v(List r5, List r10) {
        return CollectionsKt___CollectionsKt.minus(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List w(List r5, Sequence r10) {
        return CollectionsKt___CollectionsKt.plus(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void x(Iterable r5, Function1 r10) {
        CollectionsKt__MutableCollectionsKt.removeAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void y(Collection r5, Iterable r10) {
        CollectionsKt__MutableCollectionsKt.removeAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void z(Collection r5, Sequence r10) {
        CollectionsKt__MutableCollectionsKt.removeAll(r5, r10);
    }
}
