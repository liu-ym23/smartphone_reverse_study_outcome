package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.re;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.config.z90;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ToolbarManageBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData> {
    public Room a;
    public boolean b;
    public boolean c;
    public View d;
    public DataCenter e;
    public final boolean f;
    public View g;
    public TextView h;

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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        RoomContext.Companion.getClass();
        RoomContext r0 = RoomContext.a.a(null, 0);
        if (r0 != null) goto L5;
    L7:
        if (r0 == null) goto L9;
        boolean r1 = ((Boolean) r0.isAnchor().getValue()).booleanValue();
    L11:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4.c.a.e(ToolbarButton.MANAGE.name()) == false) goto L14;
        if (r1 == false) goto L14;
        boolean r2 = true;
    L16:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.x0.getValue()).booleanValue() == false) goto L19;
        if (r1 == true) goto L19;
        boolean r4 = true;
    L20:
        boolean r5 = com.bytedance.android.livesdk.chatroom.utils.b0.d();
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.s0.getValue()).booleanValue() == false) goto L25;
        if (r1 == false) goto L25;
        if (r5 == false) goto L25;
        boolean r6 = true;
    L27:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.t0.getValue()).booleanValue() == false) goto L30;
        if (r1 == false) goto L30;
        boolean r7 = true;
    L32:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.u0.getValue()).booleanValue() == false) goto L35;
        if (r1 == false) goto L35;
        boolean r8 = true;
    L37:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.v0.getValue()).booleanValue() == false) goto L40;
        if (r1 == false) goto L40;
        boolean r9 = true;
    L41:
        if (r1 == true) goto L43;
    L47:
        boolean r10 = false;
    L48:
        StringBuilder r11 = new StringBuilder("manageRedDot: ");
        if (r4 == true) goto L53;
        if (r6 == true) goto L53;
        boolean r12 = false;
    L54:
        r11.append(r12);
        r11.append(", configRedDot: ");
        r11.append(r2);
        ALogger.d("toolbar-red-dot", r11.toString());
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L58;
        if (r1 == false) goto L58;
        return false;
    L58:
        if (r2 == true) goto L65;
        if (r4 == true) goto L65;
        if (r6 == true) goto L65;
        if (r7 == true) goto L65;
        if (r8 == true) goto L65;
        if (r9 == true) goto L65;
        if (r10 == true) goto L65;
        return false;
    L65:
        return true;
    L53:
        r12 = true;
        goto L54
    L43:
        if (v22.a.a() == false) goto L47;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.B0.getValue()).booleanValue() == false) goto L47;
        r10 = true;
    L40:
        r9 = false;
    L35:
        r8 = false;
    L30:
        r7 = false;
    L25:
        r6 = false;
    L19:
        r4 = false;
    L14:
        r2 = false;
        goto L16
    L9:
        r1 = this.c;
        goto L11
    L5:
        if (r0.isBroadcastMedia() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.a;
    }

    public ToolbarManageBehavior(boolean r2) {
        this.b = true;
        this.c = false;
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        if (this.f == false) goto L5;
        return;
    L5:
        if ((r2 instanceof pp1.m) == false) goto L11;
        View r0 = this.d;
        if (r0 == null) goto L12;
        r0.setVisibility(((pp1.m) r2).a);
        return;
    L12:
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        Context r1 = r21.getContext();
        int r2 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r1) == true) goto L7;
        com.bytedance.android.live.core.utils.f2.b(2131916005, 0);
        return;
    L7:
        if (this.c == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.s0;
        Boolean r4 = Boolean.FALSE;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.t0;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r4);
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.u0;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r4);
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.v0;
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r4);
    L11:
        if (this.a == null) goto L91;
        boolean r8 = true;
        if (this.c == false) goto L42;
        LiveRoomManageAppLogger.q(true);
        Bundle r9 = new Bundle();
        if (this.c == true) goto L17;
    L21:
        boolean r10 = false;
    L22:
        r9.putBoolean("new_anchor_admin_page", false);
        r9.putBoolean("new_anchor_setting_page", r10);
        r9.putBoolean("is_from_live_room", true);
        Context r11 = r21.getContext();
        Room r12 = this.a;
        LiveProfileManageDialogV2 r18 = new LiveProfileManageDialogV2(r11, r12, r12.getBaseOwner(), true, this.b, true, null, r9, false, null, 768);
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L89;
        DialogLancet.handleBlockedDialogShow(r18);
    L28:
        if (r9.getBoolean("new_anchor_setting_page") == false) goto L30;
        com.bytedance.android.livesdk.log.u.l().f("livesdk_anchor_function_setting_click", Collections.emptyMap(), new Object[0]);
    L30:
        LiveRoomManageAppLogger.r(true);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue()).booleanValue() == true) goto L33;
    L39:
        DataCenter r13 = this.e;
        if (r13 == null) goto L92;
        r13.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
        return;
    L92:
        return;
    L33:
        if (this.a.isHasCommerceGoods() == true) goto L39;
        HashMap r14 = new HashMap();
        r14.put("live_status_type", "live_on");
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue()).booleanValue() == false) goto L37;
        String r15 = "on";
    L38:
        r14.put("to_status", r15);
        r14.put("live_type", com.bytedance.android.livesdk.utils.j.a(null));
        r14.put("anchor_id", String.valueOf(this.a.getOwnerUserIdString()));
        r14.put("room_id", String.valueOf(this.a.getIdStr()));
        com.bytedance.android.livesdk.log.g r16 = com.bytedance.android.livesdk.log.u.l();
        Map<String, String> r17 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f4.a(this.e, r14);
        am2.x r19 = new am2.x();
        r19.a = "live_take";
        r19.e = "click";
        r19.b = "live_take_page";
        r16.sendLog("livesdk_live_record_status_show", r17, new Object[]{r19});
        goto L39
    L37:
        r15 = "off";
        goto L38
    L89:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L85
    L26:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L28
    L17:
        if (tb1.c.a == false) goto L21;
        if (z90.a.getValue().booleanValue() == false) goto L21;
        r10 = true;
        goto L22
    L42:
        String r20 = null;
        LiveRoomManageAppLogger.q(false);
        User r22 = (IUser) this.e.get("data_user_in_room");
        if ((r22 instanceof User) == false) goto L94;
        Room r23 = this.a;
        RoomPermissionContext.a r24 = RoomPermissionContext.Companion;
        DataCenter r25 = this.e;
        r24.getClass();
        RoomPermissionContext r26 = RoomPermissionContext.a.f(r25);
        if (r26 == null) goto L49;
        LiveRoomPermission.Companion r110 = LiveRoomPermission.D;
        List r27 = (List) r26.getCurrentPermissions().getValue();
        r110.getClass();
        if (LiveRoomPermission.Companion.d(r27) == false) goto L49;
    L59:
        if (r8 == true) goto L62;
        com.bytedance.android.live.core.utils.f2.b(2131922923, 0);
        return;
    L62:
        if (r22.getUserAttr() != null) goto L64;
    L83:
        com.bytedance.android.live.core.utils.f2.c("你现在不是管理员", 0);
        return;
    L64:
        if (r22.getUserAttr().isAdmin() == false) goto L83;
        String r28 = re.a.getValue();
        if (TextUtils.isEmpty(r28) == true) goto L74;
        Room r29 = this.a;
        if (r29 == null) goto L74;
        Map r30 = r29.anchorAbMap;
        if (r30 == null) goto L74;
        if ("1".equals(r30.get("admin_optimize_third")) == false) goto L74;
        jc1.k.f(IBaseLiveActionHandler.class).handleWithoutHost(r21.getContext(), r28);
    L80:
        DataCenter r31 = this.e;
        if (r31 == null) goto L96;
        r31.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
        return;
    L96:
        return;
    L74:
        LiveProfileManageDialogV2 r32 = new LiveProfileManageDialogV2(r21.getContext(), this.a, r22, true, this.b, false, null, null, false, null, 992);
        if (DialogLancet.shouldBlockDialogShow(r32) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r32);
    L79:
        LiveRoomManageAppLogger.r(false);
        goto L80
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L78:
        DialogLancet.beforeDialogShow(r32);
        r32.show();
        DialogLancet.afterDialogShow(r32);
    L49:
        if (r22.getUserAttr() != null) goto L51;
    L58:
        r8 = false;
        goto L59
    L51:
        if (r22.getUserAttr().isAdmin() == false) goto L58;
        LiveRoomPermission.D.getClass();
        if (r23 == null) goto L56;
        r20 = r23.getAnchorAbValue("admin_optimize_third");
    L56:
        if ("1".equals(r20) == false) goto L58;
    L94:
        return;
    L91:
        return;
    L9:
        com.bytedance.android.livesdk.sharedpref.e r33 = com.bytedance.android.livesdk.sharedpref.b.x0;
        Boolean r34 = Boolean.FALSE;
        r33.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r33, r34);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        this.e.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        this.e = r5;
        this.a = (Room) r5.get("data_room");
        DataCenter r6 = this.e;
        Boolean r0 = Boolean.FALSE;
        this.c = ((Boolean) r6.get("data_is_anchor", r0)).booleanValue();
        this.b = ((Boolean) this.e.get("data_is_portrait")).booleanValue();
        this.d = r4;
        this.g = r4.findViewById(2131374718);
        this.h = (TextView) r4.findViewById(2131380593);
        boolean r7 = ((Boolean) this.e.get("data_is_anchor", r0)).booleanValue();
        if (this.f == true) goto L5;
        this.d.setVisibility(8);
        this.e.observe("data_user_in_room", this);
    L14:
        View r8 = this.g;
        if (r8 != null) goto L17;
        return;
    L17:
        if (this.f == true) goto L19;
        return;
    L19:
        if (this.b == false) goto L23;
        if (r7 == false) goto L22;
        r8.setBackgroundResource(2131251458);
        return;
    L22:
        r8.setBackgroundResource(2131251456);
        return;
    L23:
        r8.setBackgroundResource(2131251459);
        return;
    L5:
        if (r7 == true) goto L10;
        TextView r9 = this.h;
        if (r9 == null) goto L14;
        r9.setText(2131915075);
        goto L14
    L10:
        if (z90.a.getValue().booleanValue() == false) goto L14;
        TextView r10 = this.h;
        if (r10 == null) goto L14;
        r10.setText(com.bytedance.android.live.core.utils.s1.B(2131922850));
        goto L14
    }
}
