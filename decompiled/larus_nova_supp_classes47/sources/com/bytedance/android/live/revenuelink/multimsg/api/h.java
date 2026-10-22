package com.bytedance.android.live.revenuelink.multimsg.api;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements b {
    public final WeakReference<b> a;

    public h(b r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = new WeakReference(r2);
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.b
    public final void f(e<?, ? extends Exception> r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        b r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }
}
