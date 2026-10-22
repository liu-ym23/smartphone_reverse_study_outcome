package com.bytedance.lego.init.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IPeriodTask implements Runnable {
    public IPeriodTask() {
    }

    public abstract boolean mustRunInMainThread();

    public String toString() {
        return "runInMain:" + mustRunInMainThread();
    }
}
