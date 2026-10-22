package com.larus.bmhome.chat.component.bottom.core;

import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n3 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ n3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((FrameLayout) r3, "it");
        a r4 = r0.v4();
        if (r4 == null) goto L5;
        r4.V8();
    L5:
        int r5 = r0.F4().getActionShown();
        if (r5 != 1) goto L8;
    L10:
        r0.e4();
    L12:
        return Unit.INSTANCE;
    L8:
        if (r5 == 4) goto L10;
        com.obric.assistant.spi.keyguard.a.b(false, new k6(r0), 3);
        goto L12
    }
}
