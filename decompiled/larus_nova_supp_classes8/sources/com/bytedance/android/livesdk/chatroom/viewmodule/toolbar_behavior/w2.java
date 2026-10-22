package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final Room a;

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
    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return false;
    }

    public w2(Room r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        xs2.b.a().post(new zg1.h1(37, this.a));
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.D2;
        Boolean r0 = Boolean.TRUE;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r0);
        Room r14 = this.a;
        HashMap r1 = new HashMap();
        r1.put("request_page", "more");
        String r2 = null;
        if (r14 == null) goto L5;
        String r3 = r14.getOwnerUserIdString();
    L6:
        r1.put("to_user_id", String.valueOf(r3));
        lc0.c r4 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        int r7 = am2.c0.b;
        r5.sendLog("livesdk_dislike", r1, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.c0.a.a(r4.v())});
        HashMap r6 = new HashMap();
        r6.put("event_page", "live_detail");
        r6.put("request_page", "click");
        if (r14 == null) goto L9;
        r2 = r14.getOwnerUserIdString();
    L9:
        r6.put("to_user_id", String.valueOf(r2));
        com.bytedance.android.livesdk.log.u.l().sendLog("live_dislike", r6, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L5:
        r3 = null;
        goto L6
    }
}
