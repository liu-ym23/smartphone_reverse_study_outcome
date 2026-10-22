package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements kc0.r.a {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.c b;

    public final vc0.a getLiveVideoClientFactory() {
        hh1.v0 r0 = this.b.getLiveVideoClientFactory();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r0);
    }

    public final void a(LiveWidget r2) {
        this.a.Uj(r2);
    }

    public final void b(Widget r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131380423, r5, false, 8);
    }

    public z(com.bytedance.android.livesdk.chatroom.ui.framework.a r1, com.bytedance.android.livesdk.chatroom.ui.framework.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
