package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a a;

    public p(ProcessManager.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.ies.tools.prefetch.i.a r0 = this.a;
        r0.a((Throwable) r2);
    }
}
