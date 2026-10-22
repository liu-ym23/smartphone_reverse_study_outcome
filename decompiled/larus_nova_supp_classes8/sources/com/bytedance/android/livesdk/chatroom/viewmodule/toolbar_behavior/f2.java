package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.miniapp.MiniAppOuterHelper;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final MiniAppOuterHelper a;
    public boolean b;

    public static final class a {
    }

    static {
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
        if (ud0.a.getValue().booleanValue() == false) goto L13;
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.b.L3.getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.intValue() == 0) goto L10;
        return false;
    L10:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.A3.getValue()).booleanValue() == true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        LiveMode r8 = null;
        if (ud0.a.getValue().booleanValue() == false) goto L25;
        boolean r13 = this.b;
        HashMap r0 = new HashMap();
        r0.put("_param_for_special", "micro_app");
        RoomContext.a r6 = RoomContext.Companion;
        RoomContext r7 = RoomContext.a.c(r6, null, 0, 3);
        if (r7 == null) goto L12;
        com.bytedance.live.datacontext.m r9 = r7.getRoom();
        if (r9 == null) goto L12;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L12;
        String r11 = String.valueOf(r10.getRoomId());
        if (r11 == null) goto L12;
    L13:
        r0.put("room_id", r11);
        if (r13 == false) goto L16;
        String r14 = "1";
    L17:
        r0.put("if_yellow_spot", r14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_more_function_mp_icon_click", r0, new Object[0]);
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.L3;
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, Integer.MAX_VALUE);
        IOpenPlatformAnchorService r16 = jc1.k.n(IOpenPlatformAnchorService.class);
        RoomContext r1 = RoomContext.a.c(r6, null, 0, 3);
        if (r1 == null) goto L24;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L24;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L24;
        r8 = r3.getStreamType();
    L24:
        int r4 = com.bytedance.android.live.core.utils.h1.a;
        r16.openChoosePage("more_btn_panel", com.bytedance.android.live.core.utils.i1.a(r8), this.a);
        return;
    L16:
        r14 = "0";
    L12:
        r11 = "";
        goto L13
    L25:
        if (r12 == null) goto L27;
        Context r17 = r12.getContext();
    L28:
        FragmentActivity r18 = ContextUtil.contextToFragmentActivity(r17);
        if (r18 == null) goto L31;
        jc1.k.n(IOpenPlatformAnchorService.class).openCouponPage(r18, 3, null);
    L31:
        RoomContext r19 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r19 == null) goto L36;
        com.bytedance.live.datacontext.m r110 = r19.getRoom();
        if (r110 == null) goto L36;
        r8 = (Room) r110.getValue();
    L36:
        String r111 = com.bytedance.android.livesdk.chatroom.utils.k1.c();
        String r5 = com.bytedance.android.livesdk.chatroom.utils.k1.d();
        HashMap r20 = new HashMap();
        if (r8 == null) goto L41;
        String r21 = r8.getOwnerUserIdString();
        if (r21 == null) goto L41;
        String r22 = (String) r20.put("anchor_id", r21);
    L41:
        if (r8 == null) goto L45;
        String r23 = r8.getIdStr();
        if (r23 == null) goto L45;
        String r24 = (String) r20.put("room_id", r23);
    L45:
        if (r111 == null) goto L47;
        String r112 = (String) r20.put("enter_from_merge", r111);
    L47:
        String r113 = (String) r20.put("enter_method", r5);
        r20.put("_param_for_special", "micro_app");
        com.bytedance.android.livesdk.log.u.l().e("mp_live_entrance_click", r20, new Object[]{Room.class});
        return;
    L27:
        r17 = null;
        goto L28
    }

    public f2(Context r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        long r4 = 0;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L9;
        r4 = r3.getRoomId();
    L9:
        this.a = new MiniAppOuterHelper(r7, r4, r8);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        boolean r8 = showRedDot();
        this.b = r8;
        HashMap r9 = new HashMap();
        r9.put("_param_for_special", "micro_app");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = String.valueOf(r2.getRoomId());
        if (r3 == null) goto L10;
    L11:
        r9.put("room_id", r3);
        if (r8 == false) goto L14;
        String r10 = "1";
    L15:
        r9.put("if_yellow_spot", r10);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_more_function_mp_icon_show", r9, new Object[0]);
        jc1.k.n(IOpenPlatformAnchorService.class).recordMorePanelSnowFlakeShown();
        return;
    L14:
        r10 = "0";
    L10:
        r3 = "";
        goto L11
    }
}
