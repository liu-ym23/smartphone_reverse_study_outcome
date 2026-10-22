package com.bytedance.android.live.livepkaudience.base;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ q a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public s(q r1, long r2) {
        this.a = r1;
        this.b = r2;
        this.c = "cancel_application";
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        this.a.g = false;
        long r0 = this.b;
        dl0.m.u(r6, System.currentTimeMillis() - r0, this.c);
        Iterator<h> r1 = this.a.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().D0(this.c, r6);
        goto L4
    }
}
