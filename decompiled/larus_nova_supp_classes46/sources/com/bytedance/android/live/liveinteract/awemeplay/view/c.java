package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import gd0.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView a;

    public c(LiveVideoCommentSelectAwemePanelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        r r2 = this.a.m;
        if (r2 == null) goto L6;
        r2.d();
        return;
    }
}
