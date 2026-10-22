package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends s {
    public final /* synthetic */ AtomicReferenceArray e;

    public i(long r5, i r10, int r11) {
        super(r5, r10, r11);
        this.e = new AtomicReferenceArray(h.f);
    }

    @Override // kotlinx.coroutines.internal.s
    public final int g() {
        return h.f;
    }

    @Override // kotlinx.coroutines.internal.s
    public final void h(int r5, CoroutineContext r10) {
        g8.g r11 = h.e;
        this.e.set(r5, r11);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f18950c + ", hashCode=" + hashCode() + ']';
    }
}
