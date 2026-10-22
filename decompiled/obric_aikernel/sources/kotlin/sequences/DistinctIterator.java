package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class DistinctIterator<T, K> extends AbstractIterator<T> {
    private final Function1<T, K> keySelector;
    private final HashSet<K> observed;
    private final Iterator<T> source;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctIterator(Iterator<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        this.source = r10;
        this.keySelector = r11;
        this.observed = new HashSet();
    }

    @Override // kotlin.collections.AbstractIterator
    protected void computeNext() {
    L3:
        if (this.source.hasNext() == false) goto L8;
        T r10 = this.source.next();
        K r11 = this.keySelector.invoke(r10);
        if (this.observed.add(r11) == false) goto L3;
        setNext(r10);
        return;
    L8:
        done();
    }
}
