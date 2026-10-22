package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k0 implements Function1 {
    public final /* synthetic */ hia.a a;
    public final /* synthetic */ ObricContinuousTalkUIComponent b;

    public /* synthetic */ k0(hia.a r1, ObricContinuousTalkUIComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        hia.a r0 = this.a;
        final ObricContinuousTalkUIComponent r1 = this.b;
        int r2 = ObricContinuousTalkUIComponent.M;
        Intrinsics.checkNotNullParameter((hia.a.d) r4, "it");
        hia.c.a(r0);
        if (r1.n != r0) goto L5;
        r1.n = null;
        r1.F = ContinuousTalkStatus.STOPPED;
        com.larus.utils.t0.e(new m0(r1));
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.a.i("ObricContinuousTalkUIComponent", "skip clearing replaced session after stopAsync");
        goto L7
    }
}
