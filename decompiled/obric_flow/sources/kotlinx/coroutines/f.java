package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {
    public final Thread d;
    public final b1 e;

    public f(CoroutineContext r5, Thread r10, b1 r11) {
        super(r5, true);
        this.d = r10;
        this.e = r11;
    }

    @Override // kotlinx.coroutines.r1
    public final void t(Object r5) {
        Thread r10 = Thread.currentThread();
        Thread r11 = this.d;
        if (Intrinsics.areEqual(r10, r11) == true) goto L6;
        LockSupport.unpark(r11);
        return;
    }
}
