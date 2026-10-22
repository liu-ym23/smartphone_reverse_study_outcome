package com.larus.platform.exp;

import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
import hq9.o2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class LarkSocialExp$recomputeState$transition$1 extends FunctionReferenceImpl implements Function0<o2> {
    public LarkSocialExp$recomputeState$transition$1(Object r8) {
        super(0, r8, LarkSocialExp.class, "currentEligibilityContext", "currentEligibilityContext()Lcom/larus/platform/model/LarkSocialEligibilityContext;", 0);
    }

    public final o2 invoke() {
        LarkSocialExp r0 = (LarkSocialExp) ((CallableReference) this).receiver;
        LarkSocialExp r1 = LarkSocialExp.a;
        r0.getClass();
        AccountService r2 = AccountService.a;
        String r3 = r2.getUserId();
        String r4 = r2.getSecUserId();
        boolean r5 = true;
        if (r2.isLogin().booleanValue() == true) goto L7;
        r5 = false;
    L7:
        return new o2(r3, r4, r5, r2.isEnterpriseAccount());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m30invoke() {
        return invoke();
    }
}
