package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.coreapi.IAccountLoginService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountLoginService;", "Lcom/larus/account/saas/coreapi/IAccountLoginService;", "<init>", "()V", "a", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountLoginService implements IAccountLoginService {

    public static final class a {
    }

    static {
    }

    public AccountLoginService() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountLoginService
    public final void a(String r9, String r10, String r11, com.larus.account.saas.jsb.core.f r12) {
        Intrinsics.checkNotNullParameter(r9, "mobile");
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r12, "callback");
        LinkedHashMap r6 = new LinkedHashMap();
        c48.a.a().a();
        r6.put("app_name", com.larus.init.task.accountsdk.a.a.c());
        boolean r0 = Intrinsics.areEqual("mobile_sms_login_jsb", "mobile_sms_login_jsb");
        if (r0 == false) goto L11;
        v38.a.a.incrementAndGet();
    L11:
        com.bytedance.sdk.account.impl.d r1 = com.bytedance.sdk.account.impl.d.l();     // Catch: Throwable -> L7
        com.bytedance.sdk.account.impl.d r2 = r1;     // Catch: Throwable -> L7
        r2.m(r9, r10, 1, r11, r6, new b(r0, r12));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        v38.a.a();
    L10:
        throw th;
    }

    @Override // com.larus.account.saas.coreapi.IAccountLoginService
    public final void b(String r4, com.larus.account.saas.jsb.core.e r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "account");
        Intrinsics.checkNotNullParameter(r5, "callback");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r8 == false) goto L5;
        String r9 = "1";
    L6:
        r0.put("is6Digits", r9);
        c48.a.a().a();
        r0.put("app_name", com.larus.init.task.accountsdk.a.a.c());
        if (r7 == false) goto L9;
        r0.put("auto_read", "1");
    L9:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountLoginService", "sendCode");
        com.bytedance.sdk.account.impl.d r10 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r11 = r10;
        r11.s(r4, 24, r0, new c(r5, r6));
        return;
    L5:
        r9 = "0";
        goto L6
    }
}
