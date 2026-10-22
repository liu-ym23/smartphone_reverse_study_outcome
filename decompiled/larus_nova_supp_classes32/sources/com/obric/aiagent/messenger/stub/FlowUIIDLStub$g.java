package com.obric.aiagent.messenger.stub;

import com.obric.assistant.spi.keyguard.KeyguardService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$g implements Function0<Unit> {
    public static final FlowUIIDLStub$g a = null;

    static {
        a = new FlowUIIDLStub$g();
    }

    public FlowUIIDLStub$g() {
    }

    public final Object invoke() {
        KeyguardService.a.cancelDismissKeyguard();
        return Unit.INSTANCE;
    }
}
