package com.larus.asr.session.clicktalk;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class s implements a3a.b, FunctionAdapter {
    public final /* synthetic */ t a;

    public s(t r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof a3a.b) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.a, t.class, "onAutoStopEvent", "onAutoStopEvent(Lcom/larus/voicecall/api/autostop/AutoStopAsrEvent;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final void onEvent(a3a.a r6) {
        Intrinsics.checkNotNullParameter(r6, IP0SubProcess.P0_PROCESS_NAME);
        t r0 = this.a;
        r0.getClass();
        if ((r6 instanceof a3a.a.a) == false) goto L6;
        j r1 = new j.a(((a3a.a.a) r6).a);
    L38:
        r0.a.onEvent(r1);
        return;
    L6:
        if ((r6 instanceof a3a.a.l) == false) goto L9;
        a3a.a.l r7 = (a3a.a.l) r6;
        r1 = new j.n(r7.b, r7.c);
        goto L38
    L9:
        if ((r6 instanceof a3a.a.e) == false) goto L12;
        a3a.a.e r8 = (a3a.a.e) r6;
        r1 = new j.f(r8.a, r8.b);
        goto L38
    L12:
        if ((r6 instanceof a3a.a.f) == false) goto L15;
        r1 = new j.g(((a3a.a.f) r6).a);
        goto L38
    L15:
        if ((r6 instanceof a3a.a.h) == false) goto L18;
        r1 = new j.i(((a3a.a.h) r6).a);
        goto L38
    L18:
        if ((r6 instanceof a3a.a.g) == false) goto L21;
        r1 = j.h.a;
        goto L38
    L21:
        if ((r6 instanceof a3a.a.b) == false) goto L24;
        r1 = new j.b(((a3a.a.b) r6).a);
        goto L38
    L24:
        if ((r6 instanceof a3a.a.c) == false) goto L27;
        r1 = new j.c(((a3a.a.c) r6).a);
        goto L38
    L27:
        if ((r6 instanceof a3a.a.k) == false) goto L30;
        r1 = j.l.a;
        goto L38
    L30:
        if ((r6 instanceof a3a.a.i) == false) goto L33;
        r1 = j.C0068j.a;
        goto L38
    L33:
        if ((r6 instanceof a3a.a.j) == false) goto L36;
        r1 = j.k.a;
        goto L38
    L36:
        if ((r6 instanceof a3a.a.d) == false) goto L41;
        a3a.a.d r9 = (a3a.a.d) r6;
        r1 = new j.d(r9.a, r9.b, r9.c, r9.d);
        goto L38
    L41:
        throw new NoWhenBranchMatchedException();
    }
}
