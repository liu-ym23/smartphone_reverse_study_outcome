package com.bytedance.android.live.liveinteract.linkpanel.widget;

import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ GuestApplyContentWidget a;

    public i(GuestApplyContentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L8;
        int r0 = WaitingListType.UNKNOWN.ordinal();
        if (r4.intValue() == r0) goto L9;
        GuestApplyContentWidget r1 = this.a;
        r1.n = r4.intValue();
        return;
    L9:
        return;
    }
}
