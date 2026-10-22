package com.larus.bmhome.chat.component.bottom.core;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l3 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ l3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((ImageView) r4, "it");
        r0.k4().r0(null, r0.q4(), r0.p4());
        return Unit.INSTANCE;
    }
}
