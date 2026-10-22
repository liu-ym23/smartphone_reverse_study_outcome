package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 extends OptionAction {
    public final ActionsManager e;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.p.c;
    }

    public c0(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L5;
        Lazy r11 = DispatchLogUtil.a;
        DispatchLogUtil.d(0, DispatchLogUtil.InstanceType.UNFOLLOW);
        xs2.b.a().post(new mt1.a(1, this.b, this.e.e, null, true, 8));
        return;
    L5:
        xs2.b.a().post(new mt1.a(1, this.b, this.e.e, null, false, 24));
        com.bytedance.android.livesdk.log.filter.o r12 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r12.getMap().containsKey("enter_from_merge") == false) goto L8;
        String r1 = (String) r12.getMap().get("enter_from_merge");
    L10:
        if (r12.getMap().containsKey("enter_method") == false) goto L12;
        String r4 = (String) r12.getMap().get("enter_method");
    L14:
        if (r12.getMap().containsKey("action_type") == false) goto L17;
        r3 = (String) r12.getMap().get("action_type");
    L17:
        if (tb1.c.a == false) goto L19;
        r1 = k1.c();
    L19:
        HashMap r13 = new HashMap();
        r13.put("enter_from_merge", r1);
        r13.put("enter_method", r4);
        r13.put("action_type", r3);
        r13.put("request_page", "long_press");
        Room r2 = this.b;
        if (r2 == null) goto L22;
        String r5 = r2.getOwnerUserIdString();
    L23:
        r13.put("to_user_id", String.valueOf(r5));
        r13.put("event_page", "live_detail");
        r13.put("is_vr_machine", VrUtils.o(this.e.f));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_unfollow", r13, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L22:
        r5 = null;
        goto L23
    L12:
        r4 = "";
        goto L14
    L8:
        r1 = "";
        goto L10
    }
}
