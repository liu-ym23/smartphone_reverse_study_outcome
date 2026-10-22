package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.IObricSettingsApi;
import com.obric.assistant.account.IObricAccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;
import n38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements v {
    public c() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.LARK_ENTERPRISE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(a r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        f0 r0 = f0.a;
        String r7 = r6.d;
        r0.getClass();
        f0.a(r7);
        s.a.getClass();
        u.d.getClass();
        a r8 = u.e.b;
        boolean r1 = false;
        if (r8.a == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        FLogger.a.i("ObricEnterpriseAccountTipManager", "onEnterpriseAccountOnline, shouldShowTip: " + r2 + ", currentEnterprise: " + r8.c);
        IObricAccountService r9 = (IObricAccountService) ServiceManager.get().getService(IObricAccountService.class);
        if (r9 == null) goto L11;
        String r10 = r9.a();
    L12:
        if (r2 == false) goto L20;
        IObricSettingsApi r3 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);
        if (r3 == null) goto L16;
        r1 = r3.k0(r10);
    L16:
        if (r1 == true) goto L21;
        t0.d(new n(r10), 2000);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r10 = null;
        goto L12
    L5:
        if (r8.c == false) goto L7;
        r2 = true;
        goto L8
    }

    public final void c(a r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "previousContext");
        FLogger.a.i("ObricLoginDoubaoAccountEventStrategy", "EnterpriseDoubaoAccountEventStrategy ignore doubao account offline");
    }
}
