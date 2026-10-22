package kotlinx.coroutines.sync;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MutexImpl$onSelectCancellationUnlockConstructor$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Object $owner;
    final /* synthetic */ MutexImpl this$0;

    public MutexImpl$onSelectCancellationUnlockConstructor$1$1(MutexImpl r1, Object r2) {
        this.this$0 = r1;
        this.$owner = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable r2) {
        this.this$0.unlock(this.$owner);
    }
}
