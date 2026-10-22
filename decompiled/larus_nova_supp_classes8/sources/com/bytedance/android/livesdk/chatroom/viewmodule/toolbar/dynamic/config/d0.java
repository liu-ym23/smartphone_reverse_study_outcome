package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.yp;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.INTERACTION, ToolbarButton.INTERACTION_MORE, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        if (yp.a.getValue().booleanValue() == false) goto L7;
        return false;
    L7:
        return super.m();
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarLinkmic.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void n(boolean r3) {
        Intrinsics.checkNotNullParameter("", "reason");
        this.g.put("data_more_dialog_is_show_interact_more", Boolean.valueOf(r3));
    }

    public d0(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 6);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (u40.a.c(r4) == false) goto L9;
        if (r4 == true) goto L12;
        if (r3 == false) goto L8;
        return jc1.k.n(IInteractService.class).getMultiLinkToolbarService().b;
    L8:
        return jc1.k.n(IInteractService.class).getMultiLinkToolbarService().b;
    L12:
        return null;
    L9:
        if (r4 == false) goto L11;
        return null;
    L11:
        return jc1.k.n(IInteractService.class).getMultiLinkToolbarService().b;
    }
}
