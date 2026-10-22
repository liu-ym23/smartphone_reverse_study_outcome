package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
class a<E> extends e<E> implements ReceiveChannel {
    @Override // kotlinx.coroutines.c2
    protected void N0(Throwable r10) {
        d<E> r11 = k1();
        CancellationException r12 = null;
        if (r10 != null) goto L5;
    L9:
        r11.c(r12);
        return;
    L5:
        if ((r10 instanceof CancellationException) == false) goto L7;
        r12 = (CancellationException) r10;
    L7:
        if (r12 != null) goto L9;
        r12 = k1.a(o0.a(this) + " was cancelled", r10);
        goto L9
    }

    @Override // kotlinx.coroutines.c2
    protected boolean x0(Throwable r10) {
        i0.a(getContext(), r10);
        return true;
    }
}
