package com.larus.common.mssdk.impl;

import android.content.Context;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SecurityServiceImpl$g implements j {
    public final /* synthetic */ SecurityServiceImpl a;
    public final /* synthetic */ Context b;

    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void b(a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        IApplog.Companion r5 = IApplog.a;
        final SecurityServiceImpl r0 = this.a;
        final Context r1 = this.b;
        r5.f(new o(r0, r1));
        ILoginService r6 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r6 == null) goto L6;
        r6.Q(this);
        return;
    }

    public SecurityServiceImpl$g(SecurityServiceImpl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
