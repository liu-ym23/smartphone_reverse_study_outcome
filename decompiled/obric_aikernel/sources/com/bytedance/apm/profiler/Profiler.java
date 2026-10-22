package com.bytedance.apm.profiler;

import androidx.annotation.Keep;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Profiler {
    static {
        new AtomicReference(null);
    }

    private Profiler() {
    }

    @Keep
    private static native boolean nAttachThread(int r10);

    @Keep
    private static native boolean nCheck();

    @Keep
    private static native void nClear();

    @Keep
    private static native boolean nDetachThread(int r10);

    @Keep
    private static native String nDump(long r10, long r11);

    @Keep
    private static native String nGetStack(int r10);

    @Keep
    private static native boolean nInit();

    @Keep
    private static native void nSetAlog(long r10);

    @Keep
    private static native boolean nStart(int r10);

    @Keep
    private static native boolean nStop();
}
