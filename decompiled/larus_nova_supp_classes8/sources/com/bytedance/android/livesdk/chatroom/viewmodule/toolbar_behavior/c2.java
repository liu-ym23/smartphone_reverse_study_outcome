package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ed;
import com.bytedance.android.livesdk.config.fd;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public c2() {
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
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L5;
        return false;
    L5:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L16;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L16;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L16;
        String r3 = r2.getAnchorAbValue("admin_pin_ab_group");
        if (r3 == null) goto L16;
        if (r3.equals("1") != true) goto L16;
        boolean r4 = true;
    L18:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.w0.getValue()).booleanValue() == false) goto L22;
        if (r4 == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L16:
        r4 = false;
        goto L18
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        Intrinsics.checkNotNullParameter(r18, "v");
        Context r1 = r18.getContext();
        int r3 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r1) == true) goto L6;
        com.bytedance.android.live.core.utils.f2.b(2131916005, 0);
        return;
    L6:
        DataCenter r2 = this.a;
        if (r2 == null) goto L38;
        Room r4 = (Room) r2.get("data_room");
        if (r4 == null) goto L39;
        LiveRoomManageAppLogger.q(true);
        DataCenter r5 = this.a;
        if (r5 == null) goto L14;
        boolean r6 = com.bytedance.android.live.core.utils.z.e(r5, false);
    L15:
        LiveRoomManageAppLogger.p(r6);
        if (ed.a.getValue().booleanValue() == false) goto L21;
        ILiveService r7 = TTLiveService.getLiveService();
        if (r7 == null) goto L20;
        r7.handleSchema(r18.getContext(), UriProtector.parse(fd.a.getValue()));
    L20:
        boolean r19 = true;
    L26:
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.w0;
        Boolean r9 = Boolean.FALSE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r9);
        LiveRoomManageAppLogger.r(r19);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue()).booleanValue() == false) goto L33;
        HashMap r10 = new HashMap();
        r10.put("live_status_type", "live_on");
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue()).booleanValue() == false) goto L31;
        String r11 = "on";
    L32:
        r10.put("to_status", r11);
        r10.put("live_type", com.bytedance.android.livesdk.utils.j.a(null));
        r10.put("anchor_id", r4.getOwnerUserIdString());
        r10.put("room_id", r4.getIdStr().toString());
        com.bytedance.android.livesdk.log.g r12 = com.bytedance.android.livesdk.log.u.l();
        am2.x r13 = new am2.x();
        r13.a = "live_take";
        r13.e = "click";
        r13.b = "live_take_page";
        r12.sendLog("livesdk_live_record_status_show", r10, new Object[]{r13});
        goto L33
    L31:
        r11 = "off";
    L33:
        com.bytedance.android.livesdk.log.u.l().f("livesdk_anchor_live_mgnt_click", MapsKt.emptyMap(), new Object[0]);
        return;
    L21:
        Context r14 = r18.getContext();
        User r15 = r4.getOwner();
        Bundle r16 = new Bundle();
        r16.putBoolean("new_anchor_admin_page", true);
        r16.putBoolean("new_anchor_setting_page", false);
        r16.putBoolean("is_from_live_room", true);
        r19 = true;
        LiveProfileManageDialogV2 r17 = new LiveProfileManageDialogV2(r14, r4, r15, true, true, false, null, r16, false, null, 864);
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r17);
        goto L26
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L25:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
        goto L26
    L14:
        r6 = false;
        goto L15
    L39:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
