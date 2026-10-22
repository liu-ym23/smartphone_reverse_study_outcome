package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.livesdk.message.model.ReplyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements qh0.d<rh0.a> {
    public final /* synthetic */ BasePkInteractGuestWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;

    @Override // qh0.d
    public final void b(BaseCheckException r9) {
        Intrinsics.checkNotNullParameter(r9, "exception");
        q r1 = this.a.b;
        if (r1 == null) goto L5;
        r1.g(this.c, this.d, ReplyType.Reject.ordinal(), this.b, this.a.xq());
    L5:
        dl0.m.a.getClass();
        dl0.m.v(r9);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r3) {
        this.a.Cq(this.b, new d(this));
    }

    public e(BasePkInteractGuestWidget r1, long r2, String r4, int r5) {
        this.a = r1;
        this.b = 2;
        this.c = r2;
        this.d = r4;
        this.e = r5;
    }
}
