package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends m1 {
    public final /* synthetic */ int e;
    public final Object f;

    public /* synthetic */ u0(Object r5, int r10) {
        this.e = r10;
        this.f = r5;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        switch(this.e) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return false;
    L8:
        return false;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
        Object r10 = this.f;
        switch(this.e) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        r1 r11 = h();
        r11.getClass();
        Object r12 = r1.f18988a.get(r11);
        n1 r13 = (n1) r10;
        if ((r12 instanceof v) == false) goto L7;
        Result.Companion r14 = Result.Companion;
        r13.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(((v) r12).f19025a)));
        return;
    L7:
        Result.Companion r15 = Result.Companion;
        r13.resumeWith(Result.m124constructorimpl(j0.k(r12)));
        return;
    L9:
        ((Function1) r10).invoke(r5);
        return;
    L11:
        ((t0) r10).dispose();
    }
}
