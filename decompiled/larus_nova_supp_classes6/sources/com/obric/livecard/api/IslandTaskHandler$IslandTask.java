package com.obric.livecard.api;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\tJ\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0007\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/IslandTaskHandler$IslandTask;", "Ljava/lang/Runnable;", "sessionId", "", "block", "Lkotlin/Function0;", "", "onFinished", "Lkotlin/Function3;", "", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "isRunning", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getSessionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "cancel", "run", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IslandTaskHandler$IslandTask implements Runnable {
    private final Function0<Unit> block;
    private final AtomicBoolean cancelled;
    private final AtomicBoolean finished;
    private final AtomicBoolean isRunning;
    private final Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> onFinished;
    private final Long sessionId;

    public void com_obric_livecard_api_IslandTaskHandler$IslandTask__run$___twin___() {
        this.isRunning.compareAndSet(false, true);     // Catch: Throwable -> L11
        if (this.cancelled.get() == true) goto L7;
        this.block.invoke();     // Catch: Throwable -> L11
    L7:
        if (this.finished.compareAndSet(false, true) == false) goto L16;
        Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> r0 = this.onFinished;
        if (r0 == null) goto L19;
    L10:
        r0.invoke(this.sessionId, this, Boolean.valueOf(this.cancelled.get()));
        return;
    L19:
        return;
    L16:
        return;
    L12:
        if (this.finished.compareAndSet(false, true) == false) goto L21;
        r0 = this.onFinished;
        if (r0 != null) goto L10;
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_obric_livecard_api_IslandTaskHandler$IslandTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final boolean cancel() {
        if (this.isRunning.get() == false) goto L5;
        return false;
    L5:
        this.cancelled.compareAndSet(false, true);
        if (this.finished.compareAndSet(false, true) == false) goto L11;
        Function3<Long, IslandTaskHandler$IslandTask, Boolean, Unit> r0 = this.onFinished;
        if (r0 == null) goto L10;
        r0.invoke(this.sessionId, this, Boolean.TRUE);
    L10:
        return true;
    L11:
        return false;
    }

    public final Long getSessionId() {
        return this.sessionId;
    }

    public final AtomicBoolean isRunning() {
        return this.isRunning;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_obric_livecard_api_IslandTaskHandler$IslandTask_com_larus_apm_impl_protector_RunnableLancet_run(IslandTaskHandler$IslandTask r1) {
        r1.com_obric_livecard_api_IslandTaskHandler$IslandTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IslandTaskHandler$IslandTask(Long r2, Function0<Unit> r3, Function3<? super Long, ? super IslandTaskHandler$IslandTask, ? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "block");
        this.sessionId = r2;
        this.block = r3;
        this.onFinished = r4;
        this.cancelled = new AtomicBoolean(false);
        this.finished = new AtomicBoolean(false);
        this.isRunning = new AtomicBoolean(false);
    }

    public /* synthetic */ IslandTaskHandler$IslandTask(Long r2, Function0 r3, Function3 r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
