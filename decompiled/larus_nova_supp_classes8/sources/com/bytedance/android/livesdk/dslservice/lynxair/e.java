package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import io.reactivex.functions.Consumer;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ m b;

    public e(a r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        this.a.b = 2;
        m r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(DSLType.LynxAir, r5.toString(), r5);
        return;
    }
}
