package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public c(MediatorLiveData r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual(this.a.getValue(), r2)) == false) goto L6;
        this.a.setValue(r2);
        return;
    }
}
