package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends m1 {
    public final /* synthetic */ int e;
    public final l f;

    public /* synthetic */ n(l r5, int r10) {
        this.e = r10;
        this.f = r5;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r10) {
        l r11 = this.f;
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Result.Companion r5 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        return;
    L6:
        Throwable r12 = r11.u(h());
        if (r11.A() == false) goto L23;
        Continuation r13 = r11.d;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.e r14 = (kotlinx.coroutines.internal.e) r13;
        r14.getClass();
    L10:
        AtomicReferenceFieldUpdater r15 = kotlinx.coroutines.internal.e.f18931h;
        Object r16 = r15.get(r14);
        g8.g r17 = kotlinx.coroutines.internal.f.f18933b;
        if (Intrinsics.areEqual(r16, r17) == true) goto L13;
        if ((r16 instanceof Throwable) == true) goto L42;
    L22:
        if (r15.compareAndSet(r14, r16, null) == true) goto L23;
        if (r15.get(r14) == r16) goto L22;
    L42:
        return;
    L13:
        if (r15.compareAndSet(r14, r17, r12) == true) goto L41;
        if (r15.get(r14) == r17) goto L13;
    L41:
        return;
    L23:
        r11.cancel(r12);
        if (r11.A() == true) goto L40;
        r11.r();
        return;
    }
}
