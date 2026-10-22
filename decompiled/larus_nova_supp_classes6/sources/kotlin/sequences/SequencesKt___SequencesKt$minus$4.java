package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$4", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SequencesKt___SequencesKt$minus$4<T> implements Sequence<T> {
    final /* synthetic */ Sequence<T> $elements;
    final /* synthetic */ Sequence<T> $this_minus;

    public Iterator<T> iterator() {
        List r0 = SequencesKt.toList(this.$elements);
        if (r0.isEmpty() == false) goto L7;
        return this.$this_minus.iterator();
    L7:
        return SequencesKt.filterNot(this.$this_minus, new iterator.1(r0)).iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$minus$4(Sequence<? extends T> r1, Sequence<? extends T> r2) {
        this.$elements = r1;
        this.$this_minus = r2;
    }
}
