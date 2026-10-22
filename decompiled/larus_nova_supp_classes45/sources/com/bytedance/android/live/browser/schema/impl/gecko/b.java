package com.bytedance.android.live.browser.schema.impl.gecko;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.browser.schema.core.d r5 = (com.bytedance.android.live.browser.schema.core.d) r4;
        com.bytedance.android.live.schema.api.utils.a.d("GeckoCDNCacheInterceptor", "update from updater");
        Object r0 = this.a.b;
        monitor-enter(r0);
        this.a.f.a(r5);     // Catch: Throwable -> L7
        a r1 = this.a;     // Catch: Throwable -> L7
        int r2 = com.bytedance.android.live.browser.schema.core.c.d;     // Catch: Throwable -> L7
        r1.a = com.bytedance.android.live.browser.schema.core.c.b.b(r5, r1.e);     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
