package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ k5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        CoreInputComponent r0 = this.a;
        boolean r10 = ((Boolean) r9).booleanValue();
        r0.L1 = r10;
        r0.W2 = Boolean.valueOf(r10);
        if (r0.v1 == false) goto L5;
        r0.W6();
    L5:
        r0.Q6();
        boolean r1 = r0.F4().takeOverConfig().e;
        a r2 = r0.Zd();
        boolean r3 = false;
        if (r2 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        FLogger.a.i("CoreInputComponent", "[observeImeStatus] onStart, visible:" + r10 + ", disableAutoResetHint:" + r1 + ", inVoiceMixInput:" + r4);
        if (r0.F4().takeOverConfig().e == true) goto L20;
        a r11 = r0.Zd();
        if (r11 != null) goto L16;
    L18:
        if (r3 == true) goto L20;
        r0.k4().Rk();
        goto L20
    L16:
        if (r11.DG() != true) goto L18;
        r3 = true;
    L20:
        fx9.a r12 = (fx9.a) r0.U.getValue();
        if (r12 == null) goto L24;
        r12.Nk(fx9.b.b.b);
    L24:
        return Unit.INSTANCE;
    L8:
        if (r2.DG() != true) goto L10;
        r4 = true;
        goto L11
    }
}
