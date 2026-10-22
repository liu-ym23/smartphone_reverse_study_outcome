package com.larus.bmhome.chat.component.bottom.bottommenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b0 implements Function1 {
    public final /* synthetic */ BottomMenuComponent a;

    public /* synthetic */ b0(BottomMenuComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        final BottomMenuComponent r0 = this.a;
        final String r5 = (String) r4;
        int r1 = BottomMenuComponent.x1;
        r0.m3("click_keyboard_plus_shoot", ((Boolean) r0.V0.getValue()).booleanValue(), new i0(r0, r5));
        return Unit.INSTANCE;
    }
}
