package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.b11;
import com.bytedance.android.livesdk.config.v9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AddWidgetBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

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
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return true;
    }

    public AddWidgetBehavior() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        v9 r0 = v9.a;
        if (((b11) r0.getValue()).b() == true) goto L9;
        DataCenter r1 = this.a;
        if (r1 == null) goto L7;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r1);
    L8:
        com.bytedance.android.livesdk.castscreen.utils.c.a("livesdk_live_widget_click", r2, AnonymousClass1.INSTANCE);
        goto L9
    L7:
        r2 = null;
    L9:
        DataCenter r3 = this.a;
        if (r3 == null) goto L48;
        Room r4 = com.bytedance.android.live.core.utils.z.o(r3);
        if (r4 == null) goto L49;
        r4.getRoomId();
        if (r11 == null) goto L50;
        Context r12 = r11.getContext();
        if (r12 == null) goto L53;
        boolean r5 = false;
        if (NetworkUtils.f(r12) == true) goto L23;
        com.bytedance.android.live.core.utils.f2.b(2131915628, 0);
        return;
    L23:
        if (((b11) r0.getValue()).b() == false) goto L37;
        DataCenter r6 = this.a;
        if (r6 == null) goto L37;
        if (com.bytedance.android.live.core.utils.z.m(r6, true) != true) goto L37;
        IHostBusiness r7 = jc1.k.n(IHostBusiness.class);
        DataCenter r13 = this.a;
        if (r13 == null) goto L34;
        Room r14 = com.bytedance.android.live.core.utils.z.o(r13);
        if (r14 == null) goto L34;
        String r15 = r14.getOwnerUserIdString();
        if (r15 == null) goto L34;
    L35:
        r7.addPanelThreeDesktop("live_desktop_business", "panel_desktop_item", "passAll", "1", r15);
        com.bytedance.android.livesdk.chatroom.utils.o4.c("livesdk_desktop_app_guide_click", "more");
        return;
    L34:
        r15 = "";
    L37:
        boolean r16 = jc1.k.n(IHostBusiness.class).hasLiveAppWidgetAdded(r12);
        Activity r8 = com.bytedance.android.live.core.utils.a.d();
        if (r8 == null) goto L51;
        if (r16 == true) goto L46;
        IHostBusiness r17 = jc1.k.n(IHostBusiness.class);
        DataCenter r9 = this.a;
        if (r9 != null) goto L43;
    L45:
        r17.tryAddLiveAppWidget(r8, r5, "more");
        return;
    L43:
        if (com.bytedance.android.live.core.utils.z.m(r9, true) == true) goto L45;
        r5 = true;
        goto L45
    L46:
        com.bytedance.android.live.core.utils.f2.b(2131914623, 0);
        return;
    L51:
        return;
    L53:
        return;
    L50:
        return;
    L49:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        com.bytedance.android.livesdk.chatroom.utils.o4.c("livesdk_desktop_app_guide_show", "more");
    }
}
