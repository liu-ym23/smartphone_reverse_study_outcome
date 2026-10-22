package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.eh;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public Long a;
    public final Map<String, String> b;
    public final String c;

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

    public t2(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        this.a = 0L;
        this.b = new HashMap();
        if (tb1.c.a == false) goto L6;
        this.c = "https://webcast.amemv.com/falcon/webcast_douyin/page/live_help/common_qa/index.html";
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Map<String, String> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        r1.put("room_id", String.valueOf(this.a));
        Map<String, String> r2 = this.b;
        HashMap r3 = (HashMap) r2;
        r3.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        ((HashMap) this.b).put("entrance_type", "tool_panel");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_common_question_click", this.b, new Object[0]);
        int r4 = com.bytedance.android.livesdk.live.a.a;
        eh r6 = eh.a;
        if (com.bytedance.android.livesdk.live.a.c(r6.getValue()) == false) goto L10;
        String r7 = r6.getValue();
        ILiveActionHandler r8 = jc1.k.f(ILiveActionHandler.class);
        if (r8 == null) goto L15;
        r8.handle(r5.getContext(), r7);
        return;
    L15:
        return;
    L10:
        IBrowserService r9 = jc1.k.n(IBrowserService.class);
        Context r10 = r5.getContext();
        String r11 = this.c;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("url");
    L13:
        r9.buildFullScreenWebPage(r10, r11).d(true).b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = (Long) r3.get("data_room_id");
    }
}
