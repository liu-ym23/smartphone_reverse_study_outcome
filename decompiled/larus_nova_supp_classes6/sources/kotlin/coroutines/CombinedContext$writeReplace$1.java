package kotlin.coroutines;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
    final /* synthetic */ CoroutineContext[] $elements;
    final /* synthetic */ Ref.IntRef $index;

    public CombinedContext$writeReplace$1(CoroutineContext[] r1, Ref.IntRef r2) {
        this.$elements = r1;
        this.$index = r2;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(Unit r4, CoroutineContext.Element r5) {
        Intrinsics.checkNotNullParameter(r4, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r5, "element");
        CoroutineContext[] r6 = this.$elements;
        Ref.IntRef r0 = this.$index;
        int r1 = r0.element;
        r0.element = r1 + 1;
        r6[r1] = r5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Unit) r1, (CoroutineContext.Element) r2);
        return Unit.INSTANCE;
    }
}
