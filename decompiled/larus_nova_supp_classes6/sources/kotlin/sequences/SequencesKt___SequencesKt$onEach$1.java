package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SequencesKt___SequencesKt$onEach$1<T> extends Lambda implements Function1<T, T> {
    final /* synthetic */ Function1<T, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$onEach$1(Function1<? super T, Unit> r1) {
        this.$action = r1;
        super(1);
    }

    public final T invoke(T r2) {
        this.$action.invoke(r2);
        return r2;
    }
}
