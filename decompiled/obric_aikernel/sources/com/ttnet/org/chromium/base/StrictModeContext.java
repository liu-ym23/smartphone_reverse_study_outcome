package com.ttnet.org.chromium.base;

import android.os.Build;
import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class StrictModeContext implements Closeable {
    private final StrictMode.ThreadPolicy mThreadPolicy;
    private final StrictMode.VmPolicy mVmPolicy;

    private StrictModeContext(StrictMode.ThreadPolicy r10) {
        this(r10, null);
    }

    private StrictModeContext(StrictMode.ThreadPolicy r10, StrictMode.VmPolicy r11) {
        this.mThreadPolicy = r10;
        this.mVmPolicy = r11;
    }

    private StrictModeContext(StrictMode.VmPolicy r10) {
        this(null, r10);
    }

    public static StrictModeContext allowAllThreadPolicies() {
        StrictMode.ThreadPolicy r10 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        return new StrictModeContext(r10);
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy r10 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(r10);
    }

    public static StrictModeContext allowDiskReads() {
        return new StrictModeContext(StrictMode.allowThreadDiskReads());
    }

    public static StrictModeContext allowDiskWrites() {
        return new StrictModeContext(StrictMode.allowThreadDiskWrites());
    }

    public static StrictModeContext allowSlowCalls() {
        StrictMode.ThreadPolicy r10 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r10).permitCustomSlowCalls().build());
        return new StrictModeContext(r10);
    }

    public static StrictModeContext allowUnbufferedIo() {
        StrictMode.ThreadPolicy r10 = StrictMode.getThreadPolicy();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r10).permitUnbufferedIo().build());
    L6:
        return new StrictModeContext(r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r10 = this.mThreadPolicy;
        if (r10 == null) goto L5;
        StrictMode.setThreadPolicy(r10);
    L5:
        StrictMode.VmPolicy r11 = this.mVmPolicy;
        if (r11 == null) goto L9;
        StrictMode.setVmPolicy(r11);
        return;
    }
}
