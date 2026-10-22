package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f0 implements Function0 {
    public final /* synthetic */ aba.a a;

    public /* synthetic */ f0(aba.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        aba.a r0 = this.a;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("registerChildSurfaceListener, replacing=");
        aba.a r3 = ObricListeningMainProcessManager.o;
        if (r3 == null) goto L6;
        if (r3 == r0) goto L6;
        boolean r4 = true;
    L7:
        r2.append(r4);
        r1.i("ObricListeningMainPM", r2.toString());
        ObricListeningMainProcessManager.o = r0;
        ObricListeningMainProcessManager.a.getClass();
        r0.onChildListeningSurfaceChanged(ObricListeningMainProcessManager.d());
        return Unit.INSTANCE;
    L6:
        r4 = false;
        goto L7
    }
}
