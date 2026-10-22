package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements kotlinx.coroutines.l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f10551c;

    public g(CoroutineContext r10) {
        this.f10551c = r10;
    }

    @Override // kotlinx.coroutines.l0
    public CoroutineContext getCoroutineContext() {
        return this.f10551c;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
