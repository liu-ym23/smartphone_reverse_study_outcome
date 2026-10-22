package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class StrictModeContext implements Closeable {
    private final StrictMode.ThreadPolicy mThreadPolicy;
    private final StrictMode.VmPolicy mVmPolicy;

    private StrictModeContext(StrictMode.ThreadPolicy r8) {
        this(r8, null);
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy r8 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(r8);
    }

    public static StrictModeContext allowDiskReads() {
        return new StrictModeContext(StrictMode.allowThreadDiskReads());
    }

    public static StrictModeContext allowDiskWrites() {
        return new StrictModeContext(StrictMode.allowThreadDiskWrites());
    }

    public static StrictModeContext allowSlowCalls() {
        StrictMode.ThreadPolicy r8 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r8).permitCustomSlowCalls().build());
        return new StrictModeContext(r8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r8 = this.mThreadPolicy;
        if (r8 == null) goto L5;
        StrictMode.setThreadPolicy(r8);
    L5:
        StrictMode.VmPolicy r10 = this.mVmPolicy;
        if (r10 == null) goto L9;
        StrictMode.setVmPolicy(r10);
        return;
    }

    private StrictModeContext(StrictMode.ThreadPolicy r8, StrictMode.VmPolicy r10) {
        this.mThreadPolicy = r8;
        this.mVmPolicy = r10;
    }

    private StrictModeContext(StrictMode.VmPolicy r8) {
        this(null, r8);
    }
}
