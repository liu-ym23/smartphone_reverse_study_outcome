package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import ec2.r0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final Boolean a = null;
    public static long b;
    public static int c;
    public static long d;
    public static int e;

    static {
        a = (Boolean) r0.a.getValue();
    }

    @JvmStatic
    public static final void a(Runnable r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        if (a.booleanValue() == true) goto L6;
        r6.run();
        return;
    L6:
        long r0 = System.nanoTime();
        r6.run();
        b += System.nanoTime() - r0;
        c++;
    }
}
