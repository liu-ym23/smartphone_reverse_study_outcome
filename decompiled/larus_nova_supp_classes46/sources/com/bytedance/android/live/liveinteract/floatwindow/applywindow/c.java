package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.o.close();
    }
}
