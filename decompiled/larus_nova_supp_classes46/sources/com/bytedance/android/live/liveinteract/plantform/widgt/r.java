package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.message.model.ReplyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements qh0.d<rh0.a> {
    public final /* synthetic */ BaseGuestLinkWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;

    @Override // qh0.d
    public final void b(BaseCheckException r10) {
        Intrinsics.checkNotNullParameter(r10, "exception");
        com.bytedance.android.live.liveinteract.plantform.core.n r1 = this.a.b;
        if (r1 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.core.n.g(r1, this.c, this.d, this.e, ReplyType.Reject.ordinal(), this.b, this.a.zq());
    L5:
        InteractLinkFullLinkMonitor.e(OperateType.REPLY.ordinal(), this.b, r10);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.U(r10);
        x.K(r10);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r10) {
        InteractLinkFullLinkMonitor.f(OperateType.REPLY.ordinal(), this.b);
        this.a.getClass();
        BaseGuestLinkWidget r11 = this.a;
        r11.l = System.currentTimeMillis();
        BaseGuestLinkWidget r12 = this.a;
        r12.m = "invite";
        com.bytedance.android.live.liveinteract.plantform.core.n r1 = r12.b;
        if (r1 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.core.n.g(r1, this.c, this.d, this.e, this.f, this.b, r12.zq());
    L5:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.V();
        x.L();
    }

    public r(BaseGuestLinkWidget r1, long r2, String r4, String r5, int r6) {
        this.a = r1;
        this.b = 2;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
