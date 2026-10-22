package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorTeamPkMatchingDialog a;

    public c(MultiAnchorTeamPkMatchingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        MultiAnchorTeamPkMatchingDialog r3 = this.a;
        int r0 = MultiAnchorTeamPkMatchingDialog.i;
        r3.getClass();
        com.bytedance.android.live.revlink.impl.multianchor.match.a r1 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r1 == null) goto L5;
        r1.Bd();
    L5:
        r3.X90();
        com.bytedance.android.live.revlink.impl.multianchor.match.f r4 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r4 == null) goto L9;
        r4.j(6);
        return;
    }
}
