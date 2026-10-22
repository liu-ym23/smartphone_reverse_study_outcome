package kotlinx.coroutines;

import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = null;
    public final Deferred<T>[] a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount$volatile");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Deferred<? extends T>[] r1) {
        this.a = r1;
        this.notCompletedCount$volatile = r1.length;
    }

    public final Object a(Continuation<? super List<? extends T>> r13) {
        j r0 = new j(IntrinsicsKt.intercepted(r13), 1);
        r0.C();
        int r1 = this.a.length;
        a[] r2 = new a[r1];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        Job r6 = this.a[r4];
        r6.start();
        a r5 = new a(this, r0);
        r5.f = JobKt.invokeOnCompletion$default(r6, false, false, r5, 3, null);
        Unit r7 = Unit.INSTANCE;
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L3
    L5:
        b r8 = new b(r2);
    L6:
        if (r3 >= r1) goto L9;
        a r9 = r2[r3];
        r9.getClass();
        a.h.set(r9, r8);
        r3 = r3 + 1;
        goto L6
    L9:
        if (r0.isCompleted() == false) goto L11;
        r8.b();
    L12:
        Object r10 = r0.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L15:
        return r10;
    L11:
        l.b(r0, r8);
        goto L12
    }
}
