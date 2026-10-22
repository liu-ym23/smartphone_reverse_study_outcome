package com.obric.assistant.interaction.impl.activityresult;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "", "<init>", "()V", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tryComplete", "", "isCompleted", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityProxyTerminalGate {
    private final AtomicBoolean completed;

    public final boolean isCompleted() {
        return this.completed.get();
    }

    public final boolean tryComplete() {
        return this.completed.compareAndSet(false, true);
    }

    public ActivityProxyTerminalGate() {
        this.completed = new AtomicBoolean(false);
    }
}
