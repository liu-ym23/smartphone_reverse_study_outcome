package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 implements View.OnClickListener {
    public final /* synthetic */ j0.c a;

    public k0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        StringBuilder r4 = new StringBuilder("landscape send button click, panelBridge empty?");
        if (this.a.o.a != null) goto L5;
        boolean r0 = true;
    L6:
        r4.append(r0);
        i40.h.c(r4.toString(), true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.o.a;
        if (r5 == null) goto L10;
        r5.p0();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
