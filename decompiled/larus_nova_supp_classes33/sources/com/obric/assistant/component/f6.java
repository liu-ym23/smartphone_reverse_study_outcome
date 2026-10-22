package com.obric.assistant.component;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f6 implements Function1 {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ f6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        OrionInstructionComponent r0 = this.a;
        int r1 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter((ArrayList) r3, "it");
        r0.B4("window_custom_bar_actions_changed");
        return Unit.INSTANCE;
    }
}
