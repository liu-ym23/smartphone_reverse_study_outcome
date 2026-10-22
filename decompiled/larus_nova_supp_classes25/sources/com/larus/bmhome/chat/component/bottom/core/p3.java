package com.larus.bmhome.chat.component.bottom.core;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p3 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ p3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r3, "it");
        r0.y5(null);
        return Unit.INSTANCE;
    }
}
