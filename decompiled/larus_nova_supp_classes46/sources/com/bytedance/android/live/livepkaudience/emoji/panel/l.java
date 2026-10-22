package com.bytedance.android.live.livepkaudience.emoji.panel;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends g {
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return 2131251840;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return s1.B(2131918021);
    }

    public l(f r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r9 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r9 == null) goto L5;
        Boolean r10 = Boolean.valueOf(r9.T2());
    L6:
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        RoomContext r1 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j r2 = r1.getVideoTalkRoomSubScene();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L15;
        el0.j.j(r0, Integer.valueOf(r4.a));
    L15:
        el0.j.o(r0);
        r0.put("user_type", "guest");
        if (Intrinsics.areEqual(r10, Boolean.FALSE) == false) goto L18;
        String r11 = "before";
    L19:
        r0.put("filp_status", r11);
        r0.put("pk_id", String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId()));
        r0.put("is_in_pk", "1");
        u.l().sendLog("livesdk_connection_camera_flip", r0, new Object[]{x.class, Room.class});
        this.a.dismissDialog();
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r5 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r5 == null) goto L23;
        com.bytedance.android.live.livepkaudience.vm.c.b.a(r5, true, true, true, true, false, 112);
        return;
    L23:
        return;
    L18:
        r11 = "after";
        goto L19
    L5:
        r10 = null;
        goto L6
    }
}
