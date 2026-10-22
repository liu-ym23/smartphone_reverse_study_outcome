package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public n3() {
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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        com.bytedance.android.livesdk.reddot.a r0 = up2.a.a;
        return up2.a.w;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        String r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L10;
        r4 = r2.getAnchorAbValue("live_chatroom_announce_image_enable");
    L10:
        if (Intrinsics.areEqual(r4, "true") == false) goto L14;
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.n3.getValue()).booleanValue();
    L14:
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.m3.getValue()).booleanValue();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        Context r6 = r5.getContext();
    L6:
        FragmentActivity r7 = ContextUtil.contextToFragmentActivity(r6);
        if (r7 == null) goto L9;
        int r1 = com.bytedance.android.live.liveinteract.e.a;
        com.bytedance.android.live.liveinteract.e.b(r7, MapsKt.mapOf(TuplesKt.to("request_page", "more_panel")));
    L9:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L17;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L17;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L17;
        r0 = r10.getAnchorAbValue("live_chatroom_announce_image_enable");
    L17:
        if (Intrinsics.areEqual(r0, "true") == false) goto L19;
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.n3;
        Boolean r2 = Boolean.FALSE;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r2);
        return;
    L19:
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.b.m3;
        Boolean r3 = Boolean.FALSE;
        r12.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r12, r3);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
