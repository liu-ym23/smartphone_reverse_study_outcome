package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.uy;
import com.bytedance.android.livesdk.config.vp;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveBeInvitedDialogConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z2 implements f10.a {
    public DataCenter a;
    public final Context b;
    public com.bytedance.android.live.broadcastgame.api.model.u c;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r4) {
        ((Map) com.bytedance.android.livesdk.sharedpref.b.W1.getValue()).put(this.c.name, Boolean.FALSE);
        if (((Boolean) uy.a.getValue()).booleanValue() == false) goto L18;
        DataCenter r5 = this.a;
        if (r5 == null) goto L18;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r5);
        if (r6 == null) goto L18;
        RoomAuthStatus r7 = r6.getMRoomAuthStatus();
        if (r7 == null) goto L18;
        if (r7.getEnableGift() == true) goto L18;
        com.bytedance.android.live.broadcastgame.api.model.r r8 = this.c.c();
        if (r8 == null) goto L18;
        if (r8.k() != 1) goto L18;
        com.bytedance.android.live.core.utils.f2.c("本场直播不支持送礼", 0);
        return;
    L18:
        CloudGroupLiveBeInvitedDialogConfig r9 = (CloudGroupLiveBeInvitedDialogConfig) com.bytedance.android.live.core.setting.d0.a.getValue();
        if (r9 == null) goto L34;
        List r10 = r9.getDisableGiftMenu();
        if (r10 == null) goto L34;
        if (r10.contains(this.c.name) != true) goto L34;
        IInteractService r11 = jc1.k.f(IInteractService.class);
        if (r11 == null) goto L29;
        z30.b r12 = r11.getCloudGroupLiveService();
        if (r12 == null) goto L29;
        CloudGroupLivePipelineStatus r13 = r12.b();
    L31:
        if (r13 != CloudGroupLivePipelineStatus.START) goto L34;
        com.bytedance.android.live.core.utils.f2.c("合演期间不支持开启" + this.c.name, 0);
        return;
    L29:
        r13 = null;
    L34:
        com.bytedance.android.live.broadcastgame.api.model.r r14 = this.c.c();
        if (r14 == null) goto L40;
        String r15 = r14.C();
        if (r15 == null) goto L41;
        jc1.k.n(ILiveActionHandler.class).handle(this.b, r15);
        return;
    L41:
        return;
    }

    public final void xg(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public z2(Context r2, com.bytedance.android.live.broadcastgame.api.model.u r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "interactItem");
        this.b = r2;
        this.c = r3;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        if (((Boolean) vp.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        Map r4 = (Map) com.bytedance.android.livesdk.sharedpref.b.W1.getValue();
        View r5 = r2.findViewById(2131384095);
        if (Intrinsics.areEqual((Boolean) r4.get(this.c.name), Boolean.TRUE) == false) goto L8;
        UIUtils.setViewVisibility(r5, 0);
        return;
    L8:
        UIUtils.setViewVisibility(r5, 8);
    }
}
