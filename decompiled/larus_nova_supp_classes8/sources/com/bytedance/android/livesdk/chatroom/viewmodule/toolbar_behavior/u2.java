package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final String a;
    public final DataCenter b;

    public static final class a {
    }

    static {
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

    public u2(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.a = LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        bp1.f r1 = new bp1.f("link", "", 0);
        Boolean r0 = (Boolean) com.bytedance.android.livesdk.l1.a.getValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.b).t(ToolbarButton.SHARE);
        v2 r4 = null;
        if ((r2 instanceof e5) == true) goto L5;
        r2 = null;
    L5:
        e5 r3 = (e5) r2;
        if (r3 != null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.b);
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == true) goto L10;
        r5 = null;
    L10:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) r5;
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r8 = r6.t(ToolbarButton.SHARE);
    L15:
        if ((r8 instanceof e5) == true) goto L17;
        r8 = null;
    L17:
        r3 = (e5) r8;
        goto L18
    L13:
        r8 = null;
    L18:
        if (r3 != null) goto L20;
        return;
    L20:
        if (r0.booleanValue() == false) goto L23;
        r4 = new v2(r7);
    L23:
        r3.f(r1, true, r4, r0.booleanValue(), r0.booleanValue());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        if (((Boolean) r5.get("copy_show", Boolean.FALSE)).booleanValue() == true) goto L10;
        r5.put("copy_show", Boolean.TRUE);
        com.bytedance.android.livesdk.log.filter.t r6 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r6 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L7;
        String r7 = String.valueOf(r6.getMap().get("enter_from_merge"));
    L8:
        com.bytedance.android.livesdk.log.j0 r0 = com.bytedance.android.livesdk.log.j0.l();
        HashMap r1 = new HashMap();
        r1.put("enter_from", r7);
        r1.put("schema_type", this.a);
        r1.put("panel_name", "share_3row_panel");
        r1.put("object_id", String.valueOf(com.bytedance.android.live.core.utils.z.o(r5).id));
        r1.put("function_name", "link");
        Unit r8 = Unit.INSTANCE;
        r0.h("ug_share_client_share_function_show", r1, new Object[0]);
        return;
    L7:
        r7 = "";
        goto L8
    }
}
