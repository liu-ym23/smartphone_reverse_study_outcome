package com.bytedance.android.live.liveinteract.interact.audience;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements qh0.d<rh0.a> {
    public final /* synthetic */ rj0.b a;

    public b(rj0.b r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        this.a.onFailed(r2);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r1) {
        this.a.onSuccess();
    }
}
