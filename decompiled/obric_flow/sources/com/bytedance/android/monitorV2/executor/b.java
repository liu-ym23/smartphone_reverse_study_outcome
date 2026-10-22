package com.bytedance.android.monitorV2.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f3573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f3574b;

    static {
        f3573a = new Handler(Looper.getMainLooper());
    }

    public static ThreadPoolExecutor a() {
        if (f3574b != null) goto L5;
        f3574b = new ThreadPoolExecutor(4, 8, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardPolicy());
    L5:
        ThreadPoolExecutor r5 = f3574b;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public static void b(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        a().execute(new com.bytedance.android.anniex.monitor.b(1, r5));
    }
}
