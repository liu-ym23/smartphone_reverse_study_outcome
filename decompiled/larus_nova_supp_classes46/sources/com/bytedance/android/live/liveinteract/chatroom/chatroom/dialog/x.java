package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ y a;

    public x(y r1, long r2) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        LinkResultDialogFragmentV2.T90(this.a.a, 1);
        int r9 = d0.a;
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L5;
        IRoom r11 = (IRoom) r10.getValue();
    L6:
        LinkResultDialogFragmentV2 r1 = this.a.a;
        int r2 = r1.j;
        int r3 = r1.l;
        HashMap r4 = new HashMap();
        String r5 = "";
        if (r11 == null) goto L9;
        String r6 = com.bytedance.android.live.ktv.common.util.j.f(r11);
    L10:
        r4.put("live_type", r6);
        if (r11 == null) goto L16;
        String r7 = r11.getAnchorId();
        if (r7 == null) goto L16;
        r5 = r7;
    L16:
        r4.put("anchor_id", r5);
        if (r11 == null) goto L19;
        long r12 = r11.getId();
    L20:
        r4.put("room_id", String.valueOf(r12));
        r4.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r4.put("connection_over_type", d0.a(r2));
        r4.put("connection_over_type_detail", d0.b(Integer.valueOf(r3), r2));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_more_icon_click", r4, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        r12 = 0;
        goto L20
    L9:
        r6 = "";
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
