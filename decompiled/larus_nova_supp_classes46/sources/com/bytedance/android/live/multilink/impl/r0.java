package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r0 implements qh0.d<rh0.a> {
    public final /* synthetic */ IRoom a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ LinkMultiControlPresenter c;

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        InteractLinkFullLinkMonitor.e(OperateType.PRE_APPLY.ordinal(), 2, r3);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.U(r3);
        com.bytedance.android.live.liveinteract.plantform.utils.x.K(r3);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r3) {
        this.c.p0(this.a, this.b);
        InteractLinkFullLinkMonitor.f(OperateType.PRE_APPLY.ordinal(), 2);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.V();
        com.bytedance.android.live.liveinteract.plantform.utils.x.L();
    }

    public r0(LinkMultiControlPresenter r1, IRoom r2, LinkMultiControlWidget.e r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
