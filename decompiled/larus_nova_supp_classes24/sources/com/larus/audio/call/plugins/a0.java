package com.larus.audio.call.plugins;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a0 implements Function1 {
    public final /* synthetic */ CommonCallTimingPlugin a;

    public /* synthetic */ a0(CommonCallTimingPlugin r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        this.a.k3(((Long) r4).longValue());
        return Unit.INSTANCE;
    }
}
