package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ k0 b;

    public i0(MediatorLiveData r1, k0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        jy0.b.c("xuzr_scope", "state update in manager", null, 4);
        MediatorLiveData r0 = this.a;
        k0 r1 = this.b;
        r0.setValue(r1.k((Integer) r5));
    }
}
