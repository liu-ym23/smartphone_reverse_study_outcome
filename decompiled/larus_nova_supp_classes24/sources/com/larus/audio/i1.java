package com.larus.audio;

import d78.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i1 implements Function1 {
    public final /* synthetic */ RtcEngineInitManager a;
    public final /* synthetic */ d b;

    public /* synthetic */ i1(RtcEngineInitManager r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        RtcEngineInitManager r0 = this.a;
        d r1 = this.b;
        if (((Boolean) r3).booleanValue() == false) goto L5;
        r0.f(r1);
    L7:
        return Unit.INSTANCE;
    L5:
        r0.e(new Exception("RTC engine initialization failed"), false);
        goto L7
    }
}
