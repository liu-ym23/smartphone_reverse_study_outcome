package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.ToolbarAnchorWelfareBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.ToolbarAudienceWelfareBehavior;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public f0() {
        super(null, null, 6);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.WELFARE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, null, r1, ToolbarButton.WELFARE_FOLD);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.Welfare.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (r4 == true) goto L5;
        if (r3 == false) goto L9;
        return null;
    L9:
        if (yt2.b.a().booleanValue() == true) goto L11;
        return null;
    L11:
        return new ToolbarAudienceWelfareBehavior();
    L5:
        if (yt2.b.a().booleanValue() == true) goto L13;
        return null;
    L13:
        return new ToolbarAnchorWelfareBehavior(r3);
    }
}
