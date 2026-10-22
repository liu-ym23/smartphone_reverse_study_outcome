package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;

    public m(AnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        AnchorInteractContainerFragment r3 = this.a;
        int r0 = AnchorInteractContainerFragment.S;
        com.bytedance.android.live.revlink.impl.control.dialog.r r4 = r3.d;
        if (r4 == null) goto L6;
        r4.dismiss();
        return;
    }
}
