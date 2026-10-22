package com.bytedance.crash.java;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrashIgnoreHandler {
    public static final int DEFAULT = 0;
    public static final int IGNORE = 1;
    public static final int NO_UPLOAD = 2;

    public CrashIgnoreHandler() {
    }

    public abstract void afterIgnore(Throwable r1, Thread r2);

    public abstract int shouldIgnore(Throwable r1, Thread r2);
}
