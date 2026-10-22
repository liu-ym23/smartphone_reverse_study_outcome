package com.bytedance.crash.java;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashIgnoreHandler {
    public static final int DEFAULT = 0;
    public static final int IGNORE = 1;
    public static final int NO_UPLOAD = 2;

    public CrashIgnoreHandler() {
    }

    public abstract void afterIgnore(Throwable r10, Thread r11);

    public abstract int shouldIgnore(Throwable r10, Thread r11);
}
