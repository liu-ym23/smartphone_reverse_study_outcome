package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 a;

    public t0(RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediatorLiveData r0 = this.a.a;
        r0.postValue((JSONObject) r2);
    }
}
