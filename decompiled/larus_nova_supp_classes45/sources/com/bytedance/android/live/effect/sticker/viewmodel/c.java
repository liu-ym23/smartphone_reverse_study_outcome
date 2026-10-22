package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T, R> {
    public final Map<T, MutableLiveData<R>> a;

    public c() {
        this.a = new LinkedHashMap();
    }

    public final R a(T r2) {
        MutableLiveData r3 = (MutableLiveData) ((LinkedHashMap) this.a).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (R) r3.getValue();
    }

    public final void update(T r2, R r3) {
        MutableLiveData r4 = (MutableLiveData) ((LinkedHashMap) this.a).get(r2);
        if (r4 == null) goto L6;
        r4.setValue(r3);
        return;
    }

    public final void b(T r3, LifecycleOwner r4, Observer<R> r5) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        if (this.a.containsKey(r3) == true) goto L5;
        this.a.put(r3, new MutableLiveData());
    L5:
        MutableLiveData r6 = (MutableLiveData) ((LinkedHashMap) this.a).get(r3);
        if (r6 == null) goto L9;
        r6.observe(r4, r5);
        return;
    }
}
