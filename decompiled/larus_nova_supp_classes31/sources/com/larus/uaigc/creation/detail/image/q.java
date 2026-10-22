package com.larus.uaigc.creation.detail.image;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class q implements Function1 {
    public final /* synthetic */ BigImageDetailFragment a;

    public /* synthetic */ q(BigImageDetailFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        int r1 = BigImageDetailFragment.I;
        this.a.ha0((Throwable) r3, "saveBitmapWithCheckWatermark");
        return Unit.INSTANCE;
    }
}
