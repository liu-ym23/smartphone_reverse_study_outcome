package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
public final class SequencesKt__SequencesKt$Sequence$1<T> implements Sequence<T> {
    final /* synthetic */ Function0<Iterator<T>> $iterator;

    public Iterator<T> iterator() {
        return (Iterator) this.$iterator.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$Sequence$1(Function0<? extends Iterator<? extends T>> r1) {
        this.$iterator = r1;
    }
}
