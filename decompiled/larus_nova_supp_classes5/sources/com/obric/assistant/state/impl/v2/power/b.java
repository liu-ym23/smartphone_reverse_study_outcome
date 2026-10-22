package com.obric.assistant.state.impl.v2.power;

import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class b implements Function1 {
    public /* synthetic */ b() {
    }

    public final Object invoke(Object r2) {
        IObricDeviceStateService.a r3 = (IObricDeviceStateService.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.onScreenOff();
        return Unit.INSTANCE;
    }
}
