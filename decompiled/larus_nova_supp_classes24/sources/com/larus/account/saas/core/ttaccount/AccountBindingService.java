package com.larus.account.saas.core.ttaccount;

import com.bytedance.sdk.account.impl.p;
import com.larus.account.saas.coreapi.IAccountBindingService;
import com.larus.account.saas.jsb.core.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountBindingService;", "Lcom/larus/account/saas/coreapi/IAccountBindingService;", "<init>", "()V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountBindingService implements IAccountBindingService {
    public AccountBindingService() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountBindingService
    public final void a(String r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "platform");
        Intrinsics.checkNotNullParameter(r4, "callback");
        p r0 = p.t();
        p r1 = r0;
        r1.w(r3, new a(r3, r4));
    }
}
