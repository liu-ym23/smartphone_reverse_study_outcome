package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public f(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        int r0 = qo0.a.a;
        qo0.a.b("MemoryContextService", "fetch preset data fail, error: " + r5, null);
        this.a.invoke(r5);
    }
}
