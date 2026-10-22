package com.bytedance.crash;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashFilterExt extends ICrashFilter {
    boolean onAnrFilter(String r1, String r2);

    boolean onExitReasonFilter(String r1);
}
