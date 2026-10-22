package com.bytedance.android.live.revlink.link.core.layoutstatus;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements c<Object> {
    public final CompositeDisposable a;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.a.clear();
    }

    public m(h r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new CompositeDisposable();
    }
}
