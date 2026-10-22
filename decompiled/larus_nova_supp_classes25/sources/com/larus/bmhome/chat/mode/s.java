package com.larus.bmhome.chat.mode;

import android.view.View;
import com.larus.platform.api.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ s(ModeSwitchComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ModeSwitchComponent r0 = this.a;
        Boolean r4 = (Boolean) r3;
        int r5 = ModeSwitchComponent.k0;
        if (r0.D3() == false) goto L12;
        ry8.b r6 = r0.B3();
        if (r6 == null) goto L20;
        g0 r7 = r6.C5();
        if (r7 == null) goto L20;
        View r8 = r7.getTitle();
        if (r8 == null) goto L20;
        r8.setVisibility(0);
    L20:
        r0.V3();
        return Unit.INSTANCE;
    L12:
        if (r0.F == false) goto L20;
        if (r0.w == false) goto L20;
        if (r0.B == true) goto L20;
        r0.C = true;
        if (r0.Si().getValue() != null) goto L20;
        r0.C3();
        goto L20
    }
}
