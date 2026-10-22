package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends OptionAction {
    public final ActionsManager e;

    public h(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r12) {
        Intrinsics.checkNotNullParameter(r12, "v");
        xs2.b.a().post(new h1(67, this.b));
        com.bytedance.android.livesdk.log.filter.o r13 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r2 = "";
        if (r13.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r0 = (String) r13.getMap().get("enter_from_merge");
    L7:
        if (r13.getMap().containsKey("enter_method") == false) goto L9;
        String r3 = (String) r13.getMap().get("enter_method");
    L11:
        if (r13.getMap().containsKey("action_type") == false) goto L13;
        String r5 = (String) r13.getMap().get("action_type");
    L15:
        if (r13.getMap().containsKey("video_id") == false) goto L18;
        r2 = (String) r13.getMap().get("video_id");
    L18:
        if (tb1.c.a == false) goto L20;
        r0 = k1.c();
    L20:
        HashMap r14 = new HashMap();
        r14.put("enter_from_merge", r0);
        r14.put("enter_method", r3);
        r14.put("action_type", r5);
        r14.put("request_page", "long_press");
        Room r1 = this.b;
        String r4 = null;
        if (r1 == null) goto L23;
        String r6 = r1.getOwnerUserIdString();
    L24:
        r14.put("to_user_id", String.valueOf(r6));
        r14.put("is_vr_machine", VrUtils.o(this.e.f));
        r14.put("video_id", r2);
        r14.put("is_from_new_panel", "1");
        lc0.c r7 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
        int r9 = am2.c0.b;
        r8.sendLog("livesdk_dislike", r14, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f(), new am2.c0(r7.v())});
        HashMap r10 = new HashMap(r14);
        Room r15 = this.e.d;
        if (r15 == null) goto L27;
        r4 = r15.getAnchorId();
    L27:
        r10.put("anchor_id", String.valueOf(r4));
        r10.put("event_page", "live_detail");
        r10.put("is_second_reason", "0");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike_entrance_click", r10, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f(), new am2.c0(r7.v())});
        return;
    L23:
        r6 = null;
        goto L24
    L13:
        r5 = "";
        goto L15
    L9:
        r3 = "";
        goto L11
    L5:
        r0 = "";
        goto L7
    }
}
