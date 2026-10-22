package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX WARN: Loop in anonymous inline: com.obric.assistant.activation.presentation.runtime.manager.p0, path: [com.obric.assistant.activation.presentation.runtime.manager.p0, com.obric.assistant.activation.presentation.runtime.manager.s0, com.obric.assistant.activation.presentation.runtime.manager.t0] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p0 implements Function0 {
    public /* synthetic */ p0() {
    }

    public final Object invoke() {
        ObricListeningMainProcessManager r0 = ObricListeningMainProcessManager.a;
        s0 r1 = new s0();
        r0.getClass();
        if (ObricListeningMainProcessManager.c("listening-start confirmation", r1) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (ObricListeningMainProcessManager.f == true) goto L8;
    L16:
        FLogger.a.i("ObricListeningMainPM", "ignore listening-start confirmation, owned=" + ObricListeningMainProcessManager.f + ", finishing=" + ObricListeningMainProcessManager.p + ", confirmed=" + ObricListeningMainProcessManager.h);
        return Unit.INSTANCE;
    L8:
        if (ObricListeningMainProcessManager.p == true) goto L16;
        if (ObricListeningMainProcessManager.h == true) goto L16;
        ObricListeningMainProcessManager.h = true;
        FLogger.a.i("ObricListeningMainPM", "confirm real listening started");
        IObricInteractorPresentationBridgeService r2 = ObricListeningMainProcessManager.e;
        if (r2 == null) goto L19;
        ObricListeningMainProcessManager.n("confirmListeningStarted", r2, true, new t0());
    L19:
        return Unit.INSTANCE;
    }
}
