package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends a0 {
    public final DataCenter f;
    public final Context g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final w j() {
        ToolbarButton r1 = ToolbarButton.WATCH_LATER;
        return new w(r1, r1, null, null);
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarWatchLater.INSTANCE;
    }

    public h(DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final c0.b g(s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        return new k(r2, this.f, this.g);
    }
}
