package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__IterablesKt$Iterable$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class AnonymousClass1<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Function0<Iterator<T>> $iterator;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends Iterator<? extends T>> r10) {
            this.$iterator = r10;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.$iterator.invoke();
        }
    }

    public CollectionsKt__IterablesKt() {
    }

    @InlineOnly
    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r10, "iterator");
        return new AnonymousClass1(r10);
    }

    @PublishedApi
    public static <T> int collectionSizeOrDefault(Iterable<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
        return r11;
    L5:
        return ((Collection) r10).size();
    }

    @PublishedApi
    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((Collection) r10).size());
    }

    public static <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList();
        Iterator<? extends Iterable<? extends T>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.next());
        goto L4
    L6:
        return r11;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = CollectionsKt.collectionSizeOrDefault(r10, 10);
        ArrayList r12 = new ArrayList(r11);
        ArrayList r13 = new ArrayList(r11);
        Iterator<? extends Pair<? extends T, ? extends R>> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r15 = r14.next();
        r12.add(r15.getFirst());
        r13.add(r15.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r12, r13);
    }
}
