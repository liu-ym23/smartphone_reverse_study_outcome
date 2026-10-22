package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.interactivity.api.IIMService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean o() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.LIVE_IM_ENTRANCE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, ToolbarButton.LIVE_IM_ENTRANCE_MORE, r1, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarIM.INSTANCE;
    }

    public l(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(null, null, 7);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "button");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.f0 r6 = r3.l;
        if (r6 == null) goto L21;
        Object r7 = r6.c;
        if (r7 != null) goto L7;
        return null;
    L7:
        if ((r7 instanceof BitmapDrawable) == false) goto L23;
        if (r4 == false) goto L16;
        if (r5 == true) goto L16;
        if (u40.a.c(r5) == false) goto L16;
        IIMService r8 = jc1.k.f(IIMService.class);
        if (r8 != null) goto L15;
        return null;
    L15:
        return r8.getImBehaviorInMore((BitmapDrawable) r7);
    L16:
        IIMService r9 = jc1.k.f(IIMService.class);
        if (r9 != null) goto L19;
        return null;
    L19:
        return r9.getImBehavior((BitmapDrawable) r7);
    L23:
        return null;
    L21:
        return null;
    }
}
