package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.ttaccount.api.IAccountSwitchService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountSwitchService;", "Lcom/larus/account/saas/ttaccount/api/IAccountSwitchService;", "<init>", "()V", "a", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountSwitchService implements IAccountSwitchService {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public AccountSwitchService() {
        this.a = LazyKt.lazy(AccountSwitchService$extraApi$2.INSTANCE);
    }
}
