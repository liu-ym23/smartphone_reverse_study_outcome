package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y0<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public y0(MediatorLiveData r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        List r1 = (List) r12;
        this.a.setValue(new f31.i(r1, null, null, null, null, null, null, 124));
    }
}
