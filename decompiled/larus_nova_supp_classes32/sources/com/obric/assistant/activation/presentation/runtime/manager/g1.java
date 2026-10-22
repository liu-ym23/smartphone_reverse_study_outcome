package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g1 implements Function0 {
    public final /* synthetic */ ObricAiKeyGestureAction a;

    public /* synthetic */ g1(ObricAiKeyGestureAction r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricAiKeyGestureAction r0 = this.a;
        IObricInteractorPresentationBridgeService r1 = ObricListeningMainProcessManager.e;
        if (r1 == null) goto L6;
        ObricListeningMainProcessManager.o(ObricListeningMainProcessManager.a, "acknowledgeGesture", r1, new i1(r0));
    L6:
        return Unit.INSTANCE;
    }
}
