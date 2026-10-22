package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.paid.PrivilegeClarityEventHub;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import j40.p4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends ir1.c {
    public final boolean p() {
        if (f() == true) goto L5;
    L8:
        return true;
    L5:
        if (d() == false) goto L8;
        return false;
    }

    public m() {
    }

    public final boolean o(DataCenter r6) {
        if (r6 == null) goto L7;
        Episode r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r6);
        if (r1 == null) goto L7;
        IMainEpisode r2 = (IMainEpisode) r1.castToOrNull(IMainEpisode.class);
    L9:
        if (f() == false) goto L19;
        if (i() == false) goto L19;
        if (r2 == null) goto L19;
        ReplayPaidInfo r3 = r2.getReplayPaidInfo();
        if (r3 == null) goto L19;
        if (r3.getPaidType() != 3) goto L19;
        return false;
    L19:
        if (f() == true) goto L21;
    L29:
        yq1.a r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r4 != null) goto L32;
    L44:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r7 = ReplayDataContext.a.b(r6);
        if (r7 == null) goto L65;
        com.bytedance.live.datacontext.j<kq1.c> r8 = r7.getPrivilegeClarityManager();
        if (r8 == null) goto L65;
        kq1.c r9 = (kq1.c) r8.getValue();
        if (r9 == null) goto L65;
        PrivilegeClarityEventHub r10 = r9.getEventHub();
        if (r10 == null) goto L65;
        NextLiveData<PrivilegeClarityEventHub.State> r11 = r10.a;
        if (r11 == null) goto L65;
        PrivilegeClarityEventHub.State r12 = (PrivilegeClarityEventHub.State) r11.getValue();
        if (r12 == null) goto L65;
        if (r12.showPlayerCard() != true) goto L65;
        if (f() == false) goto L64;
        if (i() == false) goto L64;
        return false;
    L64:
        return ((xs1.i) p4.a.getValue()).a();
    L65:
        fq1.a r13 = fq1.b.a();
        if (r13 == null) goto L73;
        IMainEpisode r14 = r13.a();
        if (r14 != null) goto L70;
        return false;
    L70:
        if (r14.isPaidReplay() != true) goto L75;
        return true;
    L75:
        return false;
    L73:
        return false;
    L32:
        if (yq1.a.C0428a.a(r4, r6, null, 2) != true) goto L44;
        yq1.a r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r0 == null) goto L44;
        if (r0.N(r6, PaidSceneEnum.PAID_REPLAY_PRIVILEGE_CLARITY) != true) goto L44;
        if (f() == false) goto L43;
        if (i() == false) goto L43;
        return false;
    L43:
        return ((xs1.i) p4.a.getValue()).a();
    L21:
        if (i() == false) goto L29;
        fq1.a r5 = fq1.b.a();
        if (r5 == null) goto L29;
        IMainEpisode r15 = r5.a();
        if (r15 == null) goto L29;
        if (r15.isPrivilegeCameraReplay() != true) goto L29;
        return false;
    L7:
        r2 = null;
        goto L9
    }
}
