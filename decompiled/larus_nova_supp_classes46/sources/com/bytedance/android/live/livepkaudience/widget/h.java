package com.bytedance.android.live.livepkaudience.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import dl0.m;
import dl0.n;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements qh0.d<rh0.a> {
    public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;
    public final /* synthetic */ com.bytedance.android.live.livepkaudience.vm.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    @Override // qh0.d
    public final void b(BaseCheckException r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        com.bytedance.android.live.livepkaudience.vm.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.onError(r5.getDetailMessage());
    L5:
        String r1 = "switchCamera check onFailure detailMessage = " + r5.getDetailMessage() + ", linkType = " + this.c;
        ALogger.i(this.a.p, r1);
        m r2 = m.a;
        String r3 = this.a.p + "_switchCamera";
        r2.getClass();
        m.C(r3, r1);
        if (r5.getCheckType() != BaseCheckException.CheckType.ServerPermission) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.c;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, 2);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r7) {
        com.bytedance.android.live.livepkaudience.base.i r8 = this.a.s;
        m00.g r1 = null;
        if (r8 == null) goto L11;
        String r2 = n.d();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r3 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r3 == null) goto L7;
        String r4 = r3.getAudienceSelfLinkMicId();
    L8:
        LinkPlayerInfo r9 = r8.o(r2, r4);
        if (r9 == null) goto L11;
        int r10 = r9.getLinkType();
    L12:
        String r5 = "switchCamera check onResult skipShowBeauty = " + this.d + ", openCamera = " + this.e + ", currentLinkType = " + r10;
        ALogger.i(this.a.p, r5);
        m r6 = m.a;
        String r11 = this.a.p + "_switchCamera";
        r6.getClass();
        m.C(r11, r5);
        if (r10 == 2) goto L15;
    L19:
        com.bytedance.android.live.livepkaudience.vm.a r12 = this.b;
        if (r12 == null) goto L22;
        r12.onSuccess();
    L22:
        StringBuilder r13 = new StringBuilder("switchCamera check onResult else call mInteractVideoView = ");
        r13.append(this.a.x);
        r13.append(", as = ");
        v0 r0 = this.a.x;
        if ((r0 instanceof m00.g) == true) goto L25;
        r0 = null;
    L25:
        r13.append((m00.g) r0);
        String r14 = r13.toString();
        ALogger.i(this.a.p, r14);
        m.C(this.a.p + "_switchCamera", r14);
        m00.g r15 = this.a.x;
        if ((r15 instanceof m00.g) == false) goto L29;
        r1 = r15;
    L29:
        m00.g r16 = r1;
        if (r16 == null) goto L34;
        r16.r();
        return;
    L34:
        return;
    L15:
        if (this.d == true) goto L19;
        if (this.e == false) goto L19;
        this.a.Cq(1, new g(this));
        return;
    L7:
        r4 = null;
    L11:
        r10 = 2;
        goto L12
    }

    public h(LinkPkInteractAudienceGuestWidget r1, com.bytedance.android.live.livepkaudience.vm.a r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
