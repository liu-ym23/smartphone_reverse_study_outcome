package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.p;
import gd0.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorLinkInfoTopSelectSubView a;
    public final /* synthetic */ p b;

    public a(MultiAnchorLinkInfoTopSelectSubView r1, p r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r20) {
        IBaseUser r1 = this.b.getUser();
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r2 == null) goto L5;
        int r3 = r2.getCurrentMode();
    L6:
        long r6 = 0;
        if (v.a(r3, 64) == false) goto L17;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r4 = this.a.h;
        if (r4 == null) goto L27;
        n r5 = r4.getLinkOutManagerFn();
        if (r5 == null) goto L28;
        LinkCrossRoomDataHolder r8 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r8 == null) goto L15;
        r6 = r8.c();
    L15:
        long r12 = r1.getLiveRoomId();
        String r14 = iz.a.a(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        r5.e(new d11.c(7, r6, r12, r14, r1.getCastSecUid(), 0, "ceiling_view_canel_individual", ""), null);
        return;
    L28:
        return;
    L27:
        return;
    L17:
        if (v.a(r3, 4) == false) goto L30;
        com.bytedance.android.live.revlink.impl.pk.service.b r7 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r7 == null) goto L31;
        n r9 = r7.getLinkOutManagerFn();
        if (r9 == null) goto L32;
        LinkCrossRoomDataHolder r10 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r10 == null) goto L25;
        r6 = r10.c();
    L25:
        long r13 = r1.getLiveRoomId();
        String r15 = iz.a.a(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        r9.e(new d11.c(1, r6, r13, r15, r1.getCastSecUid(), 0, "ceiling_view_canel_individual", ""), null);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
