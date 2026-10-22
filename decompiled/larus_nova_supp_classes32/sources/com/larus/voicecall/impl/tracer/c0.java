package com.larus.voicecall.impl.tracer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c0 implements Function0 {
    public final /* synthetic */ VoiceCallTraceLogger a;
    public final /* synthetic */ z b;

    public /* synthetic */ c0(VoiceCallTraceLogger r1, z r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        this.a.d(this.b);
        return Unit.INSTANCE;
    }
}
