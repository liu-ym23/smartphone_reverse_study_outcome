package com.bytedance.crash;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r5, Thread r10);

    boolean onNativeCrashFilter(String r5, String r10);
}
