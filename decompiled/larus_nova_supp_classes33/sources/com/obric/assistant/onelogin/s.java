package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s implements Function0 {
    public /* synthetic */ s() {
    }

    public final Object invoke() {
        FLogger.a.i("ObricOneLoginUtils", "system logout success");
        StateFlowImpl r0 = c0.a;
    L3:
        Object r1 = r0.getValue();
        ((Boolean) r1).booleanValue();
        if (r0.compareAndSet(r1, Boolean.FALSE) == false) goto L3;
        return Unit.INSTANCE;
    }
}
