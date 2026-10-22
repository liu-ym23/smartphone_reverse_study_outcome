package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.bytedance.android.livesdk.utils.s3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final <T> void b(MutableLiveData<T> r1, Function1<? super T, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setState");
        Intrinsics.checkNotNullParameter(r2, "reducer");
        Object r0 = r1.getValue();
        if (r0 == null) goto L5;
        Object r3 = r2.invoke(r0);
    L6:
        r1.setValue(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final void a(MutableLiveData r2, LifecycleOwner r3, KProperty1 r4, Observer r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$observeState");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "prop1");
        Intrinsics.checkNotNullParameter(r5, "action");
        Intrinsics.checkNotNullParameter(r2, "$this$getLiveDateTCompat");
        Intrinsics.checkNotNullParameter(r4, "prop1");
        LiveData r6 = Transformations.map(r2, new s3(r4));
        Intrinsics.checkNotNullParameter(r6, "$this$distinctUntilChanged");
        MediatorLiveData r7 = new MediatorLiveData();
        r7.addSource(r6, new c(r7));
        r7.observe(r3, r5);
    }
}
