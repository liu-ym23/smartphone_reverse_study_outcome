package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m implements Continuation<Object> {
    public static final m a = null;
    public static final EmptyCoroutineContext b = null;

    public m() {
    }

    public final void resumeWith(Object r1) {
    }

    static {
        a = new m();
        b = EmptyCoroutineContext.INSTANCE;
    }

    public CoroutineContext getContext() {
        return b;
    }
}
