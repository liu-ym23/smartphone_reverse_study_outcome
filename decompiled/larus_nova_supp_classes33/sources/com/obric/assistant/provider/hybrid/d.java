package com.obric.assistant.provider.hybrid;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public /* synthetic */ d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        FLogger.a.i("OpenLoginAbility", "go login");
        IObricLaunchService r0 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r0 == null) goto L9;
        r0.startLauncherIntent();
        return;
    L9:
        return;
    L7:
        FLogger.a.i("OpenLoginAbility", "is already login");
    }
}
