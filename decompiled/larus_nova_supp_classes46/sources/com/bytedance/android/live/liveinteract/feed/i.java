package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    public i(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List<? extends tf0.e> r4 = (List) r3;
        CommonMultiLinkFeedView r0 = this.a;
        int r1 = CommonMultiLinkFeedView.W;
        r0.m(r4);
        BaseLinkSeatWindowView r2 = this.a.getBaseWindowView();
        if (r2 == null) goto L5;
        r2.O7(r4);
    L5:
        this.a.x(r4);
    }
}
