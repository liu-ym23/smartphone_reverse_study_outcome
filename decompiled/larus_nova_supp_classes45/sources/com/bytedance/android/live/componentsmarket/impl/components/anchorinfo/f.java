package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;

    public f(CommonMergeAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        CommonMergeAnchorInfoWidget r0 = this.a;
        CommonMergeAnchorInfoWidget.Cq(r0, (FollowPair) r2);
    }
}
