package com.bytedance.forest.utils;

import android.os.AsyncTask;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f4657b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f4658c = null;

    static {
        f4656a = new g();
        f4657b = LazyKt.lazy(ThreadUtils$forestHandler$2.f4600a);
        f4658c = LazyKt.lazy(ThreadUtils$reportHandler$2.f4601a);
    }

    public static void a(Runnable r5) {
        if (b() == false) goto L6;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r5);
        return;
    L6:
        r5.run();
    }

    public static boolean b() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }
}
