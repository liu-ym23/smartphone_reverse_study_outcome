package com.obric.livecard.api;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "sid", "", "t", "Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "isCancelled", "", "invoke", "(Ljava/lang/Long;Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;Z)V"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandTaskHandler$makeTask$finishedCallback$1 extends Lambda implements Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> {
    final /* synthetic */ Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> $onFinished;
    final /* synthetic */ IslandTaskHandler this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public IslandTaskHandler$makeTask$finishedCallback$1(IslandTaskHandler r1, Function3<? super Long, ? super IslandTaskHandler$IslandTask, ? super Boolean, Unit> r2) {
        this.this$0 = r1;
        this.$onFinished = r2;
        super(3);
    }

    public final void invoke(Long r6, IslandTaskHandler$IslandTask r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "t");
        if (r6 != null) goto L5;
    L7:
        Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> r0 = this.$onFinished;
        if (r0 == null) goto L11;
        r0.invoke(r6, r7, Boolean.valueOf(r8));
        return;
    L11:
        return;
    L5:
        if (r6.longValue() <= 0) goto L7;
        IslandTaskHandler.access$removeFromGroup(this.this$0, r6.longValue(), r7);
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Long) r1, (IslandTaskHandler$IslandTask) r2, ((Boolean) r3).booleanValue());
        return Unit.INSTANCE;
    }
}
