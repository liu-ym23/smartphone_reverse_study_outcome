package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ LiveVideoCommentSelectPanelVideoViewHolder a;
    public final /* synthetic */ sd0.a b;
    public final /* synthetic */ sd0.a c;

    public k(LiveVideoCommentSelectPanelVideoViewHolder r1, sd0.a r2, sd0.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        sd0.a r4 = this.b;
        if (r4 == null) goto L5;
        Long r5 = r4.b();
    L7:
        if (Intrinsics.areEqual(r5, this.c.b()) == false) goto L11;
        l r6 = this.a.f;
        if (r6 == null) goto L15;
        r6.ZZ(null);
        return;
    L15:
        return;
    L11:
        l r7 = this.a.f;
        if (r7 == null) goto L17;
        r7.ZZ(this.c);
        return;
    L17:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
