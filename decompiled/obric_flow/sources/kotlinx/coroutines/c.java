package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends m1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18774h = null;
    private volatile /* synthetic */ Object _disposer$volatile;
    public final l e;
    public t0 f;
    public final /* synthetic */ e g;

    static {
        f18774h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    }

    public c(e r5, l r10) {
        this.g = r5;
        this.e = r10;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        return false;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
        l r10 = this.e;
        if (r5 == null) goto L9;
        r10.getClass();
        g8.g r11 = r10.H(new v(false, r5), null);
        if (r11 == null) goto L17;
        r10.s(r11);
        d r12 = (d) f18774h.get(this);
        if (r12 == null) goto L18;
        r12.a();
        return;
    L18:
        return;
    L17:
        return;
    L9:
        AtomicIntegerFieldUpdater r13 = e.f18821b;
        e r14 = this.g;
        if (r13.decrementAndGet(r14) != 0) goto L20;
        m0[] r15 = r14.f18822a;
        ArrayList r16 = new ArrayList(r15.length);
        int r17 = r15.length;
        int r18 = 0;
    L12:
        if (r18 >= r17) goto L14;
        r16.add(r15[r18].b());
        r18 = r18 + 1;
        goto L12
    L14:
        r10.resumeWith(Result.m124constructorimpl(r16));
        return;
    }
}
