package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ListenerDispatchSupport<T> {
    public final Lazy a;

    public ListenerDispatchSupport() {
        this.a = LazyKt.lazy(ListenerDispatchSupport$listeners$2.INSTANCE);
    }
}
