package com.bytedance.applog.priority;

import androidx.annotation.Keep;
import xd.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface PriorityCallback {
    boolean allowIsolateReport(String r8, String r10);

    PriorityHttpResponse doHttpPost(String r8, byte[] r10, d<String, String> r11);

    String getHeaderJson();

    boolean isMonitorEnabled();

    boolean isNetworkAvailable();

    boolean isStageEnabled();

    String isolateKey();

    void monitorError(String r8, String r10);

    void monitorIncreaseStats(String r8, int r10);

    void monitorLatency(int r8, int r10, int r11);

    void monitorStage(String r8, String r10, int r11, int r12, String r13, String r14, long r15);

    void printLog(int r8, String r10);
}
