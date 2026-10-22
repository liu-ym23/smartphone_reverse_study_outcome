package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i1 implements Function1 {
    public final /* synthetic */ ObricAiKeyGestureAction a;

    public /* synthetic */ i1(ObricAiKeyGestureAction r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ObricAiKeyGestureAction r0 = this.a;
        IObricInteractorPresentationBridgeService r4 = (IObricInteractorPresentationBridgeService) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.acknowledgeGesture(r0.ordinal());
        return Unit.INSTANCE;
    }
}
