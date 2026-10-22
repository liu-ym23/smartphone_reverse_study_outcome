package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ e0 a;

    public q(e0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MutableLiveData<Boolean> r0 = this.a.r;
        r0.setValue((Boolean) r2);
    }
}
