package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ v a;

    public w(v r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        sh6.b r7 = (sh6.b) r6;
        ph0.b r0 = (ph0.b) sh6.c.b(r7);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.b;
    L6:
        boolean r3 = true;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L25;
        ph0.b r5 = (ph0.b) sh6.c.b(r7);
        if (r5 != null) goto L17;
    L19:
        r3 = false;
    L20:
        v.d r8 = this.a.i;
        ph0.b r9 = (ph0.b) sh6.c.b(r7);
        if (r9 == null) goto L23;
        r1 = r9.b;
    L23:
        Intrinsics.checkNotNull(r1);
        r8.c(r1, r3);
        return;
    L17:
        if (r5.c != 2) goto L19;
    L25:
        return;
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
