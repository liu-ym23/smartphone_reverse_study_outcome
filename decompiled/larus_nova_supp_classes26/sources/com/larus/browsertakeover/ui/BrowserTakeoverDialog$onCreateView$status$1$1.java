package com.larus.browsertakeover.ui;

import com.larus.browsertakeover.session.BrowserTakeoverSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BrowserTakeoverDialog$onCreateView$status$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public BrowserTakeoverDialog$onCreateView$status$1$1(Object r8) {
        super(0, r8, BrowserTakeoverDialog.class, "retry", "retry()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m90invoke() {
        BrowserTakeoverDialog r0 = (BrowserTakeoverDialog) ((CallableReference) this).receiver;
        if (r0.g == false) goto L32;
        BrowserTakeoverSession r1 = r0.d;
        BrowserTakeoverSession r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r1 = null;
    L8:
        int r3 = BrowserTakeoverDialog.c.a[r1.getState().ordinal()];
        if (r3 != 1) goto L11;
    L20:
        BrowserTakeoverDialog.b r4 = r0.e;
        if (r4 != null) goto L24;
        return;
    L24:
        if (r0.j == null) goto L26;
        return;
    L26:
        if (r0.g == false) goto L35;
        x r5 = new x(r0, r4);
        r0.j = r5;
        r4.e.post(r5);
        return;
    L35:
        return;
    L11:
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L33;
        BrowserTakeoverSession r6 = r0.d;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L19:
        r2.complete();
        return;
    L18:
        r2 = r6;
        goto L19
    L33:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m90invoke();
        return Unit.INSTANCE;
    }
}
