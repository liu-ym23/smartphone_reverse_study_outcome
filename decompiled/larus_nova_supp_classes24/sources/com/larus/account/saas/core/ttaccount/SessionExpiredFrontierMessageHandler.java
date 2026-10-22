package com.larus.account.saas.core.ttaccount;

import com.bytedance.sdk.account.impl.j;
import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/SessionExpiredFrontierMessageHandler;", "Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler;", "<init>", "()V", "a", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class SessionExpiredFrontierMessageHandler implements IAccountFrontierMessageHandler {

    public static final class a {
    }

    static {
    }

    public SessionExpiredFrontierMessageHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final IAccountFrontierMessageHandler.Priority priority() {
        return IAccountFrontierMessageHandler.Priority.DEFAULT;
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final boolean a(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        if (r3 == 1001) goto L6;
        return false;
    L6:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("SessionExpiredFrontierMessageHandler", "handle session expired frontier message");
        c48.a.a().a();
        j.m(com.larus.init.task.accountsdk.a.a.getApplication()).p(r4);
        return true;
    }
}
