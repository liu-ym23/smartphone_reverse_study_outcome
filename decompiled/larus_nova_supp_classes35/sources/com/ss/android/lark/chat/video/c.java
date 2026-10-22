package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ InnerVideoPreviewFragment a;

    public c(InnerVideoPreviewFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        g r2 = this.a.g;
        if (r2 == null) goto L5;
        r2.onClosed();
    L5:
        this.a.onBackPressed();
    }
}
