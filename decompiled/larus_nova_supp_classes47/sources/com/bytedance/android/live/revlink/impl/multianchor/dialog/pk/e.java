package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorTeamPkRandomView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

    public e(MultiAnchorTeamPkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        q21.k r4 = (q21.k) r3;
        if (this.a.isViewValid() == false) goto L9;
        if (r4 == null) goto L8;
        ((MultiAnchorTeamPkRandomView) this.a.S90(2131362584)).update(r4);
        return;
    L8:
        return;
    }
}
