package com.larus.contextwindow.impl.membership;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MembershipQuotaRepository$Companion$INSTANCE$2$1 extends FunctionReferenceImpl implements Function0<d> {
    public MembershipQuotaRepository$Companion$INSTANCE$2$1(Object r8) {
        super(0, r8, i.class, "evaluateCurrent", "evaluateCurrent()Lcom/larus/contextwindow/impl/membership/MembershipQuotaEligibility;", 0);
    }

    public final d invoke() {
        ((i) ((CallableReference) this).receiver).getClass();
        y29.b.a.getClass();
        boolean r8 = y29.b.a();
        int r1 = y29.c.a;
        int r2 = oa9.a.a;
        boolean r9 = ga9.a.b("context_window_membership_quota_enable", true);
        boolean r10 = AppHost.a.isOversea();
        AccountService r3 = AccountService.a;
        if (r3.isLogin().booleanValue() != true) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = x1.a.a();
        String r13 = r3.getUserId();
        Intrinsics.checkNotNullParameter(new j(r8, r9, r10, r11, r12, r13), "inputs");
        if (r8 == false) goto L17;
        if (r9 == false) goto L17;
        if (r10 == true) goto L17;
        if (r11 == false) goto L17;
        if (r12 == true) goto L17;
        if (StringsKt.isBlank(r13) == true) goto L17;
        return new d.a(r13);
    L17:
        return d.b.a;
    L5:
        r11 = false;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m20invoke() {
        return invoke();
    }
}
