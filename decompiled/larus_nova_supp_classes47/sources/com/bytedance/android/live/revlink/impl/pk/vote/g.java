package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ InteractVoteThemeBinder.a a;

    public g(InteractVoteThemeBinder.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        InteractVoteThemeBinder.a r6 = this.a;
        InteractVoteThemeBinder.b r0 = r6.d;
        if (r0 == null) goto L9;
        long r2 = r6.a;
        String r7 = r6.b;
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        r0.s80(new InteractVoteStartDialog.b(r2, r7));
        return;
    }
}
