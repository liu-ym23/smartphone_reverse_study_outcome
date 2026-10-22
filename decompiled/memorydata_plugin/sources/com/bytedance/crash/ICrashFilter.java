package com.bytedance.crash;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r1, Thread r2);

    boolean onNativeCrashFilter(String r1, String r2);
}
