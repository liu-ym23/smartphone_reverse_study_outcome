package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.widget.ImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView a;

    public b(LiveVideoCommentSelectAwemePanelView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        sd0.a r11 = (sd0.a) r10;
        LiveVideoCommentSelectAwemePanelView r0 = this.a;
        if (r0.u == false) goto L8;
        if (r11 == null) goto L15;
        r r1 = r0.m;
        if (r1 == null) goto L16;
        r1.f(new gd0.b(r11.b(), r11.c(), r11.a(), r11.d(), r11.e(), Integer.valueOf(LiveVideoCommentSelectAwemePanelView.R5(this.a))));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r11 != null) goto L10;
        int r12 = 2131253233;
    L11:
        ImageView r2 = r0.k;
        if (r2 == null) goto L18;
        r2.setBackgroundResource(r12);
        return;
    L18:
        return;
    L10:
        r12 = 2131253234;
        goto L11
    }
}
