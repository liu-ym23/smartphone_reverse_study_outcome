package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.v4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends com.bytedance.android.live.revenuelink.connect.d {
    public final /* synthetic */ j a;

    public g(j r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void Tg(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        j r4 = this.a;
        if (r4.u == false) goto L6;
        r4.h.postValue(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void q9(d11.c r1, long r2, ey.l r4) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r1, "params");
        j r3 = this.a;
        if (r3.u == false) goto L6;
        r3.h.postValue(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void O8(d11.b r2, com.bytedance.android.livesdk.link.model.f r3, long r4, ey.l r6) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r3, "applyResult");
        super.O8(r2, r3, r4, r6);
        j r5 = this.a;
        if (r5.u == false) goto L6;
        r5.h.postValue(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void Vc(d11.b r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r1, "params");
        j r4 = this.a;
        if (r4.u == false) goto L6;
        r4.h.postValue(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void hl(d11.d r2, long r3, v4 r5, ey.l r6) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "_inviteResult");
        super.hl(r2, r3, r5, r6);
        v4 r4 = r5.castTo(v4.class);
        ((InteractDialogPKSearchContract$View) this.a.c).ea0(r2.h, r2, r4);
        j r7 = this.a;
        r7.y = false;
        if (r7.u == false) goto L6;
        r7.h.postValue(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.d(r2);
        ((InteractDialogPKSearchContract$View) this.a.c).da0(r2);
        j r4 = this.a;
        r4.y = false;
        if (r4.u == false) goto L6;
        r4.h.postValue(Boolean.TRUE);
        return;
    }
}
