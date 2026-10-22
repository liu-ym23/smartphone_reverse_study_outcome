package com.bytedance.crash;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r1, Thread r2);

    boolean onNativeCrashFilter(String r1, String r2);
}
