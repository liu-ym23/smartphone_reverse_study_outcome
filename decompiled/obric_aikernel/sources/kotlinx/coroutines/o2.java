package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
class o2 extends a<Unit> {
    public o2(CoroutineContext r10, boolean r11) {
        super(r10, true, r11);
    }

    @Override // kotlinx.coroutines.c2
    protected boolean x0(Throwable r10) {
        i0.a(getContext(), r10);
        return true;
    }
}
