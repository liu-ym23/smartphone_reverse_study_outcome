package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlinx.coroutines.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends j implements u {
    @Override // kotlinx.coroutines.a
    public final void b0(boolean r5, Throwable r10) {
        if (this.d.n(false, r10) == true) goto L7;
        if (r5 == true) goto L8;
        c0.a(r10, this.f18767c);
        return;
    L8:
        return;
    }

    @Override // kotlinx.coroutines.a
    public final void c0(Object r5) {
        Unit r10 = (Unit) r5;
        this.d.o(null);
    }
}
