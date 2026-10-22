package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ e.c a;

    public n(e.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        com.bytedance.android.livesdk.interactivity.api.monitor.b.b(this.a.m(), "portrait", -2);
        e.c r4 = this.a;
        if (r4.j == false) goto L6;
        return;
    L6:
        if (e.c.g(r4) == false) goto L10;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.s.a;
        if (r5 == null) goto L12;
        r5.h();
        return;
    L12:
        return;
    L10:
        this.a.n();
    }
}
