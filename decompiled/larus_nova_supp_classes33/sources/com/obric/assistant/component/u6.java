package com.obric.assistant.component;

import com.obric.assistant.agent.ObricAgentService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class u6 implements Function0 {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ u6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final OrionInstructionComponent r0 = this.a;
        int r1 = OrionInstructionComponent.p1;
        r0.getClass();
        ObricAgentService.a.a(new w6(r0), new x6(r0), new y6(r0));
        return Unit.INSTANCE;
    }
}
