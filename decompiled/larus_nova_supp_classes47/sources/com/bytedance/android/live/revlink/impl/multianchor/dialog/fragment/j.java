package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;

    public j(AnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.live.revlink.impl.precisefind.a r3 = com.bytedance.android.live.revlink.impl.global.b.K();
        if (r3 == null) goto L5;
        r3.so();
    L5:
        AnchorInteractContainerFragment.ia0("click", this.a.L);
        com.bytedance.android.live.revlink.impl.control.dialog.r r4 = this.a.d;
        if (r4 == null) goto L9;
        r4.dismiss();
        return;
    }
}
