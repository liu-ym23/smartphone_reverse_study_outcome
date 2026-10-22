package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final String a;
    public final DataCenter b;

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

    public p4(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.a = LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        bp1.f r1 = new bp1.f("qr_code", "", 0);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r8 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.b).t(ToolbarButton.SHARE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r2 = null;
        if ((r8 instanceof e5) == true) goto L5;
        r8 = null;
    L5:
        e5 r9 = (e5) r8;
        if (r9 != null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.b);
        if ((r10 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == true) goto L10;
        r10 = null;
    L10:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r11 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) r10;
        if (r11 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r12 = r11.t(ToolbarButton.SHARE);
    L15:
        if ((r12 instanceof e5) == false) goto L18;
        r2 = r12;
    L18:
        e5 r0 = (e5) r2;
    L20:
        if (r0 == null) goto L23;
        r0.f(r1, true, null, false, false);
        return;
    L23:
        return;
    L13:
        r12 = null;
        goto L15
    L19:
        r0 = r9;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        if (((Boolean) r5.get("qrcode_show", Boolean.FALSE)).booleanValue() == true) goto L10;
        com.bytedance.android.livesdk.log.filter.t r6 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r6 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L7;
        String r7 = String.valueOf(r6.getMap().get("enter_from_merge"));
    L8:
        r5.put("qrcode_show", Boolean.TRUE);
        com.bytedance.android.livesdk.log.j0 r0 = com.bytedance.android.livesdk.log.j0.l();
        HashMap r1 = new HashMap();
        r1.put("enter_from", r7);
        r1.put("schema_type", this.a);
        r1.put("panel_name", "share_3row_panel");
        r1.put("object_id", String.valueOf(com.bytedance.android.live.core.utils.z.o(r5).id));
        r1.put("function_name", "qr_code");
        Unit r8 = Unit.INSTANCE;
        r0.h("ug_share_client_share_function_show", r1, new Object[0]);
        return;
    L7:
        r7 = "";
        goto L8
    }
}
