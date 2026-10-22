package com.obric.assistant.component;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class w5 implements Function2 {
    public final /* synthetic */ OrionChatWindowComponent a;

    public /* synthetic */ w5(OrionChatWindowComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        OrionChatWindowComponent r0 = this.a;
        ForegroundInteractionPhase r5 = (ForegroundInteractionPhase) r4;
        int r1 = OrionChatWindowComponent.T;
        Intrinsics.checkNotNullParameter((String) r3, "it");
        Intrinsics.checkNotNullParameter(r5, "state");
        r0.E3(r5);
        return Unit.INSTANCE;
    }
}
