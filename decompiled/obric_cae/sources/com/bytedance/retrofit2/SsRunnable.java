package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface SsRunnable extends Runnable {
    int getRequestDelayTime();

    boolean isStreaming();

    int priority();
}
