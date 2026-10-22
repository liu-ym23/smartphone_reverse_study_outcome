package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.android.livesdk.floatview.e r2 = this.a.v;
        if (r2 == null) goto L6;
        r2.onClose();
        return;
    }
}
