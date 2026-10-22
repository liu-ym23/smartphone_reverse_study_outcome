package com.larus.account.saas.ui.security;

import com.larus.account.saas.security.api.IAccountSecurityService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements h48.d {
    public final /* synthetic */ e48.f a;
    public final /* synthetic */ DefaultAccountSecurityPushUiService b;

    @Override // h48.d
    public final void confirm() {
        IAccountSecurityService.Companion r0 = IAccountSecurityService.a;
        e48.f r2 = this.a;
        r0.a(new e48.c(r2.c, r2.d, r2.b));
        DefaultAccountSecurityPushUiService.f(this.b, this.a.d, "confirm_myself");
    }

    public f(e48.f r1, DefaultAccountSecurityPushUiService r2) {
        this.a = r1;
        this.b = r2;
    }
}
