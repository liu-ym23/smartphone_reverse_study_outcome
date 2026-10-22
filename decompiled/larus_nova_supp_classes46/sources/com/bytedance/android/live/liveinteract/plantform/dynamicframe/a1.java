package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ DataCenter a;

    public a1(DataCenter r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        z0.e = null;
        z0.g.f(s1.getContext(), this.a, false);
    }
}
