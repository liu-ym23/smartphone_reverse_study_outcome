package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ o a;

    public n(o r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediatorLiveData r0 = this.a.a;
        r0.setValue((JSONObject) r2);
    }
}
