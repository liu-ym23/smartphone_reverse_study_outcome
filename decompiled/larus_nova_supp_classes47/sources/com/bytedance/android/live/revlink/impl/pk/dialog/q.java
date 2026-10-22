package com.bytedance.android.live.revlink.impl.pk.dialog;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;
import x31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ PkUserBanSettingDialog a;

    public q(PkUserBanSettingDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IFollowPair r5 = (IFollowPair) r4;
        PkUserBanSettingDialog r0 = this.a;
        int r1 = 0;
        r0.j = false;
        if (r5 == null) goto L5;
        Integer r2 = Integer.valueOf(r5.getFollowStatus());
    L6:
        r0.U90(r2);
        u r3 = this.a.e;
        if (r3 == null) goto L12;
        if (r5 == null) goto L10;
        r1 = r5.getFollowStatus();
    L10:
        r3.a = r1;
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
