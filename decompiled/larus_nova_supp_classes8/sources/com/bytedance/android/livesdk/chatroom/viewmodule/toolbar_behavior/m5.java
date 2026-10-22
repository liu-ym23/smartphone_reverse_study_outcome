package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.foundation.depend.SwitchAccountSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSwitchAccountConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public m5() {
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
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 != null) goto L5;
    L8:
        LiveSwitchAccountConfig r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.b;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.b(SwitchAccountSource.SOURCE_MORE_PANEL);
        return;
    L5:
        if (r3.isAudienceLinkEngineOn() != true) goto L8;
        com.bytedance.android.live.core.utils.f2.b(2131922674, 0);
    }
}
