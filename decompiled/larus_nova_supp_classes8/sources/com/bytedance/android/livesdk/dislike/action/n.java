package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends OptionAction {
    public final ActionsManager e;

    public n(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        xs2.b.a().post(new mt1.a(4, this.b, this.e.e, null, false, 24));
        com.bytedance.android.livesdk.log.filter.o r10 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r2 = "";
        if (r10.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r0 = (String) r10.getMap().get("enter_from_merge");
    L7:
        if (r10.getMap().containsKey("enter_method") == false) goto L9;
        String r3 = (String) r10.getMap().get("enter_method");
    L11:
        if (r10.getMap().containsKey("action_type") == false) goto L13;
        String r5 = (String) r10.getMap().get("action_type");
    L15:
        if (tb1.c.a == false) goto L17;
        r0 = k1.c();
    L17:
        HashMap r7 = new HashMap();
        r7.put("enter_from_merge", r0);
        r7.put("enter_method", r3);
        r7.put("action_type", r5);
        r7.put("share_platform", "long_press");
        r7.put("event_page", "live_detail");
        r7.put("is_vr_machine", VrUtils.o(this.e.f));
        String r1 = (String) r10.getMap().get("is_second_label");
        if (r1 != null) goto L20;
        r1 = "";
    L20:
        r7.put("is_second_label", r1);
        String r11 = (String) r10.getMap().get("is_self_shared");
        if (r11 == null) goto L24;
        r2 = r11;
    L24:
        r7.put("is_self_shared", r2);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share", r7, new Object[]{Room.class, am2.n.f()});
        return;
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
