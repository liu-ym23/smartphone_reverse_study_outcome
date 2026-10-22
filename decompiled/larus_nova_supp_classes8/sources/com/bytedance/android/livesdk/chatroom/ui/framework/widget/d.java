package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends g61.a.a {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 a;
    public final /* synthetic */ Object b;

    public final boolean b() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r0 = this.a;
        Object r1 = this.b;
        if ((r1 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L10;
        ToolbarButton r2 = ToolbarButton.GAME_CAST_SCREEN;
        if ((r1 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == true) goto L7;
        r1 = null;
    L7:
        r0.d(r2, (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r1);
        return true;
    L10:
        return true;
    }

    public d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }
}
