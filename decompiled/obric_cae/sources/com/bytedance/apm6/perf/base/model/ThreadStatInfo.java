package com.bytedance.apm6.perf.base.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r8, long r10) {
        this.threadName = r8;
        this.threadCpuTime = r10;
    }
}
