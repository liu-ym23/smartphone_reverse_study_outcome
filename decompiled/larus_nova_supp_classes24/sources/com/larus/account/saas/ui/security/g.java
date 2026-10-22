package com.larus.account.saas.ui.security;

import androidx.fragment.app.FragmentActivity;
import com.larus.account.saas.security.api.IAccountSecurityService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements h48.a {
    public final /* synthetic */ e48.f a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ DefaultAccountSecurityPushUiService c;

    @Override // h48.a
    public final void cancel() {
        c48.a.a().a();
        com.larus.init.task.accountsdk.a r0 = com.larus.init.task.accountsdk.a.a;
        String r1 = this.a.g;
        r0.k(r1, IAccountSecurityService.a.d(this.b, r1));
        DefaultAccountSecurityPushUiService.f(this.c, this.a.d, "manage_device");
    }

    public g(e48.f r1, FragmentActivity r2, DefaultAccountSecurityPushUiService r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
