package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f1 implements Function0 {
    public final /* synthetic */ ObricAiKeyGestureAction a;

    public /* synthetic */ f1(ObricAiKeyGestureAction r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricAiKeyGestureAction r0 = this.a;
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "action");
        ObricListeningMainProcessManager.k(new x0(r0));
        return Unit.INSTANCE;
    }
}
