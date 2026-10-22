package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public v(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        yf0.g r1 = this.a.i;
        if (r1 == null) goto L5;
        r1.dismiss();
    L5:
        LinkPanelTopBarWidget r2 = this.a;
        r2.getClass();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L68;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("shoot_way", "link_panel");
        j0.l().sendLog("livesdk_anchor_voice_live_open", r3, new Object[]{IRoom.class});
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(r2).s();
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L14;
        int r7 = r6.a;
    L15:
        com.bytedance.android.livesdk.chatroom.u r8 = com.bytedance.android.live.liveinteract.api.utils.m.e(r2);
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.j r9 = r8.s();
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r9.getValue();
        if (r10 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r11 = r10.t();
        if (r11 == null) goto L24;
        int r12 = r11.b;
    L25:
        boolean r13 = r2.k;
        int r14 = com.bytedance.android.live.liveinteract.linkpanel.util.l.a;
        if (r13 == false) goto L28;
        boolean r15 = ((Boolean) vm2.d.i1.getValue(null, vm2.d.a[110(0x6e, float:1.54E-43)])).booleanValue();
    L30:
        if (r15 == false) goto L49;
        ILinkPanelService r16 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r16 == null) goto L34;
        r16.close();
    L34:
        if (r7 != 9) goto L44;
        FragmentActivity r17 = ((Widget) r2).context;
        if (r17 == null) goto L84;
        LiveDialogFragment r19 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog("link_panel", new z(r2), false);
        if (r19 == null) goto L85;
        FragmentManager r20 = r17.getSupportFragmentManager();
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "KtvFeedbackDialog", r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r19, r21) == true) goto L95;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L81
    L43:
        r19.show(r20, "KtvFeedbackDialog");
        return;
    L95:
        return;
    L85:
        return;
    L84:
        return;
    L44:
        IInteractService r22 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r22 != null) goto L47;
        return;
    L47:
        if (r22.getLinkPanelTransitService() == null) goto L88;
        FragmentActivity r23 = r2.e;
        DataCenter r24 = ((Widget) r2).dataCenter;
        Intrinsics.checkNotNullParameter(r23, "context");
        int r25 = TalkRoomFeedbackDialog.r;
        LinkPanelTransitService.a(TalkRoomFeedbackDialog.a.a(com.bytedance.android.live.liveinteract.linkpanel.util.o.c(), true, "link_panel", new com.bytedance.android.live.liveinteract.service.n(r24), false, null, null, null, 1000), r23.getSupportFragmentManager());
        return;
    L88:
        return;
    L49:
        HashMap r26 = new HashMap();
        if (r7 == 9) goto L54;
        if (r7 == 10) goto L53;
        String r27 = "chat_room";
    L55:
        r26.put("before_function", r27);
        r26.put("interact_function", "live_room");
        r26.put("request_page", "link_setting_panel");
        j0.l().sendLog("anchor_switch_room_type", r26, new Object[]{IRoom.class, am2.x.class});
        if (r7 == 9) goto L63;
        if (r7 != 10) goto L59;
        String r28 = s1.B(2131919977);
    L64:
        Context r29 = ((Widget) r2).context;
        if (r29 == null) goto L90;
        com.bytedance.android.livesdk.widget.j0.a r30 = new com.bytedance.android.livesdk.widget.j0.a(r29);
        r30.a = r28;
        r30.b(s1.B(2131918116), new a0(r2));
        r30.a(s1.B(2131915442), b0.a);
        r30.c();
        return;
    L90:
        return;
    L59:
        if (r12 != 29) goto L61;
        r28 = s1.B(2131922747);
        goto L64
    L61:
        r28 = s1.B(2131920103);
        goto L64
    L63:
        r28 = s1.B(2131919499);
        goto L64
    L53:
        r27 = "watch_room";
        goto L55
    L54:
        r27 = "sing_room";
        goto L55
    L28:
        r15 = ((Boolean) vm2.d.j1.getValue(null, vm2.d.a[111(0x6f, float:1.56E-43)])).booleanValue();
    L24:
        r12 = 0;
    L14:
        r7 = 0;
        goto L15
    L68:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L92;
        FragmentActivity r31 = r2.e;
        DataCenter r32 = r2.f;
        String r110 = r2.l;
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        if (s0.c(com.bytedance.android.live.core.utils.a0.d(r32, false)) == false) goto L79;
        if (r32 == null) goto L74;
        r32.put("data_room_video_talk_log_over_for_over_path", "chat_close_icon");
    L74:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L76;
    L78:
        int r33 = TalkRoomFeedbackDialog.r;
        LinkPanelTransitService.a(TalkRoomFeedbackDialog.a.a(com.bytedance.android.live.liveinteract.linkpanel.util.o.c(), com.bytedance.android.live.core.utils.a0.d(r32, false), r110, null, false, null, null, null, 1016), r31.getSupportFragmentManager());
        return;
    L76:
        if (com.bytedance.android.live.core.utils.a0.d(r32, false) == false) goto L78;
        z0.a().getClass();
        x0.b r34 = z0.b(r31);
        r34.m(2131918746);
        r34.l(2131918747);
        r34.setCornerRadius(2.0f);
        r34.j(0, s1.B(2131918745), new com.bytedance.android.live.liveinteract.service.j(r32));
        r34.j(1, s1.B(2131918744), com.bytedance.android.live.liveinteract.service.k.a);
        r34.n();
        return;
    L79:
        x0.b r35 = new x0.b(r31, 0);
        r35.a.a = 5;
        r35.m(2131923159);
        r35.l(2131923160);
        r35.setCornerRadius(2.0f);
        r35.i(0, 2131923155, new com.bytedance.android.live.liveinteract.service.l(r32));
        r35.i(1, 2131915442, com.bytedance.android.live.liveinteract.service.m.a);
        r35.a.k = false;
        r35.n();
        return;
    }
}
