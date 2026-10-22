package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ xaa.b a;

    public /* synthetic */ h0(com.obric.assistant.view.listening.h r1) {
        this.a = r1;
    }

    public final Object invoke() {
        xaa.b r0 = this.a;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("registerPresentationListener, replacing=");
        xaa.b r3 = ObricListeningMainProcessManager.j;
        if (r3 == null) goto L6;
        if (r3 == r0) goto L6;
        boolean r4 = true;
    L7:
        r2.append(r4);
        r2.append(", ");
        ObricListeningMainProcessManager r5 = ObricListeningMainProcessManager.a;
        r5.getClass();
        r2.append(ObricListeningMainProcessManager.m());
        r1.i("ObricListeningMainPM", r2.toString());
        xaa.b r6 = ObricListeningMainProcessManager.j;
        if (r6 == r0) goto L12;
        if (r6 == null) goto L11;
        r6.a(ObricListeningPresentationState.g);
    L11:
        ObricListeningMainProcessManager.j = r0;
    L12:
        ObricListeningMainProcessManager.j(r5);
        return Unit.INSTANCE;
    L6:
        r4 = false;
        goto L7
    }
}
