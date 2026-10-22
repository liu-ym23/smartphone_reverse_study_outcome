package com.obric.assistant.component;

import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l6 implements Function1 {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ l6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        OrionInstructionComponent r0 = this.a;
        KeyguardLockedState r5 = (KeyguardLockedState) r4;
        int r1 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter(r5, "it");
        r0.B4("window_keyguard_state_changed_" + r5);
        return Unit.INSTANCE;
    }
}
