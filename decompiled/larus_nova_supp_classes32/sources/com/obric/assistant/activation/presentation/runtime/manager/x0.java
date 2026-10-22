package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX WARN: Loop in anonymous inline: com.obric.assistant.activation.presentation.runtime.manager.x0, path: [com.obric.assistant.activation.presentation.runtime.manager.f1, com.obric.assistant.activation.presentation.runtime.manager.g1, com.obric.assistant.activation.presentation.runtime.manager.i1, com.obric.assistant.activation.presentation.runtime.manager.x0] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class x0 implements Function0 {
    public final /* synthetic */ ObricAiKeyGestureAction a;

    public /* synthetic */ x0(ObricAiKeyGestureAction r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricAiKeyGestureAction r0 = this.a;
        ObricListeningMainProcessManager r1 = ObricListeningMainProcessManager.a;
        f1 r2 = new f1(r0);
        r1.getClass();
        if (ObricListeningMainProcessManager.c("AI key acknowledgement", r2) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (ObricListeningMainProcessManager.f == true) goto L9;
        FLogger.a.i("ObricListeningMainPM", "ignore AI key acknowledgement without child owner, action=" + r0);
        return Unit.INSTANCE;
    L9:
        if (r0 != ObricAiKeyGestureAction.SINGLE_PRESS) goto L11;
    L13:
        ObricListeningMainProcessManager.g(new g1(r0));
        return Unit.INSTANCE;
    L11:
        if (r0 == ObricAiKeyGestureAction.DOUBLE_PRESS) goto L13;
        FLogger.a.i("ObricListeningMainPM", "ignore non-terminal AI key acknowledgement, action=" + r0);
        return Unit.INSTANCE;
    }
}
