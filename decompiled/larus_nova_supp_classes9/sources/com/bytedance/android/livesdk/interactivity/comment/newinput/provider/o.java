package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ e.c a;

    public o(e.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.a.s.a;
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r4 = r3.V();
        if (r4 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r5 = r4.g;
        if (r5 == null) goto L9;
        String r6 = r5.f;
    L10:
        com.bytedance.android.live.core.utils.f2.c(r6, 0);
        return;
    L9:
        r6 = null;
        goto L10
    }
}
