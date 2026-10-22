package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import laa.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class i6 implements Function1 {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ i6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        OrionInstructionComponent r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        int r1 = OrionInstructionComponent.p1;
        FLogger.a.i("OrionExtraComponent", "onSpeakerVisibleChanged, mockSpeakerVisible: " + r6);
        r0.T = r6;
        r0.l4();
        m r2 = (m) r0.C.getValue();
        if (r2 == null) goto L6;
        r2.rT(r6);
    L6:
        return Unit.INSTANCE;
    }
}
