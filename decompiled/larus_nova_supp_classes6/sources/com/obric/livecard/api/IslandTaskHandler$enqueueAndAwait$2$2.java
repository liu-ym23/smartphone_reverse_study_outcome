package com.obric.livecard.api;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandTaskHandler$enqueueAndAwait$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Long $sessionId;
    final /* synthetic */ IslandTaskHandler$IslandTask $task;
    final /* synthetic */ IslandTaskHandler this$0;

    public IslandTaskHandler$enqueueAndAwait$2$2(IslandTaskHandler$IslandTask r1, IslandTaskHandler r2, Long r3) {
        this.$task = r1;
        this.this$0 = r2;
        this.$sessionId = r3;
        super(1);
    }

    public final void invoke(Throwable r5) {
        this.$task.cancel();
        IslandTaskHandler.access$getTaskHandler$p(this.this$0).removeCallbacks(this.$task);
        Long r6 = this.$sessionId;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.longValue() <= 0) goto L9;
        IslandTaskHandler.access$removeFromGroup(this.this$0, this.$sessionId.longValue(), this.$task);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
