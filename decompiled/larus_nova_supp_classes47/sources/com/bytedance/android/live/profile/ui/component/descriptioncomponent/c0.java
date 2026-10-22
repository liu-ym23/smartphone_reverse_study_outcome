package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 extends ka0.a {
    public final /* synthetic */ b0 c;

    public final void a(HybridCard r1, String r2) {
    }

    public final void b(HybridCard r1, View r2, int r3) {
        ViewGroup r4 = this.c.c;
        if (r4 == null) goto L5;
        r4.removeAllViews();
    L5:
        ViewGroup r5 = this.c.c;
        if (r5 == null) goto L9;
        r5.addView(r1);
        return;
    }

    public c0(b0 r1, Context r2, Uri r3, int r4) {
        this.c = r1;
        super(r2, r3, r4);
    }
}
