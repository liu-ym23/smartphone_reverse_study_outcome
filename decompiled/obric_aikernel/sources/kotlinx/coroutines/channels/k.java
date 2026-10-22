package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.i0;

/* JADX INFO: loaded from: classes3.dex */
final class k<E> extends e<E> implements l<E> {
    public k(CoroutineContext r10, d<E> r11) {
        super(r10, r11, true, true);
    }

    @Override // kotlinx.coroutines.a
    protected void g1(Throwable r10, boolean r11) {
        if (k1().w(r10) == true) goto L7;
        if (r11 == true) goto L8;
        i0.a(getContext(), r10);
        return;
    L8:
        return;
    }

    @Override // kotlinx.coroutines.channels.l
    public /* bridge */ /* synthetic */ n getChannel() {
        return j1();
    }

    @Override // kotlinx.coroutines.a
    public /* bridge */ /* synthetic */ void h1(Unit r10) {
        l1(r10);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public boolean isActive() {
        return super.isActive();
    }

    protected void l1(Unit r10) {
        n.a.a(k1(), null, 1, null);
    }
}
