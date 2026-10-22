package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void p() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.TREASURE_BOX, null, null, null);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarTreasureBox.INSTANCE;
    }

    public u(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        Lazy r5 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r4, NewToolbarButtonConstants.ToolbarTreasureBox.INSTANCE, new t());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        com.bytedance.android.live.recharge.core.d r4 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r4, "$this$rechargeConfigService");
        View.OnClickListener r5 = r4.f(Reflection.getOrCreateKotlinClass(zv0.g.class)).p1(zv0.k.class).getBehavior();
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == true) goto L6;
        r5 = null;
    L6:
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r5;
    }
}
