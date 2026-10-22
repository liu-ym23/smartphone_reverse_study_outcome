package com.larus.account.saas.mfa;

import com.larus.account.saas.coreapi.IAccountMfaService;
import com.larus.account.saas.mfa.verify.a;
import com.larus.home.impl.sdk.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/mfa/AccountMfaService;", "Lcom/larus/account/saas/coreapi/IAccountMfaService;", "<init>", "()V", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class AccountMfaService implements IAccountMfaService {
    public AccountMfaService() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountMfaService
    public final void a(b r3) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", "template");
        Intrinsics.checkNotNullParameter(r3, "callback");
        a.a(r3);
    }
}
