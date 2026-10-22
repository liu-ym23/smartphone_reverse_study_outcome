package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ AnchorLinkUserViewHolder a;
    public final /* synthetic */ IRoom b;
    public final /* synthetic */ IRivalExtraInfo c;
    public final /* synthetic */ String d;

    public e(AnchorLinkUserViewHolder r1, IRoom r2, IRivalExtraInfo r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "dialog");
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L7:
        if (this.a.e.getLinkUserCenter().n().isEmpty() == true) goto L15;
        IBaseUser r4 = (IBaseUser) ListProtector.get(this.a.e.getLinkUserCenter().n(), 0);
        if (r2 == null) goto L15;
        com.bytedance.android.live.revenuelink.connect.n r3 = this.a.e.getLinkOutManagerFn();
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L13;
        long r7 = r5.c();
    L14:
        long r9 = r4.getLiveRoomId();
        String r12 = iz.a.a(r4);
        Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
        r3.e(new d11.c(7, r7, r9, r12, r4.getCastSecUid(), 1, "cancel_for_invite", ""), null);
        goto L15
    L13:
        r7 = 0;
    L15:
        AnchorLinkUserViewHolder r6 = this.a;
        r6.j.lz(this.b, r6.d, this.c, r6.i, this.d);
        r17.dismiss();
        return;
    L5:
        r2 = null;
        goto L7
    }
}
