package com.bytedance.ai.core.base;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class d extends f {
    public final CoroutineScope c;
    public final AtomicBoolean d;
    public Job e;

    public d() {
        this(0);
    }

    public abstract void k();

    public abstract long l();

    public d(int r10) {
        CoroutineScope r11 = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        this.c = r11;
        this.d = new AtomicBoolean(false);
        this.b = new c(this);
    }
}
