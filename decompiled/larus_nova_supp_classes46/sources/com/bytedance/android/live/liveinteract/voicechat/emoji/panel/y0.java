package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y0 extends g {
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 2131251840;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return s1.B(2131918021);
    }

    public y0(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        rj0.l.n2.getClass();
        rj0.l r9 = rj0.l.a.a();
        if (r9 == null) goto L5;
        Boolean r10 = Boolean.valueOf(r9.T2());
    L6:
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L13;
        TalkRoomLogUtils.B0(r1, Integer.valueOf(r4.a), null, 4);
    L13:
        TalkRoomLogUtils.Q0(r1);
        r1.put("user_type", "guest");
        if (Intrinsics.areEqual(r10, Boolean.FALSE) == false) goto L16;
        String r0 = "before";
    L17:
        r1.put("filp_status", r0);
        r1.put("request_page", "connection_interact_panel");
        int r5 = 2;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_connection_camera_flip", r1, new Object[]{am2.x.class, IRoom.class});
        this.e.dismissDialog();
        if (vm2.i.g() == true) goto L20;
    L24:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r6 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r6 == null) goto L28;
        com.bytedance.android.live.liveinteract.plantform.camera.b.C0048b.a(r6, true, true, true, true, "switch camera panel item onClick", 16);
        return;
    L28:
        return;
    L20:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L23;
        r5 = 1;
    L23:
        com.bytedance.android.livesdk.sharedpref.d.m(r5);
        goto L24
    L16:
        r0 = "after";
        goto L17
    L5:
        r10 = null;
        goto L6
    }
}
