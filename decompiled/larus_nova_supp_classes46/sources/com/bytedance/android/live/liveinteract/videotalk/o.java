package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements qh0.d<rh0.a> {
    public final /* synthetic */ lg6.a a;

    public o(lh6.b.b r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        lg6.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFailed(r2);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r2) {
        lg6.a r3 = this.a;
        if (r3 == null) goto L6;
        r3.a(Unit.INSTANCE);
        return;
    }
}
