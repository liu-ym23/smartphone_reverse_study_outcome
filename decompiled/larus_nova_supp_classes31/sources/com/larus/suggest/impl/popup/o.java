package com.larus.suggest.impl.popup;

import com.larus.platform.api.o0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements o0 {
    public final /* synthetic */ NexPulseDialog a;

    public o(NexPulseDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.platform.api.o0
    public final void a(yq9.e r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        if (Intrinsics.areEqual(r7.a, "mdlhitcachesize") == false) goto L13;
        FLogger.a.i("NexPulseDialog", "onVideoEngineInfo " + r7);
        NexPulseDialog r0 = this.a;
        if (r7.d <= 0) goto L7;
    L10:
        boolean r8 = true;
    L11:
        r0.t = Boolean.valueOf(r8);
        return;
    L7:
        if (com.larus.utils.o0.d(r7.c) == true) goto L10;
        r8 = false;
        goto L11
    }
}
