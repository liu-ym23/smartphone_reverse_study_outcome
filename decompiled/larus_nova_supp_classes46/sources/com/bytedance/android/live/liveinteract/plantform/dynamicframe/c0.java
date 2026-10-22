package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ DataCenter a;

    public c0(DataCenter r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        d0.e = null;
        d0 r6 = d0.f;
        int r0 = e0.o;
        r6.c(e0.a.a(s1.getContext()), this.a, false);
    }
}
