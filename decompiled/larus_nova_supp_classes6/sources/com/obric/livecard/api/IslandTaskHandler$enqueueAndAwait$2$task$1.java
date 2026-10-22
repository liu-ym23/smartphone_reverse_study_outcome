package com.obric.livecard.api;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "isCancelled", "", "invoke", "(Ljava/lang/Long;Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;Z)V"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandTaskHandler$enqueueAndAwait$2$task$1 extends Lambda implements Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> {
    final /* synthetic */ i<Unit> $cont;
    final /* synthetic */ AtomicBoolean $finished;

    public IslandTaskHandler$enqueueAndAwait$2$task$1(AtomicBoolean r1, i<? super Unit> r2) {
        this.$finished = r1;
        this.$cont = r2;
        super(3);
    }

    public final void invoke(Long r2, IslandTaskHandler$IslandTask r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 1>");
        if (this.$finished.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.$cont.isActive() == false) goto L12;
        i<Unit> r5 = this.$cont;
        if (r4 == false) goto L9;
        r5.cancel(null);
        return;
    L9:
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Long) r1, (IslandTaskHandler$IslandTask) r2, ((Boolean) r3).booleanValue());
        return Unit.INSTANCE;
    }
}
