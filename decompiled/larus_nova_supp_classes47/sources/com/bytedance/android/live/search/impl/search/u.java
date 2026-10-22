package com.bytedance.android.live.search.impl.search;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public u(t r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        ra1.h r5 = (ra1.h) r4;
        String r0 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.a = r0;
        t r1 = this.a;
        if (r1.b != this.c) goto L6;
        r1.d.Xp(r5);
        return;
    }
}
