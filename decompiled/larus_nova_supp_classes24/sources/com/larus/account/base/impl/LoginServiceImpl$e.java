package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.account.base.provider.IVerificationCodeLoginProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$e implements n38.h {
    public final /* synthetic */ LoginPlatform a;
    public final /* synthetic */ n38.h b;

    public LoginServiceImpl$e(LoginPlatform r1, boolean r2, n38.h r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // n38.h
    public final void b(LoginPlatform r3, String r4, Boolean r5) {
        xg9.b.a().storeString("phone_number", "-1");
        Iterator r6 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        IThirdPartyPlatformLoginProvider r7 = (IThirdPartyPlatformLoginProvider) r6.next();
        if (r7.c() != this.a) goto L4;
        r7.o(this.b, r4);
        return;
    L9:
        Iterator r8 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        IVerificationCodeLoginProvider r9 = (IVerificationCodeLoginProvider) r8.next();
        if (r9.c() != this.a) goto L11;
        r9.o(this.b, r4);
        return;
    L16:
        n38.h r10 = this.b;
        if (r10 == null) goto L26;
        n38.h.a.b(r10, this.a, r4);
        return;
    }

    @Override // n38.h
    public final void a(LoginPlatform r12, int r13, String r14, String r15, String r16, Integer r17, String r19, Map r110) {
        n38.h r1 = this.b;
        if (r1 == null) goto L6;
        n38.h.a.a(r1, r12, r13, r14, r15, null, null, null, null, 480);
        return;
    }
}
