package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {

    @JvmField
    public final DispatchQueue dispatchQueue;

    public PausingDispatcher() {
        this.dispatchQueue = new DispatchQueue();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "block");
        this.dispatchQueue.dispatchAndEnqueue(r10, r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (z0.c().c0().isDispatchNeeded(r10) == false) goto L6;
        return true;
    L6:
        return !this.dispatchQueue.canRun();
    }
}
