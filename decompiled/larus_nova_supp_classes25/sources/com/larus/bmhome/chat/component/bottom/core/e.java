package com.larus.bmhome.chat.component.bottom.core;

import fx9.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ CoreInputAbility b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public /* synthetic */ e(boolean r1, CoreInputAbility r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        CoreInputAbility r1 = this.b;
        boolean r2 = this.c;
        String r3 = this.d;
        if (r0 == false) goto L5;
        float r4 = 45.0f;
    L6:
        r1.f.on(r4);
        r1.f.EG(r0);
        r1.F().updateShowBottomMenu(r0);
        r1.f.qy();
        r1.l.invoke(Boolean.valueOf(r0), Boolean.valueOf(r2));
        a r5 = r1.A().Z60();
        if (r5 == null) goto L9;
        r5.Nk(fx9.b.a.b);
    L9:
        com.larus.bmhome.instruction.g r6 = r1.A().vc();
        if (r6 == null) goto L12;
        r6.Vm(r0, r3);
    L12:
        com.larus.bmhome.a0 r7 = com.larus.bmhome.b0.a(r1.g);
        if (r7 == null) goto L15;
        r7.ED(!r0, "menu");
    L15:
        ci8.d r8 = ci8.e.a(r1.g);
        if (r8 == null) goto L19;
        r8.hp(!r0);
    L19:
        return Unit.INSTANCE;
    L5:
        r4 = 0.0f;
        goto L6
    }
}
