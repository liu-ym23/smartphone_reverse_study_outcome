package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y0 implements View.OnClickListener {
    public final /* synthetic */ x0 a;
    public final /* synthetic */ boolean b;

    public y0(x0 r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.b == false) goto L5;
        xs2.b.a().post(new o42.k("guide_bubble"));
    L5:
        x0 r4 = this.a;
        yo2.d<?> r0 = r4.f;
        if (r0 == null) goto L8;
        r0.d();
    L8:
        r4.f = null;
    }
}
