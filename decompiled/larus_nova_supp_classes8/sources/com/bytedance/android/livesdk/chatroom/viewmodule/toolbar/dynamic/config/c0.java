package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.QUICK_SCREEN_SHOT;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSSNAPSHOT.INSTANCE;
    }

    public c0(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        DataCenter r5 = this.g;
        Boolean r6 = Boolean.TRUE;
        Boolean r7 = (Boolean) r5.get("data_is_portrait", r6);
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.g).isMergeVSRoom() == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L10;
        Boolean r9 = (Boolean) this.g.get("data_is_portrait", r6);
        return new com.bytedance.android.livesdk.chatroom.ui.behavior.b(this.f, com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.g), r9.booleanValue());
    L10:
        return null;
    L5:
        if (r7.booleanValue() == false) goto L7;
        r8 = true;
        goto L8
    }
}
