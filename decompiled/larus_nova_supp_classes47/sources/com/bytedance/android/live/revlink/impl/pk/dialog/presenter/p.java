package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkRecordContract$View;
import com.bytedance.android.livesdk.link.model.v4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends com.bytedance.android.live.revenuelink.connect.d {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void hl(d11.d r2, long r3, v4 r5, ey.l r6) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "inviteResult");
        if (e21.a.a(r2.i) == true) goto L5;
        return;
    L5:
        super.hl(r2, r3, r5, r6);
        InteractDialogPkRecordContract$View r4 = (InteractDialogPkRecordContract$View) this.a.c;
        if (r4 == null) goto L8;
        r4.ca0(r2.h, (v4) r5.castTo(v4.class), this.a.k);
    L8:
        o r7 = this.a;
        r7.j = false;
        r7.k = 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        if (e21.a.a(r1.i) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r1, "params");
        InteractDialogPkRecordContract$View r4 = (InteractDialogPkRecordContract$View) this.a.c;
        if (r4 == null) goto L8;
        r4.ba0(r2);
    L8:
        o r6 = this.a;
        r6.j = false;
        r6.k = 0;
    }
}
