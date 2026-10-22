package com.obric.assistant.activation.presentation.runtime.session.client;

import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r2) {
        final IObricInteractorBridgeService r3 = (IObricInteractorBridgeService) r2;
        Intrinsics.checkNotNullParameter(r3, "service");
        InteractionSessionProxyClient.g("flushPendingEvents", new f(r3));
        return Unit.INSTANCE;
    }
}
