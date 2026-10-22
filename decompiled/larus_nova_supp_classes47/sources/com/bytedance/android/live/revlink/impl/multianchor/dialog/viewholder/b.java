package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ AnchorLinkUserViewHolder a;
    public final /* synthetic */ IRoom b;
    public final /* synthetic */ IRivalExtraInfo c;

    public b(AnchorLinkUserViewHolder r1, IRoom r2, IRivalExtraInfo r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r20, int r22) {
        Intrinsics.checkNotNullParameter(r20, "dialog");
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        String r3 = null;
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        Iterator<IBaseUser> r4 = this.a.e.getLinkUserCenter().getInviteeList().iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        IBaseUser r5 = r4.next();
        if (r2 == null) goto L8;
        com.bytedance.android.live.revenuelink.connect.n r6 = this.a.e.getLinkOutManagerFn();
        LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r7 == null) goto L14;
        long r9 = r7.c();
    L15:
        long r12 = r5.getLiveRoomId();
        String r13 = iz.a.a(r5);
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r6.e(new d11.c(7, r9, r12, r13, r5.getCastSecUid(), 0, "cancel_for_apply", ""), null);
        goto L8
    L14:
        r9 = 0;
        goto L15
    L16:
        AnchorLinkUserViewHolder r8 = this.a;
        i21.b r10 = r8.j;
        IRoom r14 = this.b;
        int r15 = r8.d;
        IRivalExtraInfo r16 = this.c;
        int r17 = r8.i;
        q21.g.a r18 = r8.f;
        if (r18 == null) goto L19;
        r3 = r18.g;
    L19:
        r10.a10(r14, r15, r16, r17, r3);
        r20.dismiss();
        return;
    L5:
        r2 = null;
        goto L6
    }
}
