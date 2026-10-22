package com.bytedance.android.live.revlink.impl.behavior;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ ToolbarPkBehavior a;
    public final /* synthetic */ yo2.d b;

    public q(ToolbarPkBehavior r1, yo2.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ToolbarPkBehavior r3 = this.a;
        yo2.d r0 = this.b;
        r3.getClass();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }
}
