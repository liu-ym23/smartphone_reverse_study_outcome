package com.bytedance.retrofit2.ttnet;

import com.bytedance.retrofit2.client.Request;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpCallThrottleControl {
    boolean maybeDropRequestOrAsyncDelay(Request r1, Executor r2, Runnable r3);

    void maybeDropRequestOrBlockingDelay(Request r1);

    void notifyRequestCompleted(Request r1);

    default Request setOriginalRequestProperties(Request r1) {
        return r1;
    }
}
