package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r1 f18982i;

    public n1(r1 r5, Continuation r10) {
        super(1, r10);
        this.f18982i = r5;
    }

    @Override // kotlinx.coroutines.l
    public final String C() {
        return "AwaitContinuation";
    }

    @Override // kotlinx.coroutines.l
    public final Throwable u(r1 r5) {
        r1 r10 = this.f18982i;
        r10.getClass();
        Object r11 = r1.f18988a.get(r10);
        if ((r11 instanceof p1) == false) goto L8;
        Throwable r12 = ((p1) r11).c();
        if (r12 == null) goto L8;
        return r12;
    L8:
        if ((r11 instanceof v) == false) goto L12;
        return ((v) r11).f19025a;
    L12:
        return r5.getCancellationException();
    }
}
