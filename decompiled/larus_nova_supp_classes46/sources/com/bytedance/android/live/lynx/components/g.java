package com.bytedance.android.live.lynx.components;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveLynxFragment a;

    public g(LiveLynxFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.android.live.lynx.api.c r2 = this.a.x;
        if (r2 == null) goto L6;
        r2.reload();
        return;
    }
}
