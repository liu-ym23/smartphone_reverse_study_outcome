package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f18929a;

    public c(CoroutineContext r5) {
        this.f18929a = r5;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f18929a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f18929a + ')';
    }
}
