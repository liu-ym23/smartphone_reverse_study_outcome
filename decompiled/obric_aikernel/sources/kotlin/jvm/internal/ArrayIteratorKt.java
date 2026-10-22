package kotlin.jvm.internal;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayIterator(r10);
    }
}
