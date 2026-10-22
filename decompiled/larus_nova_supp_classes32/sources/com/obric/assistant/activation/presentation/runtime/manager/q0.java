package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class q0 implements Function0 {
    public final /* synthetic */ xaa.b a;

    public /* synthetic */ q0(com.obric.assistant.view.listening.h r1) {
        this.a = r1;
    }

    public final Object invoke() {
        xaa.b r0 = this.a;
        if (ObricListeningMainProcessManager.j == r0) goto L5;
        FLogger.a.i("ObricListeningMainPM", "ignore stale presentation listener unregister");
        return Unit.INSTANCE;
    L5:
        r0.a(ObricListeningPresentationState.g);
        ObricListeningMainProcessManager.j = null;
        FLogger.a.i("ObricListeningMainPM", "presentation listener unregistered");
        return Unit.INSTANCE;
    }
}
