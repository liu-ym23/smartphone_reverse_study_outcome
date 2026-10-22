package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.e0;

/* JADX INFO: loaded from: classes3.dex */
final class h<T> extends e0<T> {
    public h(CoroutineContext r10, Continuation<? super T> r11) {
        super(r10, r11);
    }

    @Override // kotlinx.coroutines.c2
    public boolean j0(Throwable r10) {
        if ((r10 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return e0(r10);
    }
}
