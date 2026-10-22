package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import kotlin.jvm.internal.Intrinsics;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements qh0.d<rh0.a> {
    public final /* synthetic */ BaseGuestLinkWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ LinkApplyType e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Integer g;
    public final /* synthetic */ Integer h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ int k;
    public final /* synthetic */ xc.a l;

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.U(r3);
        x.K(r3);
        InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), this.b, r3);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r19) {
        com.bytedance.android.live.liveinteract.plantform.core.n r2 = this.a.b;
        if (r2 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.core.n.a(r2, this.b, this.c, this.d, this.e, false, this.f, this.g, this.h, null, this.i, this.j, this.k, null, this.l, 4368);
    L5:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.V();
        x.L();
        InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), this.b);
    }

    public q(BaseGuestLinkWidget r1, int r2, int r3, LinkApplyType r4, String r5, Integer r6, Integer r7, boolean r8, boolean r9, int r10, xc.a r11) {
        this.a = r1;
        this.b = r2;
        this.c = -1;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
    }
}
