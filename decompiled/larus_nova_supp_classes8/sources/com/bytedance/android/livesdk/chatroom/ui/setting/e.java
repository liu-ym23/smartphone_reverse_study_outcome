package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.sy;
import com.bytedance.android.livesdk.config.ty;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends mx.j implements View.OnClickListener {
    public final Room m;
    public final Context n;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (this.m == null) goto L6;
        HashMap r6 = new HashMap();
        r6.put("anchor_id", this.m.getOwnerUserIdString());
        r6.put("room_id", String.valueOf(this.m.getRoomId()));
        com.bytedance.android.livesdk.log.u.l().sendLog("audience_receive_manage_click", r6, new Object[]{new am2.x(), Room.class});
    L6:
        String r7 = sy.a.getValue().a();
        if (r7 == null) goto L10;
        jc1.k.n(IRoomService.class).actionHandler().handle(this.n, r7);
        return;
    }

    public e(Room r5, Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = ty.a.getValue().a();
        if (r0 != null) goto L5;
        r0 = s1.B(2131922470);
    L5:
        super(r0, null, false, 14);
        this.m = r5;
        this.n = r6;
        ((mx.j) this).l = this;
    }
}
