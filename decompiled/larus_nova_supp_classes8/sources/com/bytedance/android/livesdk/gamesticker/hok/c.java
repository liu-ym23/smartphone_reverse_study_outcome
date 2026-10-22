package com.bytedance.android.livesdk.gamesticker.hok;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Function0 e;

    public c(d r1, long r2, Function0 r4, long r5, Function0 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        this.a.getClass();
        if (r7 != null) goto L6;
    L8:
        long r0 = this.d + this.b;
        if (r7 != null) goto L12;
        return;
    L12:
        if (r7.longValue() != r0) goto L16;
        this.a.getClass();
        this.e.invoke();
        return;
    L16:
        return;
    L6:
        if (r7.longValue() != this.b) goto L8;
        this.a.getClass();
        this.c.invoke();
    }
}
