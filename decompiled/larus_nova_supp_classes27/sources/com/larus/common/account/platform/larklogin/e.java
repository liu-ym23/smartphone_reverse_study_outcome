package com.larus.common.account.platform.larklogin;

import androidx.fragment.app.FragmentActivity;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n38.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ u a;
    public final /* synthetic */ FragmentActivity b;

    public /* synthetic */ e(com.larus.common.account.platform.larkauth.h r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r7) {
        u r0 = this.a;
        FragmentActivity r1 = this.b;
        LarkOAuthSessionCoordinator$c r8 = (LarkOAuthSessionCoordinator$c) r7;
        LarkLogin.a r2 = LarkLogin.g;
        Intrinsics.checkNotNullParameter(r8, "outcome");
        if ((r8 instanceof LarkOAuthSessionCoordinator$c.d) == false) goto L6;
        r0.b();
    L24:
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r8, LarkOAuthSessionCoordinator$c.b.a) == false) goto L8;
        r0.c(-10001, r1.getString(2131905537));
        goto L24
    L8:
        int r4 = -10002;
        if (Intrinsics.areEqual(r8, LarkOAuthSessionCoordinator$c.a.a) == false) goto L12;
        r0.c(-10002, r1.getString(2131905538));
        goto L24
    L12:
        if ((r8 instanceof LarkOAuthSessionCoordinator$c.c) == false) goto L26;
        LarkOAuthSessionCoordinator$c.c r9 = (LarkOAuthSessionCoordinator$c.c) r8;
        Integer r3 = StringsKt.toIntOrNull(r9.a);
        if (r3 == null) goto L17;
        r4 = r3.intValue();
    L19:
        String r10 = r9.b;
        if (r10 != null) goto L22;
        r10 = r1.getString(2131905538);
    L22:
        r0.c(r4, r10);
        goto L24
    L17:
        if (Intrinsics.areEqual(r9.a, "oauth_busy") == false) goto L19;
        r4 = -10003;
        goto L19
    L26:
        throw new NoWhenBranchMatchedException();
    }
}
