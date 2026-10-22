package com.bytedance.android.livesdk.dislike.action;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends OptionAction {
    public final ActionsManager e;
    public final com.bytedance.android.live.base.model.user.f f;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        g(false, "long_press");
    }

    public l(ActionsManager r2, com.bytedance.android.live.base.model.user.f r3) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        Intrinsics.checkNotNullParameter(r3, "contact");
        super(r2);
        this.e = r2;
        this.f = r3;
    }

    public final void g(boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "sharePlatform");
        mt1.a r0 = new mt1.a(3, this.b, this.e.e, null, false, 24);
        com.bytedance.android.live.base.model.user.f r1 = this.f;
        r1.c = r11;
        r0.a = r1;
        xs2.b.a().post(r0);
        com.bytedance.android.live.base.model.user.f r2 = this.f;
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r4 = "";
        if (r3.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r5 = (String) r3.getMap().get("enter_from_merge");
    L7:
        if (r3.getMap().containsKey("enter_method") == false) goto L9;
        String r6 = (String) r3.getMap().get("enter_method");
    L11:
        if (r3.getMap().containsKey("action_type") == false) goto L13;
        String r7 = (String) r3.getMap().get("action_type");
    L15:
        if (tb1.c.a == false) goto L17;
        r5 = k1.c();
    L17:
        HashMap r9 = new HashMap();
        r9.put("enter_from_merge", r5);
        r9.put("enter_method", r6);
        r9.put("action_type", r7);
        r9.put("share_platform", r12);
        r9.put("event_page", "live_detail");
        r9.put("is_vr_machine", VrUtils.o(this.e.f));
        if (r11 == false) goto L20;
        r9.put("is_outer_head", "1");
    L20:
        Map r13 = jc1.k.n(ILiveShareService.class).getToUserConversationId(r2);
        if (r13 != null) goto L23;
    L28:
        String r14 = (String) r3.getMap().get("is_second_label");
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r9.put("is_second_label", r14);
        String r15 = (String) r3.getMap().get("is_self_shared");
        if (r15 == null) goto L35;
        r4 = r15;
    L35:
        r9.put("is_self_shared", r4);
        if (TextUtils.isEmpty(r2.b) == true) goto L38;
        r9.put("is_from_shopping_guide", "1");
        r9.put("shopping_guide_id", r2.b);
    L38:
        r9.putAll(com.bytedance.android.livesdk.locallife.g.a(this.b, (String) r9.get("to_user_id")));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share", r9, new Object[]{Room.class, am2.n.f(), am2.x.class});
        int r16 = i1.a;
        Room r17 = this.b;
        Map r8 = jc1.k.n(ILiveShareService.class).getToUserConversationId(this.f);
        if (Intrinsics.areEqual(r12, "long_press") == false) goto L41;
        String r18 = "press";
    L42:
        i1.c(r17, r8, r18);
        return;
    L41:
        r18 = "click";
        goto L42
    L23:
        if (r13.containsKey("conversation_id") == false) goto L26;
        r9.put("conversation_id", r13.get("conversation_id"));
        goto L28
    L26:
        if (r13.containsKey("to_user_id") == false) goto L28;
        r9.put("to_user_id", r13.get("to_user_id"));
        goto L28
    L13:
        r7 = "";
        goto L15
    L9:
        r6 = "";
        goto L11
    L5:
        r5 = "";
        goto L7
    }
}
