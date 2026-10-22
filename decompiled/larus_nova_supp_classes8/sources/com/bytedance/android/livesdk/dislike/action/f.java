package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends OptionAction {
    public final ActionsManager e;

    public f(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r18) {
        Intrinsics.checkNotNullParameter(r18, "v");
        xs2.b.a().post(new h1(52, this.b));
        if (com.bytedance.android.livesdk.dislike.t.a() == false) goto L5;
        HashMap r1 = new HashMap();
        qt1.c.a(r1, this.b);
        r1.put("layer_show_page", "live_detail");
        r1.put("dislike_type", "dislike_anchor");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike", r1, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_click", r1, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
        return;
    L5:
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r14 = "";
        if (r2.getMap().containsKey("enter_from_merge") == false) goto L8;
        String r12 = (String) r2.getMap().get("enter_from_merge");
    L10:
        if (r2.getMap().containsKey("enter_method") == false) goto L12;
        String r15 = (String) r2.getMap().get("enter_method");
    L14:
        if (r2.getMap().containsKey("action_type") == false) goto L16;
        String r6 = (String) r2.getMap().get("action_type");
    L17:
        String r16 = r12;
        if (r2.getMap().containsKey("video_id") == false) goto L21;
        r14 = (String) r2.getMap().get("video_id");
    L21:
        if (tb1.c.a == false) goto L23;
        String r3 = k1.c();
    L24:
        HashMap r8 = new HashMap();
        r8.put("enter_from_merge", r3);
        r8.put("enter_method", r15);
        r8.put("action_type", r6);
        r8.put("request_page", "long_press");
        Room r4 = this.b;
        if (r4 == null) goto L27;
        String r5 = r4.getOwnerUserIdString();
    L28:
        r8.put("to_user_id", String.valueOf(r5));
        r8.put("event_page", "live_detail");
        r8.put("video_id", r14);
        r8.put("dislike_type", "dislike_anchor");
        r8.put("is_vr_machine", VrUtils.o(this.e.f));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike", r8, new Object[]{am2.x.class, Room.class, am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("live_dislike", r8, new Object[]{am2.x.class, Room.class, am2.n.f()});
        r8.put("layer_show_page", "live_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_click", r8, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L27:
        r5 = null;
        goto L28
    L23:
        r3 = r16;
        goto L24
    L16:
        r6 = "";
        goto L17
    L12:
        r15 = "";
        goto L14
    L8:
        r12 = "";
        goto L10
    }
}
