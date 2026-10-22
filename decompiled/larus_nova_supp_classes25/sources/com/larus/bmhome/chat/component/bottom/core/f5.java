package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f5 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ f5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        com.larus.asr.e2 r2 = r0.l4().Vl();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.vd();
    }
}
