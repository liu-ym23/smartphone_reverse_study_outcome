package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.revlink.link.core.service.s;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements c<f> {
    public Disposable a;
    public final s b;
    public final d c;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public g(s r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r2;
        this.c = r3;
    }
}
