package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorLinkInfoTopSelectSubView a;

    public b(MultiAnchorLinkInfoTopSelectSubView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        MultiAnchorLinkInfoTopSelectSubView r3 = this.a;
        r3.setSelected(!r3.isSelected());
    }
}
