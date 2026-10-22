package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.run();
        return;
    L5:
        a.post(r2);
    }
}
