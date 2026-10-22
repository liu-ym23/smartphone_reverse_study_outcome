package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g0 implements Function0 {
    public final /* synthetic */ aba.a a;

    public /* synthetic */ g0(aba.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        aba.a r0 = this.a;
        if (ObricListeningMainProcessManager.o != r0) goto L5;
        ObricListeningMainProcessManager.o = null;
        FLogger.a.i("ObricListeningMainPM", "child Surface listener unregistered");
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("ObricListeningMainPM", "ignore stale child Surface listener unregister");
        goto L7
    }
}
