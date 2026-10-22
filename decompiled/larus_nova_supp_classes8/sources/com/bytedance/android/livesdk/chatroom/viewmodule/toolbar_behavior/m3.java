package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public View a;

    public m3() {
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
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("request_page", "interact_panel");
        r8.put("function_type", jc1.k.n(IInteractService.class).getCurrentFunctionType());
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L5;
        r2.updateSwitchSceneSource("interaction_button");
    L5:
        r8.put("source", "interaction_button");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_grouppk_icon_click", r8, new Object[]{Room.class});
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.r0;
        Boolean r3 = Boolean.FALSE;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r3);
        UIUtils.setViewVisibility(this.a, 8);
        jc1.k.n(IInteractService.class).clickLinkRoomFightIcon(MapsKt.mapOf(TuplesKt.to("request_page", "interact_panel")));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2.findViewById(2131384095);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.r0.getValue()).booleanValue() == false) goto L5;
        UIUtils.setViewVisibility(this.a, 0);
        return;
    L5:
        UIUtils.setViewVisibility(this.a, 8);
    }
}
