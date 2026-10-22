package com.bytedance.forest.utils;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4624a;

    public g() {
        this.f4624a = LazyKt.lazy(MainThreadExecutor$handler$2.f4577a);
        new ConcurrentLinkedQueue();
    }
}
