package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f7499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f7500b = null;

    static {
        f7500b = LazyKt.lazy(ThreadPool$mainHandler$2.f7494a);
    }

    public static boolean a() {
        return Intrinsics.areEqual(((Handler) f7500b.getValue()).getLooper().getThread(), Thread.currentThread());
    }
}
