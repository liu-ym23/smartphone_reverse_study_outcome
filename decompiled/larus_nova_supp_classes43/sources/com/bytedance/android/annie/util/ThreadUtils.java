package com.bytedance.android.annie.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ThreadUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ThreadUtils$mainThreadHandler$2.INSTANCE);
    }

    public static final Handler a() {
        return (Handler) a.getValue();
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final void c(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
        a().post(r10);
        return;
    L5:
        r10.run();
    }
}
