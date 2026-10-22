package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.livesdk.link.model.ITopTip;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public u(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        ITopTip r2 = (ITopTip) r1;
        this.a.isViewValid();
    }
}
