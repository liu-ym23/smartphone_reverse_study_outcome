package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;

    public h(CommonMergeAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        CommonMergeAnchorInfoWidget r0 = this.a;
        Room r4 = (Room) sh6.c.b((sh6.b) r3);
        int r1 = CommonMergeAnchorInfoWidget.x;
        r0.Gq(r4);
    }
}
