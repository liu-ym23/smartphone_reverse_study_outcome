package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.zs0;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public t3() {
    }

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

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.q.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.B;
    }

    public static void a(String r6) {
        HashMap r0 = new HashMap();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L11;
        if (r3.isLiveTypeAudio() != true) goto L11;
        String r4 = "voice_live";
    L12:
        r0.put("live_type", r4);
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L16;
        String r7 = r5.getFunctionTypeForLog();
        if (r7 == null) goto L16;
    L17:
        r0.put("function_type", r7);
        r0.put("action_type", r6);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_related_room_click", r0, new Object[]{Room.class, am2.x.class});
        return;
    L16:
        r7 = "live";
    L11:
        r4 = "video_live";
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.q;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, Boolean.FALSE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.a).b(ToolbarButton.MORE, new pp1.j(false));
    L5:
        if (r8 == null) goto L41;
        Context r9 = r8.getContext();
        if (r9 == null) goto L42;
        zs0 r1 = zs0.a;
        String r2 = r1.getValue().a();
        if (r2 != null) goto L12;
        r2 = "sslocal://webcast_lynxview?type=popup&hide_nav_bar=1&gravity=bottom&height=484";
    L12:
        u6 r3 = new u6(r2);
        String r4 = r1.getValue().b();
        if (r4 != null) goto L15;
        r4 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/social_union_matrix_lynx_douyin/pages/live_matrix_detail/template.js?business_type=matrix_share&initialProps=%5B%22current_user%22%5D";
    L15:
        r3.b("url", r4);
        u6 r5 = r3.d("url");
        String r6 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L20;
        com.bytedance.live.datacontext.m r10 = r7.getRoom();
        if (r10 == null) goto L20;
        Room r11 = (Room) r10.getValue();
    L21:
        LinkedHashMap r12 = new LinkedHashMap();
        if (r11 == null) goto L24;
        Long r13 = Long.valueOf(r11.id);
    L25:
        r12.put("room_id", String.valueOf(r13));
        if (r11 == null) goto L28;
        r6 = r11.getOwnerUserIdString();
    L28:
        r12.put("anchor_id", String.valueOf(r6));
        r12.put("function_type", jc1.k.n(IInteractService.class).getCurrentFunctionType());
        if (r11 != null) goto L31;
    L33:
        String r14 = "video_live";
    L34:
        r12.put("live_type", r14);
        Iterator r15 = r12.entrySet().iterator();
    L36:
        if (r15.hasNext() == false) goto L38;
        Map.Entry r16 = (Map.Entry) r15.next();
        r5.b((String) r16.getKey(), (String) r16.getValue());
        goto L36
    L38:
        jc1.k.n(ILiveActionHandler.class).handle(r9, r3.c());
        a("click");
        return;
    L31:
        if (r11.isLiveTypeAudio() != true) goto L33;
        r14 = "voice_live";
        goto L34
    L24:
        r13 = null;
    L20:
        r11 = null;
        goto L21
    L42:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        a("show");
    }
}
