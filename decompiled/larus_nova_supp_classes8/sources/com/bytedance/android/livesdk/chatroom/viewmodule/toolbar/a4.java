package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a4 implements c0.b {

    public static final class a {
    }

    static {
    }

    public a4() {
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
    public final /* synthetic */ void dv(e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        r0.updateSwitchSceneSource("interaction_button");
    L5:
        int r1 = com.bytedance.android.livesdk.log.n0.a;
        Intrinsics.checkNotNullParameter("link_panel", "requestPage");
        Intrinsics.checkNotNullParameter("interaction_button", "source");
        LinkedHashMap r3 = new LinkedHashMap();
        com.bytedance.android.livesdk.utils.i4.b(r3);
        Integer r4 = Integer.valueOf(jc1.k.n(IInteractService.class).getCurrentScene());
        Intrinsics.checkNotNullParameter(r3, "logMap");
        xh0.g r6 = null;
        if (r4 != null) goto L9;
    L22:
        if (r4 != null) goto L25;
    L27:
        if (r4 != null) goto L30;
    L32:
        if (r4 != null) goto L35;
    L37:
        if (r4 != null) goto L40;
    L42:
        if (r4 != null) goto L45;
    L47:
        Intrinsics.checkNotNullParameter(r3, "logMap");
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L61;
        com.bytedance.live.datacontext.j r7 = r5.getVideoTalkRoomSubScene();
        if (r7 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = r8.t();
        if (r9 == null) goto L61;
        List<Integer> r10 = r9.b;
        if (r10 == null) goto L61;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r10) == false) goto L60;
        r3.put("seat_fit_status", "on");
        goto L61
    L60:
        r3.put("seat_fit_status", "off");
    L61:
        r3.put("playmode_type", String.valueOf(5));
        r3.put("request_page", "link_panel");
        r3.put("source", "interaction_button");
        r3.put("play_mode", com.bytedance.android.live.liveinteract.linkpanel.util.m.c());
        boolean r11 = true;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r3, new Object[]{Room.class});
        if (r15 == null) goto L108;
        Context r16 = r15.getContext();
        if (r16 == null) goto L109;
        IInteractService r2 = jc1.k.n(IInteractService.class);
        if (gd0.v.a(r2.getLinkMode(), 4) == false) goto L70;
        com.bytedance.android.live.core.utils.f2.b(2131921475, 0);
        return;
    L70:
        if (r2.isOpenInteractiveSong() != true) goto L73;
        com.bytedance.android.live.core.utils.f2.b(2131919597, 0);
        return;
    L73:
        xh0.d r12 = jc1.k.n(IInteractService.class).getPlayModeService();
        if (r12 == null) goto L76;
        r6 = r12.a(11, null);
    L76:
        if (r6 != null) goto L78;
    L86:
        int r13 = r2.getLinkMode();
        if (r13 != 0) goto L89;
    L102:
        cj0.b r14 = jc1.k.n(IInteractService.class).paidLinkMicService();
        if (r14 != null) goto L105;
        return;
    L105:
        if (r14.needIntercepted() == true) goto L116;
        r2.getAudioTalkService().c(r16, "interaction_button");
        return;
    L116:
        return;
    L89:
        if (r13 == 2) goto L99;
        if (r13 == 8) goto L102;
        if (r13 != 32) goto L117;
        cj0.b r17 = jc1.k.n(IInteractService.class).paidLinkMicService();
        if (r17 != null) goto L97;
        return;
    L97:
        if (r17.needIntercepted() == true) goto L111;
        r2.getVideoTalkService().c(r16, "interaction_button");
        return;
    L111:
        return;
    L117:
        return;
    L99:
        r2.getInteractAudienceService().getClass();
        if (fj0.c.a() == false) goto L113;
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter("interaction_button", "source");
        cj0.h.b(r16, "interaction_button");
        return;
    L113:
        return;
    L78:
        if (r6.c == true) goto L86;
        if (r6.e.length() > 0) goto L83;
        r11 = false;
    L83:
        if (r11 == false) goto L86;
        com.bytedance.android.live.core.utils.f2.c(r6.e, 0);
        return;
    L109:
        return;
    L108:
        return;
    L45:
        if (r4.intValue() != 12) goto L47;
        r3.put("function_type", "party");
        goto L47
    L40:
        if (r4.intValue() != 4) goto L42;
        r3.put("function_type", SourceType.DEFAULT);
        goto L47
    L35:
        if (r4.intValue() != 10) goto L37;
        r3.put("function_type", "watch");
        goto L47
    L30:
        if (r4.intValue() != 9) goto L32;
        r3.put("function_type", "ktv");
        goto L47
    L25:
        if (r4.intValue() != 8) goto L27;
        r3.put("function_type", "radio");
        goto L47
    L9:
        if (r4.intValue() != 5) goto L22;
        r3.put("function_type", "radio");
        DataContext r18 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r18 instanceof RoomContext) == true) goto L13;
        r18 = null;
    L13:
        RoomContext r19 = (RoomContext) r18;
        if (r19 == null) goto L47;
        com.bytedance.live.datacontext.m r20 = r19.getRoom();
        if (r20 == null) goto L47;
        Room r21 = (Room) r20.getValue();
        if (r21 == null) goto L47;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r21) == false) goto L47;
        r3.put("function_type", "party");
        goto L47
    }
}
