package com.bytedance.android.live.revlink.impl.player;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ j a;

    public m(j r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        e r0 = this.a.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) sh6.c.b(r4), Boolean.TRUE) == false) goto L7;
        int r5 = 0;
    L8:
        r0.a(r5);
        return;
    L7:
        r5 = 8;
        goto L8
    }
}
