package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ MediaAnchorInfoWidget a;

    public t(MediaAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediaAnchorInfoWidget r0 = this.a;
        MediaAnchorInfoWidget.Cq(r0, (FollowPair) r2);
    }
}
