package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ MultiLinkRivalsSearchViewHolder a;
    public final /* synthetic */ i11.b b;
    public final /* synthetic */ x8 c;

    public i(MultiLinkRivalsSearchViewHolder r1, i11.b r2, x8 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "dialog");
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        Iterator<IBaseUser> r4 = this.b.getInviteeList().iterator();
    L8:
        if (r4.hasNext() == false) goto L19;
        IBaseUser r5 = r4.next();
        com.bytedance.android.live.revenuelink.connect.n r6 = MultiLinkRivalsSearchViewHolder.T3(this.a);
        if (r2 == null) goto L18;
        if (r6 == null) goto L18;
        int r8 = MultiLinkRivalsSearchViewHolder.U3(this.a);
        LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r7 == null) goto L15;
        long r9 = r7.c();
    L16:
        long r12 = r5.getLiveRoomId();
        String r13 = iz.a.a(r5);
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r6.e(new d11.c(r8, r9, r12, r13, r5.getCastSecUid(), 0, "cancel_for_apply", ""), null);
        goto L18
    L15:
        r9 = 0;
    L18:
        r2 = r2;
        goto L8
    L19:
        MultiLinkRivalsSearchViewHolder r3 = this.a;
        r3.v.v6(r3.l, this.c, r3.u);
        r19.dismiss();
        return;
    L5:
        r2 = null;
        goto L6
    }
}
