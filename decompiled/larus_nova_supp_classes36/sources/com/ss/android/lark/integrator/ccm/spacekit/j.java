package com.ss.android.lark.integrator.ccm.spacekit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Consumer<Long> {
    public final /* synthetic */ long[] a;

    public j(long[] r1) {
        this.a = r1;
    }

    public final void accept(Object r7) throws Exception {
        long[] r0 = this.a;
        r0[0] = r0[0] + ((Long) r7).longValue();
    }
}
