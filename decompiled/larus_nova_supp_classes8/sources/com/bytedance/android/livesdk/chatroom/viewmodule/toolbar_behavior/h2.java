package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.LiveAnchorOneOffKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public Room b;

    public h2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public static boolean a() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        z30.b r1 = r0.getCloudGroupLiveService();
        if (r1 == null) goto L7;
        CloudGroupLivePipelineStatus r2 = r1.b();
    L9:
        if (r2 != CloudGroupLivePipelineStatus.START) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean b() {
        DataCenter r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        boolean r2 = gd0.v.a(r1.intValue(), 4);
        boolean r3 = gd0.v.a(r1.intValue(), 64);
        r1.intValue();
        boolean r4 = jc1.k.n(IInteractService.class).getInteractAudienceService().P();
        if (gd0.v.a(r1.intValue(), 32) == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r2 == true) goto L16;
        if (r3 == true) goto L16;
        if (r4 == true) goto L16;
        if (r5 == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (gd0.v.a(r1.intValue(), 8) == true) goto L11;
        r5 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return !((LiveAnchorOneOffKeys) com.bytedance.android.livesdk.sharedpref.b.r2.getValue()).getDot_in_room_used();
    }

    public final void c(String r7) {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r1 = new Pair[4];
        Room r2 = this.b;
        String r3 = null;
        if (r2 == null) goto L5;
        LiveMode r4 = r2.getStreamType();
    L6:
        int r5 = com.bytedance.android.live.core.utils.h1.a;
        r1[0] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r4));
        Room r6 = this.b;
        if (r6 == null) goto L9;
        r3 = r6.getOwnerUserIdString();
    L9:
        r1[1] = TuplesKt.to("anchor_id", r3);
        r1[2] = TuplesKt.to("event_page", "live_take_detail");
        r1[3] = TuplesKt.to("show_type", "icon");
        r0.sendLog(r7, MapsKt.mapOf(r1), new Object[]{Room.class});
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (b() == false) goto L9;
        com.bytedance.android.live.core.utils.f2.b(2131918921, 0);
        return;
    L9:
        if (jc1.k.n(IMiddlewareBroadcastService.class).isPlayingGame() == false) goto L13;
        com.bytedance.android.live.core.utils.f2.b(2131919128, 0);
        return;
    L13:
        if (a() == false) goto L16;
        com.bytedance.android.live.core.utils.f2.b(2131918922, 0);
        return;
    L16:
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.r2;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, LiveAnchorOneOffKeys.copy$default((LiveAnchorOneOffKeys) r0.getValue(), false, true, false, 5, null));
        c("livesdk_anchor_definition_setting_button");
        AnchorVideoResolutionManager.l(r9.getContext(), this.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r3).h(ToolbarButton.IN_ROOM_RESOLUTION.extended());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.a = r5;
        IRoom r0 = com.bytedance.android.live.core.utils.z.b(r5).a;
        View r2 = null;
        if ((r0 instanceof Room) == true) goto L5;
        r0 = null;
    L5:
        this.b = (Room) r0;
        if (AnchorVideoResolutionManager.c.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r5).i(ToolbarButton.IN_ROOM_RESOLUTION.extended());
        return;
    L12:
        c("livesdk_anchor_definition_setting_button_show");
        if (b() == false) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r5).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(2131918921));
        return;
    L17:
        if (jc1.k.n(IMiddlewareBroadcastService.class).isPlayingGame() == false) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r5).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(2131919128));
        return;
    L21:
        if (a() == false) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r5).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(2131918922));
        return;
    L24:
        View r6 = r4.findViewById(2131374718);
        if ((r6 instanceof View) == false) goto L28;
        r2 = r6;
    L28:
        if (r2 == null) goto L56;
        String r7 = AnchorVideoResolutionManager.c;
        int r8 = r7.hashCode();
        if (r8 == 3324) goto L51;
        if (r8 == 3448) goto L48;
        if (r8 != 3665) goto L36;
        r7.equals("sd");
    L53:
        int r9 = 2131251861;
    L54:
        r2.setBackgroundResource(r9);
        return;
    L36:
        if (r8 == 115761) goto L44;
        if (r8 != 3005871) goto L53;
        if (r7.equals("auto") == false) goto L53;
        r9 = 2131251856;
        goto L54
    L44:
        if (r7.equals("uhd") == false) goto L53;
        r9 = 2131251862;
        goto L54
    L48:
        if (r7.equals("ld") == false) goto L53;
        r9 = 2131251859;
        goto L54
    L51:
        if (r7.equals("hd") == false) goto L53;
        r9 = 2131251857;
        goto L54
    L56:
        return;
    L8:
        r1 = false;
        goto L9
    }
}
