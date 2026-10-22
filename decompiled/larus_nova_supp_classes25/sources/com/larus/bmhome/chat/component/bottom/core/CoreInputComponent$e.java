package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.Lifecycle;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CoreInputComponent$e implements Function1<rp8.d, Unit> {
    public final /* synthetic */ CoreInputComponent a;

    public CoreInputComponent$e(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        rp8.d r5 = (t1a.c) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        rp8.d r6 = r5;
        CoreInputComponent r0 = this.a;
        if (r0.W == null) goto L24;
        if (r6.e != null) goto L7;
    L9:
        this.a.k4().N();
        if (this.a.k4().Y() == true) goto L12;
        this.a.Kf(false);
    L12:
        Boolean r7 = r6.d;
        if (r7 == null) goto L21;
        if (r7.booleanValue() == false) goto L17;
    L19:
        this.a.k4().zM();
        goto L21
    L17:
        if (this.a.F4().showBottomMenu() == false) goto L19;
        this.a.k4().C1(false, true, "config");
    L21:
        if (this.a.F4().takeOverConfig().e == true) goto L24;
        this.a.k4().Rk();
        goto L24
    L7:
        if (((BaseComponentFeatureInternal) r0).a.getCurrentState() != Lifecycle.State.RESUMED) goto L9;
        this.a.Q3(r6);
    L24:
        return Unit.INSTANCE;
    }
}
