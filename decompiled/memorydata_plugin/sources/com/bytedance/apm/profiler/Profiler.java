package com.bytedance.apm.profiler;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Profiler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1434a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1435b = false;
    private static final AtomicReference<Boolean> c = null;
    private static volatile boolean d;

    static {
        c = new AtomicReference(null);
        d = false;
    }

    private Profiler() {
    }

    private static native boolean nAttachThread(int r0);

    private static native boolean nCheck();

    private static native void nClear();

    private static native boolean nDetachThread(int r0);

    private static native String nDump(long r0, long r2);

    private static native String nGetStack(int r0);

    private static native boolean nInit();

    private static native void nSetAlog(long r0);

    private static native boolean nStart(int r0);

    private static native boolean nStop();
}
