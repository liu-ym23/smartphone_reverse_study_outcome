package com.ss.ugc.live.sdk.msg.utils;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements d {
    public final WeakReference<d> a;

    public j(d r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = new WeakReference(r2);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r2) {
        Intrinsics.checkNotNullParameter(r2, "whatResult");
        d r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
