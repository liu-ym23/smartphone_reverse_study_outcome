package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
final class l implements Continuation<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f10492c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CoroutineContext f10493g = null;

    static {
        f10492c = new l();
        f10493g = EmptyCoroutineContext.INSTANCE;
    }

    private l() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return f10493g;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
    }
}
