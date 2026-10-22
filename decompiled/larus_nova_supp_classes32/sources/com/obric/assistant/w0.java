package com.obric.assistant;

import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class w0 implements Function0 {
    public /* synthetic */ w0() {
    }

    public final Object invoke() {
        int r0 = ObricAssistantImpl.a;
        IObricLaunchService r1 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r1 == null) goto L6;
        r1.startLauncherIntent();
    L6:
        return Unit.INSTANCE;
    }
}
