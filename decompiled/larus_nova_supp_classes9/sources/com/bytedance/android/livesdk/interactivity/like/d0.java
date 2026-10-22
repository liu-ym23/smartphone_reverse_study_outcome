package com.bytedance.android.livesdk.interactivity.like;

import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements cc2.n<cc2.g> {
    public final /* synthetic */ DiggWidget a;

    public d0(DiggWidget r1) {
        this.a = r1;
    }

    @Override // cc2.n
    public final void a(cc2.g r1, Boolean r2) {
        View r3 = ((Widget) this.a).contentView;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }

    @Override // cc2.n
    public final void b(cc2.g r1, Boolean r2) {
        ((Widget) this.a).contentView.setVisibility(8);
    }
}
