package com.bytedance.frameworks.baselib.network;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile TTDelayStateManager$AppStartState f4665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f4666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f4667c = null;
    public static final AtomicLong d = null;
    public static final AtomicLong e = null;
    public static final AtomicLong f = null;

    static {
        f4665a = TTDelayStateManager$AppStartState.NormalStart;
        f4666b = new AtomicBoolean(false);
        f4667c = new AtomicLong(0);
        d = new AtomicLong(0);
        e = new AtomicLong(0);
        f = new AtomicLong(0);
    }

    public static boolean a(long r5, long r10) {
        if (((System.currentTimeMillis() / 1000) - r5) <= r10) goto L5;
        return true;
    L5:
        return false;
    }
}
