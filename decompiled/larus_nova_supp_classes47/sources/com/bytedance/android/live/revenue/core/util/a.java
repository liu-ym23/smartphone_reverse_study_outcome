package com.bytedance.android.live.revenue.core.util;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements Continuation<Unit> {
    public final /* synthetic */ AsyncService a;

    public CoroutineContext getContext() {
        return this.a.a;
    }

    public a(AsyncService r1) {
        this.a = r1;
    }

    public final void resumeWith(Object r2) {
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof CancellationException) == true) goto L9;
        throw r3;
    }
}
