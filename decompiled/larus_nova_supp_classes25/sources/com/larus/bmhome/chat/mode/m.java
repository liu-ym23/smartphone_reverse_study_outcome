package com.larus.bmhome.chat.mode;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ m(ModeSwitchComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ModeSwitchComponent r0 = this.a;
        float r4 = ((Float) r3).floatValue();
        int r1 = ModeSwitchComponent.k0;
        r0.E3(r4);
        return Unit.INSTANCE;
    }
}
