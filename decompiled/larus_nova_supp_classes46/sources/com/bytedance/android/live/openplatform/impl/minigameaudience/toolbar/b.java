package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ CandyToolbarContextService a;
    public final /* synthetic */ Function1 b;

    public b(CandyToolbarContextService r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        int r0 = qo0.a.a;
        qo0.a.b(this.a.a, "request candy entrance_info failed", r4);
        Function1 r1 = this.b;
        String r5 = r4.getMessage();
        if (r5 != null) goto L5;
        r5 = "candy entrance error: request candy entrance_info failed.";
    L5:
        r1.invoke(r5);
    }
}
