package com.larus.audio.call.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ com.larus.audio.call.arch.c a;

    public /* synthetic */ x(com.larus.audio.call.arch.c r1) {
        this.a = r1;
    }

    public final Object invoke() {
        id9.d r0 = this.a.j();
        if (r0 == null) goto L6;
        r0.p(TriggerMode.WAIT, null);
        return Unit.INSTANCE;
    L6:
        return null;
    }
}
