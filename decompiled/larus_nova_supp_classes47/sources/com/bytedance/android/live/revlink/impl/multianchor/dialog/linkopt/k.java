package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public k(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        if (this.a.isViewValid() == false) goto L16;
        if (r5 == null) goto L13;
        boolean r6 = r5.booleanValue();
        MultiAnchorRandomView r0 = (MultiAnchorRandomView) this.a.S90(2131362584);
        boolean r7 = !r6;
        r0.i = r7;
        if (r7 == false) goto L9;
        r0.e.setVisibility(0);
        r0.f.setVisibility(8);
        return;
    L9:
        r0.e.setVisibility(8);
        r0.f.setVisibility(0);
        if (r0.U5() == false) goto L15;
        r0.T5(false);
        return;
    L15:
        return;
    L13:
        return;
    }
}
