package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public c(Function0 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        int r0 = qo0.a.a;
        qo0.a.c("MemoryContextService", "updateMemoryAbilityStatus success, result: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.j) r4.data).a());
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.j) r4.data).a() == false) goto L6;
        this.a.invoke();
        return;
    }
}
