package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import com.bytedance.android.livesdk.link.model.ITopTip;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

    public n(MultiAnchorTeamPkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        ITopTip r2 = (ITopTip) r1;
        this.a.isViewValid();
    }
}
