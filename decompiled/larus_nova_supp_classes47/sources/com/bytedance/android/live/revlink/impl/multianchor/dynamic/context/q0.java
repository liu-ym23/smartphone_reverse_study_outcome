package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0<T> implements Consumer {
    public final /* synthetic */ o0 a;

    public q0(o0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MutableLiveData<JSONObject> r0 = this.a.c;
        r0.postValue((JSONObject) r2);
    }
}
