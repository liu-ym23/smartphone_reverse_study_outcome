package com.bytedance.android.livesdk.floatview;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ VideoFloatWindowView a;

    public v(VideoFloatWindowView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        VideoFloatWindowView r5 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r0 = r5.n;
        if (r0 == null) goto L5;
        r0.l(false, false, r5.h, r5.getContainContext());
    L5:
        e r6 = this.a.b;
        if (r6 == null) goto L9;
        r6.onClose();
        return;
    }
}
