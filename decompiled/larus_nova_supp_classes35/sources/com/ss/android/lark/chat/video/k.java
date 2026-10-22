package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ h a;

    public k(h r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        View.OnClickListener r0 = this.a.v;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }
}
