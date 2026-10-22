package com.bytedance.pia.core.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f7156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f7157c = null;

    static {
        f7155a = LazyKt.lazy(ThreadUtil$mPiaThread$2.f7134a);
        f7156b = LazyKt.lazy(ThreadUtil$piaHandler$2.f7136a);
        f7157c = LazyKt.lazy(ThreadUtil$mainHandler$2.f7135a);
    }

    public static final void a(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Lazy r10 = f7157c;
        if (Intrinsics.areEqual(((Handler) r10.getValue()).getLooper(), Looper.myLooper()) == false) goto L6;
        r5.run();
        return;
    L6:
        ((Handler) r10.getValue()).post(r5);
    }

    public static final void b(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Lazy r10 = f7156b;
        if (Intrinsics.areEqual(((Handler) r10.getValue()).getLooper(), Looper.myLooper()) == false) goto L6;
        r5.run();
        return;
    L6:
        ((Handler) r10.getValue()).post(r5);
    }
}
