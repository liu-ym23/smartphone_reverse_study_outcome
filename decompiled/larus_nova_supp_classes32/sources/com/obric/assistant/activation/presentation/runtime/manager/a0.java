package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class a0 implements Function0 {
    public final /* synthetic */ IObricInteractorPresentationBridgeService a;

    public /* synthetic */ a0(IObricInteractorPresentationBridgeService r1) {
        this.a = r1;
    }

    public final Object invoke() {
        IObricInteractorPresentationBridgeService r0 = this.a;
        IObricInteractorPresentationBridgeService r1 = ObricListeningMainProcessManager.e;
        if (r1 != null) goto L6;
        FLogger.a.i("ObricListeningMainPM", "ignore bridge detach without current, expected=" + r0.asBinder().hashCode());
        return Unit.INSTANCE;
    L6:
        if (r1.asBinder() == r0.asBinder()) goto L8;
        FLogger.a.i("ObricListeningMainPM", "ignore stale bridge detach, expected=" + r0.asBinder().hashCode() + ", current=" + r1.asBinder().hashCode());
        return Unit.INSTANCE;
    L8:
        ObricListeningMainProcessManager r2 = ObricListeningMainProcessManager.a;
        Function1 r3 = new l1();
        r2.getClass();
        ObricListeningMainProcessManager.n("unregisterMain", r1, false, r3);
        ObricListeningMainProcessManager.e = null;
        ObricListeningMainProcessManager.t.set(null);
        ObricListeningMainProcessManager.f();
        FLogger.a.i("ObricListeningMainPM", "interactor bridge detached");
        return Unit.INSTANCE;
    }
}
