package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.core.internal.TTAccountExecutors;
import com.larus.account.saas.coreapi.IAccountProfileService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import x38.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountProfileService;", "Lcom/larus/account/saas/coreapi/IAccountProfileService;", "<init>", "()V", "a", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountProfileService implements IAccountProfileService {
    public static final /* synthetic */ int c = 0;
    public final AtomicLong b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.account.saas.coreapi.IAccountProfileService
    public final void a() {
        final String r5 = "postLoginEvent_jsb";
        final g r4 = null;
        final long r1 = this.b.incrementAndGet();
        Lazy r0 = TTAccountExecutors.a;
        final Function0<Unit> r6 = new AccountProfileService$refreshUserInfo$1(r1, this, r4, r5);
        Intrinsics.checkNotNullParameter(r6, "block");
        ((ExecutorService) TTAccountExecutors.a.getValue()).execute(new com.larus.account.saas.core.internal.d(r6));
    }

    public AccountProfileService() {
        this.b = new AtomicLong();
    }

    public static final void b(AccountProfileService r1, final g r2, final x38.a r3) {
        r1.getClass();
        if (r2 == null) goto L7;
        com.larus.account.saas.runtime.internal.util.b.a.post(new d(r2, r3));
        return;
    }
}
