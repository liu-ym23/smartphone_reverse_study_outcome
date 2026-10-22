package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.model.MultiLinkEnlargeTipsConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends g {
    public final String f;
    public final int g;
    public final int h;
    public final boolean i;
    public final DataCenter j;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean l() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (this.i == false) goto L5;
        return 2131251478;
    L5:
        return 2131251601;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (CPositionContext.a.b(CPositionContext.Companion) == false) goto L17;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L13;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L13;
        if (r1.isLiveTypeAudio() != true) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.d;
        MultiLinkEnlargeTipsConfig r3 = (MultiLinkEnlargeTipsConfig) r2.getValue();
        if (r3.getFirstShowTimestamp() != 0) goto L17;
        r3.setFirstShowTimestamp(System.currentTimeMillis());
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
    L13:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.c;
        MultiLinkEnlargeTipsConfig r5 = (MultiLinkEnlargeTipsConfig) r4.getValue();
        if (r5.getFirstShowTimestamp() != 0) goto L17;
        r5.setFirstShowTimestamp(System.currentTimeMillis());
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
    L17:
        if (this.i == false) goto L20;
        return s1.B(2131922758);
    L20:
        return s1.B(2131922760);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String f() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int g() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int h() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (fj0.e.l() == false) goto L8;
        if (fj0.c.a() == true) goto L8;
        f2.b(2131919053, 0);
        return;
    L8:
        if (LinkMicGameContext.Companion.e() == false) goto L10;
        f2.b(2131919051, 0);
        return;
    L10:
        this.e.z0(this.i, this.j);
    }

    public d(q0 r7, boolean r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r7, "action");
        super(r7);
        this.i = r8;
        this.j = r9;
        CPositionContext.a r10 = CPositionContext.Companion;
        r10.getClass();
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        boolean r12 = true;
        if (r11 == null) goto L9;
        IRoom r13 = (IRoom) r11.getValue();
        if (r13 == null) goto L9;
        if (r13.isLiveTypeAudio() != true) goto L9;
        MultiLinkEnlargeTipsConfig r14 = (MultiLinkEnlargeTipsConfig) com.bytedance.android.livesdk.sharedpref.c.d.getValue();
    L11:
        if (r14.getFirstShowTimestamp() != 0) goto L13;
    L15:
        boolean r0 = false;
    L16:
        boolean r15 = r14.getHasClicked();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getVideoTalkRoomSubScene();
        if (r1 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L23;
        Integer r4 = Integer.valueOf(r3.a);
    L24:
        String r5 = "";
        if (r4 != null) goto L28;
    L30:
        boolean r16 = CPositionContext.a.a("");
    L31:
        if (r16 == false) goto L35;
        if (r15 == true) goto L35;
        if (r0 == true) goto L35;
    L36:
        if (r12 == false) goto L38;
        r5 = s1.B(2131922753);
    L38:
        this.f = r5;
        this.g = -1;
        this.h = 2131248780;
        return;
    L35:
        r12 = false;
        goto L36
    L28:
        if (r4.intValue() != 8) goto L30;
        r16 = r10.c();
    L23:
        r4 = null;
        goto L24
    L13:
        if ((System.currentTimeMillis() - r14.getFirstShowTimestamp()) <= 86400000) goto L15;
        r0 = true;
    L9:
        r14 = (MultiLinkEnlargeTipsConfig) com.bytedance.android.livesdk.sharedpref.c.c.getValue();
        goto L11
    }
}
