package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public r(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
        MultiAnchorLinkUserInviteDialog.T90(this.a);
        return;
    }
}
