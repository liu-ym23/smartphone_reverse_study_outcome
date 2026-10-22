package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ e.c a;

    public g(e.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.a.s.a;
        if (r2 == null) goto L6;
        r2.D0();
    L6:
        if (this.a.i() == true) goto L8;
        return;
    L8:
        if (e.c.g(this.a) == false) goto L12;
        this.a.h();
        return;
    }
}
