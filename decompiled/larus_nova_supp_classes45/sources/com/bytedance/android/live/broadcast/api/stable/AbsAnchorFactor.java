package com.bytedance.android.live.broadcast.api.stable;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class AbsAnchorFactor<T> {
    public final Lazy a;

    public abstract String a();

    public abstract T b();

    public AbsAnchorFactor() {
        this.a = LazyKt.lazy(new AbsAnchorFactor$factorForStrategy$2(this));
    }
}
