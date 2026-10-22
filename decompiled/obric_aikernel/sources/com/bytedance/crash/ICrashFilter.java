package com.bytedance.crash;

/* JADX INFO: loaded from: classes.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r10, Thread r11);

    boolean onNativeCrashFilter(String r10, String r11);
}
