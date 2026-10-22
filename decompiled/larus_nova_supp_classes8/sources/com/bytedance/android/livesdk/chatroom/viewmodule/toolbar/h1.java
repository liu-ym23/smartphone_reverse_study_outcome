package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h1 implements js0.b {
    public final /* synthetic */ List a;
    public final /* synthetic */ LiveToolbarMoreDialog b;

    public final void onSuccess(String r4) {
        this.b.O.removeAll(this.a);
        List<ToolbarButton> r5 = this.b.O;
        ToolbarButton r0 = ToolbarButton.BROADCAST_INFO;
        r5.add(r0);
        List r6 = Collections.singletonList(this.a);
        y3.f(this.b.Q).p(r0.extended(), com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.b.b(r0, r6));
    }

    public h1(LiveToolbarMoreDialog r1, List r2) {
        this.b = r1;
        this.a = r2;
    }
}
