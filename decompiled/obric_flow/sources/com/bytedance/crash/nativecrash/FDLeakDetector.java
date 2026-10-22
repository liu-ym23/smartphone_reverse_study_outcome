package com.bytedance.crash.nativecrash;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FDLeakDetector {
    static {
        new AtomicBoolean();
    }

    private static native void doSetAddrs(long r5, long r10);

    private static native void doStartDetect(String r5);
}
