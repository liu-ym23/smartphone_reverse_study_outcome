package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.config.ba;
import com.bytedance.android.livesdk.config.uy;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i4 extends e2 implements c0.b {
    public DataCenter e;

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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public i4() {
        super(ToolbarButton.WISH_LIST, new r(i4.class));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2
    public final boolean b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.isPortraitInteraction();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        RoomPermissionContext.a r2 = RoomPermissionContext.Companion;
        DataCenter r3 = this.e;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r4 = LiveRoomPermission.n;
        r2.getClass();
        if (RoomPermissionContext.a.e(r3, r4) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        Boolean r1 = Boolean.FALSE;
        return Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("toolbar_wish_list_dot_shown", r1).getValue(), r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2
    public final Panel a() {
        return Panel.MORE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.o;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("toolbar_wish_list_dot_shown", Boolean.FALSE), Boolean.TRUE);
        DataCenter r7 = this.e;
        boolean r0 = false;
        if (r7 == null) goto L5;
        boolean r8 = com.bytedance.android.live.core.utils.z.b(r7).c;
    L6:
        int r1 = j40.g4.a;
        if (j40.g4.a.a() == false) goto L14;
        if (r8 == true) goto L14;
        if (b() == true) goto L14;
        com.bytedance.android.live.core.utils.f2.b(2131922923, 0);
        return;
    L14:
        if (((Boolean) uy.a.getValue()).booleanValue() == false) goto L25;
        DataCenter r9 = this.e;
        if (r9 == null) goto L25;
        Room r10 = com.bytedance.android.live.core.utils.z.o(r9);
        if (r10 == null) goto L25;
        RoomAuthStatus r11 = r10.getMRoomAuthStatus();
        if (r11 == null) goto L25;
        if (r11.getEnableGift() == true) goto L25;
        com.bytedance.android.live.core.utils.f2.c("本场直播不支持送礼", 0);
        return;
    L25:
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r12 == null) goto L34;
        com.bytedance.live.datacontext.m r13 = r12.getUser();
        if (r13 == null) goto L34;
        User r14 = (User) r13.getValue();
        if (r14 == null) goto L34;
        py.t r15 = r14.getUserAttr();
        if (r15 == null) goto L34;
        boolean r16 = r15.isAdmin();
    L35:
        String r2 = ba.a.getValue();
        if (r2.length() != 0) goto L38;
        r0 = true;
    L38:
        if (r0 == false) goto L41;
        ALogger.e("LiveRoomPermission", "empty admin wish list schema");
        return;
    L41:
        String r17 = com.bytedance.android.livesdk.chatroom.y0.a(r2, MapsKt.mapOf(TuplesKt.to("is_admin", com.bytedance.android.live.core.utils.m2.b(r16))), 4);
        jc1.k.n(IRoomService.class).actionHandler().handle(com.bytedance.android.live.core.utils.s1.getContext(), r17);
        return;
    L34:
        r16 = false;
        goto L35
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = r3;
    }
}
