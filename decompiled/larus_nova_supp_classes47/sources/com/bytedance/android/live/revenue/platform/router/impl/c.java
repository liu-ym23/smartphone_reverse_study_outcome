package com.bytedance.android.live.revenue.platform.router.impl;

import com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Observable<UIHandleStatus> a;
    public final zy0.a b;

    public c(BehaviorSubject r2, zy0.d r3) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleObservable");
        this.a = r2;
        this.b = r3;
    }
}
