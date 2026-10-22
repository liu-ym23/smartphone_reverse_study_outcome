package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View;
import com.bytedance.android.livesdk.link.model.v4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends com.bytedance.android.live.revenuelink.connect.d {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void hl(d11.d r2, long r3, v4 r5, ey.l r6) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "inviteResult");
        super.hl(r2, r3, r5, r6);
        InteractDialogLinkRecordContract$View r4 = (InteractDialogLinkRecordContract$View) this.a.c;
        if (r4 == null) goto L5;
        r4.ca0(r2.h, (v4) r5.castTo(v4.class));
    L5:
        this.a.i = false;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
    public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r1, "params");
        InteractDialogLinkRecordContract$View r4 = (InteractDialogLinkRecordContract$View) this.a.c;
        if (r4 == null) goto L5;
        r4.ba0(r2);
    L5:
        this.a.i = false;
    }
}
