package com.larus.bmhome.chat.mode;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ ModeSwitchComponent a;
    public final /* synthetic */ l0 b;

    public /* synthetic */ n(ModeSwitchComponent r1, l0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        ModeSwitchComponent r0 = this.a;
        l0 r1 = this.b;
        boolean r6 = ((Boolean) r5).booleanValue();
        boolean r2 = r0.y;
        r0.y = r6;
        if (r6 == false) goto L5;
        r0.z = false;
    L7:
        r1.removeCallbacks(r0.U);
        r0.V3();
        if (r0.z == false) goto L11;
        r1.postDelayed(r0.U, 100);
    L11:
        return Unit.INSTANCE;
    L5:
        if (r2 == false) goto L7;
        r0.z = true;
        goto L7
    }
}
