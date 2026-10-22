package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ MediaAnchorInfoWidget a;

    public v(MediaAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        MediaAnchorInfoWidget r0 = this.a;
        Room r4 = (Room) sh6.c.b((sh6.b) r3);
        int r1 = MediaAnchorInfoWidget.x;
        r0.Gq(r4);
    }
}
