package com.ss.ugc.live.sdk.msg.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MainTaskScheduler {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainTaskScheduler$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.run();
        return;
    L5:
        ((Handler) a.getValue()).post(r2);
    }
}
