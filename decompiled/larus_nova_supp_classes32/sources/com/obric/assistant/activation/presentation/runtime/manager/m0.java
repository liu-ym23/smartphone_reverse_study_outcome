package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class m0 implements Function0 {
    public final /* synthetic */ int a;

    public /* synthetic */ m0(int r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final int r0 = this.a;
        if (r0 == ObricListeningMainProcessManager.l) goto L5;
        FLogger.a.i("ObricListeningMainPM", "ignore stale Surface linked ack, generation=" + r0 + ", currentGeneration=" + ObricListeningMainProcessManager.l);
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("ObricListeningMainPM", "forward Surface linked ack, generation=" + r0);
        IObricInteractorPresentationBridgeService r1 = ObricListeningMainProcessManager.e;
        if (r1 == null) goto L9;
        ObricListeningMainProcessManager.o(ObricListeningMainProcessManager.a, "acknowledgeChildSurfaceLinked", r1, new r0(r0));
    L9:
        return Unit.INSTANCE;
    }
}
