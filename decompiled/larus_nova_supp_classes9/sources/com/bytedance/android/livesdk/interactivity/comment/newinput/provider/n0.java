package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0 implements View.OnClickListener {
    public final /* synthetic */ j0.c a;

    public n0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.a.o.a;
        if (r3 == null) goto L5;
        r3.D0();
    L5:
        i40.h.a("V3 landscape on keyboard click");
        this.a.h(true);
    }
}
