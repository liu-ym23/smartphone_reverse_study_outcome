package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.dislike.tip.RoomOptimizeRecommendTipHelper;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public View b;
    public Context c;
    public final HashMap<String, String> d;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public k3() {
        this.d = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return com.bytedance.android.livesdk.model.b.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.t;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        DataCenter r2 = this.a;
        if (r2 == null) goto L5;
        Room r3 = (Room) r2.get("data_room", null);
    L6:
        String r6 = "";
        if (r1.getMap().containsKey("enter_from_merge") == false) goto L9;
        String r4 = (String) r1.getMap().get("enter_from_merge");
    L11:
        if (r1.getMap().containsKey("enter_method") == false) goto L13;
        String r7 = (String) r1.getMap().get("enter_method");
    L15:
        if (r1.getMap().containsKey("action_type") == false) goto L17;
        String r9 = (String) r1.getMap().get("action_type");
    L19:
        if (r1.getMap().containsKey("video_id") == false) goto L21;
        String r5 = (String) r1.getMap().get("video_id");
    L23:
        if (tb1.c.a == false) goto L25;
        r4 = com.bytedance.android.livesdk.chatroom.utils.k1.c();
    L25:
        this.d.put("enter_from_merge", r4);
        this.d.put("enter_method", r7);
        this.d.put("action_type", r9);
        this.d.put("request_page", "more_function_button");
        HashMap<String, String> r8 = this.d;
        if (r3 == null) goto L28;
        String r10 = r3.getOwnerUserIdString();
    L29:
        r8.put("to_user_id", String.valueOf(r10));
        this.d.put("event_page", "live_detail");
        this.d.put("video_id", r5);
        if (r3 == null) goto L32;
        this.d.put("anchor_id", r3.getOwnerUserIdString());
        this.d.put("room_id", r3.getIdStr());
        this.d.put("request_id", r3.getRequestId());
    L32:
        HashMap<String, String> r11 = this.d;
        View r12 = this.b;
        if (r12 != null) goto L35;
    L37:
        boolean r13 = false;
    L38:
        String r14 = "1";
        if (r13 == false) goto L41;
        String r15 = "1";
    L42:
        r11.put("is_red_dot_show", r15);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_feedback_entrance_click", this.d, new Object[]{am2.x.class, Room.class, am2.n.f()});
        ((com.bytedance.android.livesdk.dislike.tip.b) RoomOptimizeRecommendTipHelper.a.getValue()).updateOptRecommendUsedDate();
        Context r16 = this.c;
        if (r16 == null) goto L80;
        ILiveService r17 = TTLiveService.getLiveService();
        if (r17 == null) goto L81;
        RoomContext r19 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r19 == null) goto L56;
        com.bytedance.live.datacontext.n r20 = r19.getLiveDrawListPosition();
        if (r20 == null) goto L56;
        Integer r21 = (Integer) r20.getValue();
        if (r21 == null) goto L56;
        r14 = String.valueOf(r21.intValue() + 1);     // Catch: Exception -> L55
    L56:
        DislikeConfig r110 = com.bytedance.android.livesdk.model.b.a();
        if (r110 == null) goto L60;
        String r111 = r110.getFeedbackUrl();
        if (r111 == null) goto L60;
    L61:
        StringBuilder r22 = new StringBuilder(r111);
        if (r22.length() != 0) goto L64;
        boolean r112 = true;
    L65:
        if (r112 == true) goto L76;
        r22.append("&enter_from_merge=" + this.d.get("enter_from_merge") + "&enter_method=" + this.d.get("enter_method") + "&room_id=" + this.d.get("room_id") + "&anchor_id=" + this.d.get("anchor_id"));
        String r23 = this.d.get("request_id");
        if (r23 != null) goto L70;
    L75:
        r22.append("&flow_type=room_fix_entrance&draw_order=" + r14);
        r6 = r22.toString();
        goto L76
    L70:
        if (r23.length() <= 0) goto L72;
        boolean r24 = true;
        boolean r113 = true;
    L73:
        if (r113 != r24) goto L75;
        r22.append("&request_id=" + this.d.get("request_id"));
        goto L75
    L72:
        r24 = true;
        r113 = false;
    L76:
        r17.handleSchema(r16, UriProtector.parse(r6));
        return;
    L64:
        r112 = false;
    L60:
        r111 = "";
        goto L61
    L81:
        return;
    L80:
        return;
    L41:
        r15 = "0";
        goto L42
    L35:
        if (r12.getVisibility() != 0) goto L37;
        r13 = true;
        goto L38
    L28:
        r10 = null;
        goto L29
    L21:
        r5 = "";
        goto L23
    L17:
        r9 = "";
        goto L19
    L13:
        r7 = "";
        goto L15
    L9:
        r4 = "";
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        this.b = r2.findViewById(2131384095);
        this.c = r2.getContext();
    }
}
