package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j3 implements c0.b {
    public j3() {
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
    public final /* synthetic */ void dv(e r1) {
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
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("function_type", jc1.k.n(IInteractService.class).getCurrentFunctionType());
        r8.put("request_page", "interact_panel");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        String r2 = SourceType.ANCHOR;
    L10:
        r8.put("user_type", r2);
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L13;
        r3.updateSwitchSceneSource("interaction_button");
    L13:
        r8.put("source", "interaction_button");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_grouppk_icon_click", r8, new Object[]{Room.class});
        com.bytedance.android.live.liveinteract.revenue.fight.b r9 = jc1.k.n(IInteractService.class).teamFightService();
        if (r9 == null) goto L17;
        r9.d3("interact_panel");
        return;
    L17:
        return;
    L9:
        r2 = "admin";
        goto L10
    }
}
