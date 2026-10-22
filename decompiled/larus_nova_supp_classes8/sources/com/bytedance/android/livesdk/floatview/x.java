package com.bytedance.android.livesdk.floatview;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ VideoFloatWindowView a;

    public x(VideoFloatWindowView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        e r2 = this.a.b;
        if (r2 == null) goto L6;
        r2.onReturnClick();
        return;
    }
}
