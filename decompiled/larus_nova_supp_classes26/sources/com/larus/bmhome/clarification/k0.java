package com.larus.bmhome.clarification;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k0 implements Function1 {
    public /* synthetic */ k0() {
    }

    public final Object invoke(Object r3) {
        Intent r4 = (Intent) r3;
        int r5 = ClarificationComponent.k0;
        FLogger.a.i("ClarificationComponent", "clarification photo edit canceled or failed");
        return Unit.INSTANCE;
    }
}
