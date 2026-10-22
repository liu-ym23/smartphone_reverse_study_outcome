package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public s2() {
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
        DataCenter r0 = this.a;
        if (r0 != null) goto L6;
        r0 = null;
    L6:
        RoomContext.Companion.getClass();
        RoomContext r1 = RoomContext.a.a(r0, 0);
        if (r1 == null) goto L13;
        if (r1.isBroadcastMedia() != true) goto L13;
        return false;
    L13:
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.f0.getValue()).booleanValue();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        HashMap r12 = new HashMap();
        if (ud0.a.getValue().booleanValue() == false) goto L14;
        r12.put("event_page", "interact");
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r8 = this.a;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L7:
        r0.getClass();
        RoomContext r1 = RoomContext.a.a(r8, 0);
        if (r1 != null) goto L10;
    L12:
        String r2 = "0";
    L13:
        r12.put("live_status", r2);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_comment_click", r12, new Object[]{Room.class, am2.x.class});
    L18:
        RoomContext.a r13 = RoomContext.Companion;
        DataCenter r3 = this.a;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L21:
        RoomContext r14 = RoomContext.a.c(r13, r3, 0, 2);
        DataCenter r4 = this.a;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L25:
        if (ChatChannelUtils.k(r14, r4) == false) goto L28;
        u22.m r15 = new u22.m();
        r15.l = OpenInputSource.AnchorInteractivityPanel;
        r15.m = 1;
    L31:
        DataCenter r5 = this.a;
        if (r5 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L34:
        r5.put("cmd_wanna_send_message", r15);
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.f0;
        Boolean r6 = Boolean.FALSE;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r6);
        DataCenter r17 = this.a;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r17).b(ToolbarButton.MORE, new pp1.j(false));
        return;
    L28:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.q.b(r14) == false) goto L30;
        r15 = new u22.m();
        r15.l = OpenInputSource.AnchorInteractivityPanel;
        r15.m = 2;
        goto L31
    L30:
        r15 = new u22.m();
        r15.l = OpenInputSource.AnchorInteractivityPanel;
        goto L31
    L10:
        if (((Number) r1.getMediaReviewStatus().getValue()).intValue() < 5) goto L12;
        r2 = "1";
        goto L13
    L14:
        com.bytedance.android.livesdk.log.g r18 = com.bytedance.android.livesdk.log.u.l();
        DataCenter r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L17:
        r18.sendLog("livesdk_anchor_comment_click", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f4.a(r7, null), new Object[]{Room.class});
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
