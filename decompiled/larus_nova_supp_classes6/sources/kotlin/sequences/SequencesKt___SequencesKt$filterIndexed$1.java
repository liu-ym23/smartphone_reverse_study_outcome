package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SequencesKt___SequencesKt$filterIndexed$1<T> extends Lambda implements Function1<IndexedValue<? extends T>, Boolean> {
    final /* synthetic */ Function2<Integer, T, Boolean> $predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$filterIndexed$1(Function2<? super Integer, ? super T, Boolean> r1) {
        this.$predicate = r1;
        super(1);
    }

    public final Boolean invoke(IndexedValue<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return (Boolean) this.$predicate.invoke(Integer.valueOf(r3.getIndex()), r3.getValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IndexedValue) r1);
    }
}
