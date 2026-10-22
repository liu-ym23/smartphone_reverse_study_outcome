package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ PairUserAdapter.PairUserViewHolder a;
    public final /* synthetic */ h0 b;

    public x(PairUserAdapter.PairUserViewHolder r1, h0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        PairUserAdapter.PairUserViewHolder.a r15 = this.a.a;
        h0 r0 = this.b;
        VideoFriendPairDialog r16 = (VideoFriendPairDialog) r15;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "pairUser");
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L6:
        if (r2 == null) goto L33;
        LinkAnchorApi r4 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r5 = r2.getId();
        ILinkPlayerInfoBridge r3 = r0.getGuest();
        if (r3 == null) goto L12;
        IBaseUser r6 = r3.getUser();
        if (r6 == null) goto L12;
        String r7 = r6.getIdString();
    L13:
        long r8 = d5.c(r7);
        ILinkPlayerInfoBridge r9 = r0.getGuest();
        if (r9 == null) goto L18;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L18;
        String r11 = r10.getIdString();
    L19:
        ILinkPlayerInfoBridge r12 = r0.getInvestor();
        if (r12 == null) goto L24;
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L24;
        String r17 = r13.getIdString();
    L25:
        long r18 = d5.c(r17);
        ILinkPlayerInfoBridge r19 = r0.getInvestor();
        if (r19 == null) goto L30;
        IBaseUser r20 = r19.getUser();
        if (r20 == null) goto L30;
        String r110 = r20.getIdString();
    L31:
        r4.openPair(r5, r8, r11, r18, r110).compose(RxUtil.rxSchedulerHelper()).subscribe(new c0(r2, r16, r0), new d0(r16, r0));
        throw null;
    L30:
        r110 = null;
    L24:
        r17 = null;
    L18:
        r11 = null;
    L12:
        r7 = null;
        goto L13
    L33:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
