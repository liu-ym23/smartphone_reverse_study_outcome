package com.bytedance.crash;

/* JADX INFO: loaded from: classes.dex */
public interface ICrashFilterExt extends ICrashFilter {
    boolean onAnrFilter(String r10, String r11);

    boolean onExitReasonFilter(String r10);
}
