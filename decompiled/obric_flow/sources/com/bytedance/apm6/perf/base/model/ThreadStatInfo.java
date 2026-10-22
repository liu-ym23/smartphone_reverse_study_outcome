package com.bytedance.apm6.perf.base.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r5, long r10) {
        this.threadName = r5;
        this.threadCpuTime = r10;
    }
}
