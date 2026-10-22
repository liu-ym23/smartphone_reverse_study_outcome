package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j<E> extends f<E> implements k<E> {
    @Override // kotlinx.coroutines.channels.k
    public final SendChannel getChannel() {
        return this;
    }

    public final boolean isActive() {
        return super.isActive();
    }

    public final void m0(Object r1) {
        Unit r2 = (Unit) r1;
        SendChannel.a.a(this.d);
    }

    public j(CoroutineContext r2, Channel<E> r3) {
        super(r2, r3, true, true);
    }

    public final void l0(Throwable r2, boolean r3) {
        if (this.d.close(r2) == true) goto L7;
        if (r3 == true) goto L8;
        y.a(getContext(), r2);
        return;
    L8:
        return;
    }
}
