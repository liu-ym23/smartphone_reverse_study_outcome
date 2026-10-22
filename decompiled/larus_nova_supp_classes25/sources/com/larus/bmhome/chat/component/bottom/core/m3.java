package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m3 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ m3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((View) r3, "it");
        if (r0.F4().isHitTouristMode() == false) goto L6;
        r0.F4().openLoginForTour();
    L6:
        return Unit.INSTANCE;
    }
}
