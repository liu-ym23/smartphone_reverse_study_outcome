package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r2), Boolean.TRUE)) == true) goto L13;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a.e;
        if (r3 == null) goto L8;
        MultiLinkAnchorControlContext r4 = r3.ua();
    L9:
        if (r4 == null) goto L12;
        r4.setMultiLinkTimes(r4.getMultiLinkTimes() + 1);
        return;
    L12:
        return;
    L8:
        r4 = null;
        goto L9
    }
}
