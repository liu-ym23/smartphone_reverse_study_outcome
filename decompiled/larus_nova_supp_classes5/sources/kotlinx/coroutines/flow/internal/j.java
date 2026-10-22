package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j<T> extends x<T> {
    public final boolean y(Throwable r2) {
        if ((r2 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return s(r2);
    }

    public j(CoroutineContext r1, Continuation<? super T> r2) {
        super(r1, r2);
    }
}
