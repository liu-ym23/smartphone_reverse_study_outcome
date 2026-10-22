package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.COMMERCE_IM, null, null, null);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE;
    }

    public d(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(null, null, 7);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final String i(boolean r1, boolean r2) {
        return NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE.getName();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        Object r4 = r1.l.c;
        if ((r4 instanceof IExternalButton) == true) goto L5;
        r4 = null;
    L5:
        IExternalButton r5 = (IExternalButton) r4;
        if (r5 != null) goto L8;
        return null;
    L8:
        return new com.bytedance.android.livesdk.room.placeholder.behavior.f(r5);
    }
}
