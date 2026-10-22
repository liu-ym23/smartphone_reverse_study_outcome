package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ y a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public w(y r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        LinkResultDialogFragmentV2.T90(this.a.a, 2);
        int r12 = d0.a;
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L5;
        IRoom r14 = (IRoom) r13.getValue();
    L6:
        String r1 = this.c;
        long r2 = this.b;
        LinkResultDialogFragmentV2 r4 = this.a.a;
        int r5 = r4.j;
        int r6 = r4.l;
        Intrinsics.checkNotNullParameter(r1, "iconType");
        HashMap r7 = new HashMap();
        String r8 = "";
        if (r14 == null) goto L9;
        String r9 = com.bytedance.android.live.ktv.common.util.j.f(r14);
    L10:
        r7.put("live_type", r9);
        if (r14 == null) goto L16;
        String r10 = r14.getAnchorId();
        if (r10 == null) goto L16;
        r8 = r10;
    L16:
        r7.put("anchor_id", r8);
        if (r14 == null) goto L19;
        long r15 = r14.getId();
    L20:
        r7.put("room_id", String.valueOf(r15));
        r7.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r7.put("connection_over_type", d0.a(r5));
        r7.put("connection_over_type_detail", d0.b(Integer.valueOf(r6), r5));
        r7.put("icon_type", r1);
        r7.put("userlist_num", String.valueOf(r2));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_giftuser_icon_click", r7, new Object[]{IRoom.class, am2.x.class});
        return;
    L19:
        r15 = 0;
        goto L20
    L9:
        r9 = "";
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
