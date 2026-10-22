package com.bytedance.android.live.anchormodelink.impl;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AnchorModeLinkDynamicWidget a;

    public e(AnchorModeLinkDynamicWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        h1 r6 = (h1) r5;
        Intrinsics.checkNotNullParameter(r6, "event");
        AnchorModeLinkDynamicWidget r0 = this.a;
        r0.getClass();
        boolean r1 = iy.b.a;
        iy.b.e(r0.a, "onEvent event==" + r6.a);
        if (r6.a != 3) goto L7;
        iy.b.e(r0.a, "onEvent LiveEvent.ACTION_START_LIVE");
        r0.Dd("prepareAnchorLive", null);
        return;
    }
}
