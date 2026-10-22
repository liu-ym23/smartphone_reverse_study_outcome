package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 INSTANCE = null;

    static {
        INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$1();
    }

    public SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    public final Iterator<R> invoke(Iterable<? extends R> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return r2.iterator();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Iterable) r1);
    }
}
