package kotlin.collections;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    public CollectionsKt__IteratorsKt() {
    }

    public static final <T> void forEach(Iterator<? extends T> r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
    L4:
        if (r10.hasNext() == false) goto L6;
        r11.invoke(r10.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Iterator<T> iterator(Iterator<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10;
    }

    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IndexingIterator(r10);
    }
}
