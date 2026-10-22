package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public p(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.live.revlink.impl.multianchor.match.a r5 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r5 != null) goto L5;
    L6:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r6 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r6 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r6, 0, 0, null, 7);
    L9:
        MultiAnchorLinkUserInviteDialog.T90(this.a);
        return;
    L5:
        if (r5.isMatching() == true) goto L9;
        goto L6
    }
}
