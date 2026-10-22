package com.bytedance.android.annie.service.prefetch;

import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a a;

    public w(ProcessManager.b r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        com.bytedance.ies.tools.prefetch.i.a r0 = this.a;
        r0.a((Throwable) r10);
    }
}
