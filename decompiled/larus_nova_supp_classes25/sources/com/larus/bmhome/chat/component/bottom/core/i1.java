package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import oaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i1 implements Function2 {
    public final /* synthetic */ CoreInputAbility a;

    public /* synthetic */ i1(CoreInputAbility r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, Object r6) {
        CoreInputAbility r0 = this.a;
        boolean r7 = ((Boolean) r5).booleanValue();
        boolean r8 = ((Boolean) r6).booleanValue();
        if (r7 == false) goto L7;
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r9 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(r0.a).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r9 == null) goto L10;
        r9.hP(true);
    L10:
        Function1<? super Boolean, Unit> r10 = r0.P;
        if (r10 == null) goto L13;
        r10.invoke(Boolean.valueOf(r7));
    L13:
        a r11 = (a) r0.K.getValue();
        if (r11 == null) goto L17;
        r11.h1(r7);
    L17:
        if (com.larus.platform.service.z2.a.getInstructionEntranceShowConfig().b() == false) goto L22;
        com.larus.bmhome.instruction.g r12 = r0.A().vc();
        if (r12 == null) goto L22;
        r12.SF();
    L22:
        return Unit.INSTANCE;
    L7:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r2 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(r0.a).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r2 == null) goto L10;
        r2.NL(!r8);
        goto L10
    }
}
