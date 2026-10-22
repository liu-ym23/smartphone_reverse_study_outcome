package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f18881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f18882b = null;

    static {
        f18881a = new s();
        f18882b = EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return f18882b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r5) {
    }
}
