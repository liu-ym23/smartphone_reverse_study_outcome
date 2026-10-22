package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class t0 implements Function1 {
    public /* synthetic */ t0() {
    }

    public final Object invoke(Object r2) {
        IObricInteractorPresentationBridgeService r3 = (IObricInteractorPresentationBridgeService) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.confirmListeningStarted();
        return Unit.INSTANCE;
    }
}
