package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SequencesKt__SequencesKt$flatten$1<T> extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = null;

    static {
        INSTANCE = new SequencesKt__SequencesKt$flatten$1();
    }

    public SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    public final Iterator<T> invoke(Sequence<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.iterator();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Sequence) r1);
    }
}
