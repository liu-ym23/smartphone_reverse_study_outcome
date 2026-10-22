package com.ss.android.lark.integrator.ccm.spacekit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements Consumer<Boolean> {
    public final /* synthetic */ boolean[] a;

    public m(boolean[] r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        Boolean r5 = (Boolean) r4;
        boolean[] r0 = this.a;
        if (r0[0] == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        r0[0] = r6;
        return;
    L5:
        if (r5.booleanValue() == true) goto L8;
        r6 = false;
        goto L9
    }
}
