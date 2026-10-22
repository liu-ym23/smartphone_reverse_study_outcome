package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostMarketing;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public w0() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
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
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return true;
    }

    public final Map<String, String> a() {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r1 = (String) r0.getMap().get("enter_from_merge");
    L7:
        if (r0.getMap().containsKey("enter_method") == false) goto L9;
        String r4 = (String) r0.getMap().get("enter_method");
    L11:
        if (r0.getMap().containsKey("action_type") == false) goto L14;
        r3 = (String) r0.getMap().get("action_type");
    L14:
        if (tb1.c.a == false) goto L16;
        r1 = com.bytedance.android.livesdk.chatroom.utils.k1.c();
    L16:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("enter_from_merge", r1);
        r2.put("enter_method", r4);
        r2.put("action_type", r3);
        r2.put("request_page", "more_function_button");
        r2.put("event_page", "live_detail");
        DataCenter r5 = this.a;
        Room r6 = null;
        if (r5 == null) goto L19;
        r6 = (Room) r5.get("data_room", null);
    L19:
        if (r6 == null) goto L21;
        r2.put("to_user_id", r6.getOwnerUserIdString());
        r2.put("anchor_id", r6.getOwnerUserIdString());
        r2.put("room_id", r6.getIdStr());
        r2.put("request_id", r6.getRequestId());
    L21:
        r2.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r2.put("widget_type", "ug_ecom_widget");
        return r2;
    L9:
        r4 = "";
        goto L11
    L5:
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.A;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        IHostMarketing r5 = jc1.k.f(IHostMarketing.class);
        if (r5 == null) goto L5;
        r5.tryInstallShoppingFakeIcon();
    L5:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_ug_widget_desktop_button_click", a(), new Object[0]);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r4;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_ug_widget_desktop_button_show", a(), new Object[0]);
    }
}
