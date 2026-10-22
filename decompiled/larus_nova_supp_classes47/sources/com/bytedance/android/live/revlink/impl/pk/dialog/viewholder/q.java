package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ PKRivalsRankViewHolder a;
    public final /* synthetic */ i11.b b;
    public final /* synthetic */ m2 c;

    public q(PKRivalsRankViewHolder r1, i11.b r2, m2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "dialog");
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L7:
        if (this.b.n().isEmpty() == true) goto L16;
        IBaseUser r4 = (IBaseUser) ListProtector.get(this.b.n(), 0);
        com.bytedance.android.live.revenuelink.connect.n r5 = PKRivalsRankViewHolder.T3(this.a);
        if (r2 == null) goto L16;
        if (r5 == null) goto L16;
        int r7 = PKRivalsRankViewHolder.U3(this.a);
        LinkCrossRoomDataHolder r6 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r6 == null) goto L14;
        long r8 = r6.c();
    L15:
        long r10 = r4.getLiveRoomId();
        String r12 = iz.a.a(r4);
        Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
        r5.e(new d11.c(r7, r8, r10, r12, r4.getCastSecUid(), 1, "cancel_for_invite", ""), null);
        goto L16
    L14:
        r8 = 0;
    L16:
        PKRivalsRankViewHolder r3 = this.a;
        r3.v.c(r3.k, this.c);
        r18.dismiss();
        return;
    L5:
        r2 = null;
        goto L7
    }
}
