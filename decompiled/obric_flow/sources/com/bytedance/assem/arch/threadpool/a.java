package com.bytedance.assem.arch.threadpool;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f3939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3940b;

    public a() {
        this.f3939a = LazyKt.lazy(HandlerExecutor$thread$2.f3937a);
        this.f3940b = LazyKt.lazy(new HandlerExecutor$handler$2(this));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        ((Handler) this.f3940b.getValue()).post(r5);
    }
}
