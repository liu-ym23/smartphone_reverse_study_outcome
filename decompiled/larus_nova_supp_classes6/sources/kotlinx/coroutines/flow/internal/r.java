package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class r extends SharedFlowImpl<Integer> implements i1<Integer> {
    public final Object getValue() {
        monitor-enter(this);
        Object[] r0 = ((SharedFlowImpl) this).h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        Integer r1 = Integer.valueOf(((Number) SharedFlowKt.access$getBufferAt(r0, (((SharedFlowImpl) this).i + ((long) ((int) ((l() + ((long) ((SharedFlowImpl) this).k)) - ((SharedFlowImpl) this).i)))) - 1)).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public r(int r4) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(r4));
    }

    public final void s(int r8) {
        monitor-enter(this);
        Object[] r0 = ((SharedFlowImpl) this).h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        tryEmit(Integer.valueOf(((Number) SharedFlowKt.access$getBufferAt(r0, (((SharedFlowImpl) this).i + ((long) ((int) ((l() + ((long) ((SharedFlowImpl) this).k)) - ((SharedFlowImpl) this).i)))) - 1)).intValue() + r8));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
