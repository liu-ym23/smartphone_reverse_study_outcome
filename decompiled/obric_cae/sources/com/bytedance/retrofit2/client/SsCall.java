package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes.dex */
public interface SsCall {
    void cancel();

    Response execute();

    Request getRequest();

    boolean setThrottleNetSpeed(long r8);
}
