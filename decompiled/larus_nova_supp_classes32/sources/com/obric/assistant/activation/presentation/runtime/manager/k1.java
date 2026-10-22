package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k1 implements Function0 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ k1(sha.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricListeningMainProcessManager.i = this.a;
        FLogger.a.i("ObricListeningMainPM", "child presentation timeout handler registered");
        return Unit.INSTANCE;
    }
}
