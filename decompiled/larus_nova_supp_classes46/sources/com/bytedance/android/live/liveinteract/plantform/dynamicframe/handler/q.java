package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.IncreasePriceApplyDialog;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.MultiLinkPanelLifecycle;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends lh0.b {
    public final a d;
    public final ih0.b e;
    public final j1 f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L6;
            ih0.b r0 = this.a.e;
            JsonObject r1 = new JsonObject();
            r1.addProperty("apply_state", r6);
            Unit r7 = Unit.INSTANCE;
            r0.Dk("apply_waiting_dialog", "apply_state", r1, false);
            return;
        }
    }

    @Override // lh0.b
    public final void c() {
        hd0.c.f().c(this.d);
    }

    @Override // lh0.b
    public final void d() {
        super.d();
        hd0.c.f().e(this.d);
    }

    public final void f(ih0.f r11, ih0.h r12) {
        Intrinsics.checkNotNullParameter(r11, "updateStatus");
        Intrinsics.checkNotNullParameter(r12, "updateCallback");
        JsonObject r4 = r11.d;
        if (r4 != null) goto L5;
        return;
    L5:
        String r2 = "";
        int r3 = 1;
        boolean r5 = true;
        boolean r8 = false;
        switch(p.c[r11.getType().ordinal()]) {
            case 1: goto L157;
            case 2: goto L154;
            case 3: goto L127;
            case 4: goto L124;
            case 5: goto L93;
            case 6: goto L76;
            case 7: goto L69;
            case 8: goto L50;
            case 9: goto L38;
            case 10: goto L21;
            case 11: goto L21;
            case 12: goto L21;
            case 13: goto L21;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L9;
            case 17: goto L9;
            case 18: goto L9;
            case 19: goto L9;
            default: goto L172;
        };
    L21:
        int r13 = p.a[r11.getType().ordinal()];
        if (r13 != 1) goto L24;
        String r6 = "get_client_settings";
        r8 = true;
    L35:
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L172;
        r1.handleLinkLynxPanelJsbChangeAction("setting_panel_type", r6, r4, r12, this.c);
        goto L172
    L24:
        if (r13 != 2) goto L26;
        String r14 = "switch_layout";
    L33:
        r6 = r14;
        goto L35
    L26:
        if (r13 != 3) goto L28;
        r14 = "setting_panel_click";
        goto L33
    L28:
        if (r13 == 4) goto L30;
        r6 = "";
        goto L35
    L30:
        r14 = "linkmic_setting_update";
        goto L33
    L38:
        j1 r15 = this.f;
        if (r15 == null) goto L41;
        cg6.a r16 = (cg6.a) r15.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L42:
        if (r16 == null) goto L46;
        hg6.h r17 = r16.Fn();
        if (r17 == null) goto L46;
        JsonObject r18 = r17.a(r4);
    L47:
        if (r18 == null) goto L49;
        Intrinsics.checkNotNullParameter(r12, "updateCallback");
        lh0.c.a.a(r12, r18);
        goto L172
    L49:
        e(r12, "");
    L46:
        r18 = null;
        goto L47
    L41:
        r16 = null;
        goto L42
    L50:
        JsonElement r19 = r4.get("life_cycle");
        if (r19 == null) goto L53;
        int r110 = r19.getAsInt();
    L54:
        JsonElement r0 = r4.get("panel_name");
        if (r0 == null) goto L61;
        String r7 = r0.getAsString();
        if (r7 == null) goto L61;
        r2 = r7;
    L61:
        if (Intrinsics.areEqual(r2, "interaction_panel") == false) goto L172;
        DataCenter r9 = this.c;
        if (r9 == null) goto L172;
        if (r110 == MultiLinkPanelLifecycle.SHOW.ordinal()) goto L68;
        r5 = false;
    L68:
        r9.put("data_multi_link_interaction_dialog_show", Boolean.valueOf(r5));
        goto L172
    L53:
        r110 = MultiLinkPanelLifecycle.HIDE.ordinal();
        goto L54
    L69:
        JsonElement r111 = r4.get("life_cycle");
        if (r111 == null) goto L72;
        int r112 = r111.getAsInt();
    L73:
        ILinkPanelService r10 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r10 == null) goto L172;
        r10.js(r112);
        goto L172
    L72:
        r112 = MultiLinkPanelLifecycle.HIDE.ordinal();
        goto L73
    L76:
        int r113 = r4.get("sort_mode").getAsInt();
        long r20 = r4.get("current_user_offset").getAsLong();
        long r21 = r4.get("current_user_paid_amount").getAsLong();
        if (r113 == 71) goto L84;
        if (r113 == 41) goto L84;
        if (r113 != 42) goto L83;
        com.bytedance.android.livesdk.sharedpref.e r114 = b6.B;
        r114.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r114, 42);
    L85:
        DataContext r115 = com.bytedance.live.datacontext.d.d(GuestApplyViewModel.TAG);
        if ((r115 instanceof GuestApplyViewModel) == true) goto L88;
        r115 = null;
    L88:
        GuestApplyViewModel r116 = (GuestApplyViewModel) r115;
        if (r116 == null) goto L91;
        r116.setLynxCurrentUserWaitingOffset(r20);
    L91:
        if (r116 == null) goto L172;
        r116.setLynxCurrentUserPaidAmount(r21);
        goto L172
    L83:
        com.bytedance.android.livesdk.sharedpref.e r117 = b6.B;
        r117.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r117, 40);
    L84:
        com.bytedance.android.livesdk.sharedpref.e r118 = b6.B;
        r118.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r118, 41);
        goto L85
    L93:
        JsonElement r119 = r4.get("request_page");
        if (r119 == null) goto L97;
        String r120 = r119.getAsString();
        if (r120 == null) goto L97;
    L98:
        String r22 = r120;
        if (b().isLiveTypeAudio() == false) goto L112;
        ILinkPanelService r121 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r121 == null) goto L172;
        Context r23 = getContext();
        DataCenter r24 = this.c;
        IRoom r25 = b();
        com.bytedance.android.live.core.utils.a0.d(this.c, false);
        DataCenter r26 = this.c;
        if (r26 == null) goto L107;
        Boolean r27 = (Boolean) r26.get("data_is_portrait", Boolean.TRUE);
        if (r27 == null) goto L107;
        r27.booleanValue();
    L107:
        ih0.b r28 = this.e;
        if (r28 == null) goto L111;
        r121.PQ(r23, r24, r25, r22, (MultiLinkDynamicWidgetNew) r28);
        goto L172
    L111:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew");
    L112:
        ILinkPanelService r122 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r122 == null) goto L172;
        Context r29 = getContext();
        DataCenter r30 = this.c;
        IRoom r31 = b();
        com.bytedance.android.live.core.utils.a0.d(this.c, false);
        DataCenter r32 = this.c;
        if (r32 == null) goto L119;
        Boolean r33 = (Boolean) r32.get("data_is_portrait", Boolean.TRUE);
        if (r33 == null) goto L119;
        r33.booleanValue();
    L119:
        ih0.b r34 = this.e;
        if (r34 == null) goto L123;
        r122.JR(r29, r30, r31, false, (MultiLinkDynamicWidgetNew) r34);
        goto L172
    L123:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew");
    L97:
        r120 = "link_setting_click";
        goto L98
    L124:
        long r35 = r4.get("match_room_id").getAsLong();
        String r123 = r4.get("request_id").getAsString();
        String r36 = r4.get("match_type").getAsString();
        IInteractService r37 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r37 == null) goto L172;
        r37.fastMatchJump(r35, r123, r36);
        goto L172
    L127:
        r4.get("waiting_list_type").getAsInt();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(b()) == false) goto L139;
        cj0.a r124 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r124 == null) goto L136;
        cj0.c r125 = r124.getWidget();
        if (r125 == null) goto L136;
        if (r125.isIncreasePriceOn() != true) goto L136;
        boolean r126 = true;
    L137:
        if (r126 == false) goto L139;
    L141:
        if (hd0.c.f().j() == false) goto L151;
        Context r127 = getContext();
        if (r127 == null) goto L149;
        int r38 = IncreasePriceApplyDialog.g;
        GuestApplyViewModel r39 = (GuestApplyViewModel) com.bytedance.live.datacontext.d.d(GuestApplyViewModel.TAG);
        Intrinsics.checkNotNullParameter(r127, "context");
        IncreasePriceApplyDialog r40 = new IncreasePriceApplyDialog(r127, r3, r39);
        if (DialogLancet.shouldBlockDialogShow(r40) == false) goto L176;
        DialogLancet.handleBlockedDialogShow(r40);
        goto L149
    L176:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L175
    L148:
        DialogLancet.beforeDialogShow(r40);
        r40.show();
        DialogLancet.afterDialogShow(r40);
    L149:
        ALogger.i("MultiLinkDynamicWidget", "audience clicks the increase price button");
    L153:
        MultiLinkEventModule r128 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a(((Integer) ((ge1.a) hd0.c.f()).b).intValue(), r3);
        goto L172
    L151:
        if (hd0.c.f().g() == false) goto L153;
        f2.b(2131915053, 0);
    L136:
        r126 = false;
    L139:
        r3 = 0;
        goto L141
    L154:
        gd0.m r129 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r129 == null) goto L172;
        ((LinkPanelTransitService) r129).k();
        goto L172
    L157:
        String r130 = r4.get("action_type").getAsString();
        if (Intrinsics.areEqual(r130, "apply") == false) goto L168;
        int r131 = r4.get("position").getAsInt();
        String r41 = r4.get("from_source").getAsString();
        Integer r42 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r42 == null) goto L172;
        if (r42.intValue() != 0) goto L172;
        gd0.m r43 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r43 == null) goto L172;
        ((LinkPanelTransitService) r43).b("", r41, r131);
        goto L172
    L168:
        if (Intrinsics.areEqual(r130, "cancel_apply") == false) goto L172;
        gd0.m r132 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r132 == null) goto L172;
        ((LinkPanelTransitService) r132).e();
    L172:
        if (r8 == true) goto L178;
        a(r12, null);
        return;
    L178:
        return;
    L9:
        switch(p.b[r11.getType().ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L10;
        };
    L10:
        String r44 = "";
    L18:
        IInteractService r45 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r45 == null) goto L172;
        r45.handleLinkLynxPanelJsbChangeAction("emoji_interact_panel_type", r44, r4, r12, this.c);
        goto L172
    L11:
        String r133 = "interact_panel_click";
    L17:
        r44 = r133;
        goto L18
    L12:
        r133 = "open_contribution_list_panel";
        goto L17
    L13:
        r133 = "update_enlarge_status";
        goto L17
    L14:
        r133 = "open_beauty_panel";
        goto L17
    L15:
        r133 = "fast_match";
        goto L17
    L16:
        r133 = "edit_mic_position";
        goto L17
    }

    public q(Context r2, DataCenter r3, ih0.b r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "service");
        super(r2, r3);
        this.e = r4;
        this.f = r5;
        this.d = new a(this);
    }
}
