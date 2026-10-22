package com.larus.account.saas.security;

import android.net.Uri;
import com.larus.account.saas.coreapi.IAccountDeeplinkHandler;
import com.larus.account.saas.security.api.IAccountSecurityService;
import e48.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/security/AccountSecurityDeeplinkHandler;", "Lcom/larus/account/saas/coreapi/IAccountDeeplinkHandler;", "<init>", "()V", "a", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class AccountSecurityDeeplinkHandler implements IAccountDeeplinkHandler {

    public static final class a {
    }

    static {
    }

    public AccountSecurityDeeplinkHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountDeeplinkHandler
    public final boolean a(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        if (Intrinsics.areEqual(r5.getHost(), "doubaoaccountsdk") == true) goto L5;
    L18:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getPath(), "/abnormally_active") == false) goto L18;
        c48.a.a().a();
        com.larus.init.task.accountsdk.a r0 = com.larus.init.task.accountsdk.a.a;
        if (r0.isTeenMode() == false) goto L10;
        return false;
    L10:
        IAccountSecurityService.Companion r2 = IAccountSecurityService.a;
        f r6 = r2.f(r5.toString(), null);
        if (r6 != null) goto L14;
        return false;
    L14:
        if (StringsKt.isBlank(r6.g) == false) goto L16;
        return false;
    L16:
        r0.k(r6.g, r2.d(r0.getApplication(), r6.g));
        return true;
    }
}
