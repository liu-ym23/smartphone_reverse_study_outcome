package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.tip.RoomOptimizeRecommendTipHelper;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends OptionAction {
    public final ActionsManager e;
    public final HashMap<String, String> f;

    public i(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
        this.f = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r18) {
        Intrinsics.checkNotNullParameter(r18, "v");
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r1 = ILoginGuideService.a.a();
        if (r1 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r5 = "";
        if (r2.getMap().containsKey("enter_from_merge") == false) goto L10;
        String r3 = (String) r2.getMap().get("enter_from_merge");
    L12:
        if (r2.getMap().containsKey("enter_method") == false) goto L14;
        String r6 = (String) r2.getMap().get("enter_method");
    L16:
        if (r2.getMap().containsKey("action_type") == false) goto L18;
        String r8 = (String) r2.getMap().get("action_type");
    L20:
        if (r2.getMap().containsKey("video_id") == false) goto L22;
        String r4 = (String) r2.getMap().get("video_id");
    L24:
        if (tb1.c.a == false) goto L26;
        r3 = k1.c();
    L26:
        HashMap<String, String> r10 = this.f;
        if (r3 != null) goto L29;
        r3 = "";
    L29:
        r10.put("enter_from_merge", r3);
        HashMap<String, String> r7 = this.f;
        if (r6 != null) goto L32;
        r6 = "";
    L32:
        r7.put("enter_method", r6);
        this.f.put("action_type", r8);
        this.f.put("request_page", "long_press");
        HashMap<String, String> r9 = this.f;
        Room r11 = this.b;
        if (r11 == null) goto L35;
        String r12 = r11.getOwnerUserIdString();
    L36:
        r9.put("to_user_id", r12);
        this.f.put("event_page", "live_detail");
        this.f.put("video_id", r4);
        Room r13 = this.b;
        if (r13 == null) goto L39;
        this.f.put("anchor_id", r13.getOwnerUserIdString());
        this.f.put("room_id", r13.getIdStr());
        this.f.put("request_id", r13.getRequestId());
    L39:
        HashMap<String, String> r14 = this.f;
        String r15 = "1";
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("long_press_dot_" + com.bytedance.android.livesdk.model.b.a().getFeedbackText(), Boolean.FALSE).getValue()).booleanValue() == false) goto L42;
        String r16 = "0";
    L43:
        r14.put("is_red_dot_show", r16);
        boolean r17 = false;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_feedback_entrance_click", this.f, new Object[]{am2.x.class, Room.class, am2.n.f()});
        ILiveService r19 = TTLiveService.getLiveService();
        if (r19 == null) goto L82;
        ActionsManager r110 = this.e;
        if (r110 == null) goto L50;
        com.bytedance.android.livesdk.dislike.m r111 = r110.c;
        if (r111 == null) goto L50;
        Context r112 = r111.getContext();
    L51:
        RoomContext r20 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r20 == null) goto L61;
        com.bytedance.live.datacontext.n r21 = r20.getLiveDrawListPosition();
        if (r21 == null) goto L61;
        Integer r22 = (Integer) r21.getValue();
        if (r22 == null) goto L61;
        r15 = String.valueOf(r22.intValue() + 1);     // Catch: Exception -> L60
    L61:
        DislikeConfig r23 = com.bytedance.android.livesdk.model.b.a();
        if (r23 == null) goto L65;
        String r24 = r23.getFeedbackUrl();
        if (r24 == null) goto L65;
    L66:
        StringBuilder r25 = new StringBuilder(r24);
        if (r25.length() != 0) goto L69;
        boolean r26 = true;
    L70:
        if (r26 == true) goto L81;
        r25.append("&enter_from_merge=" + this.f.get("enter_from_merge") + "&enter_method=" + this.f.get("enter_method") + "&room_id=" + this.f.get("room_id") + "&anchor_id=" + this.f.get("anchor_id"));
        String r27 = this.f.get("request_id");
        if (r27 != null) goto L75;
    L80:
        r25.append("&flow_type=room_fix_entrance&draw_order=" + r15);
        r5 = r25.toString();
        goto L81
    L75:
        if (r27.length() <= 0) goto L77;
        boolean r28 = true;
        r17 = true;
    L78:
        if (r17 != r28) goto L80;
        r25.append("&request_id=" + this.f.get("request_id"));
        goto L80
    L77:
        r28 = true;
    L81:
        r19.handleSchema(r112, UriProtector.parse(r5));
        goto L82
    L69:
        r26 = false;
    L65:
        r24 = "";
    L50:
        r112 = null;
    L82:
        ((com.bytedance.android.livesdk.dislike.tip.b) RoomOptimizeRecommendTipHelper.a.getValue()).updateOptRecommendUsedDate();
        return;
    L42:
        r16 = "1";
        goto L43
    L35:
        r12 = null;
        goto L36
    L22:
        r4 = "";
        goto L24
    L18:
        r8 = "";
        goto L20
    L14:
        r6 = "";
        goto L16
    L10:
        r3 = "";
        goto L12
    L5:
        if (r1.intercept(new q61.c(new q61.b.a(cz.c.j.c))) != true) goto L7;
    }
}
