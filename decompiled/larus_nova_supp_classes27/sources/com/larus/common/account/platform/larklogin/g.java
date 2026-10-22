package com.larus.common.account.platform.larklogin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n38.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ g(com.larus.office.base.host.k r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Function1 r0 = this.a;
        LarkOAuthSessionCoordinator$c r5 = (LarkOAuthSessionCoordinator$c) r4;
        LarkLogin.a r1 = LarkLogin.g;
        Intrinsics.checkNotNullParameter(r5, "outcome");
        if ((r5 instanceof LarkOAuthSessionCoordinator$c.d) == false) goto L6;
        a0.d r6 = a0.d.a;
    L14:
        r0.invoke(r6);
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r5, LarkOAuthSessionCoordinator$c.b.a) == false) goto L9;
        r6 = a0.b.a;
        goto L14
    L9:
        if (Intrinsics.areEqual(r5, LarkOAuthSessionCoordinator$c.a.a) == false) goto L12;
        r6 = a0.a.a;
        goto L14
    L12:
        if ((r5 instanceof LarkOAuthSessionCoordinator$c.c) == false) goto L17;
        LarkOAuthSessionCoordinator$c.c r7 = (LarkOAuthSessionCoordinator$c.c) r5;
        r6 = new a0.c(r7.a, r7.b);
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
