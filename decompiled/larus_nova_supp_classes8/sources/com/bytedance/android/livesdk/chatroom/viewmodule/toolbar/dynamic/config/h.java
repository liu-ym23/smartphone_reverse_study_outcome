package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final CompositeDisposable f;
    public final Context g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.CASH_EXCHANGE, null, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void p() {
        this.f.clear();
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarExchange.INSTANCE;
    }

    public h(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.g = r3;
        this.f = new CompositeDisposable();
        Lazy r5 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r4, NewToolbarButtonConstants.ToolbarExchange.INSTANCE, new g());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        com.bytedance.android.live.recharge.core.d r4 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r4, "$this$rechargeConfigService");
        View.OnClickListener r5 = r4.f(Reflection.getOrCreateKotlinClass(zv0.g.class)).p1(zv0.j.class).getBehavior();
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == true) goto L6;
        r5 = null;
    L6:
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r5;
    }
}
