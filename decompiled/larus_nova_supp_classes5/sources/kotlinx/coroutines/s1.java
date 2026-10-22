package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s1<T> extends x<T> {
    public final boolean y(Throwable r1) {
        return false;
    }

    public s1(CoroutineContext r1, Continuation<? super T> r2) {
        super(r1, r2);
    }
}
